package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import units.Unit;
import utils.ControllableMap;
import controller.Controllable;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing units...");
		Collection<Controllable> controllables = ControllableMap.getVals();
		for (Controllable c : controllables){
			try {
				Unit u = (Unit)c;
				BufferedImage img = ImageIO.read(new File(u.getAssetPath()));
				g2.drawImage(img,u.getLocation().x, u.getLocation().y, u.getWidth(), u.getHeight(), null);
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}	
	}
}
