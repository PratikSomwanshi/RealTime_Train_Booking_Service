package com.pratik.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pratik.dto.ErrorResponse;
import com.pratik.dto.ErrorResponse.Explaination;
import com.pratik.exception.CustomException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> getErrorResponse(CustomException ex) {
		ErrorResponse errorResponse = new ErrorResponse(false, "Some Error Occured", new Explaination(ex.getMessage()));

		return new ResponseEntity<>(errorResponse, ex.getStatusCode());
	}
}
