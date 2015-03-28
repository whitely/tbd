package units;

import java.awt.Point;
import java.util.ArrayList;

import controller.Command;
import controller.ControlLink;
import controller.Controllable;
import affinity.AffinityStrategy;

public class Subject implements Controllable{
	private AffinityStrategy affinityStrat;
	private int grace;
	private int intelligence;
	private int strength;
	private int traitPoints;
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
	
	public int getTraitPoints()
	{
		return traitPoints;
	}
	
	public void setTraitPoints(int val)
	{
		traitPoints = val;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String val)
	{
		name = val;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ControlLink getControlLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Command> getSlaveCommands() {
		// TODO Auto-generated method stub
		return null;
	}
}
