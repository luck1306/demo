package com.example.demo.error.exception;

import com.example.demo.error.DemoProjectException;
import com.example.demo.error.ErrorCode;

public class UserNotFoundException extends DemoProjectException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException() { super(ErrorCode.USER_NOT_FOUND); }
}
