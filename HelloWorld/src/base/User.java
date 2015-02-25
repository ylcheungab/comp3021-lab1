package base;

public class User {
	private int ID;
	private String user;
	private String email;
	
	public User (int ID, String user, String email){
		this.ID = ID;
		this.user = user;
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
