package view;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ImageButton extends JButton {

    // create a static index for the alpha channel of a raster image. i'm not exactly sure where
    // it's specified that red = channel 0, green = channel 1, blue = channel 2, and
    // alpha = channel 3, but this have been the values i've observed.
    private final int ALPHA_BAND = 3;

    // a buffered image representing the mask for this button.
    private final BufferedImage fMask;
    public int[] lastColor;
    public Point loc = getLocation();
    protected int affinity;
    protected int grace;
    protected int intelligence;
    protected int strength;
    
    

    public ImageButton(Icon icon, Icon mask) {
        super(icon);

        if (icon == null) {
            throw new IllegalArgumentException("The icon cannot be null.");
        }
        if (mask == null) {
            throw new IllegalArgumentException("The mask cannot be null.");
        }
        checkIconMatchesMaskBounds(icon, mask);

        // remove the margins from this button, request that the content area not be filled, and
        // indicate that the border not be painted.
        setMargin(new Insets(0,0,0,0));
        setContentAreaFilled(false);
        setBorderPainted(false);

        // create the mask from the supplied icon.
        fMask = createMask(mask);
    }

    private BufferedImage createMask(Icon mask) {
        // create a BufferedImage to paint the mask into so that we can later retrieve pixel data
        // out of the image.
        BufferedImage image = new BufferedImage(
                mask.getIconWidth(),mask.getIconHeight(),BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = image.getGraphics();
        mask.paintIcon(null,graphics,0,0);
        graphics.dispose();

        return image;
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
        // if this class has already been initialized, ensure that the new icon matches the bounds
        // of the current mask.
        if (fMask != null) {
            checkIconMatchesMaskBounds(defaultIcon, new ImageIcon(fMask));
        }
    }

    @Override
    public void updateUI() {
        // install the custom ui delegate to track the icon rectangle and answer the contains
        // method.
        setUI(new CustomButtonUI());
    }

    private static void checkIconMatchesMaskBounds(Icon icon, Icon mask) {
        if (mask.getIconWidth() != icon.getIconWidth()
                || mask.getIconHeight() != icon.getIconHeight()) {
            throw new IllegalArgumentException("The mask must be the same size as the icon.");
        }
    }
    
    public int[] getLastColor(){
    	return lastColor;
    }
    
    private void setLastColor(int[] color){
    	lastColor = color;
    }
    
    public int getAffinity() {
		return affinity;
	}

	public void setAffinity(int affinity) {
		this.affinity = affinity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getGrace() {
		return grace;
	}

	public void setGrace(int grace){
    	this.grace = grace;
    }

    // CustomButtonUI implementation so that we can maintain the icon rectangle.

    private class CustomButtonUI extends BasicButtonUI {

        private Rectangle fIconRect;

        private boolean maskContains(int x, int y) {
            // if the given point is within the bounds of the icon, then realtavize the given x,y
            // coordinates and sample the alpha value at that pixel. if the pixel at the given point
            // is completley transparent, then indicate that this button does not contain the point.
        	int[] color = new int[]{0,0,0};
        	if(fIconRect != null && fIconRect.contains(x,y)){
        		color[0] = fMask.getRaster().getSample(x - fIconRect.x,y - fIconRect.y,0);
        		color[1] = fMask.getRaster().getSample(x - fIconRect.x,y - fIconRect.y,1);
        		color[2] = fMask.getRaster().getSample(x - fIconRect.x,y - fIconRect.y,2);
        	}
        	ImageButton.this.setLastColor(color);
        	return fIconRect != null && fIconRect.contains(x,y)
                    && fMask.getRaster().getSample(x - fIconRect.x,y - fIconRect.y,ALPHA_BAND) > 0;
        }
        
        @Override
        public boolean contains(JComponent c, int x, int y) {
            return maskContains(x,y);
        }

        @Override
        protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
            super.paintIcon(g, c, iconRect);
            // capture where the icon is being painted within the bounds of this button so we can
            // later use this information in the contains calculation.
            if (fIconRect == null || !fIconRect.equals(iconRect)) {
                fIconRect = new Rectangle(iconRect);    
            }
            g.drawString("10", 1019, 366); //affinity
            g.drawString("10", 1019, 257); //grace
            g.drawString("10", 925, 420); //strength
            g.drawString("10", 1125, 420); //intelligence
            g.drawString("10", 920, 227); //wp - warping points
            g.drawString("10", 920, 317); //tp - trait points
            g.drawString("10", 920, 267); //sp - summon points
            g.drawString("10", 920, 357); //health
        }
    }
}
