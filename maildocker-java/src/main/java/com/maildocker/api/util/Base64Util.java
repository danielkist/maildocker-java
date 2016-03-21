package com.maildocker.api.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {
	
	public static String encode(String arg0) {
		final byte[] authBytes = arg0.getBytes(StandardCharsets.UTF_8);
        final String encoded   = Base64.getEncoder().encodeToString(authBytes);
        return encoded;
	}

}