package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controllable;
import units.RectTerrain;
import units.Terrain;
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
		ArrayList<Terrain> t = World.getTerrain();
		for (int i = 0; i<t.size(); i++){
			g2.drawImage(getImageForText(t.get(i).getGraphics()),t.get(0).getLocation().x, t.get(0).getLocation().y,t.get(0).getWidth(),t.get(0).getHeight(),null);
		}
		//old code:
//		int currentX = 0;
//		for (int i = 0; i<terrain.size(); i++){
//			int currentY = 0;
//			for (int j = 0; j<terrain.get(0).size(); j++){
//				RectTerrain t = terrain.get(i).get(j);
//				BufferedImage img = getImageForText(t.getGraphics());
//				g2.drawImage(getImageForText(t.getGraphics()),currentX, currentY,t.getWidth(),t.getHeight(),null);
//				currentY += t.getHeight();
//			}
//		}
		g2.draw3DRect(50, 50, 100, 200, false);
		
		int x = 50, y = 50;
		
		for (Controllable c : ControllableMap.getVals()) {
			g2.drawString(c.toString(), x, y += 50);
		}
	}

	private BufferedImage getImageForText(String graphicString) {
		if (graphicString.equals("desert")){
			return desertImg;
		} else if (graphicString.equals("grass")){
			return grassImg;
		} else if (graphicString.equals("lava")){
			return lavaImg;
		} else if (graphicString.equals("miasma")){
			return miasmaImg;
		} else if (graphicString.equals("water")){
			return waterImg;
		}
		else return grassImg;
	}
	
	
	
}
