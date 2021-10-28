package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid user role. Please choose from developer or tester!")
public class InvalidUserRoleException extends UserRegistrationException{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from UserService class with error message
	 * UserService.INVALID_USER_ROLE if the given user role is not matching
	 * the constraints given in the regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidUserRoleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
