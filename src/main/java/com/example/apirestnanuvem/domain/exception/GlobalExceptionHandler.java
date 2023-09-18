package com.example.apirestnanuvem.domain.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<String> handle(IllegalAccessException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException exception){
        return new ResponseEntity<>("Resource id not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable exception){
        var message = "Unexpected server erro, see the logs";
        logger.error(message, exception );
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
