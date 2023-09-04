package com.example.demo.error;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final Integer errorCode;

    private final String errorMessage;
    public ErrorResponse(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
