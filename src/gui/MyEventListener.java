package gui;

import org.apache.batik.dom.svg.SVGOMPoint;
import org.apache.batik.dom.svg.SVGOMRectElement;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGPoint;

import stuff.MyXmlUtilities;

public class MyEventListener implements EventListener {

	private boolean pressed = false;
	private Element selectedItem;
	private float deltaX, deltaY;

	private JSVGCanvas svgCanvas;
	
	public MyEventListener(JSVGCanvas svgCanvas) {
		this.svgCanvas = svgCanvas;
	}
	
	@Override
	public void handleEvent(Event evt) {
		switch (evt.getType()) {
		case "click":
			handleClick((MouseEvent) evt);
			break;
		case "mousedown":
			handleMouseDown((MouseEvent) evt);
			break;
		case "mouseup":
			handleMouseUp((MouseEvent) evt);
			break;
		case "mouseover":
			handleMouseOver((MouseEvent) evt);
			break;
		case "mousemove":
			handleMouseMove((MouseEvent) evt);
			break;
		case "mouseout":
			handleMouseOut((MouseEvent) evt);
			break;
		}
	}

	private void handleMouseMove(MouseEvent evt) {
		System.out.println("mouse moved");
		if (pressed) {
			int newX = evt.getClientX();
			int newY = evt.getClientY();
			
			SVGPoint pt = new SVGOMPoint(newX, newY);
			SVGMatrix mat = ((SVGLocatable) evt.getTarget()).getScreenCTM();
			mat = mat.inverse();
			SVGPoint dragpt = pt.matrixTransform(mat);
			
			selectedItem.setAttribute("x", ""+(dragpt.getX()-deltaX));
			selectedItem.setAttribute("y", ""+(dragpt.getY()-deltaY));
		}
	}

	private void handleClick(MouseEvent evt) {
//		System.out.println(evt.getTarget());
		SVGOMRectElement e;
		MyXmlUtilities.drawBoundingBox((SVGElement) evt.getTarget());
	}

	private void handleMouseDown(MouseEvent evt) {
		selectedItem = (Element)evt.getTarget();
		pressed = true;
		int newX = evt.getClientX();
		int newY = evt.getClientY();
		
		//convert screen coordinates to document coordinates
		SVGPoint pt = new SVGOMPoint(newX, newY);
		Document doc = selectedItem.getOwnerDocument();
//		System.out.println(doc.createElementNS(null, "rect"));
		SVGMatrix mat = ((SVGLocatable) selectedItem).getScreenCTM(); // elem -> screen
		mat = mat.inverse(); // screen -> elem
		SVGPoint initialDragPoint = pt.matrixTransform(mat);
		
		deltaX = initialDragPoint.getX()-Float.parseFloat(selectedItem.getAttribute("x"));
		deltaY= initialDragPoint.getY()-Float.parseFloat(selectedItem.getAttribute("y"));
	}

	private void handleMouseUp(MouseEvent evt) {
		pressed = false;
	}

	private void handleMouseOver(MouseEvent evt) {

	}

	private void handleMouseOut(MouseEvent evt) {
		
	}

}
