package units;

import java.awt.Point;


public class Terrain extends EnvObject {
	protected int damageAmt;
	protected int speed;
	protected String graphics;
	
	public Terrain(Point location, int width, int height){
		super(location, width, height);
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
