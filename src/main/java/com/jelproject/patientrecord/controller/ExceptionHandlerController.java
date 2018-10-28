package com.jelproject.patientrecord.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController 
{
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class )
    protected ResponseEntity<Object> handleConflict(Exception exception, WebRequest request) 
	{
		System.out.println("Exception Occured: "+exception);
		exception.printStackTrace();
		return new ResponseEntity<Object>("Internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
