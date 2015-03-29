package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import units.EnvObject;
import units.Terrain;
import world.World;

@SuppressWarnings("serial")
public class DrawingPanel extends ViewPanel { 
	private BufferedImage desertImg, grassImg, lavaImg, miasmaImg, waterImg, boulderImg;
	
	public DrawingPanel(){
		super();
		try {
			//TODO: Correct these to match with new unit tiles present?
		    desertImg = ImageIO.read(new File("Tile Graphics/desert.png"));
		    grassImg = ImageIO.read(new File("Tile Graphics/Grass.png"));
		    lavaImg = ImageIO.read(new File("Tile Graphics/lava.png"));
		    miasmaImg = ImageIO.read(new File("Tile Graphics/Miasma.png"));
		    waterImg = ImageIO.read(new File("Tile Graphics/water.png"));
		    boulderImg = ImageIO.read(new File("Tile Graphics/boulderonsand.png"));
		} catch (IOException e) {}
	}
	
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing: called");
		
		ArrayList<Terrain> terrain = World.getTerrain();
		ArrayList<EnvObject> objects = World.getEnvObjects();
		
		for (Terrain t : terrain) {
			BufferedImage img = null;
			img = getImageForText("Tile Graphics/" + t.getAssetPath().substring(7));
			g2.drawImage(img, t.getLocation().x, t.getLocation().y, t.getWidth(), t.getHeight(), null);
		}
		for (EnvObject e : objects) {
			BufferedImage img = null;
			img = getImageForText("Tile Graphics/" + e.getAssetPath().substring(7));
			g2.drawImage(img, e.getLocation().x, e.getLocation().y, e.getWidth(), e.getHeight(), null);
			//g2.drawImage(img, x, 				 y, 				width, 		  height, 		 observer)
		}
		/*for (Terrain t: terrain) {
			for (int i = 0; i<t.getWidth()/40; i++)
				for (int j = 0; j<t.getHeight()/40; j++){
					BufferedImage img = null;
					img = getImageForText("Tile Graphics/" + t.getAssetPath().substring(7));
					g2.drawImage(img, i*40,j*40,40,40, null);
				}
		}
		for (EnvObject obj: objects){
			BufferedImage img = null;
			img = getImageForText("Tile Graphics/" + obj.getAssetPath().substring(7));
			g2.drawImage(boulderImg, obj.getLocation().x, obj.getLocation().y, 40, 40, null);
		}*/
	}

	private BufferedImage getImageForText(String graphicString) {
		//TODO: add all new unit types here with keyword?
		if (graphicString == null)
			return grassImg;
		if (graphicString.equals("Tile Graphics/desert.png"))
			return desertImg;
		if (graphicString.equals("Tile Graphics/Grass.png"))
			return grassImg;
		if (graphicString.equals("Tile Graphics/boulderonsand.png"))
			return boulderImg;
		if (graphicString.equals("miasma"))
			return miasmaImg;
		if (graphicString.equals("water"))
			return waterImg;
		return grassImg;
	}
}
