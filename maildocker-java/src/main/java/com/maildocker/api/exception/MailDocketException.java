package com.maildocker.api.exception;

import com.google.gson.GsonBuilder;
import com.maildocker.api.model.AuthorizationError;

public class MailDocketException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private AuthorizationError error;
	
	public MailDocketException() {}
	
	public MailDocketException(String json) {
		this.error = new GsonBuilder().create().fromJson(json, AuthorizationError.class);
	}

	public AuthorizationError getError() {
		return error;
	}

	public void setError(AuthorizationError error) {
		this.error = error;
	}
	
	

}
