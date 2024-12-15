package com.ust.tasks.Exceptions;


public class RecordAlreadyExists extends RuntimeException{
    public RecordAlreadyExists(String message){
        super(message);
    }
}
