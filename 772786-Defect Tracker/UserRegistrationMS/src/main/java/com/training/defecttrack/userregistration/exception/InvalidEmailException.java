package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid email id!")
public class InvalidEmailException extends UserRegistrationException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from UserService class with error message
	 * UserService.INVALID_EMAIL if the given email is not matching the
	 * constraints given in the regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidEmailException(String message) {
		super(message);
	}
}