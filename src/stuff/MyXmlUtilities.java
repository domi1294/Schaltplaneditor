package stuff;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyXmlUtilities {
	private static DOMImplementationRegistry registry;
	private static DOMImplementationLS impl;

	static {
		try {
			registry = DOMImplementationRegistry.newInstance();
			impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | ClassCastException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getStringFromXML(Document doc) {
		LSSerializer writer = impl.createLSSerializer();
		writer.getDomConfig().setParameter("format-pretty-print", true);
		return writer.writeToString(doc).trim();
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
}
