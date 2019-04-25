
package paint2;
import java.awt.Color;
//Add
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StyleChooserPanel extends JPanel implements ActionListener{
	private View view;
	private JButton previous;
	public StyleChooserPanel(View view) {
		this.view = view;
		JButton fill = new JButton("Fill");
		JButton outline = new JButton("Outline");
		fill.addActionListener(this);
		outline.addActionListener(this);
		this.setLayout(new GridLayout(2, 1));
		this.add(fill);
		this.add(outline);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(this.previous == null) {
			b.setBackground(Color.yellow);
			this.previous = b;
			if (b.getText() == "Fill") {
				this.view.getPaintPanel().setStyle(true);}
			else {
				this.view.getPaintPanel().setStyle(false);}
		}
		else if(this.previous != null){
			this.previous.setBackground(null);
			b.setBackground(Color.yellow);
			this.previous = b;
			
			if (b.getText() == "Fill") {
				this.view.getPaintPanel().setStyle(true);}
			else {
				this.view.getPaintPanel().setStyle(false);}
			}
	
		
	}
}
	


