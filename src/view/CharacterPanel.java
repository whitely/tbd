package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CharacterPanel extends JPanel {
	private final int[] MOVE = new int[]{46,0,250};
	private final int[] ATTACK = new int[]{254,2,26};
	private final int[] RANGED = new int[]{254,2,26};
	private final int[] NEXUS = new int[]{254,2,26};
	private final int[] RIFT = new int[]{254,2,26};
	private final int[] GRACE = new int[]{254,2,26};
	private final int[] STRENGTH = new int[]{254,2,26};
	private final int[] INTELLIGENCE = new int[]{254,2,26};
	private final int[] NEXT_TURN = new int[]{254,2,26};
	//private final int[]  = new int[]{};
	
	private ImageButton sidebar;

	public CharacterPanel() {
		super();
		setLayout(new BorderLayout());
		layoutGUI();
	}
	
	private void layoutGUI(){
		Icon icon = new ImageIcon("assets/sidebar/sidebar.png");
        Icon pressedIcon = new ImageIcon("assets/sidebar/sidebar.png");
        Icon mask = new ImageIcon("assets/sidebar/mask.png");
        
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
		if(arrayEqual(color, MOVE)){
			System.out.println("User clicked move button.");
		}
		else if(arrayEqual(color, ATTACK)){
			System.out.println("User clicked attack button.");
		}
		else if(arrayEqual(color, RANGED)){
			System.out.println("User clicked ranged button.");
		}
		else if(arrayEqual(color, NEXUS)){
			System.out.println("User clicked nexus button.");
		}
		else if(arrayEqual(color, RIFT)){
			System.out.println("User clicked rift button.");
		}
		else if(arrayEqual(color, GRACE)){
			System.out.println("User clicked grace button.");
		}
		else if(arrayEqual(color, STRENGTH)){
			System.out.println("User clicked strength button.");
		}
		else if(arrayEqual(color, INTELLIGENCE)){
			System.out.println("User clicked intelligence button.");
		}
		else if(arrayEqual(color, NEXT_TURN)){
			System.out.println("User clicked next turn button.");
		}
	}
	
	private boolean arrayEqual(int[] a, int[] b){
		return a[0]==b[0]&&a[1]==b[1]&&a[2]==b[2];
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.drawString("Level", 80, 200);
	}
	
}
