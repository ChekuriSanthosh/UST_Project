package com.ust.tasks.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiController {

    @ExceptionHandler(RecordNotFound.class)
    public ProblemDetail recorddoesnotfound(RecordNotFound e){
        ProblemDetail errorresponse=ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        errorresponse.setDetail(e.getMessage());
        return errorresponse;
    }


    @ExceptionHandler(RecordAlreadyExists.class)
    public ProblemDetail recordalreadyExists(RecordAlreadyExists e){
        ProblemDetail errorresponse=ProblemDetail.forStatus(HttpStatus.CONFLICT);
        errorresponse.setDetail(e.getMessage());
        return errorresponse;
    }
}
