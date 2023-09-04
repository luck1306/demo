package com.example.demo.error;

import lombok.Getter;

@Getter
public class DemoProjectException extends RuntimeException {
    private final ErrorResponse errorResponse;
    public DemoProjectException(ErrorCode errorCode) {
        this.errorResponse = errorCode.toErrorResponse();
    }
}
