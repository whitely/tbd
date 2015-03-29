package units;

import java.awt.Point;

public interface Locatable {
	public Point getLocation();
	public void setLocation(Point location);
	public int getHeight();
	public void setHeight(int value);
	public int getWidth();
	public void setWidth(int value);
}
