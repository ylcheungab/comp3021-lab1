package base;

import java.util.Date;

public class FriendsPost extends Post {
	private User friend;
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 * @param user
	 */
	public FriendsPost(Date date, String content, User user){
		super(date, content);
		friend = user;
	}

	/**
	 * friend getter
	 * @return
	 */
	public User getFriend() {
		return friend;
	}

	/**
	 * friend setter
	 * @param friend
	 */
	public void setFriend(User friend) {
		this.friend = friend;
	}






}