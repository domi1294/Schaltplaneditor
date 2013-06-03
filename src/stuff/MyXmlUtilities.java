package stuff;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGRectElement;
import org.w3c.dom.svg.SVGSVGElement;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyXmlUtilities {
	public static final DOMImplementationRegistry REGISTRY;
	public static final DOMImplementationLS IMPL_LS;
	public static final DOMImplementation IMPL;

	static {
		try {
			REGISTRY = DOMImplementationRegistry.newInstance();
			IMPL_LS = (DOMImplementationLS) REGISTRY.getDOMImplementation("LS");
			IMPL = GenericDOMImplementation.getDOMImplementation();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | ClassCastException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getStringFromXML(Document doc) {
		LSSerializer writer = IMPL_LS.createLSSerializer();
		writer.getDomConfig().setParameter("format-pretty-print", true);
		return writer.writeToString(doc).trim();
	}

	public static void drawBoundingBox(SVGElement element) {
		element.getOwnerDocument().insertBefore(getBBoxAsRectElement(element),
				element);
	}

	public static SVGElement getBBoxAsRectElement(SVGElement element) {
		SVGRect bBox = ((SVGLocatable) element).getBBox();
		SVGRectElement bbElement = (SVGRectElement) element.getOwnerDocument()
				.createElementNS(element.getNamespaceURI(), "rect");
		System.out.println(bbElement);
		// set boundingbox values to new rect-element
		bbElement.setAttribute("x", "" + bBox.getX());
		bbElement.setAttribute("y", "" + bBox.getY());
		bbElement.setAttribute("height", "" + bBox.getHeight());
		bbElement.setAttribute("width", "" + bBox.getWidth());
		NamedNodeMap nnm = bbElement.getAttributes();
		System.out.println(nnm.getNamedItem("x").getNodeValue());
		return bbElement;
	}

	public static Document getXMLFromString(String xml) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(new StringReader(xml)));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Document loadXMLFromFile(File xml) {
		try {
			SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(
					XMLResourceDescriptor.getXMLParserClassName());
			return f.createDocument(xml.toURI().toString());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void saveXMLToFile(Document xml, File file) {
		throw new UnsupportedOperationException("not yet implemented");
	}

	public static void registerAllTypes(EventTarget target,
			EventListener listener, boolean useCapture, String... types) {
		for (String string : types) {
			target.addEventListener(string, listener, useCapture);
		}
	}

	public static void testInstances(Node n) {
		System.out.println("----------------------");
		System.out.println("SVG Instanztest für " + n.getNodeName());
		System.out.println("Objekt ist Instanz von");
		if (n instanceof Element)
			System.out.println("org.w3c.dom.Element");
		if (n instanceof SVGElement)
			System.out.println("org.w3c.dom.svg.SVGElement");
		if (n instanceof SVGSVGElement)
			System.out.println("org.w3c.dom.svg.SVGSVGElement");
		if (n instanceof SVGLocatable)
			System.out.println("org.w3c.dom.svg.SVGLocatable");
		System.out.println("----------------------");
	}

	public static void testInstances(NodeList n) {
		for (int i = 0; i < n.getLength(); i++) {
			testInstances(n.item(i));
		}
	}

	public static void printChilds(Node n) {
		printChilds(n, "");
	}

	public static void printChilds(Node n, String tabs) {
		NodeList childs = n.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			System.out.println(tabs + childs.item(i).getNodeName());
			printChilds(childs.item(i), tabs + "\t");
		}
	}

}
