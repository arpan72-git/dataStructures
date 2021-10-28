package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Status must be chosen from open/closed!")
public class InvalidStatusException extends DefectsException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from DefectsService class with error message
	 * DefectsService.INVALID_STATUS if the given status is not matching with 
	 * constraints given in the method.
	 * 
	 * 
	 *
	 */
	public InvalidStatusException(String message) {
		super(message);
	}
}