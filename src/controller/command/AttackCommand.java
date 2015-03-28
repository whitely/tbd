package controller.command;

import units.Subject;
import utils.RNG;

public class AttackCommand extends Command{
	
/*
 * Attack Parameter: Subject 0, Subject 1, damage
 * hit or not (roll) 
 * target
 *  
 */

public boolean isPossible() {
	Subject subject = (Subject)params[0];
	Subject target = (Subject)params[1];
	return RNG.getRandom().nextDouble() + Math.sqrt(subject.getStrength()) > 
	target.getGrace() /*+ target.getArmorGrade()*/;
	//currently attacks have infinite range
} 
	
@Override
protected void executeCommand(Object[] params) {
	// TODO Auto-generated method stub
	int damageTotal = 0;
	Subject subject = (Subject)params[0];
	Subject target = (Subject)params[1];
	for (int i; i < subject.getStrength()/10; i++){
	damageTotal += RNG.getRandom().nextInt(4) + 1;
	}
	target.setHealth(target.getHealth() - damageTotal);
}

@Override
protected void undoCommand(Object[] params) {
	// TODO Auto-generated method stub
	
}
	
	
}
