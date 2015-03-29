package controller;

import java.awt.Point;

import units.Subject;
import world.World;
import controller.command.*;

public abstract class PlayStrategy {
	protected int turnPoints;
	
	public void doTurn(World w, Subject owner){
		turnPoints=10;
	}
	
	protected void move(Subject subject, Point location){
		MoveSelf mo = new MoveSelf();
		mo.setParameters(new Object[]{subject, location});
		mo.execute();
		turnPoints--;
	}
	
	protected void attack(Subject subject, Subject target){
		AttackCommand ac = new AttackCommand();
		ac.setParameters(new Object[]{subject, target});
		ac.execute();
		turnPoints -= 5;
	}
	
	protected void summon(Subject subject, Controllable target, Point desiredLocation){
		Summon s = new Summon();
		s.setParameters(new Object[]{subject, target, desiredLocation});
		s.execute();
		turnPoints -= 5;
	}
}
