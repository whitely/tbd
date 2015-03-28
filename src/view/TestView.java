package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	}
	
	private void setupModel() {
		w = new World();
	}
	
	private void layoutGUI() {
		panel1 = new drawingPanel();
		w.addObserver(panel1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("THE FARM");
		setLayout(null);
		setSize(800,800);
		setLocation(X_SCREEN_SIZE/2-400, Y_SCREEN_SIZE/2-400);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		b = new JButton("Add a Subject");
		b.addActionListener(new ButtonListener());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.addPerson(new Subject(new Point(1,1),5,5));
			}
		});
		
//		setLayout(new BorderLayout());
		
		add(p);
		p.setLayout(null);
		p.setLocation(0,0);
		p.setSize(1200,900);
		p.add(b);
		b.setLocation(50,50);
		b.setSize(500,500);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
	static ActionListener timerAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// continuous timer code here:
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
