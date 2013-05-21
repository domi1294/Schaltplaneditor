package gui;

import org.apache.batik.dom.events.DOMMouseEvent;
import org.apache.batik.dom.svg.SVGOMPoint;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;

//TODO change class name.
public class MyEventListener implements EventListener {

	private boolean drag;
	private Element selectedItem;
	private SVGOMPoint initialDragPoint;

	@Override
	public void handleEvent(Event evt) {
		System.out.println("something happened");
		switch (evt.getType()) {
		case "mousedown":
			mousePressed(evt);
			break;
		case "mouseup":
			mouseReleased(evt);
			break;
		case "mousemove":
			mouseMoved(evt);
			break;
		case "mouseover":

			break;
		case "click":
			break;
		}
	}

	private void mouseMoved(Event evt) {
		if (drag) {
			// Cast the event onto a Batik Mouse event,
			// so we can get ccordinates
			DOMMouseEvent elEvt = (DOMMouseEvent) evt;
			int nowToX = elEvt.getClientX();
			int nowToY = elEvt.getClientY();
			// convert it to a point for use with the Matrix
			SVGOMPoint pt = new SVGOMPoint(nowToX, nowToY);
			// Get the items screen coordinates, and apply the transformation
			// elem -> screen
			SVGMatrix mat = ((SVGLocatable) evt.getTarget()).getScreenCTM();

			mat = mat.inverse(); // screen -> elem
			SVGOMPoint dragpt = (SVGOMPoint) pt.matrixTransform(mat);
		}
	}

	private void mousePressed(Event evt) {
		SVGLocatable thisNode = (SVGLocatable) evt.getTarget();

		drag = true;

		// Set the initial drag point
		DOMMouseEvent elEvt = (DOMMouseEvent) evt;
		int nowToX = elEvt.getClientX();
		int nowToY = elEvt.getClientY();

		// Convert Screen coordinates to Document Coordinates.
		SVGOMPoint pt = new SVGOMPoint(nowToX, nowToY);
		SVGMatrix mat = thisNode.getScreenCTM(); // elem -> screen
		mat = mat.inverse(); // screen -> elem
		initialDragPoint = (SVGOMPoint) pt.matrixTransform(mat);
	}

	private void mouseReleased(Event evt) {
		drag = false;
	}

}
