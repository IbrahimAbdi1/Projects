
package paint2;
//Add
import java.awt.Color;

public class Point {
	private Color color;
	int x, y;
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return this.color;
	}
	public void addColor(Color c) {
		this.color = c;
	}
	
}
