package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "No defects found for this user!")
public class NoDefectFoundException extends DefectsException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from DefectsRepository class with error message
	 * DefectsRepository.NO_DEFECT_FOUND if the there were no defects for the entered
	 * user id
	 * 
	 *
	 */
	public NoDefectFoundException(String message) {
		super(message);
	}
}