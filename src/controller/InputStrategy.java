package controller;

import java.awt.Point;

import controller.command.MoveOther;
import units.Subject;
import world.World;

public class InputStrategy extends PlayStrategy {
	public void doTurn(World w, Subject owner){
		super.doTurn(w, owner);
	}
	
	public void moveTo(Subject subject, Point location){
		if(turnPoints>0){
			super.move(subject, location);
		}
	}
	
	public void attackTarget(Subject subject, Subject target) {
		if(turnPoints>=5){
			super.attack(subject, target);
		}
	}
	
	public void summonTargetTo(Subject subject, Controllable target, Point location){
		if(turnPoints>=5){
			super.summon(subject, target, location);
		}
	}
	
	public void commandTarget(Subject subject, Subject target, Point location) {
		MoveOther mo = new MoveOther();
		mo.setParameters(new Object[]{subject,target,location});
		mo.execute();
		turnPoints -= 2;
	}
}
