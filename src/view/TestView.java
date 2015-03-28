package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import units.Subject;
import utils.ControllableMap;
import world.World;

@SuppressWarnings("serial")
public class TestView extends JFrame {
	
	private drawingPanel p;
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
		p = new drawingPanel();
		w.addObserver(p);
		b = new JButton("Add a Subject");
		b.addActionListener(new ButtonListener());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.addPerson(new Subject());
			}
		});
		
		setSize(1200, 900);
		setResizable(false);
		setLayout(new BorderLayout());
		
		add(p, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
	public static void main(String[] args) {
		new TestView().setVisible(true);
	}
	
}
