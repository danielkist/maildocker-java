package com.maildocker.api.util;

public class StringUtil {
	
	public static String replaceSpecialCharToUnicode(String value) {
		char[] special = { 'á','à','â','ã','é','ê','í','î','ó','ô','õ','ú','û','ü','ç','ñ', 
					       'Á','À','Â','Ã','É','Ê','Í','Î','Ó','Ô','Õ','Ú','Û','Ü','Ç','Ñ' };
		for (char c : special) value = value.replace(c + "","\\u" + Integer.toHexString(c | 0x10000).substring(1));
		return value;
	}

}
