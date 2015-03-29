package view;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import units.EnvObject;
import units.Terrain;
import world.World;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());
	private final Point CS = new Point(X_SCREEN_SIZE / 2, Y_SCREEN_SIZE);
	BufferedImage desertImg, grassImg, lavaImg, miasmaImg, waterImg, plate;

	public UnitPanel() {
		super();
		try {
			// TODO: Correct these to match with new controllables present
			desertImg = ImageIO.read(new File("Tile Graphics/desert.png"));
			grassImg = ImageIO.read(new File("Tile Graphics/Grass.png"));
			lavaImg = ImageIO.read(new File("Tile Graphics/lava.png"));
			miasmaImg = ImageIO.read(new File("Tile Graphics/Miasma.png"));
			waterImg = ImageIO.read(new File("Tile Graphics/water.png"));
			plate = ImageIO.read(new File("character art/platearmor.png"));
		} catch (IOException e) {
		}
	}
	
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Unit: RIGHT HERE I WAS CALLED LOOK AT ME");
		ArrayList<EnvObject> objects = World.getEnvObjects();
		for (EnvObject obj: objects){
			BufferedImage img = null;
			//System.out.println("Tile Graphics/" + obj.getAssetPath().substring(7));
			img = getImageForText("Tile Graphics/" + obj.getAssetPath().substring(7));
			try {
			BufferedImage boulderImg = ImageIO.read(new File("Tile Graphics/boulderonsand.png"));
			g2.drawImage(boulderImg, obj.getLocation().x, obj.getLocation().y, 40, 40, null);
			} catch (Exception ex) {
				
			}
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
	}

	/*@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Using paintComponent");
		Collection<Controllable> c = ControllableMap.getVals();
		Iterator iter = c.iterator();
		System.out.println("painting");
		while(iter.hasNext()){
			Unit unit = (Unit)iter.next();
			System.out.println("Painting "+unit.getAssetPath());
			g2.drawImage(getImageForText(unit.getAssetPath()),unit.getLocation().x*40, unit.getLocation().y*40, unit.getWidth()*10, unit.getHeight()*10, null);
			//g2.drawString("!!!!", unit.getWidth(), unit.getHeight());
			System.out.println("PRINTING ! mark at " + unit.getLocation().x*40 +"," + unit.getLocation().y*40);
		}
	}*/

	private BufferedImage getImageForText(String graphicString) {
		// TODO: add all new tile types here with keyword
		if (graphicString.equals("Tile Graphics/desert.png")) {
			return desertImg;
		} else if (graphicString.equals("Tile Graphics/Grass.png")) {
			return grassImg;
		} else if (graphicString.equals("lava")) {
			return lavaImg;
		} else if (graphicString.equals("miasma")) {
			return miasmaImg;
		} else if (graphicString.equals("water")) {
			return waterImg;
		} else if (graphicString.equals("character art/platearmor.png"))
			return plate;
		else return grassImg;
	}

}
