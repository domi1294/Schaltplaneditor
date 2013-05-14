package stuff;
import gui.MainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    // Get a DOMImplementation.
	    DOMImplementation domImpl =
	      GenericDOMImplementation.getDOMImplementation();

	    // Create an instance of org.w3c.dom.Document.
	    String svgNS = "http://www.w3.org/2000/svg";
	    Document document = domImpl.createDocument(svgNS, "svg", null);

	    // Create an instance of the SVG Generator.
	    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
		
		Node rootNode = new Node();
		rootNode.add(new SVGObject() {
			@Override
			public void draw(Graphics g) {
				g.setColor(Color.BLACK);
				g.fillRect(20, 20, 200, 200);
			}
		});
		
		MainFrame frm = new MainFrame();
		frm.setRootNode(rootNode);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
	}

}
