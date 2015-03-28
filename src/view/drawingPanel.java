package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class drawingPanel extends JPanel implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.draw3DRect(50, 50, 100, 200, false);
	}
	
	
	
}
