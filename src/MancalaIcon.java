import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;

public class MancalaIcon implements Icon {
	private int width;
	private int height; 
	private int stones; 
	private String label; 
	
	public MancalaIcon(int width, int height) {
		this.width = width; 
		this.height = height; 
	}
	
	public MancalaIcon(int width, int height, int stones, String label) {
		this(width, height); 
		this.stones = stones; 
		this.label = label;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		RoundRectangle2D.Double rec = new RoundRectangle2D.Double(x, y, width, height, 70, 70);
		g2.draw(rec);
	}
	
	public int getIconWidth() {
		return width; 
	}
	
	public int getIconHeight() {
		return height;
	}
	
	public int getNumberOfStones() {
		return stones;
	}
	
	public String getLable() {
		return label; 
	}
	
	public void setNumberOfStones(int n) {
		stones = n;
	}
	
	public void setLabel(String s) {
		label = s;
	}
}