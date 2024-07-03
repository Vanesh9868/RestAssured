package com.utility;

import java.util.Random;

public class Library {

	public static String getRandomString(int lenght) {
		String characters = "ASDFGHJKLQWERTYUIO123456789asdfghjkmnbvcxz3456789";
		Random RANDOM = new Random();
		StringBuilder sb = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			int index = RANDOM.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
