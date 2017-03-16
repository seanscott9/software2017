package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JOptionPane;


/**
 * Ace Venturas Detective Agency
 * @author B00076316 Liam Walsh & B00091655 Seán Scott
 *  
 */
public class DBConnection {
	
	public static Connection connection;
	public static Booking booking;
	public static User user;
	
	
	public static Booking getBooking() {
		return booking;
	}
	
	
	public static void setBooking(Booking booking) {
		DBConnection.booking = booking;
	}
	
	
	public static User getUser() {
		return user;
	}

	
	public static void setUser(User user) {
		DBConnection.user = user;
	}

	
	/**
	 * Establishes connection with database
	 */
	private static void getConnection() {
		try{
			//Register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Get a connection to the database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/barber","root", "root");
			System.out.println("Database connection successful.");
		}
		catch(Exception e){
			// something went wrong with DB connection
			System.out.println("Database Connection Error!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes connection with database
	 */
	private static void closeConnection(){
		if (connection != null){
			try{
				connection.close();
				System.out.println("Database closed successfully.");
			}
			catch(Exception e){
				System.out.println("Error closing the DB");
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static User logIn(String email, String password) {
		User user = null;
		getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "';";
			System.out.println("[SQL QUERY] " + query);
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				System.out.println("User record found");
				System.out.println("ID: " + resultSet.getInt("userid"));
				user = new User(resultSet.getInt("userID"), resultSet.getString("email"), resultSet.getString("phoneNum"));
				DBConnection.setUser(user);
				System.out.println("Hello " + user.getEmail() + " Welcome to Ace Ventura's Barber Shop!");
			}
			else {
				System.out.println("User email or password incorrect");
				JOptionPane.showMessageDialog(null, "Incorrect email or password", "Login failed", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e){
			System.out.println("Error executing SELECT statement");
			e.printStackTrace();
		}		
		closeConnection();
		return user;
	}
	
	public static boolean isAdmin(User user) {
		boolean isAdmin = false;
		
		getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM admin WHERE email='" + user.getEmail() + "';";
			System.out.println("[SQL QUERY] " + query);
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				System.out.println("User is admin");
				System.out.println("Hello " + user.getEmail() + " you now have access to the admin Panel!");
				isAdmin = true;
			}
			else {
				System.out.println("User email or password incorrect");
				JOptionPane.showMessageDialog(null, "Doesn't look like you should be here.", "Login failed", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e){
			System.out.println("Error executing SELECT statement");
			e.printStackTrace();
		}		
		closeConnection();
		return isAdmin;
	}



	public static void insertUser(User user) {
		getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO user(email, password, phoneNum) VALUES (";
			query = query + "'" + user.getEmail() + "','" + user.getPassword() + user.getPhoneNum() + "');";
			System.out.println("[SQL QUERY] " + query);
			statement.executeUpdate(query);
			System.out.println("User added");
		}
		catch(Exception e){
			System.out.println("Error executing INSERT statement");
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public static void deleteUser(User user){
		getConnection();
		try{
			// Create a statement object
			Statement statement = connection.createStatement();
			//Execute a Query
			String query = "DELETE FROM user WHERE userID ='" + user.getUserID() + "';";
			System.out.println("[SQL QUERY] " + query);
			statement.executeUpdate(query);
			statement.close();
			System.out.println("User successfully deleted.");
		}
		catch(Exception e){
			System.out.println("Error executing DELETE statemennt");
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public static void insertBooking(Booking booking, User user) {
		
			getConnection();
			try {
				Statement statement = connection.createStatement();
				String query = "INSERT INTO booking(email, time, date ,userid) VALUES (";
				query = query + "'" + booking.getEmail() + "','" + booking.getTime() + "','"  + "','" + user.getUserID() + "');";
				System.out.println("[SQL QUERY] " + query);
				statement.executeUpdate(query);
				System.out.println("Booking saved");
			}
			catch(Exception e){
				System.out.println("Error executing INSERT statement");
				e.printStackTrace();
			}
			closeConnection();
		}
	
	public static void deleteBooking(Booking booking, User user){
		getConnection();
		try{
			// Create a statement object
			Statement statement = connection.createStatement();
			//Execute a Query
			String query = "DELETE FROM booking WHERE email ='" + user.getEmail() + "';";
			System.out.println("[SQL QUERY] " + query);
			statement.executeUpdate(query);
			statement.close();
			System.out.println("Booking successfully deleted.");
		}
		catch(Exception e){
			System.out.println("Error executing DELETE statemennt");
			e.printStackTrace();
		}
		closeConnection();
	}
}
