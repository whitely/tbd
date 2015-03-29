package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import units.Subject;

public class CharacterPanel extends JPanel {
	private JButton button3;

	public CharacterPanel() {
		super();
		setLayout(new BorderLayout());
		layoutGUI();
	}
	
	private void layoutGUI(){
		button3 = new JButton("YAY!");
		add(button3, BorderLayout.NORTH);
		button3.addActionListener(new ButtonListener());
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You pressed a button!");
			}
		});
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
}
