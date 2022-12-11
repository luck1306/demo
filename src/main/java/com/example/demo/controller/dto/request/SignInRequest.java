package com.example.demo.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignInRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;
}
