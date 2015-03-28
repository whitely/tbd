package controller;

import java.util.ArrayList;

import controller.command.Command;
import units.Subject;

public class ControlLink {
	private Subject master;
	private Controllable slave;
	private int controlStrength;
	
	public ControlLink(Controllable master, Controllable slave){
		//TODO: calculate controlStrenght based on master-slave qualities
	}
	
	public ArrayList<Command> getCommands(){
		return slave.getSlaveCommands();
	}
	
	
}
