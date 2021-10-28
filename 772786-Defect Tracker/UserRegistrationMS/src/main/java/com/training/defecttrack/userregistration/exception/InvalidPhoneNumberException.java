package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid phone number!")
public class InvalidPhoneNumberException extends UserRegistrationException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from UserService class with error message
	 * UserService.INVALID_PHONE_NUMBER if the given phone is not matching
	 * the constraints given in the regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}