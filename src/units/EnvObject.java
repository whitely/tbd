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
	private int height;
	private int width;
	
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

	@Override
	public String getGraphics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGraphics(String newGraphics) {
		// TODO Auto-generated method stub
		
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

}
