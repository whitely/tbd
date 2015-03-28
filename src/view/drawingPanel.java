package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.Controllable;
import utils.ControllableMap;
import world.World;

@SuppressWarnings("serial")
public class drawingPanel extends JPanel implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("drawingPanel received update from " + o);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.draw3DRect(50, 50, 100, 200, false);
		
		int x = 50, y = 50;
		
		for (Controllable c : ControllableMap.getVals()) {
			g2.drawString(c.toString(), x, y += 50);
		}
	}
	
	
	
}
