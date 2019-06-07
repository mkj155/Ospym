package com.osdepym.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.osdepym.rest.server.ActualizacionPersonaREST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestServiceErrorAdvice {
        
	Logger logger = LoggerFactory.getLogger(ActualizacionPersonaREST.class);
	
	@ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(HttpStatus.BAD_REQUEST, e);
    }

    
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
    	logger.error(e.getMessage());
        System.out.println("Exception : " + e.getMessage());
        return ResponseEntity.status(status).body("Error en el formato del request");
    }
   
}