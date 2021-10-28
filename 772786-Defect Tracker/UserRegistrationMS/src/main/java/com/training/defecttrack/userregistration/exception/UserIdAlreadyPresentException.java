package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If the given user id is already present then this exception will be thrown.
 *
 */
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Given user id is already available. Please enter a different one!")
public class UserIdAlreadyPresentException extends UserRegistrationException {
	private static final long serialVersionUID = 1L;

	public UserIdAlreadyPresentException(String message) {
		super(message);
	}
}