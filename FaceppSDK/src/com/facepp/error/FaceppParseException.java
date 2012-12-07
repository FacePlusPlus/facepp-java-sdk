package com.facepp.error;

public class FaceppParseException extends Exception {
	
	private String errorMessage = null;
	private Integer errorCode = null, httpResponseCode = null;
	
	private static final long serialVersionUID = 3;
	public FaceppParseException(String message) {
		super(message);
	}
	
	public FaceppParseException(String message, int errorCode, String errorMessage, int httpResponseCode) {
		super(message + " code="+errorCode + ", message="+errorMessage + ", responseCode="+httpResponseCode);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpResponseCode = httpResponseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public Integer getHttpResponseCode() {
		return httpResponseCode;
	}
	
	public boolean isAPIError() {
		return this.errorCode != null && this.errorMessage != null && this.httpResponseCode != null; 
	}
		
}
