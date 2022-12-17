package com.example.demo.controller;

import com.example.demo.controller.dto.request.SignInRequest;
import com.example.demo.controller.dto.request.SignUpRequest;
import com.example.demo.controller.dto.response.TokenResponse;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpRequest request) {
        authService.signUp(request);
    }

    @PostMapping("/sign-in")
    public TokenResponse signIn(@RequestBody SignInRequest request) {
        return authService.signIn(request);
    }

    @DeleteMapping("/logout")
    public void logout() {
        authService.logout();
    }
}
