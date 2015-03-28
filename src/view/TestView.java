package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestView extends JFrame {
	
	private drawingPanel p;
	private JButton b;
	
	public TestView() {
		setupModel();
		layoutGUI();
	}
	
	private void setupModel() {
		
	}
	
	private void layoutGUI() {
		p = new drawingPanel();
		b = new JButton("Add a Subject");
		b.addActionListener(new ButtonListener());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked.");
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
