package com.osdepym.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestServiceErrorAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
    
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        System.out.println("Exception : ");
        return ResponseEntity.status(status).body(e.getMessage());
    }
   
}