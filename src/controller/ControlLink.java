package controller;

import java.awt.Point;
import java.util.ArrayList;

import controller.command.Command;
import controller.command.Destroy;
import controller.command.MoveSelf;
import controller.command.Summon;
import units.Subject;

public class ControlLink {
	private Controllable master;
	private Controllable slave;
	private int controlStrength;
	
	public ControlLink(Controllable master, Controllable slave){
		this.master = master;
		this.slave = slave;
	}
	
	public ArrayList<Class> getCommands(){
		return slave.getSlaveCommands();
	}
	
	public Command createSummonCommand(Controllable master, Controllable slave, Point desiredLocation){
		Command c = new Summon();
		Object[] obj = new Object[3];
		obj[0]= master; 
		obj[1] = slave;
		obj[2] = desiredLocation;
		c.setParameters(obj);
		return c;
	}
	
	public Command createDestroyCommand(Controllable master, Controllable slave, Point desiredLocation){
		Command c = new Destroy();
		Object[] obj = new Object[3];
		obj[0]= master; 
		obj[1] = slave;
		obj[2] = desiredLocation;
		c.setParameters(obj);
		return c;
	}
	
	public Command createMoveSelfCommand(Controllable master, Point desiredLocation){
		Command c = new MoveSelf();
		Object[] obj = new Object[2];
		obj[0]= master; 
		obj[1] = desiredLocation;
		c.setParameters(obj);
		return c;
	}
	
	public Command createMoveOtherCommand(Controllable master, Controllable slave, Point desiredLocation){
		Command c = new Destroy();
		Object[] obj = new Object[2];
		obj[0]= master; 
		obj[1] = slave;
		obj[2] = desiredLocation;
		c.setParameters(obj);
		return c;
	}
	
}
