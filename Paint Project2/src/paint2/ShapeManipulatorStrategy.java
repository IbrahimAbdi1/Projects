package paint2;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Shape;
//Add
import java.awt.Stroke;

public abstract class  ShapeManipulatorStrategy implements MouseMotionListener,MouseListener,DrawCommands {
	private Color color;
	private boolean wantitFilled;
	private BasicStroke stroke;
	private Point startPoint,endPoint;
	
	
	public void addStroke(BasicStroke s) {
		this.stroke = s;
	}
	public void setPoints(ArrayList<Point> p) {
	}
	
	public BasicStroke getStroke() {
		return this.stroke;
	}
	
	public void addStyle(boolean b) {
		this.wantitFilled = b;
	}
	
	public boolean getStyle() {
		return this.wantitFilled;
	}

	public void addColor(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public String shapeName() {
		return "Shape";
	}
	
	public Point getStart() {
		return this.startPoint;
	}
	
	public Point getEnd(){
		return this.endPoint;
	}
	
	
	@Override 
	public void executeColor(Graphics2D g){
		g.setColor(this.color);
	}
	
	@Override
	public void executeStroke(Graphics2D g) {
		g.setStroke(this.stroke);
	}
	
	@Override
	public void execute(Graphics2D g) {}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.endPoint = new Point(e.getX(),e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.startPoint = new Point(e.getX(),e.getY());	
		this.endPoint = new Point(e.getX(),e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.endPoint = new Point(e.getX(),e.getY());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}