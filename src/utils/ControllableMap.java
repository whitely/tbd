package utils;

import java.util.Collection;
import java.util.HashMap;

import controller.Controllable;

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
	
	public static void remove(String id) {
		check();
		hash.remove(id);
	}
	
	public static void put(Controllable c) {
		check();
		hash.put(c.getID().get(), c);
	}
	
	public static Controllable get(String id)
	{
		check();
		return hash.get(id);
	}
	
	public static Controllable get(UUID uuid) {
		return get(uuid.get());
	}
	
	public static Collection<Controllable> getVals() {
		check();
		return hash.values();
	}

}
