package com.pratik.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private HttpStatus errorCode;

	public CustomException(String msg, HttpStatus errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public HttpStatus getStatusCode() {
		return this.errorCode;
	}

	public void setStatusCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

}
