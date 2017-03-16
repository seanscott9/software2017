package db;
/**
 * Ace Venturas Detective Agency
 * @author B00076316 Liam Walsh & B00091655 Seán Scott
 *
 */
public class User {
	private int userID;
	private String email;
	private String password;
	private String phoneNum;
	private boolean checkedIn;
	

	
	/**
	 * Constructs a booking with all information
	 * @param bookingID Booking ID
	 * @param roomID Room ID
	 * @param startDate Start date
	 * @param endDate End date
	 * @param userID User ID
	 * @param checkedIn Is checked in
	 */
	public User(int userID, String email, String phoneNum) {
		this.userID = userID;
		this.email = email;
		this.phoneNum = phoneNum;
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

	
	public int getUserID() {
		return userID;
	}

	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	
	public String getEmail() {
		return email;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the startDate
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the endDate
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}

