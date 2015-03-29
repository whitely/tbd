package utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;

import units.Locatable;
import units.Subject;
import world.World;
import controller.Controllable;

public class CollisionChecker {
	public static boolean checkCollision(Locatable a, Locatable b){
		Rectangle rectA = new Rectangle(a.getLocation().x,a.getLocation().y,a.getWidth(),a.getHeight());
		Rectangle rectB = new Rectangle(b.getLocation().x,b.getLocation().y,b.getWidth(),b.getHeight());
		return rectA.intersects(rectB) || rectA.contains(rectB) || rectB.contains(rectA);
	}

	public static boolean checkCollision(Rectangle a, Locatable b){
		Rectangle rectB = new Rectangle(b.getLocation().x,b.getLocation().y,b.getWidth(),b.getHeight());
		return a.intersects(rectB) || a.contains(rectB) || rectB.contains(a);
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

	public static Locatable getContaining(ArrayList<Locatable> locatables, Point p) {
		for (Locatable l : locatables) {
			if (p != null && contains(l, p)) {
				System.out.println("You clicked at (" + p.x + ", " + p.y + ") on Locatable " + l);
				return l;
			}
		}
		return null;
	}

	private static boolean contains(Locatable l, Point p) {
		Rectangle rect = new Rectangle(l.getLocation().x, l.getLocation().y, l.getWidth(), l.getHeight());
		return rect.contains(p);
	}

	public static Locatable getContaining(Point p) {
		ArrayList<Subject> subjects = World.getSubjects();
		ArrayList<Locatable> locs = new ArrayList<>();
		for (Subject s : subjects)
			locs.add(s);
		return CollisionChecker.getContaining(locs, p);
	}
}
