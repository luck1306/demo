package com.example.demo.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignUpRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;

    private String introduce;
}
