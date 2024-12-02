package com.example.springBootdemo_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg, HttpStatus httpStatus) {
    }

    @ExceptionHandler(InvalidCredentials.class)
    public InvalidCredentials exception(String msg, HttpStatus httpstatus) {
        return new InvalidCredentials(msg, httpstatus);
    }
}