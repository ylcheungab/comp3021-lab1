package base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
	private int ID;
	private String user;
	private String email;
	
	/**
	 * Constructor
	 * @param ID
	 * @param user
	 * @param email
	 */
	public User (int ID, String user, String email){
		this.ID = ID;
		this.user = user;
		this.email = email;
	}

	/**
	 * ID getter
	 * @return
	 */
	public int getID() {
		return ID;
	}
	/**
	 * ID setter
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * User getter
	 * @return
	 */
	public String getUser() {
		return user;
	}
	/**
	 * User setter
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Email getter
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Email setter
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Comparing this.ID and u.ID
	 */
	@Override
	public int compareTo(User u){
		if (this.ID > u.ID)
			return 1;
		else if (this.ID < u.ID)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", user=" + user + ", email=" + email + "]";
	}
}
