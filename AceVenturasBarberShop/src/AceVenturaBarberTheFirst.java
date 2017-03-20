import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import db.DBConnection;
import db.User;
/**
 * @author Seán Scott, Liam Walsh
 * version 1.0 28/02/2017
 */
public class AceVenturaBarberTheFirst extends JFrame implements ActionListener{
	//home window buttons
	JFrame frame;
	JButton timeSlotBookingButt;
	JButton registrationButt;
	JButton viewCalendar;
	JButton loginButt;
	//////////////////
	//CALENDAR 
	JFrame calFrame;
	JButton homeButt;
	JLabel bannerLabel;
	JButton logoutButt;
	JButton makeBooking;
	////////////////////
	//LOGIN
	JFrame loginFrame;
	JPanel loginMainPanel;
	////////////////////
	//SignUP
	JFrame signupFrame;
	public AceVenturaBarberTheFirst(){
		super("Barbershop");
			//main home frame
			frame = new JFrame();
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
			
			
			
			//buttons
			timeSlotBookingButt = new JButton("Book a Timeslot");
			
			timeSlotBookingButt.addActionListener(this);////////TIME SLOT BUTTON
			registrationButt = new JButton("Registration Form");
			registrationButt.addActionListener(this);/////////REGISTRATION BUTTON
			viewCalendar = new JButton("ViewCalendar(placeholder)");
			viewCalendar.addActionListener(this);////////VIEW CALENDAR BUT
			loginButt = new JButton("Login");/////////LOGIN BUTT
			loginButt.addActionListener(this);
			
			//seats in use placeholder
			JLabel inUse0 = new JLabel(new ImageIcon("src/img/ace.jpg"));
			JLabel inUse1 = new JLabel(new ImageIcon("src/img/ace.jpg"));
			JLabel inUse2 = new JLabel(new ImageIcon("src/img/ace.jpg"));
			//JLabel inUse3 = new JLabel(new ImageIcon("///E:/College/software/AceVenturasBarberShop/src/img/ace.jpg"));
			
			//logo
			JLabel logo = new JLabel(new ImageIcon("src/img/barber.jpeg"));
			
			frame.setVisible(true);
			frame.setSize(500, 500);
			//north
			northPanel.add(inUse0);
			northPanel.add(inUse1);
			northPanel.add(inUse2);
			//northPanel.add(inUse3);
			
			//middle
			middlePanel.add(logo);
			//west
			westPanel.add(timeSlotBookingButt);
			westPanel.add(registrationButt);
			//east
			eastPanel.add(viewCalendar);
			eastPanel.add(loginButt);
			
			frame.add(northPanel, BorderLayout.PAGE_START);
			frame.add(eastPanel, BorderLayout.LINE_START);
			frame.add(westPanel, BorderLayout.LINE_END);
			frame.add(middlePanel, BorderLayout.CENTER);
		/////////////////////////////////////////////////////////END OF HOME FRAME
			
		///START OF CALENDAR FRAME////////////////////////////////////////////////	
			homeButt = new JButton("Home");//////HOME BUTT
			homeButt.addActionListener(this);
			bannerLabel = new JLabel("Calendar");//////HOME BUTT
			logoutButt = new JButton("Logout");
			logoutButt.addActionListener(this);//////LOGOUT
			JPanel panelTop =new JPanel();
			panelTop.setLayout(new GridLayout(1,3));
			panelTop.add(homeButt);
			panelTop.add(bannerLabel);
			panelTop.add(logoutButt);
			
			String[] dates ={"dates","will","be","here"};
			
			JComboBox<String> datesDropDown = new JComboBox<String>(dates);
			JPanel middle = new JPanel();
			middle.add(datesDropDown);
			
			
			makeBooking = new JButton("Make Booking");
			makeBooking.addActionListener(this);
			JPanel bookingPanel= new JPanel(); 
			bookingPanel.add(makeBooking);
			
			calFrame = new JFrame();
			calFrame.setSize(500, 500);
			calFrame.setVisible(false);
			calFrame.add(panelTop, BorderLayout.PAGE_START);
			calFrame.add(middle, BorderLayout.CENTER);
			calFrame.add(bookingPanel, BorderLayout.PAGE_END);
		////////////////////////////////////////////////////////END OF CALENDAR
		////////LOGIN GUI
			JPanel LoginBannerPanel = new JPanel();
			JLabel loginBanner = new JLabel("Login");
			JPanel loginMiddlePanel = new JPanel();//to arrange inputs
			JPanel usrnamePanel = new JPanel();
			JLabel usrNameLabel = new JLabel("Username");
			JTextField usrName = new JTextField(25);
			JPanel pwdPanel = new JPanel();
			JLabel pwdLabel = new JLabel("Password");
			JTextField pwd = new JTextField(25);
			JButton homeButton = new JButton("Home");/////////HOME BUTTON
			homeButton.addActionListener(this);
			JButton loginButt = new JButton("Login");/////////SUBMIT/LOGIN BUTTON
			loginButt.addActionListener(this);
			
			JPanel loginPanel = new JPanel();
			loginPanel.add(loginButt);
			
			LoginBannerPanel.add(loginBanner);
			LoginBannerPanel.add(loginButt); 
			usrnamePanel.add(usrNameLabel);
			usrnamePanel.add(usrName);
			pwdPanel.add(pwdLabel);
			pwdPanel.add(pwd);
			loginMiddlePanel.add(usrnamePanel, BorderLayout.PAGE_START);//to arrange inputs
			loginMiddlePanel.add(pwdPanel, BorderLayout.PAGE_START);
			
			loginFrame = new JFrame();
			loginFrame.setSize(500, 500);
			loginFrame.setVisible(false);
			loginFrame.add(LoginBannerPanel, BorderLayout.PAGE_START);
			loginFrame.add(loginMiddlePanel,BorderLayout.CENTER);
			loginFrame.add(loginPanel, BorderLayout.PAGE_END);
			///////////////////////////////LOGIN GUI END
			////////////////////////////////////////////SIGN UP GUI
			JPanel signUpBannerPanel = new JPanel();
			JLabel signUpLabel = new JLabel("Sign-Up");
			//email, passwrod, phone optional
			JPanel emailSignPanel = new JPanel();
			JButton backHome = new JButton("HOME");////////HOME BUTTON
			backHome.addActionListener(this);
			JLabel emailLabel = new JLabel("E-Mail Address");
			JTextField emailArea = new JTextField(25);//eamil field
			JPanel passwrodSignUpPanel = new JPanel();
			JLabel passwordsignUpLabel = new JLabel("Password");
			JPasswordField passwordSignUpArea = new JPasswordField(25);//pwd field
			JPanel phoneSignUpPanel = new JPanel();
			JLabel phoneLabel = new JLabel("Contact Numbers");//phone field
			JTextField phoneTextField = new JTextField(25);
			JButton submit = new JButton("Submit");//*********SUBMIT BUTTON HERE
			submit.addActionListener(this);
			
			signUpBannerPanel.add(signUpLabel);
			emailSignPanel.add(emailLabel, BorderLayout.PAGE_START);
			emailSignPanel.add(emailArea, BorderLayout.PAGE_END);
			passwrodSignUpPanel.add(passwordsignUpLabel, BorderLayout.PAGE_START);
			passwrodSignUpPanel.add(passwordSignUpArea, BorderLayout.PAGE_END);
			phoneSignUpPanel.add(phoneLabel, BorderLayout.PAGE_START);
			phoneSignUpPanel.add(phoneTextField, BorderLayout.PAGE_END);
			
			JPanel signUpInputs = new JPanel();
			signUpInputs.add(emailSignPanel);
			signUpInputs.add(passwrodSignUpPanel);
			signUpInputs.add(phoneSignUpPanel);
			
			signupFrame = new JFrame();
			signupFrame.setSize(500, 500);
			signupFrame.setVisible(false);
			signupFrame.add(signUpBannerPanel, BorderLayout.PAGE_START);
			signupFrame.add(signUpInputs, BorderLayout.CENTER);
			signupFrame.add(submit, BorderLayout.PAGE_END);
						
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AceVenturaBarberTheFirst frame = new AceVenturaBarberTheFirst();	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source==timeSlotBookingButt){
			System.out.println("Test booking button");
		}if(source == registrationButt){
			System.out.println("Test registration button");
			frame.setVisible(false);
			signupFrame.setVisible(true);
		}if(source == viewCalendar){
			frame.setVisible(false);
			calFrame.setVisible(true);
		}if(source == loginButt){
			System.out.println("Login: " + usrName.getText() + ", Password: " + pwd.getText());
			User user = DBConnection.logIn(usrName.getText(), pwd.getText());
			if(user != null) 
			{
				System.out.println("Login userID: " + user.getUserID());
				DBConnection.setUser(user);
			}
			frame.setVisible(false);
			loginFrame.setVisible(true);
		}if(source == homeButt){
			calFrame.setVisible(false);
			frame.setVisible(true);
		}
		
	}

}
