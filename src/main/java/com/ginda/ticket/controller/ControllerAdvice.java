package com.ginda.ticket.controller;

import com.ginda.ticket.exception.BadRequestException;
import com.ginda.ticket.exception.NotFoundException;
import com.ginda.ticket.exception.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<Object> handleException(Throwable throwable) {
        if (throwable instanceof UnprocessableEntityException) {
            return new ResponseEntity<>(throwable, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (throwable instanceof BadRequestException) {
            return new ResponseEntity<>(throwable, HttpStatus.BAD_REQUEST);
        }
        if (throwable instanceof NotFoundException) {
            return new ResponseEntity<>(throwable, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(throwable, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
