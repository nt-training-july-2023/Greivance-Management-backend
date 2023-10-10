package com.grievance.Grievance.exception;

/**
 * Exception thrown to indicate authentication-related errors.
 */
@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {
	/**
	 * Constructs a new AuthenticationException with a message.
	 *
	 * @param message describes the authentication error.
	 */
	public AuthenticationException(String message) {
		super(message);
	}
}
