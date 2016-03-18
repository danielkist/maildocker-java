package com.maildocker.api.model;

import java.io.Serializable;

public class AuthorizationError implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String error_code;
	
	private String user_message;
	
	private String dev_message;

	public String getErrorCode() {
		return error_code;
	}

	public void setErrorCode(String errorCode) {
		this.error_code = errorCode;
	}

	public String getUserMessage() {
		return user_message;
	}

	public void setUserMessage(String userMessage) {
		this.user_message = userMessage;
	}

	public String getDevMessage() {
		return dev_message;
	}

	public void setDevMessage(String devMessage) {
		this.dev_message = devMessage;
	}

}
