package paint2;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;

public class ShapeFactory{
	public ShapeFactory(){}
	
	public  ShapeManipulatorStrategy NewShape(String s) {
		if (s == "Circle") {
			System.out.println("Shape is now a circle");
			return new DrawableCircle();
			}
		else if(s == "Rectangle") {
			System.out.println("Shape is now a Rectangle");
			return new DrawableRectangles();
				}
		else if (s == "Squiggle") {
			System.out.println("Shape is now a Squiggle");
			return new DrawableSquiggle();
				}
		else if (s == "Square") {
			System.out.println("Shape is now a Square");
				return  new DrawableSquare();}
		else if (s == "Polyline") {	
			System.out.println("Shape is now a Polyline");
			return new DrawablePolyLine();
		}
		else if(s == "Oval") {
			return new DrawableOval();
		}
		else if(s == "Line") {
			return new DrawableLine();
		}else if(s == "Eraser") {
			return new Eraser();
		}
		else {
			System.out.println("Im sexy");
			return null;}
	}
	
	public  ShapeManipulatorStrategy evaluate( ShapeManipulatorStrategy shape) {
		if(shape.shapeName() == "Polyline") {
			return shape;
		}
		else {
			return NewShape(shape.shapeName());
		}
	}
	


}
