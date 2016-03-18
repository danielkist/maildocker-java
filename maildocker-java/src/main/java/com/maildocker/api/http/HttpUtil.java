package com.maildocker.api.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class HttpUtil {
	
	public static String read(InputStream stream) {
		try {
			return IOUtils.toString(stream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String read(InputStream stream, Charset charset) {
		try {
			return IOUtils.toString(stream, charset);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
