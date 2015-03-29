package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ViewPanel extends JPanel implements Observer {

	protected ViewPanel() {
		super();
		setOpaque(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		draw(g2);
	}
	
	protected abstract void draw(Graphics2D g2);
}
