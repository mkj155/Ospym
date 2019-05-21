package com.osdepym.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1361286122292980072L;
	private String customMessage;
	
	// Parameterless Constructor
	public CustomException() {
	}

	// Constructor that accepts a message
	public CustomException(String message, String customMessage) {
		super(message);
		printStackTrace();
		this.setCustomMessage(customMessage);
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

}
