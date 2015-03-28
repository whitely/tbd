package units.elementals;

import java.awt.Point;
import java.util.ArrayList;

import utils.UUID;
import controller.ControlLink;
import controller.Controllable;
import controller.command.Command;

public class Elemental implements Controllable{
	protected Point location;
	private UUID id;
	
	
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

	@Override
	public void setLocation(Point location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UUID getID() {
		return id;
	}

}
