package paint2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class DrawablePolyLine extends  ShapeManipulatorStrategy {
	private ArrayList<Point> points;
	private Point start,end;
	private boolean isclicked;
	
	public DrawablePolyLine() {
		super();
		this.points = new ArrayList<Point>();
		this.isclicked = false;
		this.end = null;
	}
	@Override
	public String shapeName() {
		return "Polyline";
	}
	
	@Override
	public void execute(Graphics2D g) {
		g.setStroke(super.getStroke());
		g.setColor(super.getColor());
		for(int i=0;i<this.points.size()-1; i++){
			Point p1=this.points.get(i);
		    Point p2=this.points.get(i+1);
		    g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		    }

	}
	



	@Override
	public void mouseMoved(MouseEvent e) {	
		if(this.isclicked == true) {
			Point p = new Point(e.getX(),e.getY());
			this.end = p;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			this.isclicked = false;
		}else {
		Point p = new Point(e.getX(),e.getY());
		this.start = p;
		this.isclicked = true;
		this.points.add(p);
		}
	}




	
	
}
