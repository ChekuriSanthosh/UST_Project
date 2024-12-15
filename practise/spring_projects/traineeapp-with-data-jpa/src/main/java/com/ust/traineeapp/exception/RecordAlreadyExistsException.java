package com.ust.traineeapp.exception;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String message){
        super(message);
    }
}
