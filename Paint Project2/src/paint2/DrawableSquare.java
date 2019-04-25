package paint2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

//Add
public class DrawableSquare extends  ShapeManipulatorStrategy  {

	
	public DrawableSquare() {
		super();
	}
	
	
	
	@Override
	public void execute(Graphics2D g) {
		int w = Math.abs(super.getStart().getX() -super.getEnd().getX());
		int h = Math.abs(super.getStart().getY() -super.getEnd().getY());
		int min = Math.min(w,h);
		if(super.getStart().getX() > super.getEnd().getX() && super.getStart().getY() > super.getEnd().getY() ) {
			if(super.getStyle() == false) {
			g.drawRect(super.getStart().getX() - min, super.getStart().getY()- min, min, min);}
			else {
				g.fillRect(super.getStart().getX() - min, super.getStart().getY()- min, min, min);}
			}
		else if(super.getStart().getX() < super.getEnd().getX() && super.getStart().getY() > super.getEnd().getY()) {
			if(super.getStyle() == false) {
			g.drawRect(super.getStart().getX(), super.getStart().getY()- min, min, min);}
			else {
				g.fillRect(super.getStart().getX(), super.getStart().getY()- min, min, min);}
			
		}else if(super.getStart().getX() > super.getEnd().getX() && super.getStart().getY() < super.getEnd().getY()) {
			if(super.getStyle() == false) {
			g.drawRect(super.getStart().getX() - min, super.getStart().getY(), min, min);}
			else {
				g.fillRect(super.getStart().getX() - min, super.getStart().getY(), min, min);
			}
		}else {
			if(super.getStyle() == false) {
			g.drawRect(super.getStart().getX(), super.getStart().getY(), min, min);}
			else {
				g.fillRect(super.getStart().getX(), super.getStart().getY(), min, min);	
			}
		}
	}
	
	
	@Override
	public String shapeName() {
		return "Square";
	}
	



}
