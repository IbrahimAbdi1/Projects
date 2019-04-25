
package paint2;
//Add
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<DrawCommands> commands = new ArrayList<DrawCommands>();
	private ArrayList<DrawCommands> undos =  new ArrayList<DrawCommands>();
	private boolean click = false;
	
	
	public ArrayList<DrawCommands> getCommands(){
		return commands;
	}

	
	
	public void addShape(ShapeManipulatorStrategy s){
		if(s.shapeName() == "Polyline") {}
		else {
		this.commands.add(s);
		this.setChanged();
		this.notifyObservers();}
		}
	
	public void setClick(boolean b) {
		this.click = b;
	}
	
	public void addPolyline(ShapeManipulatorStrategy s) {
		if(s.shapeName() == "Polyline" && click == false) {
			this.commands.add(s);
			this.setChanged();
			this.notifyObservers();
			this.click = true;
		}
		}
		
	public void undo() {
		DrawCommands c = this.commands.get(commands.size() - 1);
		this.commands.remove(commands.size() - 1); 
		this.undos.add(c);
		this.setChanged();
		this.notifyObservers();
		
	}
	
	public void redo() {
		if(this.undos.size() > 0) {
			DrawCommands c = this.undos.get(commands.size() - 1);
			this.undos.remove(commands.size() - 1);
			this.commands.add(c);
			this.setChanged();
			this.notifyObservers();
			
		}
	}

	
}
