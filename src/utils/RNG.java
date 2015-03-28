package utils;

import java.util.Random;

public class RNG {
	private static volatile Random rand;
	
	private RNG() {
		rand = new Random();
	}
	
	public static Random getRandom() {
		if (rand == null)
			new RNG();
		
		return rand;
	}
}
