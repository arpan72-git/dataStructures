package com.training.defecttrack.userregistration.exception;

/**
 * All other user defined exception classes will inherit this exception class.
 *
 */
public class UserRegistrationException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserRegistrationException(String message) {
		super(message);
	}
}