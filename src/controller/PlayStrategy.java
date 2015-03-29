package controller;

import java.awt.Point;

import units.Subject;
import controller.command.*;

public abstract class PlayStrategy {
	protected int turnPoints;
	
	public void doTurn(){
		turnPoints=10;
	}
	
	protected void move(Subject subject, Point location){
		MoveSelf mo = new MoveSelf();
		mo.setParameters(new Object[]{subject, location});
		mo.execute();
		turnPoints--;
	}
	
	protected void attack(Subject subject, Subject target, int damage){
		AttackCommand ac = new AttackCommand();
		ac.setParameters(new Object[]{subject, target, damage});
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
