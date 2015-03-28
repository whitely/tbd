package controller.command;

import java.awt.Point;

import controller.Controllable;
import units.Subject;
import utils.RNG;


public class Create extends Command{
	/*
	 * Subject, Controllable, desiredLocation
	 * 
	 */
	Subject subject = (Subject)params[0];
	Controllable controllable = (Controllable)params[1];
	Point desiredLocation = (Point)params[2];
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
		if (RNG.getRandom().nextDouble()*subject.getIntelligence()>.3){
			return true;
		}
		return false;
	}


}
