import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */

/**
 * @author sean
 *
 */
public class Main{
	CardLayout c1 = new CardLayout();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Home g1 = new Home();//HOME MADE
	
	public Main(){
	panel.setLayout(c1);
	panel.add(g1, "1");//HOME SET AS 1
	
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	c1.show(panel, "1");//home displayed
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();

	}


}
