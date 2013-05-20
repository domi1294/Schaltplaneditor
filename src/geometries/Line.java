package geometries;

import java.awt.Graphics;

public class Line extends GraphicalComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(x, y, x + width, y + width);
	}

}
