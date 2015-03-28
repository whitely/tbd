package units;
import java.awt.Point;
import java.util.ArrayList;

import controller.ControlLink;

public class EnvObject extends Unit{
	protected int regenerationRate;
	protected boolean projectilePassability;
	protected double speedMultiplier;
	protected int damageSubject;
	protected Unit dropItem;
	protected String assetPath;
	
	public EnvObject(Point location, int width, int height) {
		super(location, width, height);
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

	@Override
	public ControlLink getControlLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Class> getSlaveCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAssetPath() {
		// TODO Auto-generated method stub
		return assetPath;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDamageSubject() {
		return damageSubject;
	}

	public void setDamageSubject(int damageSubject) {
		this.damageSubject = damageSubject;
	}

	public Unit getDropItem() {
		return dropItem;
	}

	public void setDropItem(Unit dropItem) {
		this.dropItem = dropItem;
	}

	public boolean isProjectilePassability() {
		return projectilePassability;
	}

	public double getSpeedMultiplier() {
		return speedMultiplier;
	}

}
