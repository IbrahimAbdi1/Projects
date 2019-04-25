
package paint2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private Color color;
	private boolean wantitFilled;
	private BasicStroke stroke;
	private ShapeManipulatorStrategy shape;
	private ShapeFactory newShape;
	
	
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.shape = null;
		this.stroke = new BasicStroke(1);
		this.wantitFilled = false;
		this.color = Color.black;
		this.model = model;
		this.model.addObserver(this);
		this.newShape = new ShapeFactory();
		
		this.view= view;
	}
	
	public  ShapeManipulatorStrategy getShape() {
		return this.shape;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public void setStroke(BasicStroke s) {
		this.stroke = s;
	}
	
	public void setStyle(boolean b) {
		System.out.println("OMEGALUL");
		this.wantitFilled = b;
	}
	
	public void setShape(String s) {
		this.shape = newShape.NewShape(s);	
	}
	public void StopShape() {
		this.shape = null;
	}
	
	public PaintModel getmodel() {
		return this.model;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
   

		
		ArrayList<DrawCommands> commandList = this.model.getCommands();
		for(DrawCommands c: commandList) {
			c.executeColor(g2d);
			c.executeStroke(g2d);
			c.execute(g2d);
		}
		
		
		
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if(shape != null) {
		this.shape.mouseMoved(e);
		this.repaint();
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.shape != null) {
		this.shape.mouseDragged(e);
		this.repaint();
		}
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.shape != null) {
		this.shape.mouseClicked(e);
		if(SwingUtilities.isRightMouseButton(e)) {
			this.shape = newShape.NewShape(shape.shapeName());
			this.model.setClick(false);
		}else {
			this.model.addPolyline(this.shape);}
		this.repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.shape != null) {
		this.shape.mousePressed(e);
		shape.addColor(this.color);
		shape.addStyle(this.wantitFilled);
		shape.addStroke(this.stroke);
		shape.addColor(color);
		this.model.addShape(this.shape);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.shape != null) {
		this.shape.mouseReleased(e);
		this.shape = newShape.evaluate(this.shape);
		System.out.println(this.model.getCommands().size());
		
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
