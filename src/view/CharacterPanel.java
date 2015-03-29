package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import units.Subject;

public class CharacterPanel extends JPanel {
	private JButton sidebar;

	public CharacterPanel() {
		super();
		setLayout(new BorderLayout());
		layoutGUI();
	}
	
	private void layoutGUI(){
		Icon icon = new ImageIcon("sidebar/sidebar.png");
        Icon pressedIcon = new ImageIcon("sidebar/sidebar.png");
        Icon mask = new ImageIcon("sidebar/mask.png");
        
        ImageButton sidebar = new ImageButton(icon, mask);
        sidebar.setPressedIcon(pressedIcon);
        
        add(sidebar, BorderLayout.NORTH);
		sidebar.addActionListener(new ButtonListener());
		sidebar.addActionListener(new ActionListener() {
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
