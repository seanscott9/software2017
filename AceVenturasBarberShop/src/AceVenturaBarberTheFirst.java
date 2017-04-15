import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;

import db.Booking;
import db.DBConnection;
import db.User;
/**
 * Ace Ventura's Detective Agency
 * @author Sean Scott, Liam Walsh
 * version 1.0 28/02/2017
 */
public class AceVenturaBarberTheFirst extends JFrame implements ActionListener{
	/**
	 * Main Class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * IS USER AN ADMIN
	 */
	Boolean isAdmin = false;
	Boolean isLogged = false;
	User user;
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
	JComboBox<String> timesDropDown;
	JComboBox<String> datesDropDown;
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
	JPanel adminCreateAccountPanel;
	JButton adminBooking;
	JPanel adminAccDeletionPanel;
	JButton adminBookingDelete;
	JButton adminAccountCreate;
	JPanel adminBookingCreationPanel;
	JButton adminAccountDelete;
	JPanel crudPanel;
	JPanel adminBookingDeletionPanel;
	//ADMIN DATA
	JRadioButton seat1InUse;
	JRadioButton seat2InUse; 
	JRadioButton seat3InUse;
	JTextArea adminAccCreateEmail;//create email
	JTextArea adminCreatePhone;//create phone
	JTextArea adminAccCreatePassTextArea;//create password
	JButton createAccountSubmitButton;//admin create accoutn submit bttn
	JButton adminBookingCreationSubmit;//admin create booking submit
	JButton adminBookingDeletionSubmit;//admin delete booking sublit
	JButton deletionSubmit;//admin account deletion submit button
	JComboBox<String> adminDatesDropDownDeletion;
	JComboBox<String> adminTimesDropDownDeletion;
	JTextArea accDeletionEmailArea;
	JComboBox<String> adminDatesDropDown;
	JComboBox<String> adminTimesDropDown;
	

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
		
		viewCalendar = new JButton("View Calendar");
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

		if(isLogged == false)
		{
			viewCalendar.setVisible(false);
		}
		
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
		datesDropDown = new JComboBox<String>(days);

		JLabel times = new JLabel("Times");
		/*
		 * SELECT TIME TIME
		 */
		timesDropDown = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
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
		adminButtonsPanel.setLayout(new BoxLayout(adminButtonsPanel, BoxLayout.PAGE_AXIS));
		adminButtonsPanel.add(adminBooking);
		adminButtonsPanel.add(adminBookingDelete);
		adminButtonsPanel.add(adminAccountCreate);
		adminButtonsPanel.add(adminAccountDelete);
		JPanel adminSeats = new JPanel();
		adminSeats.add(seat1InUse);
		adminSeats.add(seat2InUse);
		adminSeats.add(seat3InUse);	
		crudPanel = new JPanel();


		crudPanel.add(adminHeadingPanel, BorderLayout.PAGE_START);
		crudPanel.add(adminButtonsPanel, BorderLayout.CENTER);
		crudPanel.add(adminSeats, BorderLayout.PAGE_END);
		crudFrame.add(crudPanel);

		/**
		 * END OF CRUD HOME DISPLAY
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE ACCOUNT ADMIN PANEL	
		 */
		adminCreateAccountPanel = new JPanel();
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
		adminCreateAccountPanel.setLayout(new BoxLayout(adminCreateAccountPanel, BoxLayout.PAGE_AXIS));	

		adminCreateAccountPanel.add(adminAccCreationEmailLabel);
		adminCreateAccountPanel.add(adminAccCreateEmail);
		adminCreateAccountPanel.add(adminAccCreatePhone);
		adminCreateAccountPanel.add(adminCreatePhone);
		adminCreateAccountPanel.add(adminAccCreatePass);
		adminCreateAccountPanel.add(adminAccCreatePassTextArea);
		adminCreateAccountPanel.add(createAccountSubmitButton);
		/**
		 * END OF CREATE ACCOUNT ADMIN PANEL
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF ACCOUNT DELETION ADMIN PANEL
		 */
		adminAccDeletionPanel = new JPanel();
		adminAccDeletionPanel.setLayout(new BoxLayout(adminAccDeletionPanel, BoxLayout.PAGE_AXIS));	

		JLabel accDeletionEmail = new JLabel("Email");
		/**
		 * ACCOUNT DELETION TEXTAREA
		 */
		accDeletionEmailArea = new JTextArea();
		/**
		 * SUBMIT BUTTON
		 */
		deletionSubmit = new JButton("Submit");
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
		adminBookingCreationPanel.setLayout(new GridLayout(3, 2));	
		JLabel adminLabelDay = new JLabel("Day");
		/*
		 * DATES HERE
		 */
		adminDatesDropDown = new JComboBox<String>(new String[]{"Monday","Tuesday","Wednsday","Thursday", "Friday", "Saturday", "Sunday"});
		JLabel adminLabelTimes = new JLabel("Times");
		/*
		 * TIMES HERE
		 */
		JComboBox<String> adminTimesDropDown = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
		adminBookingCreationSubmit = new JButton("Submit");
		adminBookingCreationSubmit.addActionListener(this);
	
		adminBookingCreationPanel.add(adminLabelDay);
		adminBookingCreationPanel.add(adminDatesDropDown);
		adminBookingCreationPanel.add(adminLabelTimes);
		adminBookingCreationPanel.add(adminTimesDropDown);
		adminBookingCreationPanel.add(adminBookingCreationSubmit);

