package com.Identity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	//This function is not called in our scenario
	@ExceptionHandler(Exception.class)
	public String  exceptionHandler(Exception ex) {
		return  ex.getMessage();
	}
	//This sends a bad request back if IdentityException is thrown by controller and body is the message sent in IdentityException 
	@ExceptionHandler(IdentityException.class)
	public ResponseEntity<String> exceptionHandler(IdentityException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
