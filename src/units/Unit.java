package units;

import java.awt.Point;

import utils.UUID;
import view.Drawable;
import controller.Controllable;

public abstract class Unit implements Locatable, Controllable, Drawable {
	protected Point location;
	protected int health;
	protected String graphics;
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
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int h)
	{
		health = h;
	}
	
	public String getGraphics()
	{
		return graphics;
	}
	
	public void setGraphics(String newGraphics)
	{
		graphics = newGraphics;
	}
	
	public UUID getID() {
		return id;
	}
	
}
