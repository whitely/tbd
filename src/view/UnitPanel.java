package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import units.Subject;
import world.World;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing units...");
		
		ArrayList<Subject> subjects = World.getSubjects();
		
		for (Subject s : subjects) {
			try {
				BufferedImage img = ImageIO.read(new File(s.getAssetPath()));
				g2.drawImage(img, s.getLocation().x, s.getLocation().y, s.getWidth(), s.getHeight(), null);
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}
	}
}
