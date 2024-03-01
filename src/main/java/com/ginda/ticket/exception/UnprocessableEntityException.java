package com.ginda.ticket.exception;

public class UnprocessableEntityException extends Throwable{
    public UnprocessableEntityException(String message){
        super(message);
    }
}
