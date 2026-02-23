package com.example.mentoring.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException e) {
        int status = e.getStatus().value();
        return ResponseEntity
                .status(e.getStatus())
                .body(ErrorResponse.of(e.getCode(), e.getMessage(), status));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.of("BAD_REQUEST", e.getMessage(), 400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .orElse("요청 값이 올바르지 않습니다.");

        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.of("VALIDATION_ERROR", msg, 400));
    }
}
