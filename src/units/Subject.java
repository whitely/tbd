package units;

import java.awt.Point;
import java.util.ArrayList;

import world.World;
import affinity.AffinityStrategy;
import controller.ControlLink;
import controller.Controllable;
import controller.command.AttackCommand;
import controller.command.Command;
import controller.command.MoveSelf;
import controller.command.Summon;

public class Subject extends Unit {
	private AffinityStrategy affinityStrat;
	private ControlLink currentControlLink;
	private int grace;
	private int intelligence;
	private int strength;
	private int traitPoints;
	private double volume;
	private double mass;
	private String name;
	private String assetPath;
	
	public Subject(Point location, int width, int height) {
		super(location, width, height);
	}
	
	public Subject()
	{
		super(new Point(0,0), 0, 0);
	}
	
	public void createControlLink(Controllable target){
		currentControlLink = new ControlLink(this,target);
	}
	
	public ArrayList<Class> getCurrentControlCommands(){
		return currentControlLink.getCommands();
	}
	
	public void doSummon(Controllable slave, Point desiredLocation){
		if (currentControlLink != null){
			Command c = currentControlLink.createSummonCommand(this, slave, desiredLocation);
			World.doCommand(c);
		} else {
			System.out.println("Warning - Attempted summon command given without present control link.");
		}
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
		return currentControlLink;
	}

	@Override
	public ArrayList<Class> getSlaveCommands() {
		//TODO: include here all new commands which may be acted on Subject
		ArrayList<Class> c = new ArrayList<Class>();
		c.add(MoveSelf.class);
		c.add(Summon.class);
		c.add(AttackCommand.class);
		return c;
	}

	public double getVolume(){
		return volume;
	}
	
	public void setVolume(double volume){
		this.volume = volume;
	}

	public double getMass() {
		return mass;
	}
	
	public void setMass(double value)
	{
		mass = value;
	}
	
	public void setAffinityStrat(AffinityStrategy affinityStrat) {
		this.affinityStrat = affinityStrat;
	}

	@Override
	public String getAssetPath() {
		return assetPath;
	}
	
	@Override
	public void setAssetPath(String location)
	{
		assetPath = location;
	}
}
