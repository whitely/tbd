package utils;

import java.util.Random;

public class UUID implements Comparable<UUID> {
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

	@Override
	public int compareTo(UUID o) {
		if (this.equals(o))
			return 0;
		else
			return 1;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!(other instanceof UUID))
			return false;
		
		return this.id.equals(((UUID)other).id);
	}
}
