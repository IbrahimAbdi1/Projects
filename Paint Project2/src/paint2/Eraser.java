package paint2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Eraser extends ShapeManipulatorStrategy {
	private ArrayList<Point> points;
	private Color c = Color.WHITE;

	public Eraser() {
		super(); 
		this.points = new ArrayList<Point>();
		this.c = null;
	}
	
	public ArrayList<Point> getPoints(){
		return this.points;
	}
	
	
	
	@Override
	public void setPoints(ArrayList<Point> p) {
		this.points = p;
	}

	@Override
	public void execute(Graphics2D g) {
		g.setColor(Color.WHITE);
		for(int i=0;i<this.points.size()-1; i++){
			Point p1=this.points.get(i);
		    Point p2=this.points.get(i+1);
		    g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		    }
	}
	
	@Override
	public String shapeName() {
		return "Eraser";
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("hit");
		Point p = new Point(e.getX(),e.getY());
		this.points.add(p);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		this.points.add(p);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		this.points.add(p);
	}
}
