package com.ginda.ticket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<Object> handleException(Throwable throwable) {
        return ResponseEntity.unprocessableEntity().build();
    }
}
