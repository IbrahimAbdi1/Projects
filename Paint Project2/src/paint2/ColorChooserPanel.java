package paint2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooserPanel extends JPanel implements ChangeListener {
	private View view;
	private JColorChooser colorChooser;
	public ColorChooserPanel(View view) {	
		this.view=view;
		this.colorChooser = new JColorChooser();
		this.colorChooser.getSelectionModel().addChangeListener(this);
		this.add(colorChooser);

		}
	@Override
	public void stateChanged(ChangeEvent e) {
		Color color = colorChooser.getColor();
		this.view.getPaintPanel().setColor(color);
	}


}
