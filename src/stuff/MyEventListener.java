package stuff;

import org.apache.batik.dom.events.DOMMouseEvent;
import org.apache.batik.dom.svg.SVGOMPoint;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;

public class MyEventListener implements EventListener {

	private boolean drag = false;
	private Element selectedItem;
	private SVGOMPoint initialDragPoint;
	
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
		if (drag) {
			DOMMouseEvent temp = (DOMMouseEvent) evt;
			int newX = temp.getClientX();
			int newY = temp.getClientY();
			
			SVGOMPoint pt = new SVGOMPoint(newX, newY);
			SVGMatrix mat = ((SVGLocatable) evt.getTarget()).getScreenCTM();
			mat = mat.inverse();
			SVGOMPoint dragpt = (SVGOMPoint) pt.matrixTransform(mat);
			
			selectedItem.setAttribute("x", ""+dragpt.getX());
			selectedItem.setAttribute("y", ""+dragpt.getY());
		}
	}

	private void handleClick(MouseEvent evt) {
		System.out.println(evt.getTarget());
	}

	private void handleMouseDown(MouseEvent evt) {
		selectedItem = (Element)evt.getTarget();
		drag = true;
		DOMMouseEvent temp = (DOMMouseEvent) evt;
		int newX = temp.getClientX();
		int newY = temp.getClientY();
		
		//convert screen coordinates to document coordinates
		SVGOMPoint pt = new SVGOMPoint(newX, newY);
		SVGMatrix mat = ((SVGLocatable) selectedItem).getScreenCTM(); // elem -> screen
		mat = mat.inverse(); // screen -> elem
		initialDragPoint = (SVGOMPoint) pt.matrixTransform(mat);
		System.out.println("dragging activated");
	}

	private void handleMouseUp(MouseEvent evt) {
		drag = false;
		System.out.println("dragging deactivated");
	}

	private void handleMouseOver(MouseEvent evt) {
		
	}

	private void handleMouseOut(MouseEvent evt) {
		
	}

}
