package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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
import utils.CollisionChecker;
import world.World;

@SuppressWarnings("serial")
public class UnitPanel extends ViewPanel {

	private Point clickPoint;
	private Locatable selected;
	private ArrayList<GUIObserver> observers;
	
	public UnitPanel() {
		super();
		
		observers = new ArrayList<GUIObserver>();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickPoint = new Point(e.getX(), e.getY());
				selected = null;
				
				ArrayList<Subject> subjects = World.getSubjects();
				ArrayList<Locatable> locs = new ArrayList<>();
				for (Subject s : subjects)
					locs.add(s);
				selected = CollisionChecker.getContaining(locs, clickPoint);
				
				repaint();
				UnitPanel.this.notify("unit");
			}
		});
	}
	
	public void registerObserver(GUIObserver guio) {
		observers.add(guio);
	}
	
	private void notify(Object arg) {
		for (GUIObserver o : observers)
			o.update(this, arg);
	}
	
	@Override
	protected void draw(Graphics2D g2) {
		System.out.println("Drawing units...Selected is " + selected);
		
		ArrayList<Subject> subjects = World.getSubjects();
		
		for (Subject s : subjects) {
			try {
				BufferedImage img = ImageIO.read(new File(s.getAssetPath()));
				g2.drawImage(img, s.getLocation().x, s.getLocation().y, s.getWidth(), s.getHeight(), null);
				if (selected != null)
					highlight(new Rectangle(selected.getLocation(), new Dimension(selected.getWidth(), selected.getHeight())), g2);
			} catch (IOException ioEx) { ioEx.printStackTrace(); continue; }
		}
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
	
	public Locatable getSelected(){
		return selected;
	}
	
	public Point getClickPoint(){
		return clickPoint;
	}
}
