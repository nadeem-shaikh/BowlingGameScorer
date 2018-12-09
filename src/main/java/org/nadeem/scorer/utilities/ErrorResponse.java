package org.nadeem.scorer.utilities;

public class ErrorResponse {

	private static ErrorResponse errorResponseObj = new ErrorResponse();
	private String message;
	private boolean errorExists;

	private ErrorResponse() {
		setErrorExists(false);
	}

	public static ErrorResponse getInstance() {
		if (errorResponseObj == null)
			errorResponseObj = new ErrorResponse();
		return errorResponseObj;
	}

	public boolean getErrorExists() {
		return errorExists;
	}

	public void setErrorExists(boolean errorExists) {
		this.errorExists = errorExists;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
