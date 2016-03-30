package com.maildocker.api.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maildocker.api.model.Authorization;
import com.maildocker.api.util.Base64Util;


public class BaseHttpBuilder {
	
	private final Gson gson  = new GsonBuilder().create();
	private String URL       = "http://%s.ecentry.io/api";
	
	/**
	 * HTTP Call
	 * Method GET
	 * @param authorization
	 * @param endpoint
	 * @return
	 */
	public String call(Authorization authorization, String endpoint) {
		return this.call(authorization, endpoint, null);
	}
	
	/**
	 * HTTP Call
	 * IF param != null -> Method == POST
	 * IF param == null -> Method == GET
	 * @param authorization
	 * @param endpoint
	 * @param param
	 * @return
	 */
	public String call(Authorization authorization, String endpoint, Object param) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String content = null;
		CloseableHttpResponse response;
		try {
			HttpRequestBase http;
			if(param == null) {
				http = new HttpGet(String.format(URL + endpoint, authorization.getDomain()));
			} else {
				http = new HttpPost(String.format(URL + endpoint, authorization.getDomain()));
				http.addHeader("Content-Type", "application/json;charset=UTF-8");
				
				StringEntity input = new StringEntity(gson.toJson(param), Charset.forName("UTF-8"));
				input.setContentType("application/json;charset=UTF-8");
				input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
				((HttpPost) http).setEntity(input);
			}
			
			http.addHeader("Authorization", getBasicAuthorization(authorization));
			response = httpclient.execute(http);
			HttpEntity entity = response.getEntity();
			content = HttpUtil.read(entity.getContent());
			EntityUtils.consume(entity);			
			
			response.close();
			httpclient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	private String getBasicAuthorization(Authorization authorization) {
		String userpass  = String.format("%s:%s", authorization.getKey(), authorization.getSecret());
		userpass = Base64Util.encode(userpass);
		return "Basic " + userpass;
	}

}
