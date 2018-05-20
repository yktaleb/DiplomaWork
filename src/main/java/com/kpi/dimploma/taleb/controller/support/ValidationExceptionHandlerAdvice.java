package com.kpi.dimploma.taleb.controller.support;

import com.kpi.dimploma.taleb.support.validation.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandlerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
