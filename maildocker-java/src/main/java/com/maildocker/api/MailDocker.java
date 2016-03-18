package com.maildocker.api;

import com.maildocker.api.exception.MailDocketException;
import com.maildocker.api.http.BaseHttpBuilder;
import com.maildocker.api.model.Authorization;
import com.maildocker.api.model.Message;
import com.maildocker.api.model.MessageResponse;

public class MailDocker {
	
	private final Authorization authorization;
	private final BaseHttpBuilder http = new BaseHttpBuilder();;
	
	public MailDocker(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public MailDocker(String domain, String key, String secret) {
		this.authorization = Authorization.getInstance(domain, key, secret);
	}
	
	public void events() {
		String response = http.call(authorization, "/event/");
		System.out.println(response);
	}
	
	public MessageResponse send(Message message) throws MailDocketException {
		String response = http.call(authorization, "/mail/", message);
		if(response.contains("error_code")) throw new MailDocketException(response);
		System.out.println(response);
		return null;
	}

}
