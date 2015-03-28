package controller;

import java.util.ArrayList;

import utils.UUID;
import controller.command.Command;

public interface Controllable {
	public ControlLink getControlLink(); //?
	public ArrayList<Class> getSlaveCommands();
	
	public UUID getID();
}
