package controller;

import java.util.ArrayList;

import units.Subject;
import world.World;

public class AgressiveStrategy extends PlayStrategy {
	public void doTurn(World w, Subject owner){
		super.doTurn(w, owner);
		while(turnPoints>0){
			ArrayList<Subject> targets = World.getSubjects();
			if(targets == null || targets.isEmpty()){
				return;
			}
			Subject closest = null;
			double distance=10000;
			for(Subject target : targets){
				if(target.getID() != owner.getID() && target.getLocation().distance(owner.getLocation())<distance){
					distance = target.getLocation().distance(owner.getLocation());
					closest = target;
				}
			}
			if(distance>40 && closest != null){
				move(owner, closest.getLocation());
			} else if(closest != null && turnPoints>=5){
				attack(owner, closest);
			} else {
				turnPoints=0;
			}
		}
	}
}
