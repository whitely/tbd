package units;
import java.awt.Point;

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
}
