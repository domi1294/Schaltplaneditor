package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGOMRect;
import org.apache.batik.svggen.SVGRectangle;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGSVGElement;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import stuff.Main;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(MainFrame.class
			.getName());

	private JMenuBar jMenuBar;
	private JMenuItem jMenuItemNew;
	private JMenu jMenuEdit;
	private JPanel jPanel1;
	private JTabbedPane jTabbedPane2;
	private JScrollPane jScrollPane1;
	private JTextArea jTextAreaXMLContent;
	private JTabbedPane jTabbedPane1;
	private JScrollPane jScrollPaneToolbox;
	private JScrollPane jScrollPaneDrawingBoard;
	private JSplitPane jSplitPane1;
	private JMenuItem jMenuItemSaveAs;
	private JSeparator jSeparator2;
	private JMenuItem jMenuItemSave;
	private JMenuItem jMenuItemOpen;
	private JSeparator jSeparator1;
	private JMenuItem jMenuItemClose;
	private JMenu jMenuFile;
	private JSVGCanvas svgCanvas;

	private JFileChooser fileChooser;

	private DOMImplementationRegistry registry;
	private DOMImplementationLS impl;

	private SVGSVGElement svgRoot; 
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		Main.initLogging();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainFrame() {
		super();
		initGUI();
		try {
			registry = DOMImplementationRegistry.newInstance();
			impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | ClassCastException e) {
			throw new RuntimeException(e);
		}
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setMinimumSize(new java.awt.Dimension(400, 300));
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setDoubleBuffered(true);
				jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
				jTabbedPane1.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						jTabbedPane1StateChanged(evt);
					}
				});
				{
					jSplitPane1 = new JSplitPane();
					jTabbedPane1.addTab("Image", null, jSplitPane1, null);
					{
						jScrollPaneDrawingBoard = new JScrollPane();
						jSplitPane1.add(jScrollPaneDrawingBoard,
								JSplitPane.LEFT);
						jScrollPaneDrawingBoard
								.setMinimumSize(new java.awt.Dimension(200, 200));
						{

							svgCanvas = new JSVGCanvas();
							jScrollPaneDrawingBoard.setViewportView(svgCanvas);
							svgCanvas.setBackground(new java.awt.Color(255,
									255, 255));
							svgCanvas.setPreferredSize(new java.awt.Dimension(
									800, 600));
						}
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					jTabbedPane1.addTab("XML", null, jScrollPane1, null);
					jScrollPane1.setDoubleBuffered(true);
					jScrollPane1.getVerticalScrollBar().addAdjustmentListener(
							new AdjustmentListener() {
								public void adjustmentValueChanged(
										AdjustmentEvent evt) {
									verticalScrollBarAdjustmentValueChanged(evt);
								}
							});
					jScrollPane1.getHorizontalScrollBar()
							.addAdjustmentListener(new AdjustmentListener() {
								public void adjustmentValueChanged(
										AdjustmentEvent evt) {
									horizontalScrollBarAdjustmentValueChanged(evt);
								}
							});
					{
						jTextAreaXMLContent = new JTextArea();
						jScrollPane1.setViewportView(jTextAreaXMLContent);
						jTextAreaXMLContent.setDoubleBuffered(true);
						jScrollPaneToolbox = new JScrollPane();
						jSplitPane1.add(jScrollPaneToolbox, JSplitPane.RIGHT);
						jScrollPaneToolbox
								.setMinimumSize(new java.awt.Dimension(200, 200));
						{
							jTabbedPane2 = new JTabbedPane();
							jScrollPaneToolbox.setViewportView(jTabbedPane2);
							{
								jPanel1 = new JPanel();
								jTabbedPane2.addTab("Basic", null, jPanel1, null);
								jPanel1.setBackground(new java.awt.Color(255,
										255, 255));
							}
						}
					}
				}
			}
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenuFile = new JMenu();
					jMenuBar.add(jMenuFile);
					jMenuFile.setText("Datei");
					jMenuFile.setMnemonic(java.awt.event.KeyEvent.VK_D);
					{
						jMenuItemNew = new JMenuItem();
						jMenuFile.add(jMenuItemNew);
						jMenuItemNew.setText("Neu ...");
						jMenuItemNew.setMnemonic(java.awt.event.KeyEvent.VK_N);
						jMenuItemNew.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed N"));
						jMenuItemNew.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemNewActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemOpen = new JMenuItem();
						jMenuFile.add(jMenuItemOpen);
						jMenuItemOpen.setText("Öffnen ...");
						jMenuItemOpen.setMnemonic(java.awt.event.KeyEvent.VK_F);
						jMenuItemOpen.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed O"));
						jMenuItemOpen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemOpenActionPerformed(evt);
							}
						});
					}
					{
						jSeparator1 = new JSeparator();
						jMenuFile.add(jSeparator1);
					}
					{
						jMenuItemSave = new JMenuItem();
						jMenuFile.add(jMenuItemSave);
						jMenuItemSave.setText("Speichern");
						jMenuItemSave.setMnemonic(java.awt.event.KeyEvent.VK_S);
						jMenuItemSave.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed S"));
						jMenuItemSave.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemSaveActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemSaveAs = new JMenuItem();
						jMenuFile.add(jMenuItemSaveAs);
						jMenuItemSaveAs.setText("Speichern Unter ...");
						jMenuItemSaveAs
								.setMnemonic(java.awt.event.KeyEvent.VK_U);
						jMenuItemSaveAs.setAccelerator(KeyStroke
								.getKeyStroke("shift ctrl pressed S"));
					}
					{
						jSeparator2 = new JSeparator();
						jMenuFile.add(jSeparator2);
					}
					{
						jMenuItemClose = new JMenuItem();
						jMenuFile.add(jMenuItemClose);
						jMenuItemClose.setText("Beenden");
						jMenuItemClose
								.setMnemonic(java.awt.event.KeyEvent.VK_B);
						jMenuItemClose.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed Q"));
						jMenuItemClose.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemCloseActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenuEdit = new JMenu();
					jMenuBar.add(jMenuEdit);
					jMenuEdit.setText("Bearbeiten");
				}
			}
			initFileChooser();
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void initFileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.setDoubleBuffered(true);
		fileChooser.setCurrentDirectory(new File("D:/Users/Domi/git/Schaltplaneditor"));//TODO Remove/Change this line
	}

	private void jMenuItemSaveActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemSave.actionPerformed, event=" + evt);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(svgCanvas.getSVGDocument());
			StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	private void jMenuItemNewActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemNew.actionPerformed, event=" + evt);

		setXML(loadXMLFromFile(new File("default.svg")));
	}

	private void jMenuItemOpenActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemOpen.actionPerformed, event=" + evt);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			setXML(loadXMLFromFile(fileChooser.getSelectedFile()));
	}

	private void jMenuItemCloseActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemClose.actionPerformed, event=" + evt);
		System.exit(0);
	}

	private void horizontalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		log.fine("jScrollPane1.getHorizontalScrollBar().adjustmentValueChanged, event="
				+ evt);
		((JScrollBar) evt.getSource()).getParent().repaint();
	}

	private void verticalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		log.fine("jScrollPane1.getVerticalScrollBar().adjustmentValueChanged, event="
				+ evt);
		((JScrollBar) evt.getSource()).getParent().repaint();
	}

	private void jTabbedPane1StateChanged(ChangeEvent evt) {
		log.fine("jTabbedPane1.stateChanged, event=" + evt);
		switch (((JTabbedPane) evt.getSource()).getSelectedIndex()) {
		case 0:
			if (jTextAreaXMLContent != null)
				svgCanvas.setDocument(getXMLFromString(jTextAreaXMLContent
						.getText()));
			break;
		case 1:
			jTextAreaXMLContent.setText(getStringFromXML(svgCanvas
					.getSVGDocument()));
			break;
		}
	}

	public void setXML(Document xml) {
		svgCanvas.setDocument(xml);
		jTextAreaXMLContent.setText(getStringFromXML(xml));
		svgRoot = svgCanvas.getSVGDocument().getRootElement();
	}
	
	public static void testInstances(Node n) {
		System.out.println("----------------------");
		System.out.println("SVG Instanztest für "+n.getNodeName());
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

	public Document getXML() {
		return svgCanvas.getSVGDocument();
	}

	private String getStringFromXML(Document doc) {
			LSSerializer writer = impl.createLSSerializer();
			writer.getDomConfig().setParameter("format-pretty-print", true);
			return writer.writeToString(doc).trim();
	}

	public Document getXMLFromString(String xml) {
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

	public void saveXMLToFile(Document xml, File file) {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
