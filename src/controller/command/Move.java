package controller.command;

import units.Subject;
import utils.RNG;

public class Move extends Command{
	/*
	 * Move Parameters
	 * Subject, desiredLocation
	 */
	@Override
	protected void executeCommand(Object[] params) {
		
	}

	@Override
	protected void undoCommand(Object[] params) {
		
	}

	@Override
	public boolean isPossible() {
		if (RNG.getRandom().nextDouble()*((Subject)params[0]).getGrace()>.3){
			return true;
		}
		return false;
	}

}
