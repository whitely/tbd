package units;

import java.awt.Point;

import utils.UUID;
import view.Drawable;
import world.World;
import controller.Controllable;
import controller.IdleStrategy;
import controller.PlayStrategy;

public abstract class Unit implements Locatable, Controllable, Drawable {
	protected Point location;
	protected int health;
	protected int height;
	protected int width;
	public UUID id;
	
	protected Unit(Point location, int width, int height) {
		this.location = location;
		this.health = 0;
		this.height = height;
		this.width = width;
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
	
	public UUID getID() {
		return id;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void setHeight(int value)
	{
		height = value;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public void setWidth(int value)
	{
		width = value;
	}
	
}
