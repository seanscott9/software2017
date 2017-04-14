package db;
/**
 * Ace Venturas Detective Agency
 * @author B00076316 Liam Walsh & B00091655 SeÃ¡n Scott
 *
 */
public class User {
	/**
	 * Sets up Varibles
	 */
	private int userID;
	private String email;
	private String password;
	private String phoneNum;
	private boolean checkedIn;
	

	public User(String email, String password, String phoneNum) {
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
	}
	
	public User(int userID, String email, String phoneNum) {
		this.userID = userID;
		this.email = email;
		this.phoneNum = phoneNum;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String email) {
		this.email = email;
		
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
	 * @return userID
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
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}



