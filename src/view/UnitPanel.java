package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import units.Unit;
import utils.ControllableMap;
import controller.Controllable;

@SuppressWarnings("serial")
public class UnitPanel extends JPanel implements Observer {
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
	public void update(Observable o, Object arg) {
		System.out.println("drawingPanel received update from " + o);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Using paintComponent");
		Graphics2D g2 = (Graphics2D)g;
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
		//g2.draw3DRect(50, 50, 100, 200, false);
		
//		int x = 50, y = 50;
		
//		for (Controllable c : ControllableMap.getVals()) {
//			g2.drawString(c.toString(), x, y += 50);
//		}
	}

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
