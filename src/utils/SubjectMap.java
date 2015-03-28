package utils;

import java.util.HashMap;

import controller.Controllable;
import units.Subject;

public class SubjectMap {
	private static HashMap<String, Subject> hash;
	
	public SubjectMap()
	{
		hash = new HashMap<>();
	}
	
	public void put(String id, Subject subject)
	{
		hash.put(id, subject);
	}
	
	public Subject get(String id)
	{
		return hash.get(id);
	}
	
	public static Controllable get(UUID uuid) {
		
	}

}
