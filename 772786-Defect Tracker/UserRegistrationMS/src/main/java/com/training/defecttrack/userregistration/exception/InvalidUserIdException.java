package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid userId!")
public class InvalidUserIdException extends UserRegistrationException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from UserService class with error message
	 * UserService.INVALID_USER_ID if the given userId is not matching the
	 * constraints given in the form of regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidUserIdException(String message) {
		super(message);
	}
}