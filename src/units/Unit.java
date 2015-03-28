package units;

import java.awt.Point;

import utils.UUID;
import controller.Controllable;

public abstract class Unit implements Locatable, Controllable {
	protected Point location;
	public UUID id;
	
	protected Unit() {
		id = new UUID();
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public UUID getID() {
		return id;
	}
	
}
