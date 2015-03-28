package units;
import java.awt.Point;

public class EnvObject extends Unit{
	protected int regenerationRate;
	protected boolean projectilePassability;
	protected double speedMultiplier;
	protected int damageSubject;
	protected Unit dropItem;
	
	public EnvObject() {
		super();
		regenerationRate = 0;
		projectilePassability = true;
		speedMultiplier = 1;
		damageSubject = 0;
	}
	
	public int getRegenerationRate()
	{
		return regenerationRate;
	}
	
	public void setRegenerationRate(int r)
	{
		regenerationRate = r;
	}
}
