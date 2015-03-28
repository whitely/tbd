package units;

import java.awt.Point;


public class Terrain extends EnvObject {
	public Terrain(Point location, int width, int height)
	{
		super(location, width, height);
	}
	
	public Terrain()
	{
		super(new Point(0, 0), 0, 0);
	}
}
