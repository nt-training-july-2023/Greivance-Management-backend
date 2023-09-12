package com.grievance.Grievance.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	// Credentials doesnot match
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handlDataIntegrity(Exception exception){
		return new ResponseEntity<String>("Email Already Exist" , HttpStatus.BAD_REQUEST);
	}
}
