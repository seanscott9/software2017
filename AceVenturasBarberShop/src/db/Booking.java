package db;
/**
 * Ace Venturas Detective Agency
 * @author B00076316 Liam Walsh & B00091655 Seán Scott
 *
 */
public class Booking {
	private int bookingID;
	private String email;
	private String time;
	private String date;
	private int userID;
	private boolean checkedIn;
	
	
	public Booking(String time, String date) {
		this.time = time;
		this.date = date;
	}
	
	
	public Booking(int bookingID, String email, String time, String date, int userID) {
		this.bookingID = bookingID;
		this.email = email;
		this.date = date;
		this.time = time;
		this.userID = userID;
	}
	
	/**
	 * @return the checkedIn
	 */
	public boolean isCheckedIn() {
		return checkedIn;
	}

	/**
	 * @param checkedIn the checkedIn to set
	 */
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	
	public int getBookingID() {
		return bookingID;
	}

	
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getDate() {
		return date;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getTime() {
		return time;
	}

	
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
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
