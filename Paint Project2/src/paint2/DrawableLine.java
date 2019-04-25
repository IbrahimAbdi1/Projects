package paint2;

import java.awt.Graphics2D;

public class DrawableLine extends ShapeManipulatorStrategy{

	public DrawableLine() {
		super();
	}
	
	@Override
	public void execute(Graphics2D g) {
		g.drawLine(super.getStart().getX(), super.getStart().getY(), super.getEnd().getX(),  super.getEnd().getY());
	}
	
	@Override
	public String shapeName() {
		return "Line";
	}
}
