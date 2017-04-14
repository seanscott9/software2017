package db;
/**
 * Ace Ventura's Detective Agency
 * @author B00076316 Liam Walsh & B00091655 SeÃ¡n Scott
 *
 */
public class Booking {
	/**
	 * Booking Varibles
	 */
	private int bookingID;
	private String email;
	private String time;
	private String date;
	private int userID;
	private boolean checkedIn;
	
	/**
	 * Booking setting for Bookings
	 */
	public Booking(String time, String date) {
		this.time = time;
		this.date = date;
	}
	
	/**
	 * Booking setting for Bookings
	 */
	public Booking(int bookingID, String email, String time, String date, int userID) {
		this.bookingID = bookingID;
		this.email = email;
		this.date = date;
		this.time = time;
		this.userID = userID;
	}
	
	/**
	 * @return checkedIn
	 */
	public boolean isCheckedIn() {
		return checkedIn;
	}

	/**
	 * @param checkedIn set
	 */
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	/**
	 * @return bookingID
	 */
	public int getBookingID() {
		return bookingID;
	}

	/** 
	 * @param bookingID set
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}