		/**
		 * END OF CREATE BOOKING ADMIN PANEL
		 */
		/**
		 * booking deletion admin Panel
		 */
		adminBookingDeletionPanel = new JPanel();
		adminBookingDeletionPanel.setLayout(new GridLayout(3, 2));	
		JLabel adminLabelDayDEletion = new JLabel("Day");
		/*
		 * DATES HERE
		 */
		
		adminDatesDropDownDeletion = new JComboBox<String>(new String[]{"Monday","Tuesday","Wednsday","Thursday", "Friday", "Saturday", "Sunday"});
		JLabel adminLabelTimesDeletion = new JLabel("Times");
		/*
		 * TIMES HERE
		 */
		adminTimesDropDownDeletion = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
		adminBookingDeletionSubmit = new JButton("Submit");
		adminBookingDeletionSubmit.addActionListener(this);

		adminBookingDeletionPanel.add(adminLabelDayDEletion);
		adminBookingDeletionPanel.add(adminDatesDropDownDeletion);
		adminBookingDeletionPanel.add(adminLabelTimesDeletion);
		adminBookingDeletionPanel.add(adminTimesDropDownDeletion);
		adminBookingDeletionPanel.add(adminBookingDeletionSubmit);
		/**
		 * END OF BOOKING DELETION ADMIN PANEL
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
				user = DBConnection.logIn(usrName.getText(), pwd.getText());
				boolean isAdmin = DBConnection.isAdmin(user);
				if(user != null && isAdmin == false) 
				{
					System.out.println("Login userID: " + user.getUserID());
					DBConnection.setUser(user);
					frame.setVisible(true);
					loginFrame.setVisible(false);
					isLogged = true;
					viewCalendar.setVisible(true);
					
				}
			
			 
			//if logged as admin goes straigth to admin mode
				if(user != null && isAdmin == true)
				{
					loginFrame.setVisible(false);
					crudFrame.setVisible(true);
					crudFrame.setSize(500, 500);
					isLogged = true;
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
			
			
			Booking booking = new Booking(new String((String) timesDropDown.getSelectedItem()) ,new String((String) datesDropDown.getSelectedItem()));
			DBConnection.insertBooking(booking, user);
			System.out.println("Booking for " + (String)timesDropDown.getSelectedItem() + " on " + (String)datesDropDown.getSelectedItem());
			calFrame.setVisible(false);
			frame.setVisible(true);
			
			//////TEST MUTHAFUCKA/////////
		}
		/*
		 * admin make booking
		 */
		if(source == adminBooking){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminBookingCreationPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN BOOKING PAGE BUTTON");
		}
		/*
		 * submit for admin booking
		 * 
		 */
		if(source == adminBookingCreationSubmit){
			
			Booking booking = new Booking(new String((String) adminTimesDropDown.getSelectedItem()) ,new String((String) adminDatesDropDown.getSelectedItem()));
			DBConnection.insertBooking(booking, user);
			System.out.println("Booking for " + (String)adminTimesDropDown.getSelectedItem() + " on " + (String)adminDatesDropDown.getSelectedItem());

			crudFrame.remove(adminBookingCreationPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			//System.out.println("TEST ADMIN CREATE BOOKING SUBMIT");
			
		}
		/*
		 * admin delete booking panel
		 */
		if(source == adminBookingDelete){
			
			crudFrame.remove(crudPanel);
			crudFrame.add(adminBookingDeletionPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN BOOKIN DELETE PAGE BUTTON");
		}
		/*
		 * admin booking delete submit button
		 */
		if(source == adminBookingDeletionSubmit){
			
			Booking booking = new Booking(new String((String) adminTimesDropDownDeletion.getSelectedItem()) ,new String((String) adminDatesDropDownDeletion.getSelectedItem()));
			DBConnection.deleteBooking(booking, user);
			
			crudFrame.remove(adminBookingDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN BOOKING DELETE SUBMIT BUTTON");
		}
		/*
		 * admin account create account
		 */
		if(source == adminAccountCreate){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminCreateAccountPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN CREATE ACCOUNT PAGE");
		}
		/*
		 * admin account creation submit button
		 */
		if(source == createAccountSubmitButton){
			
			
			System.out.println("Create Account: " + adminAccCreateEmail.getText() + ", Password: " + adminAccCreatePassTextArea.getText() + ", Phone Number: " + adminCreatePhone.getText());
			User user = new User(adminAccCreateEmail.getText(), adminAccCreatePassTextArea.getText(), adminCreatePhone.getText());
			DBConnection.setUser(user);
			DBConnection.insertUser(user);
			
			crudFrame.remove(adminCreateAccountPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN CREATE ACCOUNT SUBMIT BUTTON");
		}
		/*
		 * admin delete account panel
		 */
		if(source == adminAccountDelete){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminAccDeletionPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 
			
			//System.out.println("TEST ADMIN ACCOUNT DELETION PAGE BUTTON");
		}
		/*
		 * admin account deletion
		 */
		if(source == deletionSubmit){
			
			System.out.println("Delete Account: " + accDeletionEmailArea.getText());
			User user = new User(accDeletionEmailArea.getText());
			DBConnection.deleteUser(user);
			
			crudFrame.remove(adminAccDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint();
			
			//System.out.println("TEST DELETE SUBMIT");
		}







		/**
		 * END OF ACTIONLISTENERS
		 */
	}
	/**
	 * END OF PROGRAM
	 */

}

