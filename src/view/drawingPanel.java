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
import units.EnvObject;
import units.Terrain;
import utils.ControllableMap;
import world.World;

@SuppressWarnings("serial")
public class drawingPanel extends JPanel implements Observer {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());	
	private final Point CS = new Point(X_SCREEN_SIZE/2,Y_SCREEN_SIZE); 
	BufferedImage desertImg, grassImg, lavaImg, miasmaImg, waterImg, boulderImg;
	
	public drawingPanel(){
		try {
			//TODO: Correct these to match with new unit tiles present?
		    desertImg = ImageIO.read(new File("Tile Graphics/desert.png"));
		    grassImg = ImageIO.read(new File("Tile Graphics/Grass.png"));
		    lavaImg = ImageIO.read(new File("Tile Graphics/lava.png"));
		    miasmaImg = ImageIO.read(new File("Tile Graphics/Miasma.png"));
		    waterImg = ImageIO.read(new File("Tile Graphics/water.png"));
		    boulderImg = ImageIO.read(new File("Tile Graphics/boulderonsand.png"));
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
		ArrayList<EnvObject> objects = World.getEnvObjects();
		for (EnvObject obj: objects){
			BufferedImage img = null;
			System.out.println("Tile Graphics/" + obj.getAssetPath().substring(7));
			img = getImageForText("Tile Graphics/" + obj.getAssetPath().substring(7));
			g2.drawImage(boulderImg, obj.getLocation().x, obj.getLocation().y, 40, 40, null);
		}
		ArrayList<Terrain> terrain = World.getTerrain();
		for (Terrain t: terrain){
			for (int i = 0; i<t.getWidth()/40; i++){
				for (int j = 0; j<t.getHeight()/40; j++){
					BufferedImage img = null;
					img = getImageForText("Tile Graphics/" + t.getAssetPath().substring(7));
					g2.drawImage(img, i*40,j*40,40,40, null);
				}
			}
		}
		
//		for (int i = 0; i<t.size(); i++){
//			g2.drawImage(getImageForText(((EnvObject)t.get(i)).getAssetPath()),t.get(i).getLocation().x, t.get(i).getLocation().y,t.get(i).getWidth(),t.get(i).getHeight(),null);
//		}
		//g2.draw3DRect(50, 50, 100, 200, false);
		
//		int x = 50, y = 50;
		
//		for (Controllable c : ControllableMap.getVals()) {
//			g2.drawString(c.toString(), x, y += 50);
//		}
	}

	private BufferedImage getImageForText(String graphicString) {
		//TODO: add all new unit types here with keyword?
		if (graphicString.equals("Tile Graphics/desert.png")){
			return desertImg;
		} else if (graphicString.equals("Tile Graphics/Grass.png")){
			return grassImg;
		} else if (graphicString.equals("Tile Graphics/boulderonsand.png")){
			return boulderImg;
		} else if (graphicString.equals("miasma")){
			return miasmaImg;
		} else if (graphicString.equals("water")){
			return waterImg;
		}
		else return grassImg;
	}
	
	
	
}
