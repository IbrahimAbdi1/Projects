package paint2;

import java.awt.Graphics2D;

public class DrawableOval extends ShapeManipulatorStrategy{

	public DrawableOval() {
		super();
	}
	
	
	@Override
	public void execute(Graphics2D g) {
	int x = Math.min(super.getStart().getX(), super.getEnd().getX());
	int y = Math.min(super.getStart().getY(), super.getEnd().getY());
	int w = Math.abs(super.getStart().getX() - super.getEnd().getX());
	int h = Math.abs(super.getStart().getY() -super.getEnd().getY());
	if(super.getStyle() == false) {
		g.drawOval(x,y,w,h);}
		else if(super.getStyle() == true){
			g.fillOval(x,y,w,h);
		}
	}

	
	@Override
	public String shapeName() {
		return "Oval";
	} 


}
