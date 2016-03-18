package com.maildocker.api.model;

import java.io.Serializable;

public class MessageResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String uuid;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
