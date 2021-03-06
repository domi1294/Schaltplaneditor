package stuff;

import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGSVGElement;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initLogging();

		SVGDocument doc = null;
		try {
			SAXSVGDocumentFactory docFactory = new SAXSVGDocumentFactory(
					XMLResourceDescriptor.getXMLParserClassName());
			File file = new File("test2.svg");
			doc = docFactory.createSVGDocument(file.toURI().toString());
			MyXmlUtilities.saveXMLToFile(doc, file);
		} catch (IOException ex) {
		}

		MyXmlUtilities.printChilds(doc);

		SVGSVGElement svgRoot = doc.getRootElement();
		SVGRect rect = svgRoot.createSVGRect();
		rect.setHeight(600);
		rect.setWidth(800);

		// NodeList gChilds = svgRoot.getElementsByTagName("g");
		// for (int i = 0; i < gChilds.getLength(); i++) {
		// Node item = gChilds.item(i);
		// NamedNodeMap attributes = item.getAttributes();
		// Node id = attributes.getNamedItem("id");
		// if (id != null)
		// System.out.println(id.getNodeValue());
		// else
		// System.out.println("Element has no ID");
		// }

		// // Get a DOMImplementation.
//		 DOMImplementation domImpl = GenericDOMImplementation
//		 .getDOMImplementation();
		//
		// // Create an instance of org.w3c.dom.Document.
		// String svgNS = "http://www.w3.org/2000/svg";
		// Document document = domImpl.createDocument(svgNS, "svg", null);
		//
		// // Create an instance of the SVG Generator.
		// SVGGraphics2D svgGenerator = new SVGGraphics2D(doc);
		//
		// Node rootNode = new Node();
		// rootNode.add(new SVGObject() {
		// @Override
		// public void draw(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillRect(20, 20, 200, 200);
		// }
		// });
		//
		// rootNode.draw(svgGenerator);
		// try {
		// svgGenerator.stream("test.svg");
		// } catch (SVGGraphics2DIOException e) {
		// e.printStackTrace();
		// }

		// MainFrame frm = new MainFrame();
		// frm.setRootNode(rootNode);
		// frm.setLocationRelativeTo(null);
		// frm.setVisible(true);
	}

	public static void initLogging() {
		System.setProperty("java.util.logging.config.file",
				"logging.properties");
		try {
			LogManager.getLogManager().readConfiguration();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception");
		}
		log.config("Logging started");
	}

}
