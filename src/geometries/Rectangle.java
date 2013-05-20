package geometries;

import java.awt.Graphics;

public class Rectangle extends GraphicalComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

}
