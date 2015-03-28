package controller;

import java.util.ArrayList;

import utils.UUID;
import controller.command.Command;

public interface Controllable {
	public ControlLink getControlLink(); //?
	public ArrayList<Command> getSlaveCommands();
	
	public UUID getID();
}
