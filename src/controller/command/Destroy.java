package controller.command;

import java.awt.Point;

import controller.Controllable;
import units.Subject;
import units.elementals.Elemental;
import utils.ControllableMap;
import utils.RNG;

public class Destroy extends Command{
	//TODO: find good difficulty factor to allow decent chance of destroy
	private final double DIFFICULTY = 1;
	
	@Override
	public boolean isPossible() {
		//Might want to make the difficulty modifier here dependent on summoned object level or something.
		//Currently it is only depended on the distance and the type of controllable (thus volume or energy level).
		Subject subject = (Subject)params[0];
		Controllable controllable = (Controllable)params[1];
		Point desiredLocation = (Point)params[2];
		double distance = Math.sqrt((desiredLocation.x - subject.getLocation().x)^2 + (desiredLocation.y - subject.getLocation().y)^2); 
		double difficultyModifier = Math.pow(distance,2);
		if (controllable instanceof Subject && RNG.getRandom().nextDouble()*(((Subject)controllable).getVolume())>DIFFICULTY*difficultyModifier){
			return true;
		}
		if (controllable instanceof Elemental && RNG.getRandom().nextDouble()*(((Elemental)controllable).getJoules())>DIFFICULTY*difficultyModifier){
			return true;
		}
		return false;
	}
	
	@Override
	public void executeCommand(Object[] params) {
		ControllableMap.remove(((Controllable) params[1]).getID().get());
	}

	@Override
	public void undoCommand(Object[] params) {
		ControllableMap.put((Controllable)params[1]);
	}

}
