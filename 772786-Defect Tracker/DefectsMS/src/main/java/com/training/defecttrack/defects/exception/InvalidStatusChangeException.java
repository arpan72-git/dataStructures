package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Status can not be changed from closed to open!")
public class InvalidStatusChangeException extends DefectsException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from DefectsService class with error message
	 * DefectsService.INVALID_STATUS_CHANGE if the user is trying to open a closed defect
	 * 
	 * 
	 *
	 */
	public InvalidStatusChangeException(String message) {
		super(message);
	}
}