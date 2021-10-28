package com.training.defecttrack.defects.exception;

/**
 * All other user defined exception classes will inherit this exception class.
 *
 */
public class DefectsException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DefectsException(String message) {
		super(message);
	}
}
