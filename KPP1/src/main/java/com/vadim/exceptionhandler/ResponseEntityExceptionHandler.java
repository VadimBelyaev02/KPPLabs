package com.vadim.exceptionhandler;

import com.vadim.exception.CalculatingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleAuthenticationException(ConstraintViolationException e) {
        ExceptionInfo info = new ExceptionInfo(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CalculatingException.class)
    public ResponseEntity<?> handleCalculatingException(CalculatingException e) {
        ExceptionInfo info = new ExceptionInfo(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
