package com.training.defecttrack.userprofile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This user id does not exist")
public class UserIdNotExistException extends Exception {
	private static final long serialVersionUID = 1L;

}
