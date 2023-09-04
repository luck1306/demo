package com.example.demo.error.exception;

import com.example.demo.error.DemoProjectException;
import com.example.demo.error.ErrorCode;

public class SourceNotFoundException extends DemoProjectException {
    public static final SourceNotFoundException EXCEPTION = new SourceNotFoundException();
    private SourceNotFoundException() { super(ErrorCode.SOURCE_NOT_FOUND); }
}
