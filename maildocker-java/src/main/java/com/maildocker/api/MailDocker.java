package com.maildocker.api;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.maildocker.api.exception.MailDocketException;
import com.maildocker.api.http.BaseHttpBuilder;
import com.maildocker.api.model.Authorization;
import com.maildocker.api.model.Message;
import com.maildocker.api.model.MessageResponse;
import com.maildocker.api.model.TemplateMessage;

public class MailDocker {
	
	private final Authorization authorization;
	private final BaseHttpBuilder http = new BaseHttpBuilder();;
	private final Gson gson = new GsonBuilder().create();
	
	public MailDocker(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public MailDocker(String domain, String key, String secret) {
		this.authorization = Authorization.getInstance(domain, key, secret);
	}
	
	public MessageResponse send(Message message) throws MailDocketException {
		String response = http.call(authorization, "/maildocker/v1/mail/", message);
		if(response.contains("error_code")) throw new MailDocketException(response);
		return getMessageResponse(response);
	}
	
	public MessageResponse send(TemplateMessage message) throws MailDocketException {
		String response = http.call(authorization, "/maildocker/v1/mail/", message);
		if(response.contains("error_code")) throw new MailDocketException(response);
		return getMessageResponse(response);
	}
	
	private MessageResponse getMessageResponse(String response) {
		List<MessageResponse> list = gson.fromJson(response, new TypeToken<List<MessageResponse>>() {}.getType());
		return list.get(0);
	}

}
