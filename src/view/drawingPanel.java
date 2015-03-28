package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controllable;
import utils.ControllableMap;
import world.World;

@SuppressWarnings("serial")
public class drawingPanel extends JPanel implements Observer {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());	
	private final Point CS = new Point(X_SCREEN_SIZE/2,Y_SCREEN_SIZE); 
	BufferedImage desertImg, grassImg, lavaImg, miasmaImg, waterImg;
	
	public drawingPanel(){
		try {
		    desertImg = ImageIO.read(new File("Tile Graphics/desert.png"));
		    grassImg = ImageIO.read(new File("Tile Graphics/Grass.png"));
		    lavaImg = ImageIO.read(new File("Tile Graphics/lava.png"));
		    miasmaImg = ImageIO.read(new File("Tile Graphics/Miasma.png"));
		    waterImg = ImageIO.read(new File("Tile Graphics/water.png"));
		} catch (IOException e) {
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("drawingPanel received update from " + o);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(desertImg,50,50,40,40,null);
		World.
		for (int i = 0; i<)
		g2.draw3DRect(50, 50, 100, 200, false);
		
		int x = 50, y = 50;
		
		for (Controllable c : ControllableMap.getVals()) {
			g2.drawString(c.toString(), x, y += 50);
		}
	}
	
	
	
}
