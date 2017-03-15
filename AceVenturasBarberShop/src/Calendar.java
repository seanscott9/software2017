import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;

public class Calendar extends JFrame implements ActionListener{

	static JPanel calPanel;
	JButton homeButt;
	JLabel bannerLabel;
	JButton logoutButt;
	JButton makeBooking;
	String[] dates ={"dates","will","be","here"};
	private JComboBox comboBox;
	public Calendar() {
		homeButt = new JButton("Home");
		homeButt.addActionListener(this);
		bannerLabel = new JLabel("Calendar");
		logoutButt = new JButton("Logout");
		logoutButt.addActionListener(this);
		JPanel panelTop =new JPanel();
		panelTop.setLayout(new GridLayout(1,3));
		panelTop.add(homeButt);
		panelTop.add(bannerLabel);
		panelTop.add(logoutButt);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dates","will","be","here"}));
		JPanel middle = new JPanel();
		middle.add(comboBox);
		
		
		makeBooking = new JButton("Make Booking");
		makeBooking.addActionListener(this);
		JPanel bookingPanel= new JPanel(); 
		bookingPanel.add(makeBooking);
		
		calPanel = new JPanel();
		calPanel.setSize(500, 500);
		calPanel.setVisible(false);
		calPanel.setLayout(new BorderLayout());
		calPanel.add(panelTop, BorderLayout.NORTH);
		
		calPanel.add(middle, BorderLayout.CENTER);
		calPanel.add(bookingPanel, BorderLayout.SOUTH);
		
		
		//calPanel.add(comboBox, BorderLayout.NORTH);
		//calPanel.add(comboBox, BorderLayout.NORTH);
		//calPanel.add();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
