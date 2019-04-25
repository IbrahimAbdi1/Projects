
package paint2;
import java.awt.BasicStroke;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ThicknessChooserPanel extends JPanel implements ChangeListener {
	JButton button;
	JLabel label;
	View view;
	JSlider slider;
	public ThicknessChooserPanel(View view) {
		this.view = view;
		this.label = new JLabel("Move the slider to change the thickness size of selected item");
		this.slider = new JSlider(JSlider.HORIZONTAL,1,50,1);
		this.slider.addChangeListener(this);
		this.setLayout(new GridLayout(2,1));
		this.add(label);
		this.add(slider);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		this.view.getPaintPanel().setStroke(new BasicStroke(source.getValue()));
		
	}
	
}
