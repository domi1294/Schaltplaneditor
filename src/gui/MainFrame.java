package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import stuff.Node;

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
	private JMenuBar jMenuBar;
	private JMenuItem jMenuItemNew;
	private JMenu jMenuEdit;
	private JTabbedPane jTabbedPane1;
	private JPanel jPanel2;
	private JPanel jPanel1;
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

	private Node rootNode = null;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
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

	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setMinimumSize(new java.awt.Dimension(400, 300));
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
				jTabbedPane1.setDoubleBuffered(true);
				{
					jSplitPane1 = new JSplitPane();
					jTabbedPane1.addTab("Image", null, jSplitPane1, null);
					{
						jScrollPaneDrawingBoard = new JScrollPane();
						jScrollPaneDrawingBoard.getHorizontalScrollBar()
						.setVisible(false);
						jSplitPane1.add(jScrollPaneDrawingBoard, JSplitPane.LEFT);
						jScrollPaneDrawingBoard
						.setMinimumSize(new java.awt.Dimension(200, 200));
						{
							jPanel1 = new JPanel() {
								@Override
								public void paint(Graphics g) {
									super.paint(g);
									if (rootNode != null)
										rootNode.draw(g);
								}
							};
							jScrollPaneDrawingBoard.setViewportView(jPanel1);
							jPanel1.setBackground(new java.awt.Color(255, 255, 255));
							jPanel1.setPreferredSize(new java.awt.Dimension(800,
									600));
						}
					}
					{
						jScrollPaneToolbox = new JScrollPane();
						jSplitPane1.add(jScrollPaneToolbox, JSplitPane.RIGHT);
						jScrollPaneToolbox.setMinimumSize(new java.awt.Dimension(
								200, 200));
						{
							jPanel2 = new JPanel();
							jScrollPaneToolbox.setViewportView(jPanel2);
							jPanel2.setPreferredSize(new java.awt.Dimension(800,
									600));
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
					}
					{
						jMenuItemOpen = new JMenuItem();
						jMenuFile.add(jMenuItemOpen);
						jMenuItemOpen.setText("Öffnen ...");
						jMenuItemOpen.setMnemonic(java.awt.event.KeyEvent.VK_F);
						jMenuItemOpen.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed O"));
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
								System.exit(0);
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
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
