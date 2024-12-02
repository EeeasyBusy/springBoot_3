package com.example.springBootdemo_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String msg, HttpStatus httpstatus) {
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public UnauthorizedUser exception(String msg, HttpStatus httpstatus) {
        return new UnauthorizedUser(msg, httpstatus);
    }
}