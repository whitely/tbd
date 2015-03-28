package controller;

import java.awt.Point;
import java.util.ArrayList;

public interface Controllable {
	public Point getLocation();
	public ControlLink getControlLink(); //?
	public ArrayList<Command> getSlaveCommands();
}
