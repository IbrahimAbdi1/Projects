package paint2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public interface DrawCommands {
	  public void execute(Graphics2D g);
	  public void executeColor(Graphics2D g);
	  public void executeStroke(Graphics2D g);
	  
	  

}
