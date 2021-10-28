package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid password!")
public class InvalidPasswordException extends UserRegistrationException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from UserService class with error message
	 * UserService.INVALID_PASSWORD if the given password is not matching
	 * the constraints given in the regular expression.
	 * 
	 * 
	 *
	 */

	public InvalidPasswordException(String message) {
		super(message);
	}
}