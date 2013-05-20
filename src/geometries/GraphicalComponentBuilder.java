package geometries;

import java.awt.Rectangle;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GraphicalComponentBuilder {

	private static GraphicalComponentBuilder instance;
	private Document doc;
	private String svgNS;

	private GraphicalComponentBuilder() {
		svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		doc = SVGDOMImplementation.getDOMImplementation().createDocument(svgNS, "svg", null);
	}

	public static GraphicalComponentBuilder getInstance() {
		if (instance == null)
			instance = new GraphicalComponentBuilder();
		return instance;
	}

	public GraphicalComponent makeLine(int x1, int y1, int x2, int y2) {
		GraphicalComponent retVal = new Line();
		Element line = doc.createElementNS(svgNS, "line");
		line.setAttributeNS(null, "x1", ""+x1);
		line.setAttributeNS(null, "y1", ""+y1);
		line.setAttributeNS(null, "x2", ""+x2);
		line.setAttributeNS(null, "y2", ""+y2);
		retVal.setElement(line);
		retVal.setBounds(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		return retVal;
	}
	
	public GraphicalComponent makeRectangle(Rectangle bounds) {
		GraphicalComponent retVal = new geometries.Rectangle();
		retVal.setBounds(bounds);
		return retVal;
	}
	
	public GraphicalComponent makeEllipse(Rectangle bounds) {                                                                                                     
		GraphicalComponent retVal = new Ellipse();
		retVal.setBounds(bounds);
		return retVal;
	}
	
	public GraphicalComponent makePolyline(int[] xPoints, int[] yPoints, int nPoints) {
		GraphicalComponent retVal = new Polyline(xPoints, yPoints, nPoints);
		return retVal;
	}
}
