package com.pratik.dto;

import java.util.Collections;
import java.util.List;

public class ErrorResponse {
	private boolean success;
	private String error;
	private Explaination explaination;
	private List<?> data;

	public ErrorResponse(boolean success, String error, Explaination explaination) {
		this.success = success;
		this.error = error;
		this.explaination = explaination;
		this.data = Collections.emptyList();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Explaination getExplaination() {
		return explaination;
	}

	public void setExplaination(Explaination explaination) {
		this.explaination = explaination;
	}

	public static class Explaination {
		private String message;

		public Explaination(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
