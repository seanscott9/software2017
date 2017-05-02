import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	JPanel mainPanel;
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
	JButton homeButt1;
	JButton homeButt2;
	JLabel bannerLabel;
	JButton logoutButt;
	JButton makeBooking;
	JComboBox<String> timesDropDown;
	JComboBox<String> datesDropDown;
	/**
	 * Login Frame and Buttons
	 */
	JPanel loginFrame;
	JPasswordField pwd;
	JTextField usrName;
	/**
	 * Signup Frame and Buttons
	 */
	JPanel signupFrame;
	JTextField phoneTextField;
	JTextField emailArea;
	JPasswordField passwordSignUpArea;
	/*
	 * ADMIN CRUD ELEMENTS
	 */
	JPanel crudFrame;
	JPanel adminCreateAccountPanel;
	JButton adminBooking;
	JPanel adminAccDeletionPanel;
	JButton adminBookingDelete;
	JButton adminAccountCreate;
	JPanel adminBookingCreationPanel;
	JButton adminAccountDelete;
	JPanel crudPanel;
	JPanel adminBookingDeletionPanel;
	
	//Admin home buttons
	JButton homeButtonAdminCreateAcc;
	JButton adminDeletionButton;
	JButton AdminBookingDeletionHome;
	JButton adminBookingCreationHomeButton;
	JButton AdminDeletionHomeButton;
	JButton btnNewButton;
	//ADMIN DATA
	JRadioButton seat1InUse;
	JRadioButton seat2InUse; 
	JRadioButton seat3InUse;
	JTextField adminAccCreateEmail;//create email
	JTextField adminCreatePhone;//create phone
	JPasswordField adminAccCreatePassTextArea;//create password
	JButton createAccountSubmitButton;//admin create accoutn submit bttn
	JButton adminBookingCreationSubmit;//admin create booking submit
	JButton adminBookingDeletionSubmit;//admin delete booking sublit
	JButton deletionSubmit;//admin account deletion submit button
	JComboBox<String> adminDatesDropDownDeletion;
	JComboBox<String> adminTimesDropDownDeletion;
	JTextField accDeletionEmailArea;
	JComboBox<String> adminDatesDropDown;
	JComboBox<String> adminTimesDropDown;


	public AceVenturaBarberTheFirst(){
		super("Barbershop");
		////////////////////////////////////////////////////////////////////////////
		/**
		 * Main frame
		 */
		frame = new JFrame();
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
		westPanel.setMaximumSize(new Dimension(101, 23));
		westPanel.setLayout(new GridLayout(2,1));
		/**
		 * Right Panel
		 */
		JPanel eastPanel = new JPanel();
		eastPanel.setMaximumSize(new Dimension(101, 23));
		eastPanel.setLayout(new GridLayout(2,1));


		/**
		 * Buttons
		 */

		/**
		 * TimeSlot Button
		 */
		timeSlotBookingButt = new JButton("<html>Book <br> a <br> Timeslot</html>");
		timeSlotBookingButt.setSize(101, 23);
		timeSlotBookingButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		timeSlotBookingButt.setForeground(new Color(0, 0, 255));
		timeSlotBookingButt.addActionListener(this);
		/**
		 * Registration Button
		 */
		registrationButt = new JButton("Registration");
		registrationButt.setSize(101, 23);
		registrationButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		registrationButt.setForeground(new Color(0, 0, 255));
		registrationButt.addActionListener(this);
		/**
		 * Calendar Button
		 */

		viewCalendar = new JButton("<html>View<br> Calendar");

		viewCalendar.setMinimumSize(new Dimension(101, 23));
		viewCalendar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		viewCalendar.setForeground(new Color(0, 0, 255));
		viewCalendar.setPreferredSize(new Dimension(101, 23));
		viewCalendar.addActionListener(this);

		/**
		 * Login Button
		 */
		logButt = new JButton("Login");
		logButt.setAlignmentX(Component.CENTER_ALIGNMENT);

		logButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		logButt.setForeground(new Color(0, 0, 255));
		logButt.setSize(101, 23);
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
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);

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

		if(isLogged == true)
		{
			viewCalendar.setVisible(false);
			timeSlotBookingButt.setVisible(true);
		}
		
		timeSlotBookingButt.setVisible(false);
		viewCalendar.setVisible(false);
		//add all elements to panel
		
		mainPanel  = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		frame.getContentPane().add(mainPanel);
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
		
		loginBanner.setFont(new Font("Segoe UI", Font.BOLD, 13));
		JPanel loginMiddlePanel = new JPanel();
		JPanel usrnamePanel = new JPanel();
		/**
		 * Adding Components to the Panel
		 */
		JLabel usrNameLabel = new JLabel("Username");
		usrName = new JTextField(25);
		JPanel pwdPanel = new JPanel();
		JLabel pwdLabel = new JLabel("Password");
		pwd = new JPasswordField(25);
		/**
		 * Home Button
		 */
		homeButt = new JButton("Home");//FIX
		homeButt.addActionListener(this);
		/**
		 * Login Button
		 */
		loginButt = new JButton("Login");
		loginButt.addActionListener(this);

		JPanel loginPanel = new JPanel();
		loginPanel.add(loginButt);
		loginPanel.add(homeButt);
		loginButt.setForeground(Color.BLUE);
		loginButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		homeButt.setForeground(Color.BLUE);
		homeButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		LoginBannerPanel.add(loginBanner);
		//LoginBannerPanel.add(loginButt); 
		usrnamePanel.add(usrNameLabel);
		usrnamePanel.add(usrName);
		pwdPanel.add(pwdLabel);
		pwdPanel.add(pwd);
		loginMiddlePanel.setLayout(new GridLayout(2,1));
		loginMiddlePanel.add(usrnamePanel);//to arrange inputs
		loginMiddlePanel.add(pwdPanel);
		
		loginFrame = new JPanel();
		loginFrame.setSize(500, 500);
		loginFrame.setVisible(false);
		loginFrame.setLayout(new BorderLayout(0, 0));
		loginFrame.add(LoginBannerPanel, BorderLayout.NORTH);
		loginFrame.add(loginMiddlePanel, BorderLayout.CENTER);
		loginFrame.add(loginPanel, BorderLayout.SOUTH);
		/**
		 * END OF LOGIN FRAME
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF SIGNUP FRAME
		 */
		JPanel signUpBannerPanel = new JPanel();
		JLabel signUpLabel = new JLabel("Sign-Up");
		signUpLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		signUpLabel.setForeground(Color.DARK_GRAY);
		/**
		 * Home Button
		 */
		homeButt2 = new JButton("Home");
		homeButt2.setForeground(Color.BLUE);
		homeButt2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		homeButt2.addActionListener(this);
		/**
		 * Email Field
		 */
		/**
		 * Password Field
		 */
		/**
		 * Phone Number Field
		 */
		/**
		 * Submit Button
		 */
		signupButt = new JButton("Submit");
		signupButt.setForeground(Color.BLUE);
		signupButt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		signupButt.addActionListener(this);

		signUpBannerPanel.add(signUpLabel);

		JPanel signUpInputs = new JPanel();

		signupFrame = new JPanel();
		signupFrame.setSize(500, 500);
		signupFrame.setVisible(false);
		signupFrame.setLayout(new BorderLayout(0, 0));
		signupFrame.add(signUpBannerPanel, BorderLayout.NORTH);
		signupFrame.add(signUpInputs);

		JPanel emailSignPanel = new JPanel();
		JLabel emailLabel = new JLabel("Username :    ");
		emailArea = new JTextField(25);
		emailSignPanel.add(emailLabel, BorderLayout.PAGE_START);
		emailSignPanel.add(emailArea, BorderLayout.PAGE_END);
		JPanel passwrodSignUpPanel = new JPanel();
		JLabel passwordsignUpLabel = new JLabel("Password: ");
		passwordSignUpArea = new JPasswordField(25);
		passwrodSignUpPanel.add(passwordsignUpLabel, BorderLayout.PAGE_START);
		passwrodSignUpPanel.add(passwordSignUpArea, BorderLayout.PAGE_END);
		JPanel phoneSignUpPanel = new JPanel();
		JLabel phoneLabel = new JLabel("Phone :     ");
		phoneLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		phoneTextField = new JTextField(25);
		phoneSignUpPanel.add(phoneLabel, BorderLayout.PAGE_START);
		phoneSignUpPanel.add(phoneTextField, BorderLayout.PAGE_END);
		signUpInputs.setLayout(new BoxLayout(signUpInputs, BoxLayout.Y_AXIS));
		signUpInputs.add(emailSignPanel);
		signUpInputs.add(passwrodSignUpPanel);
		signUpInputs.add(phoneSignUpPanel);
		JPanel buttnPanel = new JPanel();
		buttnPanel.add(homeButt2);
		buttnPanel.add(signupButt);
		signupFrame.add(buttnPanel, BorderLayout.PAGE_END);
		/**
		 * END OF SIGNUP FRAME
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CRUD HOME DISPLAY		
		 */
		crudFrame = new JPanel();
		@SuppressWarnings("unused")
		JButton logout = new JButton(); ///REMEMBER TO IMPLEMENT
		JLabel crudHeading = new JLabel("ADMIN");
		crudHeading.setFont(new Font("Segoe UI", Font.BOLD, 14));
		adminBooking = new JButton("Create new Booking");
		adminBooking.setForeground(Color.BLUE);
		adminBooking.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adminBooking.addActionListener(this);
		adminBookingDelete = new JButton("Delete a Booking");
		adminBookingDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adminBookingDelete.setForeground(Color.BLUE);
		adminBookingDelete.addActionListener(this);
		adminAccountCreate = new JButton("Create Account");
		adminAccountCreate.setForeground(Color.BLUE);
		adminAccountCreate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adminAccountCreate.addActionListener(this);
		adminAccountDelete = new JButton("Account Deletion");
		adminAccountDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		adminAccountDelete.setForeground(Color.BLUE);
		adminAccountDelete.addActionListener(this);
		//seat1InUse = new JRadioButton();//need to look up how to getinput frm these
		//seat2InUse = new JRadioButton();//??
		//seat3InUse = new JRadioButton();//??
		JPanel adminHeadingPanel = new JPanel();
		adminHeadingPanel.add(crudHeading);
		JPanel adminButtonsPanel = new JPanel();
		//JPanel adminSeats = new JPanel();
		//adminSeats.add(seat1InUse);
		//adminSeats.add(seat2InUse);
		//adminSeats.add(seat3InUse);	
		crudPanel = new JPanel();
		crudFrame.setLayout(new BorderLayout(0, 0));


		crudPanel.add(adminHeadingPanel, BorderLayout.NORTH);
		crudPanel.add(adminButtonsPanel, BorderLayout.CENTER);
		GroupLayout gl_adminButtonsPanel = new GroupLayout(adminButtonsPanel);
		gl_adminButtonsPanel.setHorizontalGroup(
			gl_adminButtonsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminButtonsPanel.createSequentialGroup()
					.addGap(161)
					.addGroup(gl_adminButtonsPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(adminAccountDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(adminBookingDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(adminBooking, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(adminAccountCreate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_adminButtonsPanel.setVerticalGroup(
			gl_adminButtonsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminButtonsPanel.createSequentialGroup()
					.addComponent(adminBooking)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(adminBookingDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(adminAccountCreate)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(adminAccountDelete)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		adminButtonsPanel.setLayout(gl_adminButtonsPanel);
		//crudPanel.add(adminSeats, BorderLayout.PAGE_END);
		crudFrame.add(crudPanel);

		/**
		 * END OF CRUD HOME DISPLAY
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE ACCOUNT ADMIN PANEL	
		 */
		
		adminCreateAccountPanel = new JPanel();
		JLabel adminAccCreationEmailLabel = new JLabel("UserName :");
		/**
		 * Email text area
		 */
		adminAccCreateEmail = new JTextField();//
		adminAccCreateEmail.setBackground(Color.WHITE);
		adminAccCreationEmailLabel.setLabelFor(adminAccCreateEmail);
		
		JLabel adminAccCreatePhone = new JLabel("Phone :");
		/**
		 * phone text area
		 */
		adminCreatePhone = new JTextField();//
		adminCreatePhone.setBackground(Color.WHITE);
		adminAccCreatePhone.setLabelFor(adminCreatePhone);
		
		/**
		 * password text area
		 */
		JLabel adminAccCreatePass = new JLabel("Password :");
		
		/**
		 * Submit button
		 */
		createAccountSubmitButton = new JButton("Submit");
		createAccountSubmitButton.setForeground(Color.BLUE);
		createAccountSubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		createAccountSubmitButton.addActionListener(this);
		
		adminAccCreatePassTextArea = new JPasswordField();
		adminAccCreatePassTextArea.setBackground(Color.WHITE);
		adminAccCreatePassTextArea.setColumns(10);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		GroupLayout gl_adminCreateAccountPanel = new GroupLayout(adminCreateAccountPanel);
		gl_adminCreateAccountPanel.setHorizontalGroup(
			gl_adminCreateAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
					.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(adminAccCreatePass)
								.addComponent(adminAccCreationEmailLabel)
								.addComponent(adminAccCreatePhone))
							.addGap(18)
							.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(adminAccCreateEmail, Alignment.LEADING)
								.addComponent(adminAccCreatePassTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addComponent(adminCreatePhone, Alignment.LEADING)))
						.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
							.addGap(175)
							.addComponent(lblCreateAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(52))
						.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
							.addGap(115)
							.addComponent(btnNewButton)
							.addGap(73)
							.addComponent(createAccountSubmitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(130))
		);
		gl_adminCreateAccountPanel.setVerticalGroup(
			gl_adminCreateAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateAccount)
					.addGap(53)
					.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminAccCreateEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminAccCreationEmailLabel))
					.addGap(52)
					.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminCreatePhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminAccCreatePhone))
					.addGap(53)
					.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminAccCreatePass)
						.addComponent(adminAccCreatePassTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_adminCreateAccountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(createAccountSubmitButton))
					.addGap(27))
		);
		adminCreateAccountPanel.setLayout(gl_adminCreateAccountPanel);
		/**
		 * END OF CREATE ACCOUNT ADMIN PANEL
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF ACCOUNT DELETION ADMIN PANEL
		 */
		adminAccDeletionPanel = new JPanel();
		
		JLabel accDeletionEmail = new JLabel("Username :");
		/**
		 * ACCOUNT DELETION TEXTAREA
		 */
		accDeletionEmailArea = new JTextField();
		/**
		 * SUBMIT BUTTON
		 */
		deletionSubmit = new JButton("Submit");
		deletionSubmit.addActionListener(this);
		deletionSubmit.setForeground(Color.BLUE);
		deletionSubmit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		AdminDeletionHomeButton = new JButton("Home");
		AdminDeletionHomeButton.addActionListener(this);
		AdminDeletionHomeButton.setForeground(Color.BLUE);
		AdminDeletionHomeButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		GroupLayout gl_adminAccDeletionPanel = new GroupLayout(adminAccDeletionPanel);
		gl_adminAccDeletionPanel.setHorizontalGroup(
			gl_adminAccDeletionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_adminAccDeletionPanel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(accDeletionEmail)
					.addGap(18)
					.addComponent(accDeletionEmailArea, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(Alignment.LEADING, gl_adminAccDeletionPanel.createSequentialGroup()
					.addGap(109)
					.addComponent(AdminDeletionHomeButton)
					.addGap(85)
					.addComponent(deletionSubmit)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_adminAccDeletionPanel.setVerticalGroup(
			gl_adminAccDeletionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminAccDeletionPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_adminAccDeletionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(accDeletionEmailArea, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(accDeletionEmail))
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addGroup(gl_adminAccDeletionPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(AdminDeletionHomeButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(deletionSubmit))
					.addGap(40))
		);
		adminAccDeletionPanel.setLayout(gl_adminAccDeletionPanel);
		/**
		 * END OF ACCOUNT DELTION PANEL
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE A BOOKING ADMIN PANEL
		 */
		adminBookingCreationPanel = new JPanel();
		JLabel adminLabelDay = new JLabel("Day :");
		adminLabelDay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		/*
		 * DATES HERE
		 */
		adminDatesDropDown = new JComboBox<String>();
		adminDatesDropDown.addItem("Monday");
		adminDatesDropDown.addItem("Tuesday");
		adminDatesDropDown.addItem("Wednesday");
		adminDatesDropDown.addItem("Thurday");
		adminDatesDropDown.addItem("Friday");
		adminDatesDropDown.addItem("Saturday");
		adminDatesDropDown.addItem("Sunday");
		JLabel adminLabelTimes = new JLabel("Time :");
		adminLabelTimes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		/*
		 * TIMES HERE
		 */
		adminTimesDropDown = new JComboBox<String>();
		adminTimesDropDown.addItem("9.00");
		adminTimesDropDown.addItem("10.00");
		adminTimesDropDown.addItem("11.00");
		adminTimesDropDown.addItem("12.00");
		adminTimesDropDown.addItem("13.00");
		adminTimesDropDown.addItem("14.00");
		adminTimesDropDown.addItem("15.00");
		adminTimesDropDown.addItem("16.00");
		adminTimesDropDown.addItem("17.00");
		adminTimesDropDown.addItem("18.00");
		adminBookingCreationSubmit = new JButton("Submit");
		adminBookingCreationSubmit.setForeground(Color.BLUE);
		adminBookingCreationSubmit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		adminBookingCreationSubmit.addActionListener(this);
		
		adminBookingCreationHomeButton = new JButton("Home");
		adminBookingCreationHomeButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		adminBookingCreationHomeButton.setForeground(Color.BLUE);
		adminBookingCreationHomeButton.addActionListener(this);
	
		GroupLayout gl_adminBookingCreationPanel = new GroupLayout(adminBookingCreationPanel);
		gl_adminBookingCreationPanel.setHorizontalGroup(
			gl_adminBookingCreationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminBookingCreationPanel.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_adminBookingCreationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_adminBookingCreationPanel.createSequentialGroup()
							.addComponent(adminLabelDay, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_adminBookingCreationPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_adminBookingCreationPanel.createSequentialGroup()
									.addComponent(adminTimesDropDown, 0, 204, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(adminDatesDropDown, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
							.addGap(52))
						.addComponent(adminLabelTimes, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.TRAILING, gl_adminBookingCreationPanel.createSequentialGroup()
					.addGap(66)
					.addComponent(adminBookingCreationSubmit, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(adminBookingCreationHomeButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_adminBookingCreationPanel.setVerticalGroup(
			gl_adminBookingCreationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminBookingCreationPanel.createSequentialGroup()
					.addGroup(gl_adminBookingCreationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminLabelDay, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminDatesDropDown, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_adminBookingCreationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminLabelTimes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminTimesDropDown, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_adminBookingCreationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminBookingCreationSubmit, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminBookingCreationHomeButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(44))
		);
		adminBookingCreationPanel.setLayout(gl_adminBookingCreationPanel);

		/**
		 * END OF CREATE BOOKING ADMIN PANEL
		 */
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * booking deletion admin Panel
		 */
		
		
		String cats = new String("cats");
		adminBookingDeletionPanel = new JPanel();
		JLabel adminLabelDayDEletion = new JLabel("Day :");
		adminLabelDayDEletion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		/*
		 * DATES HERE
		 */

		//adminDatesDropDownDeletion = new JComboBox<String>(new String[]{"Monday","Tuesday","Wednesday","Thursday", "Friday", "Saturday", "Sunday"});
		adminDatesDropDownDeletion = new JComboBox<String>();
		adminDatesDropDownDeletion.addItem("Monday");
		adminDatesDropDownDeletion.addItem("Tuesday");
		adminDatesDropDownDeletion.addItem("Wednesday");
		adminDatesDropDownDeletion.addItem("Thursday");
		adminDatesDropDownDeletion.addItem("Friday");
		adminDatesDropDownDeletion.addItem("Saturday");
		adminDatesDropDownDeletion.addItem("Sunday");
		
		JLabel adminLabelTimesDeletion = new JLabel("Times :");
		adminLabelTimesDeletion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		/*
		 * TIMES HERE
		 */
		//adminTimesDropDownDeletion = new JComboBox<String> (new String[] {"9.00","10.00","11.00","12.00","13.00","14.00","15.00","16.00","17.00","18.00"});
		adminTimesDropDownDeletion = new JComboBox<String>();
		adminTimesDropDownDeletion.addItem("9.00");
		adminTimesDropDownDeletion.addItem("10.00");
		adminTimesDropDownDeletion.addItem("11.00");
		adminTimesDropDownDeletion.addItem("12.00");
		adminTimesDropDownDeletion.addItem("13.00");
		adminTimesDropDownDeletion.addItem("14.00");
		adminTimesDropDownDeletion.addItem("15.00");
		adminTimesDropDownDeletion.addItem("16.00");
		adminTimesDropDownDeletion.addItem("17.00");
		adminTimesDropDownDeletion.addItem("18.00");
		
		adminBookingDeletionSubmit = new JButton("Submit");
		adminBookingDeletionSubmit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		adminBookingDeletionSubmit.setForeground(Color.BLUE);
		adminBookingDeletionSubmit.addActionListener(this);
		
		AdminBookingDeletionHome = new JButton("Home");
		AdminBookingDeletionHome.setForeground(Color.BLUE);
		AdminBookingDeletionHome.setFont(new Font("Segoe UI", Font.BOLD, 13));
		AdminBookingDeletionHome.addActionListener(this);
		GroupLayout gl_adminBookingDeletionPanel = new GroupLayout(adminBookingDeletionPanel);
		gl_adminBookingDeletionPanel.setHorizontalGroup(
			gl_adminBookingDeletionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminBookingDeletionPanel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addGroup(gl_adminBookingDeletionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_adminBookingDeletionPanel.createSequentialGroup()
							.addComponent(adminLabelDayDEletion, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(36))
						.addGroup(gl_adminBookingDeletionPanel.createSequentialGroup()
							.addComponent(adminLabelTimesDeletion, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(51)))
					.addGroup(gl_adminBookingDeletionPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(adminTimesDropDownDeletion, 0, 175, Short.MAX_VALUE)
						.addComponent(adminDatesDropDownDeletion, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addGap(92))
				.addGroup(gl_adminBookingDeletionPanel.createSequentialGroup()
					.addGap(52)
					.addComponent(adminBookingDeletionSubmit, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(AdminBookingDeletionHome, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_adminBookingDeletionPanel.setVerticalGroup(
			gl_adminBookingDeletionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adminBookingDeletionPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_adminBookingDeletionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminDatesDropDownDeletion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminLabelDayDEletion, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_adminBookingDeletionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminTimesDropDownDeletion, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminLabelTimesDeletion, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_adminBookingDeletionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AdminBookingDeletionHome, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminBookingDeletionSubmit, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		adminBookingDeletionPanel.setLayout(gl_adminBookingDeletionPanel);
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
	/**
	 * ActionListeners for the Buttons
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * Get source of ActionListener
		 */
		Object source = e.getSource();
		/**
		 * TimeSlot Panel Button Action
		 */
		if(source==timeSlotBookingButt){
			//System.out.println("Test booking button");
			
			frame.remove(mainPanel);
			frame.add(adminBookingCreationPanel);
			frame.revalidate(); 
			frame.repaint(); 
			adminBookingCreationPanel.setVisible(true);
		}
		/**
		 * Registration Panel Button Action
		 */
		if(source == registrationButt){
			//System.out.println("Test registration button");
			/**
			 * Changes the visible frame
			 */
			frame.remove(mainPanel);
			frame.add(signupFrame);
			signupFrame.setVisible(true);
		}
		/**
		 * Login Panel Button Action
		 */
		if(source == logButt){
			/**
			 * Changes the visible frame
			 */
			frame.remove(mainPanel);
			frame.add(loginFrame);
			frame.revalidate(); 
			frame.repaint(); 
			loginFrame.setVisible(true);
			
		}
		/**
		 * Calendar Panel Button Action
		 */
		if(source == viewCalendar){
			/**
			 * Change the visible frame
			 */
			frame.remove(mainPanel);
			frame.add(loginFrame);
			frame.revalidate(); 
			frame.repaint(); 
			loginFrame.setVisible(true);
		}
		/**
		 * Login Button Action
		 */
		if(source == loginButt){
			/**
			 * Calls the DBConnection LogIn and passes the variables
			 */

			System.out.println("Login: " + usrName.getText() + ", Password: " + new String(pwd.getPassword()));
			user = DBConnection.logIn(usrName.getText(), new String(pwd.getPassword()));
			
			if(user != null) 
			{
				isAdmin = DBConnection.isAdmin(user);
				System.out.println("Login userID: " + user.getUserID());
				DBConnection.setUser(user);
				if(isAdmin == false)
				{
					frame.remove(loginFrame);
					frame.add(mainPanel);
					repaint();
					revalidate();
					isLogged = true;
					timeSlotBookingButt.setVisible(true);
					usrName.setText("");
					pwd.setText("");
				}
				else if(isAdmin ==true)
				{		
						frame.remove(loginFrame);
						frame.add(crudFrame);
						repaint();
						revalidate();
						isLogged = true;
						usrName.setText("");
						pwd.setText("");
				}
			}
			else
			{
				usrName.setText("");
				pwd.setText("");
			}


			/**
			 * If it is an Admin it Auto goes to Admin Panel
			 */
			

		}
		/**
		 * Home Button Action
		 */
		if(source == homeButt)
		{
			System.out.println("Home button from Login");
			frame.remove(loginFrame);
			frame.add(mainPanel);
			frame.revalidate();
			frame.repaint();
			
		}
		
		if(source == homeButt2)
		{
			System.out.println("Somewhere to home");
			frame.remove(signupFrame);
			frame.add(mainPanel);
			frame.revalidate();
			frame.repaint();
		}
		if(source == homeButt1){
			
			/**
			 * Change the visible frame
			 */
			System.out.println("Home Button Used");
			
			frame.remove(signupFrame);
			frame.add(mainPanel);
			frame.revalidate(); 
			frame.repaint(); 
			mainPanel.setVisible(true);
			
		}
		
		if(source == homeButtonAdminCreateAcc)
		{
			System.out.println("adminCreate home butt");
			crudFrame.remove(adminCreateAccountPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint();
			
		}
		
		if(source == AdminDeletionHomeButton)
		{
			System.out.println("admin Delete Button home");
			crudFrame.remove(adminAccDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint();
			
		}
		
		if(source == AdminBookingDeletionHome)
		{
			System.out.println("admin book delete home");
			crudFrame.remove(adminBookingDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint();
		}
		
		if(source == adminBookingCreationHomeButton)
		{
			if (isAdmin == true)
			{
				System.out.println("admin book create home");
				crudFrame.remove(adminBookingCreationPanel);
				crudFrame.add(crudPanel);
				crudFrame.revalidate();
				crudFrame.repaint();
				//crudFrame.setVisible(true);
			}
			else
			{
				System.out.println("WHY ARE YOU RUNNING");
				frame.remove(adminBookingCreationPanel);
				frame.add(mainPanel);
				frame.revalidate();
				frame.repaint();
			}
		}
		
		if(source == btnNewButton)
		{
			System.out.println("admin create account panel");
			crudFrame.remove(adminCreateAccountPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate();
			crudFrame.repaint();
			
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
			
			isLogged = true;
			timeSlotBookingButt.setVisible(true);
			
			
			frame.remove(signupFrame);
			frame.add(mainPanel);
			frame.revalidate(); 
			frame.repaint(); 
			mainPanel.setVisible(true);
			
		}
		if(source == adminBookingCreationSubmit){
			/**
			 * SUBMIT BUTTON ON BOOKING PAGE
			 */


			Booking booking = new Booking(new String((String) adminTimesDropDown.getSelectedItem()) ,new String((String) adminDatesDropDown.getSelectedItem()));
			DBConnection.insertBooking(booking, user);
			System.out.println("Booking for " + (String)adminTimesDropDown.getSelectedItem() + " on " + (String)adminDatesDropDown.getSelectedItem());
			//frame.setVisible(true);


		}
		/**
		 * admin make booking
		 */
		if(source == adminBooking){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminBookingCreationPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 


		}
		/**
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


		}
		/**
		 * admin delete booking panel
		 */
		if(source == adminBookingDelete){

			crudFrame.remove(crudPanel);
			crudFrame.add(adminBookingDeletionPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			//System.out.println("TEST ADMIN BOOKIN DELETE PAGE BUTTON");
		}
		/**
		 * admin booking delete submit button
		 */
		if(source == adminBookingDeletionSubmit){

			System.out.println("TEST ADMIN BOOKING DELETE SUBMIT BUTTON");
			Booking booking = new Booking(new String((String) adminTimesDropDownDeletion.getSelectedItem()) ,new String((String) adminDatesDropDownDeletion.getSelectedItem()));
			DBConnection.deleteBooking(booking);

			crudFrame.remove(adminBookingDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			
		}
		/**
		 * admin account create account
		 */
		if(source == adminAccountCreate){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminCreateAccountPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			//System.out.println("TEST ADMIN CREATE ACCOUNT PAGE");
		}
		/**
		 * admin account creation submit button
		 */
		if(source == createAccountSubmitButton){


			System.out.println("Create Account: " + adminAccCreateEmail.getText() + ", Password: " + new String(adminAccCreatePassTextArea.getPassword()) + ", Phone Number: " + adminCreatePhone.getText());
			User user = new User(adminAccCreateEmail.getText(), new String(adminAccCreatePassTextArea.getPassword()), adminCreatePhone.getText());
			DBConnection.setUser(user);
			DBConnection.insertUser(user);

			crudFrame.remove(adminCreateAccountPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			//System.out.println("TEST ADMIN CREATE ACCOUNT SUBMIT BUTTON");
		}
		/**
		 * admin delete account panel
		 */
		if(source == adminAccountDelete){
			crudFrame.remove(crudPanel);
			crudFrame.add(adminAccDeletionPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			//System.out.println("TEST ADMIN ACCOUNT DELETION PAGE BUTTON");
		}
		/**
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

