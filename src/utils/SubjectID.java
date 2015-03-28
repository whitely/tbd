package utils;

import java.util.Random;

public class SubjectID {
	private String id;
	
	public void generate()
	{
		StringBuffer buf = new StringBuffer();
		
		for(int i = 0; i < 16; i++)
		{
			buf.append(randomChar());
		}
		
		id = buf.toString();
	}
	
	public String get()
	{
		return id;
	}
	
	private char randomChar()
	{
		Random random = RNG.getRandom();
		
		int num = random.nextInt(16);
		char val;
		
		switch(num)
		{
		case 0:
			val = '0';
			break;
		case 1:
			val = '1';
			break;
		case 2:
			val = '2';
			break;
		case 3:
			val = '3';
			break;
		case 4:
			val = '4';
			break;
		case 5:
			val = '5';
			break;
		case 6:
			val = '6';
			break;
		case 7:
			val = '7';
			break;
		case 8:
			val = '8';
			break;
		case 9:
			val = '9';
			break;
		case 10:
			val = 'a';
			break;
		case 11:
			val = 'b';
			break;
		case 12:
			val = 'c';
			break;
		case 13:
			val = 'd';
			break;
		case 14:
			val = 'e';
			break;
		case 15:
			val = 'f';
			break;
		default:
			val = '0';
			break;
		}
		
		return val;
	}
}
