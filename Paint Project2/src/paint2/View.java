
package paint2;
//Add
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
//	private PaintModel model;
	
// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorChooserPanel colorChooserPanel;
	private StyleChooserPanel styleChooserPanel;
	private ThicknessChooserPanel thicknessChooserPanel;
	private UndoRedoListener undoRedo;
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		this.setLayout(null);
		
		Container c=this.getContentPane();

		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.colorChooserPanel = new ColorChooserPanel(this);
		this.styleChooserPanel = new StyleChooserPanel(this);
		this.thicknessChooserPanel = new ThicknessChooserPanel(this);
		
		
		this.paintPanel = new PaintPanel(model, this);
		this.paintPanel.setBounds(140,0, 900, 520);
		c.add(this.paintPanel);
		this.shapeChooserPanel.setBounds(0,10,130,400);
		this.thicknessChooserPanel.setBounds(20, 550, 400, 40);
		this.styleChooserPanel.setBounds(0, 450, 100, 60);
		this.colorChooserPanel.setBounds(380,450,600,400);
		c.add(this.shapeChooserPanel);
		c.add(this.styleChooserPanel);
		c.add(this.colorChooserPanel);
		c.add(this.thicknessChooserPanel);
		//this.model=model;
		

		
		//this.setSize(200,200);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------
		
		undoRedo = new UndoRedoListener(this);

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(undoRedo);
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(undoRedo);
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
}
