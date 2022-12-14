package com.example.demo.security;

import com.example.demo.entity.repository.UserRepository;
import com.example.demo.redis.entity.Refresh;
import com.example.demo.redis.entity.RefreshRepository;
import com.example.demo.security.details.Details;
import com.example.demo.security.details.DetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenProvider {

    @Value("${jwt.secret-key}")
    private String secret;

    @Value("${jwt.exp.access}")
    private Long accessExp;

    @Value("${jwt.exp.refresh}")
    private Long refreshExp;

    private final UserRepository userRepository;

    private final DetailsService detailsService;

    private final RefreshRepository refreshRepository;

    private byte[] encodingKey() {
        return Base64.getEncoder().encodeToString(secret.getBytes(StandardCharsets.UTF_8)).getBytes();
    }

    public String parsingRequest(HttpServletRequest req) { // parse request to token
        String token = req.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    public Claims parseToken(String token) { // token parsing
        return Jwts.parserBuilder().setSigningKey(encodingKey()).build().parseClaimsJws(token).getBody();
    }

    public Authentication generateAuthentication(String token) { // in this project, when you request with token (in order to set token's user)
        Claims claims = parseToken(token);
        Details principle = detailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(principle, "");
    }

    public String accessToken(String subject) {
        return generateToken(subject, "access");
    }

    public String refreshToken(String subject) {
        String token = generateToken(subject, "refresh");
        Long id = userRepository.findByAccountId(subject)
                        .orElseThrow(RuntimeException::new).getId();
        refreshRepository.save(Refresh.builder()
                        .id(id)
                        .token(token)
                        .exp(System.currentTimeMillis() + refreshExp)
                .build());
        return token;
    }

    public String generateToken(String subject, String type) {
        return Jwts.builder()
                .setSubject(subject)
                .claim("type", type)
                .signWith(SignatureAlgorithm.HS256, encodingKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +
                        (type.equals("access") ? accessExp : refreshExp) * 1000))
                .compact();
    }
}
