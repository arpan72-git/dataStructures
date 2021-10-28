package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid Date! Please enter in the format : YYYY-MM-DD")
public class InvalidDateException extends DefectsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
