package units;
import java.awt.Point;
import java.util.ArrayList;

import controller.ControlLink;

public class EnvObject extends Unit{
	protected int r;
	protected String graphics;
	
	
	
	public int getr()
	{
		return r;
	}
	
	public void setr(int val)
	{
		r = val;
	}
	
	public String getGraphics()
	{
		return graphics;
	}
	
	public void setGraphics(String val)
	{
		graphics = val;
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
		return null;
	}
}
