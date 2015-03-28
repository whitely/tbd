package world;

public abstract class Terrain {
	protected int damageAmt;
	protected int speed;
	protected String graphics;
	
	public int getDamageAmt()
	{
		return damageAmt;
	}
	
	public void setDamageAmt(int val)
	{
		damageAmt = val;
	}
	
	public int setSpeed()
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
