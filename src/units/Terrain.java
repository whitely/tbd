package units;

import java.awt.Point;

public abstract class Terrain {
	protected int damageAmt;
	protected int speed;
	protected String graphics;
	protected Point location;
	
	public Point getLocation()
	{
		return location;
	}
	
	public void setLocation(Point loc)
	{
		location = loc;
	}
	
	public int getDamageAmt()
	{
		return damageAmt;
	}
	
	public void setDamageAmt(int val)
	{
		damageAmt = val;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int val)
	{
		speed = val;
	}
	
	public String getGraphics()
	{
		return graphics;
	}
	
	public void setGraphics(String val)
	{
		graphics = val;
	}
}
