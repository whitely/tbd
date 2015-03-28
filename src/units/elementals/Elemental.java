package units.elementals;

import java.util.ArrayList;

import units.Unit;
import controller.ControlLink;
import controller.command.Attack;
import controller.command.AttackCommand;
import controller.command.Command;
import controller.command.Move;
import controller.command.Summon;

public abstract class Elemental extends Unit{
	private int joules;

	protected Elemental() {
		super();
	}
	
	@Override
	public ControlLink getControlLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Class> getSlaveCommands() {
		//TODO: include here all new commands which may be acted on Subject
		ArrayList<Class> c = new ArrayList<Class>();
		c.add(Move.class);
		c.add(Summon.class);
		c.add(AttackCommand.class);
		c.add(Destroy.class);
		return c;
	}

	public double getJoules() {
		// TODO Auto-generated method stub
		return joules;
	}

}
