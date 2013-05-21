package geometries;

import java.awt.Rectangle;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SVGComponentBuilder {

	private static SVGComponentBuilder instance;
	private Document doc;
	private String svgNS;

	private SVGComponentBuilder() {
		svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		doc = SVGDOMImplementation.getDOMImplementation().createDocument(svgNS, "svg", null);
	}

	public static SVGComponentBuilder getInstance() {
		if (instance == null)
			instance = new SVGComponentBuilder();
		return instance;
	}

	public SVGComponent makeLine(int x1, int y1, int x2, int y2) {
		SVGComponent retVal = new Line();
		Element line = doc.createElementNS(svgNS, "line");
		line.setAttributeNS(null, "x1", ""+x1);
		line.setAttributeNS(null, "y1", ""+y1);
		line.setAttributeNS(null, "x2", ""+x2);
		line.setAttributeNS(null, "y2", ""+y2);
		retVal.setElement(line);
		retVal.setBounds(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		return retVal;
	}
	
	public SVGComponent makeRectangle(Rectangle bounds) {
		SVGComponent retVal = new geometries.Rectangle();

		return retVal;
	}
	
	public SVGComponent makeEllipse(Rectangle bounds) {                                                                                                     
		SVGComponent retVal = new Circle();
		retVal.setBounds(bounds);
		return retVal;
	}
	
	public SVGComponent makePolyline(int[] xPoints, int[] yPoints, int nPoints) {
		SVGComponent retVal = new Polyline(xPoints, yPoints, nPoints);
		return retVal;
	}
}
