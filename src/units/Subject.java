package units;

import affinity.AffinityStrategy;

public class Subject {
	private AffinityStrategy affinityStrat;
	private int G;
	private int I;
	private int S;
	//private PosnObject posn;
	private String name;
	
	public AffinityStrategy getAffinityStrat()
	{
		return affinityStrat; 
	}
	
	public int getG()
	{
		return G;
	}
	
	public void setG(int val)
	{
		G = val;
	}
	
	public int getI()
	{
		return I;
	}
	
	public void setI(int val)
	{
		I = val;
	}
	
	public int getS()
	{
		return S;
	}
	
	public void setS(int val)
	{
		S = val;
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
