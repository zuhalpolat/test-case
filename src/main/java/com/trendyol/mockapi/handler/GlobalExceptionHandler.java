package com.trendyol.mockapi.handler;

import com.trendyol.mockapi.model.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(ZonedDateTime.now().toString())
                .status(HttpStatus.BAD_REQUEST.value())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(ZonedDateTime.now().toString())
                .status(HttpStatus.BAD_REQUEST.value())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MissingRequestHeaderException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(ZonedDateTime.now().toString())
                .status(HttpStatus.BAD_REQUEST.value())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(AuthenticationException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(ZonedDateTime.now().toString())
                .status(HttpStatus.UNAUTHORIZED.value())
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
