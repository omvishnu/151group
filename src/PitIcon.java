import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class PitIcon implements Icon {
	private int width;
	private int height;
	private int stones;
	private String label;

	public PitIcon(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public PitIcon(int width, int height, int stones, String label) {
		this(width, height);
		this.stones = stones;
		this.label = label;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(x, y, width, height);
		g2.draw(pit);
		int count = 0;
		if (stones == 0) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				double a = (width / 7) * (j + 1) + x;
				double b = (height / 14) * (i + 2) + y;
				g2.fill(new Ellipse2D.Double(a, b, width /  7, height / 14));
				count++;
				if (count == stones) {
					return;
				}
			}
		}
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

	public String getLabel() {
		return label;
	}

	public void setNumberOfStones(int n) {
		stones = n;
	}

	public void setLabel(String s) {
		label = s;
	}
}
