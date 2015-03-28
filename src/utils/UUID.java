package utils;

import java.util.Random;

public class UUID {
	private final String id;
	
	public UUID() {
		String s = "";
		
		for(int i = 0; i < 16; i++)
			s += randomChar();
		
		id = s;
	}
	
	public String get()
	{
		return id;
	}
	
	private String randomChar()
	{
		Random random = RNG.getRandom();
		int num = random.nextInt(16);
		return Integer.toHexString(num);
	}
}
