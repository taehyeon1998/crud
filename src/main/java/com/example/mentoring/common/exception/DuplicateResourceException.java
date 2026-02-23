package com.example.mentoring.common.exception;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends RuntimeException {

    private final String code = "DUPLICATE_RESOURCE";
    private final HttpStatus status = HttpStatus.CONFLICT;

    public DuplicateResourceException(String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
