package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import units.Subject;
import world.World;

@SuppressWarnings("serial")
public class TestView extends JFrame {
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private final int X_SCREEN_SIZE = ((int) tk.getScreenSize().getWidth());
	private final int Y_SCREEN_SIZE = ((int) tk.getScreenSize().getHeight());
	
	private static int MOVE_TIME_MS = 20;
	
	private static drawingPanel panel1;
	private JButton b;
	
	private World w;
	
	public TestView() {
		setupModel();
		layoutGUI();
		registerListeners();
	}
	
	private void setupModel() {
		w = new World();
	}
	
	private void layoutGUI() {
		panel1 = new drawingPanel();
		w.addObserver(panel1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("THE FARM");
		setSize(700,700);
		setLocation(X_SCREEN_SIZE/2-400, Y_SCREEN_SIZE/2-400);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
				
//		setLayout(new BorderLayout());
		add(panel1);
		panel1.setLayout(new BorderLayout());
		panel1.setLocation(0, 0);
		panel1.setSize(700,700);
		
		b = new JButton("Add a Subject");
		panel1.add(b, BorderLayout.SOUTH);
		b.setLocation(50,50);
		b.setSize(500,500);
		
		b.addActionListener(new ButtonListener());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.addPerson(new Subject(new Point(1,1),5,5));
			}
		});
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
		//TODO
	}
	public void rightPress(){
		//TODO
	}
	public void upPress(){
		//TODO
	}
	public void downPress(){
		//TODO
	}
	
	static ActionListener timerAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// continuous timer code here:
			panel1.repaint();
			//world.update();
		}
	};
	// change timer value to determine speed
	static Timer repaintTimer = new Timer(MOVE_TIME_MS, timerAction);
	
	public static void main(String[] args) {
		new TestView().setVisible(true);
		repaintTimer.start();
	}
	
	
}
