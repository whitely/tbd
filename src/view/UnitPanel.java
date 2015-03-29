package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import units.Locatable;
import units.Subject;
import world.World;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {

	private Point clickPoint;
	private Locatable selected;
	
	public UnitPanel() {
		super();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickPoint = new Point(e.getX(), e.getY());
				selected = null;
				repaint();
			}
		});
	}
	
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing units...");
		
		ArrayList<Subject> subjects = World.getSubjects();
		
		for (Subject s : subjects) {
			try {
				BufferedImage img = ImageIO.read(new File(s.getAssetPath()));
				g2.drawImage(img, s.getLocation().x, s.getLocation().y, s.getWidth(), s.getHeight(), null);
				
				if (clickPoint != null && contains(s, clickPoint, g2)) {
					System.out.println("You clicked at (" + clickPoint.x + ", " + clickPoint.y + ") on Subject " + s);
					selected = s;
					clickPoint = null;
				}
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}
	}
	
	private boolean contains(Locatable l, Point p, Graphics2D g2) {
		Rectangle rect = new Rectangle(l.getLocation().x, l.getLocation().y, l.getWidth(), l.getHeight());
		if (rect.contains(p))
			highlight(rect, g2);
		return rect.contains(p);
	}
	
	private void highlight(Rectangle rect, Graphics2D g2) {
		Color c = g2.getColor();
		Stroke s = g2.getStroke();
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(4));
		g2.draw(rect);
		g2.setColor(c);
		g2.setStroke(s);
	}
}
