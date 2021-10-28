package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid Priority! Please select from (1-5)!")
public class InvalidPriorityException extends DefectsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPriorityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
