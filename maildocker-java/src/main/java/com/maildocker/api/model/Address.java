package com.maildocker.api.model;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String email;
	
	public static Address getInstance(String name, String email) {
		Address inst = new Address();
		inst.setName(name);
		inst.setEmail(email);
		return inst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
