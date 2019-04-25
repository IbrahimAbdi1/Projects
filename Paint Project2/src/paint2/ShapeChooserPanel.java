
package paint2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton previous,button,button1,button2,button3,button4,button5,button6,button7;
	private Icon Circle = new ImageIcon(getClass().getResource("circle.png"));
	private Icon Rectangle = new ImageIcon(getClass().getResource("rectangle.png"));
	private Icon Square = new ImageIcon(getClass().getResource("square.png"));
	private Icon Squiggle = new ImageIcon(getClass().getResource("scirbble.png"));
	private Icon Polyline = new ImageIcon(getClass().getResource("polyline.png"));
	private Icon Eraser = new ImageIcon(getClass().getResource("eraser.png"));
	private Icon Line = new ImageIcon(getClass().getResource("line.png"));
	private Icon Oval = new ImageIcon(getClass().getResource("oval.png"));
	public ShapeChooserPanel(View view) {	
		this.view=view;
		this.setLayout(new GridLayout(8,1));
		this.previous = null;
		
		button = new JButton("Circle",Circle);
		button1 = new JButton("Rectangle",Rectangle);
		button2= new JButton("Square",Square);
		button3 = new JButton("Polyline",Polyline);
		button4 = new JButton("Squiggle",Squiggle);
		button5 = new JButton("Oval",Oval);
		button6 = new JButton("Line",Line);
		button7 = new JButton("Eraser",Eraser);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		
		this.add(button);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		this.add(button7);

	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(this.previous == null) {
			b.setBackground(Color.yellow);
			this.previous = b;
		}
		else {
			this.previous.setBackground(null);
			b.setBackground(Color.yellow);
			this.previous = b;
		}
		this.view.getPaintPanel().setShape(b.getText());
		System.out.println(e.getActionCommand());
	}

	
}
