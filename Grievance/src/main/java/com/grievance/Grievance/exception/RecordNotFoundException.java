package com.grievance.Grievance.exception;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException {

	/**
	 * Constructs a new RecordNotFoundException with the specified detail message.
	 *
	 * @param message The detail message.
	 */
	public RecordNotFoundException(String message) {
		super(message);
	}

}
