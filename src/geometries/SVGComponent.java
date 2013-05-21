package geometries;

import java.awt.Polygon;

import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

public abstract class SVGComponent extends Polygon implements
		Comparable<SVGComponent>, EventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int layer;

	private BoundingBoxCalculator bbc;

	protected Element source;

	public SVGComponent(Element source) {
		this.source = source;
		registerListener();
	}

	private void registerListener() {
		EventTarget target = (EventTarget) source;
		target.addEventListener("DOMAttrModified", this, false);
	}

	public void attachChild(SVGComponent child) {
		throw new UnsupportedOperationException();
	}

	public void detachChild(SVGComponent child) {
		throw new UnsupportedOperationException();
	}

	public SVGComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public void setAttribute(String qualifiedName, String value) {
		source.setAttributeNS(null, qualifiedName, value);
	}

	public String getAttribute(String qualifiedName) {
		return source.getAttributeNS(null, qualifiedName);
	}

	@Override
	public void handleEvent(Event evt) {
		System.out.println(evt);
		switch(evt.getType()) {
		case "DOMAttrModified":
			domAttrModified((MutationEvent) evt);
			break;
		}
	}
	
	protected abstract void domAttrModified(MutationEvent evt);
	
	public void updateBoundingBox() {
		bbc.calculateBoundingBox(source);
	}
		
	@Override
	public int compareTo(SVGComponent that) {
		return this.layer - that.layer;
	}

}
