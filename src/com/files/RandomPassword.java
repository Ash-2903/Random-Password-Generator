package com.files;

import java.util.Random;

public class RandomPassword {

	public static final String lowercase_chars = "abcdefghijklmnopqrstuvwxyz";
	public static final String uppercase_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numbers = "0123456789";
	public static final String sp_symbols = "!@#$%^&(*)=[]{}:<>?";
	
	private final Random random;
	
	public RandomPassword() {
		random = new Random();
	}
	
	public String generate(int len, boolean up, boolean low, boolean num, boolean sym) {
		
		StringBuilder st = new StringBuilder();
		
		String validChars = "";
		
		if(up)
			validChars += uppercase_chars;
		if(low)
			validChars += lowercase_chars;
		if(num)
			validChars += numbers;
		if(sym)
			validChars += sp_symbols;
		
		for(int i=0;i<len;i++) {
			char randomChar = validChars.charAt(random.nextInt(validChars.length()));
			st.append(randomChar);
		}
		
		return st.toString();
		
	}
	
}
