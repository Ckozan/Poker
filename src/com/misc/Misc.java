package com.misc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Misc {
	
	public static String hashString(String string, long key) {
		StringBuilder builder = new StringBuilder();
		string = string+key;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(string.getBytes(StandardCharsets.UTF_8));
		    for (int i = 0; i < hash.length; i++) {
		        String hex = Integer.toHexString(0xff & hash[i]);
		        if(hex.length() == 1) builder.append('0');
		            builder.append(hex);
		        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(builder.toString());
		return builder.toString();
	}
}
