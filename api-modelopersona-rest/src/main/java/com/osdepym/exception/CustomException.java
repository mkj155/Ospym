package com.osdepym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Verifique los datos enviados")
public class CustomException extends Exception {

	/**
	 * 
	 */
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