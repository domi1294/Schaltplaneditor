package symboleditor;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGSymbolElement;

import stuff.MyXmlUtilities;

public class SymbolFactory {
	private static final File symbolFolder = new File("symbols");

	private static final Logger log = Logger
			.getLogger(SymbolFactory.class.getName());
	
	private static SymbolFactory instance;
	
	private HashMap<String, SVGSymbolElement> symbols;
	
	private SymbolFactory() {
		symbols = new HashMap<String,SVGSymbolElement>();
		loadAllSymbols();
	}
	
	public static SymbolFactory getInstance() {
		if (instance != null)
			return instance;
		else {
			instance = new SymbolFactory();
			return instance;
		}
	}
	
	private void loadAllSymbols() {
		for (String s : symbolFolder.list()) {
			loadSymbol(s);
		}
	}
	
	private void loadSymbol(String name) {
		File symbolFile = new File(symbolFolder, name);
		if (!symbolFile.exists()) {
			log.warning(String.format("Datei '%s' wurde nicht gefunden.", name));
			return;
		}
		Document xml = MyXmlUtilities.loadXMLFromFile(symbolFile);
		Element symbol = xml.getElementById(name);
		if (symbol instanceof SVGSymbolElement)
			symbols.put(name, (SVGSymbolElement) symbol);
		else
			log.warning(String.format("Datei '%s' enthält kein entsprechendes Symbol.", name));
	}
	
	public SVGSymbolElement create(String name) {
		return (SVGSymbolElement) symbols.get(name).cloneNode(true);
	}
	
	public void registerNewSymbol(String name, SVGSymbolElement symbol) {
		symbols.put(name, symbol);
	}
	
	public void registerNewSymbol(String name) {
		loadSymbol(name);
	}
	
	public Collection<SVGSymbolElement> getExistingSymbols() {
		return new HashMap<String, SVGSymbolElement>(symbols).values();
	}
	
}
