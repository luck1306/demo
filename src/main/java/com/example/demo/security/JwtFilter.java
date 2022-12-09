package com.example.demo.security;

import com.example.demo.entity.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final TokenProvider provider;

    private final UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = provider.parsingRequest(request);
        Claims claim = provider.parseToken(token);
        boolean b = repository.findByAccountId(claim.getSubject())
                .isPresent();

        if(b) {
            Authentication savingInfo = provider.generateAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(savingInfo);

        }

        filterChain.doFilter(request, response);
    }
}
