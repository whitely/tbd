package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CharacterPanel extends JPanel {
	private final int[] MOVE = new int[]{38,19,19};
	private final int[] ATTACK = new int[]{255,255,0};
	private final int[] RANGED = new int[]{0,0,76};
	private final int[] NEXUS = new int[]{255,0,255};
	private final int[] RIFT = new int[]{165,41,0};
	private final int[] GRACE = new int[]{10,114,133};
	private final int[] STRENGTH = new int[]{11,158,171};
	private final int[] INTELLIGENCE = new int[]{83,234,232};
	private final int[] NEXT_TURN = new int[]{0,0,0};
	private boolean first = true;
	private String mode = "move";
	//private final int[]  = new int[]{};
	
	private ImageButton sidebar;
	private ArrayList<GUIObserver> observers;

	public CharacterPanel(GUIObserver parent) {
		super();
		observers = new ArrayList<GUIObserver>();
		setLayout(new BorderLayout());
		layoutGUI();
	}
	
	public void registerObserver(GUIObserver guio) {
		observers.add(guio);
	}
	
	private void notify(Object arg) {
		for (GUIObserver o : observers)
			o.update(this, arg);
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
	
	public String getMode(){
		return mode;
	}
	
	public int getAffinity() {
		return sidebar.getAffinity();
	}

	public void setAffinity(int affinity) {
		sidebar.setAffinity(affinity);
	}

	public int getGrace() {
		return sidebar.getGrace();
	}

	public void setGrace(int grace) {
		sidebar.setGrace(grace);
	}

	public int getIntelligence() {
		return sidebar.getIntelligence();
	}

	public void setIntelligence(int intelligence) {
		sidebar.setIntelligence(intelligence);
	}

	public int getStrength() {
		return sidebar.getStrength();
	}

	public void setStrength(int strength) {
		sidebar.setStrength(strength);
	}

	private void f(ActionEvent e) {
		int[] color = sidebar.getLastColor();
		System.out.println("CLICK! "+color[0]+" "+color[1]+" "+color[2]);
		if(arrayEqual(color, MOVE)){
			System.out.println("User clicked move button.");
			mode = "move";
		}
		else if(arrayEqual(color, ATTACK)){
			System.out.println("User clicked attack button.");
			mode = "attack";
		}
		else if(arrayEqual(color, RANGED)){
			System.out.println("User clicked ranged button.");
			mode = "ranged";
		}
		else if(arrayEqual(color, NEXUS)){
			System.out.println("User clicked nexus button.");
			mode = "nexus";
		}
		else if(arrayEqual(color, RIFT)){
			System.out.println("User clicked rift button.");
			mode = "rift";
		}
		else if(arrayEqual(color, GRACE)){
			System.out.println("User clicked grace button.");
			mode = "grace";
		}
		else if(arrayEqual(color, STRENGTH)){
			System.out.println("User clicked strength button.");
			mode = "strength";
		}
		else if(arrayEqual(color, INTELLIGENCE)){
			System.out.println("User clicked intelligence button.");
			mode = "intelligence";
		}
		else if(arrayEqual(color, NEXT_TURN)){
			System.out.println("User clicked next turn button.");
			mode = "next turn";
		}
		
		notify(mode);
	}
	
	private boolean arrayEqual(int[] a, int[] b){
		return a[0]==b[0]&&a[1]==b[1]&&a[2]==b[2];
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("User clicked button with text '" + ((JButton)(e.getSource())).getText() + "'.");
			CharacterPanel.this.notify("repaint");
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//g2.drawString("Level", 80, 200);
	}
	
}
