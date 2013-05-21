package geometries;

import java.awt.Polygon;

import org.w3c.dom.Element;

public interface BoundingBoxCalculator {
	
	public Polygon calculateBoundingBox(Element source);
	
}
