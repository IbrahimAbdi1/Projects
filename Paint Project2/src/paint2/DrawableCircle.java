package paint2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class DrawableCircle extends  ShapeManipulatorStrategy{

	
	public DrawableCircle(){
		super();
	}


	
	@Override
	public void execute(Graphics2D g) {
		g.setColor(super.getColor());
		int x = Math.abs(super.getStart().getX() - super.getEnd().getX());
		int y = Math.abs(super.getStart().getY() -super.getEnd().getY());
		int radius = (int) Math.sqrt(x*x + y*y);
		if(super.getStyle() == false) {
		g.drawOval(super.getStart().getX() - radius,super.getStart().getY()-radius,2*radius,2*radius);}
		else if(super.getStyle() == true){
			g.fillOval(super.getStart().getX() - radius,super.getStart().getY()-radius,2*radius,2*radius);
		}
	}
	


	@Override
	public String shapeName() {
		return "Circle";
	}







}
