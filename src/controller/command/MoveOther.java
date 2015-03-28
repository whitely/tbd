package controller.command;

import java.awt.Point;
import java.awt.Rectangle;

import controller.Controllable;
import units.Locatable;
import units.Subject;
import units.elementals.Elemental;
import utils.ControllableMap;
import utils.RNG;

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
		double distance = Math.sqrt((desiredLocation.x - subject.getLocation().x)^2 + (desiredLocation.y - subject.getLocation().y)^2); 
		//TODO: verify this formula with Random
		for(Object objA : params){
			for(Controllable contB : ControllableMap.getVals()) {
				Locatable a = (Locatable)objA;
				Locatable b = (Locatable)contB;
				if(checkCollision(a,b)){
					return false;
				}
			}
		}
		if (controllable instanceof Subject && RNG.getRandom().nextDouble()*subject.getIntelligence()*subject.getStrength()>=.3*distance*((Subject)controllable).getMass()*DIFFICULTY){
			return true;
		}
		if (controllable instanceof Elemental && RNG.getRandom().nextDouble()*subject.getIntelligence()>=.3*distance*((Elemental)controllable).getJoules()*DIFFICULTY){
			return true;
		}
		return false;
	}
	
	public boolean checkCollision(Locatable a, Locatable b){
		Rectangle rectA = new Rectangle(a.getLocation().x,a.getLocation().y,a.getWidth(),a.getHeight());
		Rectangle rectB = new Rectangle(b.getLocation().x,b.getLocation().y,b.getWidth(),b.getHeight());
		return rectA.intersects(rectB);
	}

}
