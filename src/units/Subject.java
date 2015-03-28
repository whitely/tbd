package units;

import java.awt.Point;
import java.util.ArrayList;

import utils.UUID;
import controller.ControlLink;
import controller.command.Command;
import affinity.AffinityStrategy;

public class Subject extends Unit {
	private AffinityStrategy affinityStrat;
	private int grace;
	private int intelligence;
	private int strength;
	private int traitPoints;
	private int volume;
	//private PosnObject posn;
	private String name;
	
	public final UUID id;
	
	public Subject() {
		id = new UUID();
	}
	
	public AffinityStrategy getAffinityStrat() {
		return affinityStrat; 
	}
	
	public int getGrace() {
		return grace;
	}
	
	public void setGrace(int val) {
		grace = val;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public void setIntelligence(int val) {
		intelligence = val;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int val) {
		strength = val;
	}
	
	public int getTraitPoints() {
		return traitPoints;
	}
	
	public void setTraitPoints(int val) {
		traitPoints = val;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String val) {
		name = val;
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

	@Override
	public void setLocation(Point location) {
		this.location = location;
	}

	@Override
	public UUID getID() {
		return id;
	}
	
	public int getVolume(){
		return volume;
	}
	
	public void setVolume(){
		this.volume = volume;
	}
}
