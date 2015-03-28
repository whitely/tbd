package controller;

import java.awt.Point;
import java.util.ArrayList;

import utils.UUID;
import controller.command.Command;

public interface Controllable {
	public Point getLocation();
	public ControlLink getControlLink(); //?
	public ArrayList<Command> getSlaveCommands();
	
	public UUID getID();
}
