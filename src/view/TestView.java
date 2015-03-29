package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import units.Locatable;
import units.Subject;
import utils.CollisionChecker;
import world.World;

@SuppressWarnings("serial")
public class TestView extends JFrame implements GUIObserver {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());
	
	//private static int REPAINT_TIME_MS = 20;
	
	private JPanel centerPanel;
	private ViewPanel drawingPanel, unitPanel;
	private CharacterPanel cPanel;
	private ChatPanel chat;
	
	private World w;
	
	//TODO: Use the real subject instead of this fake one
	//private Subject subject = new Subject(new Point(1,1), 5, 5);
	
	public TestView(World w) throws IOException {
		super();
		setupModel(w);
		layoutGUI();
		//registerListeners();
	}
	
	public Subject getMe(){
		//TODO
		return new Subject();
	}
	
	private void setupModel(World w) throws IOException {
		this.w = w;
	}
	
	private void layoutGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("THE FARM");
		setSize(1200,900);
		setLocation(X_SCREEN_SIZE/2-700, Y_SCREEN_SIZE/2-500);
		setBackground(Color.BLACK);
		setResizable(false);
		setLayout(null);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setSize(800, 800);
		centerPanel.setLocation(0, 23);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(centerPanel);
		setComponentZOrder(centerPanel, 0);
		
		chat = new ChatPanel();
		chat.setSize(390, 340);
		chat.setLocation(802, 485);
		add(chat);
		setComponentZOrder(chat, 1);
		
		cPanel = new CharacterPanel(this);
		cPanel.registerObserver(this);
		cPanel.setSize(1200, 900);
		cPanel.setLocation(30, -50); // Because the image is 1196 pixels wide for whatever goddamn reason.
		add(cPanel);
		setComponentZOrder(cPanel, 2);
		
		unitPanel = new UnitPanel();
		((UnitPanel)unitPanel).registerObserver(this);
		centerPanel.add(unitPanel);
		centerPanel.setComponentZOrder(unitPanel, 0);
		w.addObserver(unitPanel);
		
		drawingPanel = new DrawingPanel();
		centerPanel.add(drawingPanel);
		centerPanel.setComponentZOrder(drawingPanel, 1);
		w.addObserver(drawingPanel);
		
		
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
	public ChatPanel getChatPanel() {
		return chat;
	}
	
	
	/*
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
	}*/
	
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
		new TestView(new World()).setVisible(true);
//		repaintTimer.start();
	}

	private Point p1 = null, p2 = null;
	private String mode = null;
	
	@Override
	public void update(Object source, Object arg) {
		if (arg instanceof String && "repaint".equals(arg)) {
			repaint();
			return;
		}
		
		if (source instanceof CharacterPanel) {
			System.out.println("Notification from CharacterPanel with arg " + arg);
			if (mode == null && p1 != null) {
				mode = (String)arg;
			}
		} else if (source instanceof UnitPanel) {
			System.out.println("Notification from UnitPanel with arg " + arg);
			//Locatable l = 
			Point p = ((UnitPanel)unitPanel).getClickPoint();
			
			if (p1 == null || mode == null)
				p1 = p;
			else if (p2 == null)
				p2 = p;
		}
		
		if (p1 != null && p2 != null && mode != null) {
			if (mode.equals("move")) {
				Subject s = (Subject)CollisionChecker.getContaining(p1);
				s.getStrategy().move(s, p2);
				
			}
			
			p1 = null;
			p2 = null;
			mode = null;
		}
		
		
	}
	
	
}
