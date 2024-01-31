package com.reward.RewardBackEnd.exception;

import com.reward.RewardBackEnd.exception.notFound.UserNotFoundException;
import com.reward.RewardBackEnd.exception.save.DuplicateRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<APIErrorDetail> handleUserNotFoundException(Exception ex, WebRequest request){
        APIErrorDetail e = new APIErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordFoundException.class)
    public final ResponseEntity<APIErrorDetail> handleDuplicateRecordFoundException(Exception ex, WebRequest request){
        APIErrorDetail e = new APIErrorDetail(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.CONFLICT);
    }

}
