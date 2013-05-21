package geometries;

import org.w3c.dom.Element;

public class Polyline extends SVGComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] xPoints, yPoints;
	private int nPoints;

	// default Constructor
	public Polyline(Element source) {
		super(source);
	}
	
	public Polyline(Element source, int[] xPoints, int[] yPoints, int nPoints) {
		super(source);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.nPoints = nPoints;
	}
	
}
