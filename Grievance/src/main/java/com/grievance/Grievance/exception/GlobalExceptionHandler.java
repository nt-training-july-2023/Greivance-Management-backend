package com.grievance.Grievance.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling various exceptions and returning
 * appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles DataIntegrityViolationException and returns a BAD_REQUEST response.
	 *
	 * @param exception The DataIntegrityViolationException to handle.
	 * @return A ResponseEntity with a BAD_REQUEST status code and the exception
	 *         message.
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handlDataIntegrity(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles AuthenticationException and returns an UNAUTHORIZED response.
	 *
	 * @param exception The AuthenticationException to handle.
	 * @return A ResponseEntity with an UNAUTHORIZED status code and the exception
	 *         message.
	 */
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Handles DuplicateEntryException and returns a BAD_REQUEST response.
	 *
	 * @param exception The DuplicateEntryException to handle.
	 * @return A ResponseEntity with a BAD_REQUEST status code and the exception
	 *         message.
	 */
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<String> handleDuplicateEntry(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleRecordNotfoundException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
