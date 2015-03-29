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
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing terrain...");

		ArrayList<Terrain> terrain = World.getTerrain();
		ArrayList<EnvObject> objects = World.getEnvObjects();

		for (Terrain t : terrain) {
			try {
				BufferedImage img = ImageIO.read(new File(t.getAssetPath()));
				g2.drawImage(img, t.getLocation().x, t.getLocation().y, t.getWidth(), t.getHeight(), null);
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}
		for (EnvObject e : objects) {
			try {
				BufferedImage img = ImageIO.read(new File(e.getAssetPath()));
				g2.drawImage(img, e.getLocation().x, e.getLocation().y, e.getWidth(), e.getHeight(), null);
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}
	}
}
