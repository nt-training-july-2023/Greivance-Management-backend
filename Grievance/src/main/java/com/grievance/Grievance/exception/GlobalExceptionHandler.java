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
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handlDataIntegrity(Exception exception){
		return new ResponseEntity<String>("Email Already Exist" , HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException(Exception exception){
		return new ResponseEntity<String>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<String> handleDuplicateEntry(Exception exception){
		return new ResponseEntity<String>("User with entered email already exist",HttpStatus.BAD_REQUEST);
	}
}
