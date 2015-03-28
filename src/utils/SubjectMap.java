package utils;

import java.util.HashMap;

import units.Subject;

public class SubjectMap {
	private HashMap<String, Subject> hash;
	
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
}
