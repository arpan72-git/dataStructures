package com.training.defecttrack.defects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Defect Id does not exist!")
public class DefectIdNotExistException extends DefectsException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This Exception is thrown from DefectsRepository class with error message
	 * DefectsRepository.DEFECTID_NOT_EXIST if the defect id does not exist
	 * 
	 * 
	 *
	 */
	public DefectIdNotExistException(String message) {
		super(message);
	}
}