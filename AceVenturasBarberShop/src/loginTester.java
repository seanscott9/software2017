import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.DBConnection;
import db.User;
	public class loginTester extends JFrame implements ActionListener{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	Boolean isAdmin = false;
		Boolean isLogged = false;
		User user;
		
		
		JFrame loginFrame;
		JPanel loginMainPanel;
		JTextField pwd;
		JTextField usrName;
		JButton loginButt;
		
		
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
		
		
		public loginTester(){
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
			loginFrame.setVisible(true);
			loginFrame.setSize(500,500);
		
		///////////////////////////////////////////////////////////////
			
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
			//seat1InUse = new JRadioButton();//need to look up how to getinput frm these
			//seat2InUse = new JRadioButton();//??
			//seat3InUse = new JRadioButton();//??
			JPanel adminHeadingPanel = new JPanel();
			adminHeadingPanel.add(crudHeading);
			JPanel adminButtonsPanel = new JPanel();
			adminButtonsPanel.setLayout(new BoxLayout(adminButtonsPanel, BoxLayout.PAGE_AXIS));
			adminButtonsPanel.add(adminBooking);
			adminButtonsPanel.add(adminBookingDelete);
			adminButtonsPanel.add(adminAccountCreate);
			adminButtonsPanel.add(adminAccountDelete);
			JPanel adminSeats = new JPanel();
			//adminSeats.add(seat1InUse);
			//adminSeats.add(seat2InUse);
			//adminSeats.add(seat3InUse);	
			crudPanel = new JPanel();


			crudPanel.add(adminHeadingPanel, BorderLayout.PAGE_START);
			crudPanel.add(adminButtonsPanel, BorderLayout.CENTER);
			crudPanel.add(adminSeats, BorderLayout.PAGE_END);
			crudFrame.add(crudPanel);
		
		}

		public static void main(String[] args) {
			loginTester loginFrame = new loginTester();	
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
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
						System.out.println("WINNER");
						//frame.setVisible(true);
						loginFrame.setVisible(false);
						isLogged = true;
						//viewCalendar.setVisible(true);
						
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
			
		}
		
}
