package com.grad.project.nc.controller.support;

import com.grad.project.nc.service.exceptions.BusinessConstraintException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessConstraintExceptionHandlerAdvice {

    @ExceptionHandler(BusinessConstraintException.class)
    public ResponseEntity<?> handleException(BusinessConstraintException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}