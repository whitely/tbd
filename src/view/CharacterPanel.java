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
	private final int[] RED = new int[]{46,0,250};
	private final int[] BLUE = new int[]{254,2,26};
	//private final int[] GREEN = new int[]{};
	
	private ImageButton sidebar;

	public CharacterPanel() {
		super();
		setLayout(new BorderLayout());
		layoutGUI();
	}
	
	private void layoutGUI(){
		Icon icon = new ImageIcon("sidebar/sidebar.png");
        Icon pressedIcon = new ImageIcon("sidebar/sidebar.png");
        Icon mask = new ImageIcon("sidebar/mask.png");
        
        sidebar = new ImageButton(icon, mask);
        sidebar.getLastColor();
        add(sidebar, BorderLayout.NORTH);
        
		sidebar.addActionListener(new ButtonListener());
		sidebar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f(e);
			}
		});
		
		
	}
	
	private void f(ActionEvent e) {
		int[] color = sidebar.getLastColor();
		System.out.println("CLICK! "+color[0]+" "+color[1]+" "+color[2]);
		if(color[0] == RED[0]&&color[1] == RED[1]&&color[2] == RED[2]){
			System.out.println("User clicked button with color red.");
		}
		else if(color[0] == BLUE[0]&&color[1] == BLUE[1]&&color[2] == BLUE[2]){
			System.out.println("User clicked button with color blue.");
		}
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");			
		}
	}
	
}
