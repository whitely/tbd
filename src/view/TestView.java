package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import units.EnvObject;
import units.Subject;
import units.Terrain;
import world.World;
import xml.XMLLoad;

@SuppressWarnings("serial")
public class TestView extends JFrame {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());
	
	//private static int REPAINT_TIME_MS = 20;
	
	private JPanel centerPanel;
	private ViewPanel drawingPanel, unitPanel;
	private JPanel panelR, panelS;
	private JButton button2;
	
	private World w;
	
	//TODO: Use the real subject instead of this fake one
	private Subject subject = new Subject(new Point(1,1), 5, 5);
	
	public TestView() throws IOException {
		super();
		setupModel();
		layoutGUI();
		registerListeners();
		
		//for testing
		testModelScript1();
	}
	
	private void setupModel() throws IOException {
		w = new World();
	}
	
	private void layoutGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("THE FARM");
		setSize(1000,900);
		setLocation(X_SCREEN_SIZE/2-400, Y_SCREEN_SIZE/2-400);
		setResizable(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(centerPanel, BorderLayout.CENTER);
		
		unitPanel = new UnitPanel();
		unitPanel.setBackground(Color.RED);
		centerPanel.add(unitPanel);
		centerPanel.setComponentZOrder(unitPanel, 0);
		w.addObserver(unitPanel);
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.BLUE);
		centerPanel.add(drawingPanel);
		centerPanel.setComponentZOrder(drawingPanel, 1);
		w.addObserver(drawingPanel);
				
		panelR = new CharacterPanel();
		add(panelR, BorderLayout.EAST);

		panelS = new JPanel();
		panelS.setLayout(new BorderLayout());
		add(panelS, BorderLayout.SOUTH);
		
		button2 = new JButton("Move Subject North");
		panelS.add(button2, BorderLayout.WEST);
		button2.addActionListener(new ButtonListener());
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subject subject = new Subject(new Point(1,1),5,5);
				subject.setAssetPath("character art/platearmor.png");
				w.addPerson(subject);
			}
		});
	}
	
	public void testModelScript1(){
		Subject subjA = new Subject(new Point(1,1),5,5);
		subjA.setAssetPath("character art/platearmor.png");
		w.addPerson(subjA);
		w.addPerson(new Subject(new Point(2,2),5,5));
		final String objectFile = "objects/core.xml";
		final String mapFile = "maps/desertarenaxmltbd.xml";
		
		HashMap<String, Terrain> terrainObjects;
		ArrayList<Terrain> terrains = new ArrayList<Terrain>();
		ArrayList<EnvObject> objects = new ArrayList<EnvObject>();
		try {
			terrainObjects = XMLLoad.loadTerrainTypes(objectFile);
			HashMap<String, EnvObject> envObjects = XMLLoad.loadObjectTypes(objectFile);
			terrains = XMLLoad.loadTerrain(mapFile, terrainObjects);
			objects = XMLLoad.loadObjects(mapFile, envObjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(terrains.size());
		//w.setTerrain(terrains);
		w.setEnvObjects(objects);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
	private void registerListeners() {

		KeyStroke left = KeyStroke.getKeyStroke("LEFT");
		KeyStroke a = KeyStroke.getKeyStroke("A");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(left,
				"moveLeft");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(a,
				"moveLeft");
		getRootPane().getActionMap().put("moveLeft", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leftPress();
			}
		});

		KeyStroke right = KeyStroke.getKeyStroke("RIGHT");
		KeyStroke d = KeyStroke.getKeyStroke("D");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(right,
				"moveRight");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(d,
				"moveRight");
		getRootPane().getActionMap().put("moveRight", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rightPress();
			}
		});

		KeyStroke up = KeyStroke.getKeyStroke("UP");
		KeyStroke w = KeyStroke.getKeyStroke("W");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(up,
				"moveUp");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(w,
				"moveUp");
		getRootPane().getActionMap().put("moveUp", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upPress();
			}
		});

		KeyStroke down = KeyStroke.getKeyStroke("DOWN");
		KeyStroke s = KeyStroke.getKeyStroke("S");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(down,
				"moveDown");
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(s,
				"moveDown");
		getRootPane().getActionMap().put("moveDown", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				downPress();
			}
		});
	}
	
	public void leftPress(){
		Point point = new Point();
		point.x = subject.getLocation().x - 20;
		point.y = subject.getLocation().y;
		subject.setLocation(point);
	}
	public void rightPress(){
		Point point = new Point();
		point.x = subject.getLocation().x + 20;
		point.y = subject.getLocation().y;
		subject.setLocation(point);
	}
	public void upPress(){
		Point point = new Point();
		point.x = subject.getLocation().x;
		point.y = subject.getLocation().y - 20;
		subject.setLocation(point);
	}
	public void downPress(){
		Point point = new Point();
		point.x = subject.getLocation().x;
		point.y = subject.getLocation().y + 20;
		subject.setLocation(point);
	}
	
//	static ActionListener timerAction = new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			// continuous timer code here:
//			unitPanel.repaint();
//			drawingPanel.repaint();
//			//world.update();
//		}
//	};
//	// change timer value to determine repaint speed
//	static Timer repaintTimer = new Timer(REPAINT_TIME_MS, timerAction);
	
	public static void main(String[] args) throws IOException {
		new TestView().setVisible(true);
//		repaintTimer.start();
	}
	
	
}
