package com.osdepym.rest.server;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {


	@ExceptionHandler(value = {Exception.class})
    public String handleException(Exception e){
		return "error";
    }


}