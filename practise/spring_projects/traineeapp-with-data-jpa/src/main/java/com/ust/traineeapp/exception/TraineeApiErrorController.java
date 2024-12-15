package com.ust.traineeapp.exception;

import com.ust.traineeapp.dto.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class TraineeApiErrorController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlenotfound(RecordNotFoundException e, HttpServletRequest request){
        var stat=HttpStatus.NOT_FOUND;
        ErrorResponseDTO body=new ErrorResponseDTO(
                LocalDateTime.now(),
                stat.value(),
                stat.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(stat).body(body);
    }


//    @ExceptionHandler(RecordNotFoundException.class)
//    public ResponseEntity<ErrorResponseDTO> handleRecordNotFoundError(RecordNotFoundException e, HttpServletRequest request){
//        var stat=HttpStatus.NOT_FOUND;
//        ErrorResponseDTO errorResponse=new ErrorResponseDTO(
//                LocalDateTime.now(),
//                stat.value(),
//                stat.getReasonPhrase(),
//                e.getMessage(),
//                request.getRequestURI()
//        );
//        return ResponseEntity.status(stat).body(errorResponse);
//    }


    @ExceptionHandler(RecordNotFoundException.class)
    public ProblemDetail handleRecordNotFoundError(RecordNotFoundException e, HttpServletRequest request){
        var stat=HttpStatus.NOT_FOUND;
        ProblemDetail errorResponse= ProblemDetail.forStatus(stat);
        errorResponse.setDetail(e.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public  ProblemDetail handleRecordAlreadyExists(RecordAlreadyExistsException e, HttpServletRequest response){
        var stat=HttpStatus.CONFLICT;
        ProblemDetail errorResponse=ProblemDetail.forStatus(stat);
        errorResponse.setDetail(e.getMessage());
        return errorResponse;
    }
}
