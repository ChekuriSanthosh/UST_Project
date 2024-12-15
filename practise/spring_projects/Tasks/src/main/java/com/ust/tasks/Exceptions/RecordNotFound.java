package com.ust.tasks.Exceptions;

public class RecordNotFound extends RuntimeException{
    public RecordNotFound(String message){
        super(message);
    }
}
