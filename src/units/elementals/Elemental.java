package units.elementals;

import java.util.ArrayList;

import units.Unit;
import controller.ControlLink;
import controller.command.Command;

public class Elemental extends Unit{
	private int joules;

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

	public double getJoules() {
		// TODO Auto-generated method stub
		return joules;
	}

}
