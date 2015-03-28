package units;

import affinity.AffinityStrategy;

public class Subject {
	private AffinityStrategy affinityStrat;
	private int grace;
	private int intelligence;
	private int strength;
	//private PosnObject posn;
	private String name;
	
	public AffinityStrategy getAffinityStrat()
	{
		return affinityStrat; 
	}
	
	public int getGrace()
	{
		return grace;
	}
	
	public void setGrace(int val)
	{
		grace = val;
	}
	
	public int getIntelligence()
	{
		return intelligence;
	}
	
	public void setIntelligence(int val)
	{
		intelligence = val;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public void setStrength(int val)
	{
		strength = val;
	}
	
	//TODO: posn getter and setter
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String val)
	{
		name = val;
	}
}
