import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home() {
		JButton timeSlotBookingButt;
		JButton registrationButt;
		JButton viewCalendar;
		JButton loginButt;
				
				//main home frame
				
				//top panel for seats in use 
				JPanel northPanel = new JPanel();
				northPanel.setLayout(new FlowLayout());
				//middle panel for logo
				JPanel middlePanel = new JPanel();
				//left panel for buttons
				JPanel westPanel = new JPanel();
				westPanel.setLayout(new GridLayout(2,1));
				//right panel
				JPanel eastPanel = new JPanel();
				eastPanel.setLayout(new GridLayout(2,1));
				registrationButt = new JButton("Registration");
				registrationButt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
				registrationButt.setForeground(new Color(0, 128, 0));
				registrationButt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				registrationButt.setBackground(SystemColor.activeCaption);
				registrationButt.setPreferredSize(new Dimension(150, 25));
				registrationButt.setMinimumSize(new Dimension(100, 20));
				registrationButt.setMaximumSize(new Dimension(150, 20));
				registrationButt.addActionListener(this);//actionlistener
				viewCalendar = new JButton("View Calendar");
				viewCalendar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
				viewCalendar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				viewCalendar.setForeground(new Color(0, 128, 0));
				viewCalendar.setBackground(SystemColor.activeCaption);
				viewCalendar.setMaximumSize(new Dimension(150, 23));
				viewCalendar.setMinimumSize(new Dimension(100, 23));
				viewCalendar.setPreferredSize(new Dimension(150, 25));
				//viewCalendar.addActionListener(this);//ActionListener
				loginButt = new JButton("Login");
				loginButt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
				loginButt.setBackground(SystemColor.activeCaption);
				loginButt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				loginButt.setForeground(new Color(0, 128, 0));
				//loginButt.addActionListener(this);//ACtionListener
				
				//seats in use placeholder
				JLabel inUse0 = new JLabel(new ImageIcon("src/img/ace.jpg"));
				JLabel inUse1 = new JLabel(new ImageIcon("src/img/ace.jpg"));
				JLabel inUse2 = new JLabel(new ImageIcon("src/img/ace.jpg"));
				//JLabel inUse3 = new JLabel(new ImageIcon("src/img/ace.jpg"));
				
				//logo
				JLabel logo = new JLabel(new ImageIcon("src/img/barber.jpeg"));
				logo.setOpaque(true);
				
				//north
				northPanel.add(inUse0);
				northPanel.add(inUse1);
				northPanel.add(inUse2);
				//northPanel.add(inUse3);
				
				//middle
				middlePanel.add(logo);
				westPanel.add(registrationButt);
				//east
				eastPanel.add(viewCalendar);
				eastPanel.add(loginButt);
				
				
				//buttons
				timeSlotBookingButt = new JButton("Book Timeslot");
				timeSlotBookingButt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
				timeSlotBookingButt.setBackground(SystemColor.activeCaption);
				timeSlotBookingButt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				timeSlotBookingButt.setForeground(new Color(0, 128, 0));
				westPanel.add(timeSlotBookingButt);
				
				
				setLayout(new BorderLayout());
				add(northPanel, BorderLayout.PAGE_START);
				add(eastPanel, BorderLayout.LINE_START);
				add(westPanel, BorderLayout.LINE_END);
				add(middlePanel, BorderLayout.CENTER);
				setSize(500,500);
				setVisible(true);
				this.setVisible(true);
				

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
