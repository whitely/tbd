package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.imageio.ImageIO;

import units.Unit;
import utils.ControllableMap;
import controller.Controllable;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {
	private BufferedImage desertImg, grassImg, lavaImg, miasmaImg, waterImg, plate;

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
		} catch (IOException e) {}
	}

	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing units...");
		Collection<Controllable> c = ControllableMap.getVals();
		Iterator iter = c.iterator();
		while(iter.hasNext()){
			Unit unit = (Unit)iter.next();
			g2.drawImage(getImageForText(unit.getAssetPath()),unit.getLocation().x*40, unit.getLocation().y*40, unit.getWidth()*10, unit.getHeight()*10, null);
			g2.drawString("!!!!!!!!", unit.getLocation().x*40, unit.getLocation().y*40);
			System.out.println("PRINTING ! mark at " + unit.getLocation().x*40 +"," + unit.getLocation().y*40);
		}
	}

	private BufferedImage getImageForText(String graphicString) {
		// TODO: add all new tile types here with keyword
		if (graphicString == null)
			return grassImg;
		if (graphicString.equals("Tile Graphics/desert.png"))
			return desertImg;
		if (graphicString.equals("Tile Graphics/Grass.png"))
			return grassImg;
		if (graphicString.equals("lava"))
			return lavaImg;
		if (graphicString.equals("miasma"))
			return miasmaImg;
		if (graphicString.equals("water"))
			return waterImg;
		if (graphicString.equals("character art/platearmor.png"))
			return plate;
		return grassImg;
	}

}
