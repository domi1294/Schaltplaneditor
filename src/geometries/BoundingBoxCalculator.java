package geometries;

import java.awt.Rectangle;
import java.util.List;

public interface BoundingBoxCalculator {
	
	public Rectangle calculateBoundingBox(List<GraphicalComponent> children);
	
}
