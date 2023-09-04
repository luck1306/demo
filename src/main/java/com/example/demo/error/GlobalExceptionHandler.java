package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DemoProjectException.class})
    public ResponseEntity<ErrorResponse> demoProjectExceptionHandler(DemoProjectException e) {
        ErrorResponse body = e.getErrorResponse();
        return new ResponseEntity<>(body, HttpStatus.valueOf(e.getErrorResponse().getErrorCode()));
    }
}
