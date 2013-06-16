package symboleditor;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.svg.SVGCircleElement;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSymbolElement;

import stuff.MyXmlUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class SymbolEditor extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private static final File symbolFolder = new File("symbols");
	private static final File template = new File("template");
	
	private JToolBar jToolBarTools;
	private JButton jButtonSave;
	private JButton jButtonSaveAs;
	private JToggleButton jToggleButtonSelection;
	private JToggleButton jToggleButtonLine;
	private JToggleButton jToggleButtonRectangle;
	private JToggleButton jToggleButtonOval;
	private JToggleButton jToggleButtonFill;
	
	private JSVGCanvas jSVGCanvasEditor;

	private String name;
	private SVGDocument doc;
	private SVGSymbolElement symbol;
	private SVGCircleElement connector;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SymbolEditor inst = new SymbolEditor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SymbolEditor() {
		super();
		initGUI();
		reloadTemplate();
	}
	
	public void newSymbol() {
		reloadTemplate();
		setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setMinimumSize(new java.awt.Dimension(400, 300));
			{
				jToolBarTools = new JToolBar();
				getContentPane().add(jToolBarTools, BorderLayout.NORTH);
				jToolBarTools.setBounds(31, -7, 384, 62);
				jToolBarTools.setDoubleBuffered(true);
				{
					jButtonSave = new JButton();
					jToolBarTools.add(jButtonSave);
					jButtonSave.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/save.png")));
					jButtonSave.setPreferredSize(new java.awt.Dimension(30, 30));
				}
				{
					jButtonSaveAs = new JButton();
					jToolBarTools.add(jButtonSaveAs);
					jButtonSaveAs.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/save_as.png")));
					jButtonSaveAs.setPreferredSize(new java.awt.Dimension(30, 30));
				}
				jToolBarTools.addSeparator();
				{
					jToggleButtonSelection = new JToggleButton();
					jToolBarTools.add(jToggleButtonSelection);
					jToggleButtonSelection.setPreferredSize(new java.awt.Dimension(30, 30));
					jToggleButtonSelection.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/selection.png")));
				}
				{
					jToggleButtonLine = new JToggleButton();
					jToolBarTools.add(jToggleButtonLine);
					jToggleButtonLine.setPreferredSize(new java.awt.Dimension(30, 30));
					jToggleButtonLine.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/line.png")));
				}
				{
					jToggleButtonRectangle = new JToggleButton();
					jToolBarTools.add(jToggleButtonRectangle);
					jToggleButtonRectangle.setPreferredSize(new java.awt.Dimension(30, 30));
					jToggleButtonRectangle.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/rectangle_unfilled.png")));
				}
				{
					jToggleButtonOval = new JToggleButton();
					jToolBarTools.add(jToggleButtonOval);
					jToggleButtonOval.setPreferredSize(new java.awt.Dimension(30, 30));
					jToggleButtonOval.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/circle_unfilled.png")));
				}
				jToolBarTools.addSeparator();
				{
					jToggleButtonFill = new JToggleButton();
					jToolBarTools.add(jToggleButtonFill);
					jToggleButtonFill.setPreferredSize(new java.awt.Dimension(30, 30));
					jToggleButtonFill.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("icons/fill.png")));
				}
			}
			{
				jSVGCanvasEditor = new JSVGCanvas();
				getContentPane().add(jSVGCanvasEditor, BorderLayout.CENTER);
				jSVGCanvasEditor.setDoubleBuffered(true);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void reloadTemplate() {
		doc = (SVGDocument) MyXmlUtilities.loadXMLFromFile(template);
		symbol = (SVGSymbolElement) doc.getElementById("none");
		connector = (SVGCircleElement) doc.getElementById("connector");
		System.out.println("no errors - yay");
	}

}
