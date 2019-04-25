package paint2;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class DrawableRectangles extends  ShapeManipulatorStrategy{
	Point Location,end;
	
	public DrawableRectangles() {
		super();
		this.Location = null;
		this.end = null;
	}
	
	
	@Override
	public void execute(Graphics2D g) {
		g.setColor(super.getColor());
		int x = Math.min(super.getStart().getX(), super.getEnd().getX());
		int y = Math.min(super.getStart().getY(), super.getEnd().getY());
		int w = Math.abs(super.getStart().getX() - super.getEnd().getX());
		int h = Math.abs(super.getStart().getY() -super.getEnd().getY());
		if(super.getStyle() == false) {
			g.drawRect(x,y,w,h);}
			else if(super.getStyle() == true){
				g.fillRect(x,y,w,h);
		}
	}

	
	@Override
	public String shapeName() {
		return "Rectangle";
	} 
	
	


	
	



}
