package geometries;

import java.awt.Graphics;

public class Ellipse extends GraphicalComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics g) {
		g.drawOval(x, y, width, height);
	}

}
