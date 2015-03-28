package utils;

import java.util.Random;

public class SubjectID {
	private final String id;
	
	public SubjectID() {
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
