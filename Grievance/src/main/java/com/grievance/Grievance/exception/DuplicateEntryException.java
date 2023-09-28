package com.grievance.Grievance.exception;
/**
 * Exception thrown to indicate a duplicate entry or record already existing in the system.
 */
@SuppressWarnings("serial")
public class DuplicateEntryException extends RuntimeException {
	  /**
     * Constructs a new DuplicateEntryException with a message.
     *
     * @param message that describes the duplicate entry.
     */
	public DuplicateEntryException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
