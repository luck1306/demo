package com.example.demo.service;

import com.example.demo.controller.dto.request.SignUpRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.repository.UserRepository;
import com.example.demo.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final TokenProvider tokenProvider;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequest request) {
        boolean b = userRepository.findByAccountId(request.getAccountId()).isPresent();
        if(b) {
            throw new RuntimeException("user is already joining (AuthService:20)");
        }
        userRepository.save(User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .introduce(request.getIntroduce() != null ? request.getIntroduce() : null)
                .build());
    }
}
