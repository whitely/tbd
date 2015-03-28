package utils;

import java.awt.Rectangle;
import java.util.Collection;

import controller.Controllable;
import units.Locatable;

public class CollisionChecker {
	public static boolean checkCollision(Locatable a, Locatable b){
		Rectangle rectA = new Rectangle(a.getLocation().x,a.getLocation().y,a.getWidth(),a.getHeight());
		Rectangle rectB = new Rectangle(b.getLocation().x,b.getLocation().y,b.getWidth(),b.getHeight());
		return rectA.intersects(rectB);
	}
	
	public static boolean checkCollisions(Object[] listA, Collection<Controllable> listB){
		for(Object objA : listA){
			for(Controllable contB : listB) {
				Locatable a = (Locatable)objA;
				Locatable b = (Locatable)contB;
				if(checkCollision(a,b)){
					return true;
				}
			}
		}
		return false;
	}
}
