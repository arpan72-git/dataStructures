package com.training.defecttrack.userregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If the given email id is already present then this exception will be thrown.
 *
 */
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Given email id already exists. Please enter a different one!")
public class EmaiIdAlreadyPresentException extends UserIdAlreadyPresentException{
	private static final long serialVersionUID = 1L;
	
	public EmaiIdAlreadyPresentException(String message) {
		super(message);
	}

	
	
}
