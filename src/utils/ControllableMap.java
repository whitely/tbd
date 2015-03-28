package utils;

import java.util.HashMap;

import controller.Controllable;
import units.Subject;

public class ControllableMap {
	private static volatile HashMap<String, Controllable> hash;
	
	private ControllableMap()
	{
		hash = new HashMap<>();
	}
	
	private static void check() {
		if (hash == null)
			new ControllableMap();
	}
	
	public static void put(String id, Subject subject)
	{
		check();
		hash.put(id, subject);
	}
	
	public static Controllable get(String id)
	{
		check();
		return hash.get(id);
	}
	
	public static Controllable get(UUID uuid) {
		return get(uuid.get());
	}

}
