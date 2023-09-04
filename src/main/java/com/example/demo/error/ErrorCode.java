package com.example.demo.error;

public enum ErrorCode {
    USER_NOT_FOUND("user can't find in database", 404),
    SOURCE_NOT_FOUND("source can't find in database", 404);

    private final String message;
    private final Integer code;

    ErrorCode(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(this.code, this.message);
    }
}
