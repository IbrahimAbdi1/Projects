package paint2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class UndoRedoListener implements ActionListener{
	View view;
	
	public UndoRedoListener(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {e.getSource();
		
		if(((AbstractButton) e.getSource()).getText() == "Redo") {
		this.view.getPaintPanel().getmodel().redo();}
		else if(((AbstractButton) e.getSource()).getText() == "Undo") {
			this.view.getPaintPanel().getmodel().undo();
		}
		
	}
	
	

}
