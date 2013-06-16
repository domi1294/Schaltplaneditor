package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;
import org.w3c.dom.Document;
import org.w3c.dom.events.EventTarget;

import stuff.Main;
import stuff.MyXmlUtilities;

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
	private JSVGCanvas svgCanvasStromlaufplanBasics;
	private JTabbedPane jTabbedPaneStromlaufplanToolbox;
	private JSVGCanvas svgCanvasStromlaufplan;
	private JScrollPane jScrollPaneStromlaufplanToolbox;
	private JScrollPane jScrollPaneStromlaufplan;
	private JSplitPane jSplitPaneStromlaufplan;
	private JSVGCanvas svgCanvasWirkschaltplanBasics;
	private JTabbedPane jTabbedPaneWirkschaltplanToolbox;
	private JScrollPane jScrollPaneXml;
	private JTextArea jTextAreaXMLContent;
	private JTabbedPane jTabbedPaneMain;
	private JScrollPane jScrollPaneWirkschaltplanToolbox;
	private JScrollPane jScrollPaneWirkschaltplan;
	private JSplitPane jSplitPaneWirkschaltplan;
	private JMenuItem jMenuItemSaveAs;
	private JSeparator jSeparator2;
	private JMenuItem jMenuItemSave;
	private JMenuItem jMenuItemOpen;
	private JSeparator jSeparator1;
	private JMenuItem jMenuItemClose;
	private JMenu jMenuFile;
	private JSVGCanvas svgCanvasWirkschaltplan;

	private JFileChooser fileChooser;

	private Document document;
	private int selectedIndex = 0;

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
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setMinimumSize(new java.awt.Dimension(400, 300));
			{
				jTabbedPaneMain = new JTabbedPane();
				getContentPane().add(jTabbedPaneMain, BorderLayout.CENTER);
				jTabbedPaneMain.setDoubleBuffered(true);
				jTabbedPaneMain.setTabPlacement(JTabbedPane.BOTTOM);
				{
					jSplitPaneWirkschaltplan = new JSplitPane();
					jTabbedPaneMain.addTab("Wirkschaltplan", null,
							jSplitPaneWirkschaltplan, null);
					jSplitPaneWirkschaltplan.addPropertyChangeListener(
							JSplitPane.DIVIDER_LOCATION_PROPERTY,
							new PropertyChangeListener() {
								public void propertyChange(
										PropertyChangeEvent evt) {
									jSplitPaneWirkschaltplanPropertyChange(evt);
								}
							});
					{
						jScrollPaneWirkschaltplan = new JScrollPane();
						jSplitPaneWirkschaltplan.add(jScrollPaneWirkschaltplan,
								JSplitPane.LEFT);
						jScrollPaneWirkschaltplan
								.setMinimumSize(new java.awt.Dimension(200, 200));
						{

							svgCanvasWirkschaltplan = new JSVGCanvas();
							jScrollPaneWirkschaltplan
									.setViewportView(svgCanvasWirkschaltplan);
							svgCanvasWirkschaltplan
									.setPreferredSize(new java.awt.Dimension(
											800, 600));
							svgCanvasWirkschaltplan
									.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
							svgCanvasWirkschaltplan
									.addSVGLoadEventDispatcherListener(new SVGLoadEventDispatcherAdapter() {
										public void svgLoadEventDispatchStarted(
												SVGLoadEventDispatcherEvent e) {
											registerListeners();
										}
									});
						}
					}
				}
				{
					jSplitPaneStromlaufplan = new JSplitPane();
					jTabbedPaneMain.addTab("Stromlaufplan", null,
							jSplitPaneStromlaufplan, null);
					jSplitPaneStromlaufplan.addPropertyChangeListener(
							JSplitPane.DIVIDER_LOCATION_PROPERTY,
							new PropertyChangeListener() {
								public void propertyChange(
										PropertyChangeEvent evt) {
									jSplitPaneStromlaufplanPropertyChange(evt);
								}
							});
					{
						jScrollPaneStromlaufplan = new JScrollPane();
						jSplitPaneStromlaufplan.add(jScrollPaneStromlaufplan,
								JSplitPane.LEFT);
						jScrollPaneStromlaufplan
								.setMinimumSize(new java.awt.Dimension(200, 200));
						{
							svgCanvasStromlaufplan = new JSVGCanvas();
							jScrollPaneStromlaufplan
									.setViewportView(svgCanvasStromlaufplan);
							svgCanvasStromlaufplan.setSize(800, 600);
							svgCanvasStromlaufplan
									.setPreferredSize(new java.awt.Dimension(
											800, 600));
						}
					}
					{
						jScrollPaneStromlaufplanToolbox = new JScrollPane();
						jSplitPaneStromlaufplan.add(
								jScrollPaneStromlaufplanToolbox,
								JSplitPane.RIGHT);
						{
							jTabbedPaneStromlaufplanToolbox = new JTabbedPane();
							jScrollPaneStromlaufplanToolbox
									.setViewportView(jTabbedPaneStromlaufplanToolbox);
							jTabbedPaneStromlaufplanToolbox
									.addChangeListener(new ChangeListener() {
										public void stateChanged(ChangeEvent evt) {
											jTabbedPaneStromlaufplanToolboxStateChanged(evt);
										}
									});
							{
								svgCanvasStromlaufplanBasics = new JSVGCanvas();
								jTabbedPaneStromlaufplanToolbox.addTab("Basic",
										null, svgCanvasStromlaufplanBasics,
										null);
							}
						}
					}
				}
				jTabbedPaneMain.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						jTabbedPaneMainStateChanged(evt);
					}
				});
				{
					jScrollPaneXml = new JScrollPane();
					jTabbedPaneMain.addTab("XML", null, jScrollPaneXml, null);
					jScrollPaneXml.setDoubleBuffered(true);
					jScrollPaneXml.getVerticalScrollBar()
							.addAdjustmentListener(new AdjustmentListener() {
								public void adjustmentValueChanged(
										AdjustmentEvent evt) {
									verticalScrollBarAdjustmentValueChanged(evt);
								}
							});
					jScrollPaneXml.getHorizontalScrollBar()
							.addAdjustmentListener(new AdjustmentListener() {
								public void adjustmentValueChanged(
										AdjustmentEvent evt) {
									horizontalScrollBarAdjustmentValueChanged(evt);
								}
							});
					{
						jTextAreaXMLContent = new JTextArea();
						jScrollPaneXml.setViewportView(jTextAreaXMLContent);
						jTextAreaXMLContent.setDoubleBuffered(true);
						jScrollPaneWirkschaltplanToolbox = new JScrollPane();
						jSplitPaneWirkschaltplan.add(
								jScrollPaneWirkschaltplanToolbox,
								JSplitPane.RIGHT);
						jScrollPaneWirkschaltplanToolbox
								.setMinimumSize(new java.awt.Dimension(200, 200));
						{
							jTabbedPaneWirkschaltplanToolbox = new JTabbedPane();
							jScrollPaneWirkschaltplanToolbox
									.setViewportView(jTabbedPaneWirkschaltplanToolbox);
							jTabbedPaneWirkschaltplanToolbox
									.addChangeListener(new ChangeListener() {
										public void stateChanged(ChangeEvent evt) {
											jTabbedPaneWirkschaltplanToolboxStateChanged(evt);
										}
									});
							{
								svgCanvasWirkschaltplanBasics = new JSVGCanvas();
								jTabbedPaneWirkschaltplanToolbox.addTab(
										"Basic", null,
										svgCanvasWirkschaltplanBasics, null);
								svgCanvasWirkschaltplanBasics
										.setBackground(new java.awt.Color(255,
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

	private void registerListeners() {
		MyEventListener myEventListener = new MyEventListener(
				svgCanvasWirkschaltplan);
		EventTarget target = ((EventTarget) document.getDocumentElement());
		String[] types = { "click", "mousedown", "mouseup", "mouseover",
				"mousemove", "mouseout" };
		MyXmlUtilities.registerAllTypes(target, myEventListener, false, types);
	}

	private void initFileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.setDoubleBuffered(true);
	}

	private void jMenuItemSaveActionPerformed(ActionEvent evt) {
		// TODO Change this when done
		log.fine("jMenuItemSave.actionPerformed, event=" + evt);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(
					svgCanvasWirkschaltplan.getSVGDocument());
			StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	private void jMenuItemNewActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemNew.actionPerformed, event=" + evt);

		setXML(MyXmlUtilities.loadXMLFromFile(new File("default.svg")));
	}

	private void jMenuItemOpenActionPerformed(ActionEvent evt) {
		// TODO Change this when done
		log.fine("jMenuItemOpen.actionPerformed, event=" + evt);
		// if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		// setXML(MyXmlUtilities
		// .loadXMLFromFile(fileChooser.getSelectedFile()));
		setXML(MyXmlUtilities.loadXMLFromFile(new File("test.svg")));

	}

	private void jMenuItemCloseActionPerformed(ActionEvent evt) {
		log.fine("jMenuItemClose.actionPerformed, event=" + evt);
		System.exit(0);
	}

	private void horizontalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		log.fine("jScrollPaneXml.getHorizontalScrollBar().adjustmentValueChanged, event="
				+ evt);
		((JScrollBar) evt.getSource()).getParent().repaint();
	}

	private void verticalScrollBarAdjustmentValueChanged(AdjustmentEvent evt) {
		log.fine("jScrollPaneXml.getVerticalScrollBar().adjustmentValueChanged, event="
				+ evt);
		((JScrollBar) evt.getSource()).getParent().repaint();
	}

	private void jTabbedPaneMainStateChanged(ChangeEvent evt) {
		switch (jTabbedPaneMain.getSelectedIndex()) {
		case 0:
		case 1:
			if (selectedIndex == 2 && jTextAreaXMLContent != null) {
				document = MyXmlUtilities.getXMLFromString(jTextAreaXMLContent
						.getText());
				svgCanvasWirkschaltplan.setDocument(document);
				svgCanvasStromlaufplan.setDocument(document);
			}
			selectedIndex = jTabbedPaneMain.getSelectedIndex();
			break;
		case 2:
			jTextAreaXMLContent.setText(MyXmlUtilities
					.getStringFromXML(document));
			selectedIndex = jTabbedPaneMain.getSelectedIndex();
			break;
		}
	}

	public void setXML(Document xml) {
		document = xml;
		svgCanvasWirkschaltplan.setDocument(xml);
		svgCanvasStromlaufplan.setDocument(xml);
		jTextAreaXMLContent.setText(MyXmlUtilities.getStringFromXML(xml));
	}

	public Document getXML() {
		return document;
	}

	// synchronize JSplitPanes
	private void jSplitPaneWirkschaltplanPropertyChange(PropertyChangeEvent evt) {
		jSplitPaneStromlaufplan.setDividerLocation((int) evt.getNewValue());
	}

	// synchronize JSplitPanes
	private void jSplitPaneStromlaufplanPropertyChange(PropertyChangeEvent evt) {
		jSplitPaneWirkschaltplan.setDividerLocation((int) evt.getNewValue());
	}

	// synchronize JTabbedPanes in Toolbox
	private void jTabbedPaneWirkschaltplanToolboxStateChanged(ChangeEvent evt) {
		System.out
				.println("jTabbedPaneWirkschaltplanToolbox.stateChanged, event="
						+ evt);
		jTabbedPaneStromlaufplanToolbox
				.setSelectedIndex(jTabbedPaneWirkschaltplanToolbox
						.getSelectedIndex());
	}

	// synchronize JTabbedPanes in Toolbox
	private void jTabbedPaneStromlaufplanToolboxStateChanged(ChangeEvent evt) {
		System.out
				.println("jTabbedPaneStromlaufplanToolbox.stateChanged, event="
						+ evt);
		if (jTabbedPaneWirkschaltplanToolbox != null)
			jTabbedPaneWirkschaltplanToolbox
					.setSelectedIndex(jTabbedPaneStromlaufplanToolbox
							.getSelectedIndex());
	}

}
