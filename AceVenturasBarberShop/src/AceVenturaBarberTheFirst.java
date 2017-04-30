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
	JPanel loginMainPanel;
	JTextField pwd;
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
		homeButt = new JButton("Home");
		homeButt.addActionListener(this);
		/**
		 * Login Button
		 */
		loginButt = new JButton("Login");
		loginButt.addActionListener(this);

		JPanel loginPanel = new JPanel();
		loginPanel.add(loginButt);
		loginPanel.add(homeButt);

		LoginBannerPanel.add(loginBanner);
		LoginBannerPanel.add(loginButt); 
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
		//homeButt2.addActionListener(this);
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
		//signupButt.addActionListener(this);

		signUpBannerPanel.add(signUpLabel);

		JPanel signUpInputs = new JPanel();

		signupFrame = new JPanel();
		signupFrame.setSize(500, 500);
		signupFrame.setVisible(false);
		signupFrame.setLayout(new BorderLayout(0, 0));
		signupFrame.add(signUpBannerPanel, BorderLayout.NORTH);
		signupFrame.add(signUpInputs);

		JPanel emailSignPanel = new JPanel();
		JLabel emailLabel = new JLabel("E-Mail :      ");
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


		crudFrame.add(adminHeadingPanel, BorderLayout.NORTH);
		crudFrame.add(adminButtonsPanel, BorderLayout.CENTER);
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
		//crudFrame.add(crudPanel);

		/**
		 * END OF CRUD HOME DISPLAY
		 */
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * START OF CREATE ACCOUNT ADMIN PANEL	
		 */
		adminCreateAccountPanel = new JPanel();
		JLabel adminAccCreationEmailLabel = new JLabel("Email :");
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
		
		adminAccCreatePassTextArea = new JPasswordField();
		adminAccCreatePassTextArea.setBackground(Color.WHITE);
		adminAccCreatePassTextArea.setColumns(10);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 13));
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
							.addGap(190)
							.addComponent(createAccountSubmitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(47))
						.addGroup(gl_adminCreateAccountPanel.createSequentialGroup()
							.addGap(175)
							.addComponent(lblCreateAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(52)))
					.addGap(148))
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
					.addComponent(createAccountSubmitButton)
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
			frame.setVisible(false);
			loginFrame.setVisible(true);
		}
		/**
		 * Registration Panel Button Action
		 */
		if(source == registrationButt){
			//System.out.println("Test registration button");
			/**
			 * Changes the visible frame
			 */
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
			 * Calls the DBConnection LogIn and passes the variables
			 */

			System.out.println("Login: " + usrName.getText() + ", Password: " + pwd.getText());
			user = DBConnection.logIn(usrName.getText(), pwd.getText());
			boolean isAdmin = DBConnection.isAdmin(user);
			if(user != null && isAdmin == false) 
			{
				System.out.println("Login userID: " + user.getUserID());
				DBConnection.setUser(user);
				frame.add(loginFrame);
				repaint();
				revalidate();
				isLogged = true;


			}


			/**
			 * If it is an Admin it Auto goes to Admin Panel
			 */
			if(user != null && isAdmin == true)
			{
				frame.add(loginFrame);
				repaint();
				revalidate();
				isLogged = true;
			}

		}
		/**
		 * Home Button Action
		 */
		if(source == homeButt1){
			/**
			 * Change the visible frame
			 */
			System.out.println("Home Button Used");
			calFrame.setVisible(false);
			signupFrame.setVisible(false);
			loginFrame.setVisible(false);
			frame.setVisible(true);
		}
		/**
		 * Home Button Action
		 */
		if(source == homeButt){
			/**
			 * Change the visible frame
			 */
			System.out.println("Home Button Used");
			calFrame.setVisible(false);
			signupFrame.setVisible(false);
			loginFrame.setVisible(false);
			frame.setVisible(true);
		}
		/**
		 * Home Button Action
		 */
		if(source == homeButt2){
			/**
			 * Change the visible frame
			 */
			System.out.println("Home Button Used");
			calFrame.setVisible(false);
			signupFrame.setVisible(false);
			loginFrame.setVisible(false);
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

			Booking booking = new Booking(new String((String) adminTimesDropDownDeletion.getSelectedItem()) ,new String((String) adminDatesDropDownDeletion.getSelectedItem()));
			DBConnection.deleteBooking(booking, user);

			crudFrame.remove(adminBookingDeletionPanel);
			crudFrame.add(crudPanel);
			crudFrame.revalidate(); 
			crudFrame.repaint(); 

			//System.out.println("TEST ADMIN BOOKING DELETE SUBMIT BUTTON");
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

