package com.maildocker.api.model;

import java.io.Serializable;

public class Authorization implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String domain;
	
	private String key;
	
	private String secret;
	
	public static Authorization getInstance(String domain, String key, String secret) {
		Authorization inst = new Authorization();
		inst.setDomain(domain);
		inst.setKey(key);
		inst.setSecret(secret);
		return inst;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
