package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Invalid year of purchase!")
public class InvalidYearOfPurchaseException extends DefectsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidYearOfPurchaseException(String message) {
		super(message);
	}

}
