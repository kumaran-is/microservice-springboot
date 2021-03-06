package com.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ResourceNotFoundException(String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}
}
