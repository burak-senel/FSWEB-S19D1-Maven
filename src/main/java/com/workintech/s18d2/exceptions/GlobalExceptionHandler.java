package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ErrorResponse> handlerException(PlantException exception){
        ErrorResponse error = new ErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        log.error("Plant exception occured: ", exception);
        return new ResponseEntity<>(error,exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception exception){
        ErrorResponse error = new ErrorResponse( HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),LocalDateTime.now());
        log.error("Plant exception occured: ", exception);
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
