package controller.command;

import java.awt.Point;

import units.Subject;
import utils.RNG;

public class MoveSelf extends Command{
	/*
	 * Parameters:
	 * Subject, desiredLocation
	 */
	private Point oldLocation;
	
	@Override
	protected void executeCommand(Object[] params) {
		oldLocation = ((Subject)params[0]).getLocation();
		((Subject)params[0]).setLocation((Point)params[1]);
	}

	@Override
	protected void undoCommand(Object[] params) {
		((Subject)params[0]).setLocation(oldLocation);
	}

	@Override
	public boolean isPossible() {
		//this formula was not approved by Random
		Subject s = (Subject)params[0];
		if (RNG.getRandom().nextDouble()*s.getGrace()>.3){
			return true;
		}
		return false;
	}

}
