import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import db.DBConnection;
import db.User;
/**
 * Ace Ventura's Detective Agency
 * @author Seán Scott, Liam Walsh
 * version 1.0 28/02/2017
 */
public class AceVenturaBarberTheFirst extends JFrame implements ActionListener{
	/**
	 * Main Class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Home window Frame and Buttons
	 */
	JFrame frame;
	JButton timeSlotBookingButt;
	JButton registrationButt;
	JButton viewCalendar;
	JButton logButt;
	JButton loginButt;
	JButton signupButt;
	/**
	 * Calendar Frame and Buttons
	 */
	JFrame calFrame;
	JButton homeButt;
	JLabel bannerLabel;
	JButton logoutButt;
	JButton makeBooking;
	/**
	 * Login Frame and Buttons
	 */
	JFrame loginFrame;
	JPanel loginMainPanel;
	JTextField pwd;
	JTextField usrName;
	/**
	 * Signup Frame and Buttons
	 */
	JFrame signupFrame;
	JTextField phoneTextField;
	JTextField emailArea;
	JPasswordField passwordSignUpArea;
	/*
	 * ADMIN CRUD ELEMENTS
	 */
	JFrame crudFrame;
	JPanel adminCreateBookingPanel;
	JButton adminBooking;
	JPanel adminAccDeletionPanel;
	JButton adminBookingDelete;
	JButton adminAccountCreate;
	JPanel adminBookingCreationPanel;
	JButton adminAccountDelete;
	//ADMIN DATA
	JRadioButton seat1InUse;
	JRadioButton seat2InUse; 
	JRadioButton seat3InUse;
	JTextArea adminAccCreateEmail;//create email
	JTextArea adminCreatePhone;//create phone
	JTextArea adminAccCreatePassTextArea;//create password
	JButton createAccountSubmitButton;//admin create accoutn submit bttn
	
