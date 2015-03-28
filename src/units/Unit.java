package units;

import java.awt.Point;

import controller.Controllable;

public abstract class Unit implements Locatable, Controllable {
	protected Point location;
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
}
