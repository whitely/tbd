package controller.command;

import java.awt.Point;
import java.awt.Rectangle;

import controller.Controllable;
import units.Locatable;
import units.Subject;
import units.Terrain;
import utils.CollisionChecker;
import utils.ControllableMap;
import utils.RNG;
import world.World;

public class MoveSelf extends Command{
	/*
	 * Parameters:
	 * Subject, desiredLocation
	 */
	private Point oldLocation;
	private final double DIFFICULTY = 0;

	
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
		Subject subject = (Subject)params[0];
		Point desiredLocation = (Point)params[1];
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
		double distance = Math.sqrt((moveWidth)^2 + (moveHeight)^2)*1/(speedModifier);
		//TODO: verify this formula with Random
		if (RNG.getRandom().nextDouble()*subject.getGrace()>.3*DIFFICULTY*distance){
			return true;
		}
		return false;
	}

}
