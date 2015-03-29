package controller.command;

import java.awt.Point;
import java.awt.Rectangle;

import controller.Controllable;
import units.Locatable;
import units.Subject;
import units.Terrain;
import units.elementals.Elemental;
import utils.CollisionChecker;
import utils.ControllableMap;
import utils.RNG;
import world.World;

public class MoveOther extends Command{
	/*
	 * Parameters:
	 * Subject, Controllable, desiredLocation
	 */
	//TODO: determine good difficulty constant
	private final double DIFFICULTY = 0;

	private Point oldLocation;
	
	@Override
	protected void executeCommand(Object[] params) {
		oldLocation = ((Subject)params[1]).getLocation();
		((Subject)params[1]).setLocation((Point)params[1]);
	}

	@Override
	protected void undoCommand(Object[] params) {
		((Subject)params[1]).setLocation(oldLocation);
	}

	@Override
	public boolean isPossible() {
		Subject subject = (Subject)params[0];
		Controllable controllable = (Controllable)params[1];
		Point desiredLocation = (Point)params[2];
		int moveWidth = desiredLocation.x - subject.getLocation().x;
		int moveHeight = desiredLocation.y - subject.getLocation().y;
		Rectangle a = new Rectangle(subject.getLocation().x,subject.getLocation().y,moveWidth,moveHeight); 
		double speedModifier = 1; 
		for(Terrain terrain : World.getTerrain()) {
			Locatable b = (Locatable)terrain;
			if(CollisionChecker.checkCollision(a,b)){
				speedModifier = speedModifier*terrain.getSpeedMultiplier();
			}
		}
		double distance = Math.sqrt((moveWidth)^2 + (moveHeight)^2);
		//TODO: verify this formula with Random
		if (controllable instanceof Subject && RNG.getRandom().nextDouble()*subject.getIntelligence()*subject.getStrength()>=.3*distance*((Subject)controllable).getMass()*DIFFICULTY){
			return true;
		}
		if (controllable instanceof Elemental && RNG.getRandom().nextDouble()*subject.getIntelligence()>=.3*distance*((Elemental)controllable).getJoules()*DIFFICULTY){
			return true;
		}
		return false;
	}

}
