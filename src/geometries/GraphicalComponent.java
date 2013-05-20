package geometries;

import java.awt.Graphics;
import java.awt.Rectangle;

import org.w3c.dom.Element;

public abstract class GraphicalComponent extends Rectangle implements Comparable<GraphicalComponent>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int layer;
	
	protected Element element;
	
	public void attachChild(GraphicalComponent child) {
		throw new UnsupportedOperationException();
	}
	
	public void detachChild(GraphicalComponent child) {
		throw new UnsupportedOperationException();
	}
	
	public GraphicalComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}
	
	public void setElement(Element element) {
		this.element = element;
	}
	
	@Override
	public int compareTo(GraphicalComponent that) {
		return this.layer-that.layer;
	}

	public abstract void draw(Graphics g);
	
}
