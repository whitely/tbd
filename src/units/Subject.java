package units;

import java.awt.Point;
import java.util.ArrayList;

import utils.SubjectID;
import controller.ControlLink;
import controller.Controllable;
import controller.command.Command;
import affinity.AffinityStrategy;

public class Subject implements Controllable{
	private AffinityStrategy affinityStrat;
	private Point location;
	private int grace;
	private int intelligence;
	private int strength;
	private int traitPoints;
	//private PosnObject posn;
	private String name;
	
	public final SubjectID id;
	
	public Subject() {
		id = new SubjectID();
	}
	
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
		return location;
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
