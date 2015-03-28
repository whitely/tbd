package controller;

import java.util.ArrayList;

import controller.command.Command;
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
	
	public void doCreateCommand(Controllable master, Controllable slave, Point desiredLocation){
		
	}
	
}
