package geometries;

import java.awt.Graphics;

public class Polyline extends GraphicalComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] xPoints;
	private int[] yPoints;
	private int nPoints;

	// default Constructor
	public Polyline() {
	}
	
	public Polyline(int[] xPoints, int[] yPoints, int nPoints) {
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nPoints = nPoints;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawPolyline(xPoints, yPoints, nPoints);
	}

}
