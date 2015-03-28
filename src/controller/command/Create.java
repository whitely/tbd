package controller.command;

import units.Subject;
import utils.RNG;


public class Create extends Command{
	/*
	 * Subject, Controllable, desiredLocation
	 * 
	 */

	@Override
	public void executeCommand(Object[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undoCommand(Object[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPossible() {
		//formula not approved by Random
		if (RNG.getRandom().nextDouble()*((Subject)params[0]).getIntelligence()>.3){
			return true;
		}
		return false;
	}


}