	public AceVenturaBarberTheFirst(){
		super("Barbershop");
		////////////////////////////////////////////////////////////////////////////
		/**
		 * Main frame
		 */
		frame = new JFrame();
		/**
		 * Top panel for seats in use (NYI)
		 */
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		/**
		 * Middle Panel for Logo
		 */
		JPanel middlePanel = new JPanel();
		/**
		 * Left Panel for Buttons
		 */
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(2,1));
		/**
		 * Right Panel
		 */
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(2,1));


		/**
		 * Buttons
		 */

		/**
		 * TimeSlot Button
		 */
		timeSlotBookingButt = new JButton("Book a Timeslot");
		timeSlotBookingButt.addActionListener(this);
		/**
		 * Registration Button
		 */
		registrationButt = new JButton("Registration Form");
		registrationButt.addActionListener(this);
		/**
		 * Calendar Button
		 */
		viewCalendar = new JButton("ViewCalendar(placeholder)");
		viewCalendar.addActionListener(this);
		/**
		 * Login Button
		 */
		logButt = new JButton("Login");
		logButt.addActionListener(this);

		/**
		 * Seats in user(NYI) placeholder
		 */
		JLabel inUse0 = new JLabel(new ImageIcon("src/img/ace.jpg"));
		JLabel inUse1 = new JLabel(new ImageIcon("src/img/ace.jpg"));
		JLabel inUse2 = new JLabel(new ImageIcon("src/img/ace.jpg"));
		//JLabel inUse3 = new JLabel(new ImageIcon("///E:/College/software/AceVenturasBarberShop/src/img/ace.jpg"));

		/**
		 * Logo
		 */
		JLabel logo = new JLabel(new ImageIcon("src/img/barber.jpeg"));

		/**
		 * Setting main frame as Visible
		 * and Size
		 */
		frame.setVisible(true);
		frame.setSize(500, 500);
		/**
		 * North Panel
		 */
		northPanel.add(inUse0);
		northPanel.add(inUse1);
		northPanel.add(inUse2);
		//northPanel.add(inUse3);

		/**
		 * Middle Panel
		 */
		middlePanel.add(logo);
		/**
		 * West Panel
		 */
		westPanel.add(timeSlotBookingButt);
		westPanel.add(registrationButt);
		/**
		 * East Panel
		 */
		eastPanel.add(viewCalendar);
		eastPanel.add(logButt);

		frame.add(northPanel, BorderLayout.PAGE_START);
		frame.add(eastPanel, BorderLayout.LINE_START);
		frame.add(westPanel, BorderLayout.LINE_END);
		frame.add(middlePanel, BorderLayout.CENTER);
		/**
		 * END OF MAIN FRAME
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CALENDAR FRAME	
		 */
		/**
		 * Home Button
		 */
		homeButt = new JButton("Home");
		homeButt.addActionListener(this);
		/**
		 * Logout Button
		 */
		bannerLabel = new JLabel("Calendar");
		logoutButt = new JButton("Logout");
		logoutButt.addActionListener(this);
		JPanel panelTop =new JPanel();
		panelTop.setLayout(new GridLayout(1,3));
		panelTop.add(homeButt);
		panelTop.add(bannerLabel);
		panelTop.add(logoutButt);

		String[] days ={"Monday","Tuesday","Wednsday","Thursday", "Friday", "Saturday", "Sunday"};
		JLabel labelDays = new JLabel("Days");
		/*
		 * SELECT DATE HERE
		 */
		JComboBox<String> datesDropDown = new JComboBox<String>(days);
		
		JLabel times = new JLabel("Times");
		/*
		 * SELECT TIME TIME
		 */
		JComboBox<String> timesDropDown = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
		JPanel middle = new JPanel();
		middle.add(labelDays);
		middle.add(datesDropDown);
		middle.add(times);
		middle.add(timesDropDown);


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
		/**
		 * END OF CALENDAR FRAME
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF LOGIN FRAME
		 */
		/**
		 * To arrange Layout
		 */
		JPanel LoginBannerPanel = new JPanel();
		JLabel loginBanner = new JLabel("Login");
		JPanel loginMiddlePanel = new JPanel();
		JPanel usrnamePanel = new JPanel();
		/**
		 * Adding Components to the Panel
		 */
		JLabel usrNameLabel = new JLabel("Username");
		usrName = new JTextField(25);
		JPanel pwdPanel = new JPanel();
		JLabel pwdLabel = new JLabel("Password");
		pwd = new JTextField(25);
		/**
		 * Home Button
		 */
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(this);
		/**
		 * Login Button
		 */
		loginButt = new JButton("Login");
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
		/**
		 * END OF LOGIN FRAME
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF SIGNUP FRAME
		 */
		JPanel signUpBannerPanel = new JPanel();
		JLabel signUpLabel = new JLabel("Sign-Up");

		JPanel emailSignPanel = new JPanel();
		/**
		 * Home Button
		 */
		homeButt = new JButton("HOME");
		homeButt.addActionListener(this);
		/**
		 * Email Field
		 */
		JLabel emailLabel = new JLabel("E-Mail Address");
		emailArea = new JTextField(25);
		/**
		 * Password Field
		 */
		JPanel passwrodSignUpPanel = new JPanel();
		JLabel passwordsignUpLabel = new JLabel("Password");
		passwordSignUpArea = new JPasswordField(25);
		/**
		 * Phone Number Field
		 */
		JPanel phoneSignUpPanel = new JPanel();
		JLabel phoneLabel = new JLabel("Contact Numbers");
		phoneTextField = new JTextField(25);
		/**
		 * Submit Button
		 */
		signupButt = new JButton("Submit");
		signupButt.addActionListener(this);

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
		signupFrame.add(signupButt, BorderLayout.PAGE_END);
		/**
		 * END OF SIGNUP FRAME
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CRUD HOME DISPLAY		
		 */
		crudFrame = new JFrame();
		JButton logout = new JButton(); ///REMEMBER TO IMPLEMENT
		JLabel crudHeading = new JLabel("ADMIN");
		adminBooking = new JButton("Create new Booking");//GOES TO BOOKING CREATION GUI
		adminBooking.addActionListener(this);
		adminBookingDelete = new JButton("Delete a Booking");//GOES TO BOOKING DELETION GUI 
		adminBookingDelete.addActionListener(this);
		adminAccountCreate = new JButton("Create Account");//GOES TO ACCOUNT CREATION GUI
		adminAccountCreate.addActionListener(this);
		adminAccountDelete = new JButton("Account Deletion");//GOES TO ACCOUNT DELETION GUI
		adminAccountDelete.addActionListener(this);
		seat1InUse = new JRadioButton();//need to look up how to getinput frm these
		seat2InUse = new JRadioButton();//??
		seat3InUse = new JRadioButton();//??
		JPanel adminHeadingPanel = new JPanel();
		adminHeadingPanel.add(crudHeading);
		JPanel adminButtonsPanel = new JPanel();
		adminButtonsPanel.add(adminBooking);
		adminButtonsPanel.add(adminBookingDelete);
		adminButtonsPanel.add(adminAccountCreate);
		adminButtonsPanel.add(adminAccountDelete);
		JPanel adminSeats = new JPanel();
		adminSeats.add(seat1InUse);
		adminSeats.add(seat2InUse);
		adminSeats.add(seat3InUse);	
		
		crudFrame.add(adminHeadingPanel, BorderLayout.PAGE_START);
		crudFrame.add(adminButtonsPanel, BorderLayout.CENTER);
		crudFrame.add(adminSeats, BorderLayout.PAGE_END);
		
		/**
		 * END OF CRUD HOME DISPLAY
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE ACCOUNT ADMIN PANEL	
		 */
		adminCreateBookingPanel = new JPanel();
		JLabel adminAccCreationEmailLabel = new JLabel("Email");
		/**
		 * Email text area
		 */
		adminAccCreateEmail = new JTextArea();//
		JLabel adminAccCreatePhone = new JLabel("Phone");
		/**
		 * phone text area
		 */
		adminCreatePhone = new JTextArea();//
		/**
		 * password text area
		 */
		JLabel adminAccCreatePass = new JLabel("Password");
		adminAccCreatePassTextArea = new JTextArea();//
		/**
		 * Submit button
		 */
		createAccountSubmitButton = new JButton("Submit");//
		createAccountSubmitButton.addActionListener(this);
		
		adminCreateBookingPanel.add(adminAccCreationEmailLabel);
		adminCreateBookingPanel.add(adminAccCreateEmail);
		adminCreateBookingPanel.add(adminAccCreatePhone);
		adminCreateBookingPanel.add(adminCreatePhone);
		adminCreateBookingPanel.add(adminAccCreatePass);
		adminCreateBookingPanel.add(adminAccCreatePassTextArea);
		adminCreateBookingPanel.add(createAccountSubmitButton);
		/**
		 * END OF CREATE ACCOUNT ADMIN PANEL
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF ACCOUNT DELETION ADMIN PANEL
		 */
		adminAccDeletionPanel = new JPanel();
		JLabel accDeletionEmail = new JLabel("Email");
		/**
		 * ACCOUNT DELETION TEXTAREA
		 */
		JTextArea accDeletionEmailArea = new JTextArea();
		/**
		 * SUBMIT BUTTON
		 */
		JButton deletionSubmit = new JButton("Submit");
		deletionSubmit.addActionListener(this);
		adminAccDeletionPanel.add(accDeletionEmail);
		adminAccDeletionPanel.add(accDeletionEmailArea);
		adminAccDeletionPanel.add(deletionSubmit);	
		/**
		 * END OF ACCOUNT DELTION PANEL
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE A BOOKING ADMIN PANEL
		 */
		adminBookingCreationPanel = new JPanel();
		JLabel adminLabelDay = new JLabel("Day");
		/*
		 * DATES HERE
		 */
		JComboBox<String> adminDatesDropDown = new JComboBox<String>(new String[]{"Monday","Tuesday","Wednsday","Thursday", "Friday", "Saturday", "Sunday"});
		JLabel adminLabelTimes = new JLabel("Times");
		/*
		 * TIMES HERE
		 */
		JComboBox<String> adminTimesDropDown = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
		JButton adminBookingCreationSubmit = new JButton("Submit");
		
		
		adminBookingCreationPanel.add(adminLabelDay);
		adminBookingCreationPanel.add(adminDatesDropDown);
		adminBookingCreationPanel.add(adminLabelTimes);
		adminBookingCreationPanel.add(adminTimesDropDown);
		adminBookingCreationPanel.add(adminBookingCreationSubmit);

		/**
		 * END OF CREATE BOOKING ADMIN PANEL
		 */
		
		
	}


	/**
	 * Main Class
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AceVenturaBarberTheFirst frame = new AceVenturaBarberTheFirst();	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Get source of ActionListener
		 */
		Object source = e.getSource();
		/**
		 * TimeSlot Panel Button Action
		 */
		if(source==timeSlotBookingButt){
			System.out.println("Test booking button");
		}
		/**
		 * Registration Panel Button Action
		 */
		if(source == registrationButt){
			System.out.println("Test registration button");
			/**
			 * Changes the visible frame
			 */
			frame.setVisible(false);
			signupFrame.setVisible(true);
		}
		/**
		 * Login Panel Button Action
		 */
		if(source == logButt){
			/**
			 * Changes the visible frame
			 */
			frame.setVisible(false);
			loginFrame.setVisible(true);
		}
		/**
		 * Calendar Panel Button Action
		 */
		if(source == viewCalendar){
			/**
			 * Change the visible frame
			 */
			frame.setVisible(false);
			calFrame.setVisible(true);
		}
		/**
		 * Login Button Action
		 */
		if(source == loginButt){
			/**
			 * Calls the DBConnection LogIn and passes the varibles
			 */
			System.out.println("Login: " + usrName.getText() + ", Password: " + pwd.getText());
			User user = DBConnection.logIn(usrName.getText(), pwd.getText());
			if(user != null) 
			{
				System.out.println("Login userID: " + user.getUserID());
				DBConnection.setUser(user);
				frame.setVisible(true);
				loginFrame.setVisible(false);
			}	
		}
		/**
		 * Home Button Action
		 */
		if(source == homeButt){
			/**
			 * Change the visible frame
			 */
			calFrame.setVisible(false);
			frame.setVisible(true);
		}
		/**
		 * Signup Button Action
		 */
		if(source == signupButt){
			/**
			 * Calls the setUser and insertUser and passes the parameters
			 */
			System.out.println("Create Account: " + emailArea.getText() + ", Password: " + new String(passwordSignUpArea.getPassword()) + ", Phone Number: " + phoneTextField.getText());
			User user = new User(emailArea.getText(), new String(passwordSignUpArea.getPassword()), phoneTextField.getText());
			DBConnection.setUser(user);
			DBConnection.insertUser(user);

		}
		if(source == makeBooking){
			/**
			 * SUBMIT BUTTON ON BOOKING PAGE
			 */
		}
		if(source == adminBooking){
			crudFrame.add(adminCreateBookingPanel);
		}
		if(source == adminBookingDelete){
			crudFrame.add(adminAccDeletionPanel);
		}
		if(source == adminAccountCreate){
			crudFrame.add(adminBookingCreationPanel);
		}
		if(source == adminAccountDelete){
			crudFrame.add(adminAccDeletionPanel);
		}
		if(source == adminAccountCreate){
			crudFrame.add(adminBookingCreationPanel);
		}

		/**
		 * END OF ACTIONLISTENERS
		 */
	}
	/**
	 * END OF PROGRAM
	 */

}
