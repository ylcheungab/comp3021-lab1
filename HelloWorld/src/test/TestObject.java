package test;

import java.util.Date;

import base.User;
import base.FriendsPost;
import base.Post;

public class TestObject {
	
	public static void main(String[] args){
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Date date = new Date();
		String content = "This is my first post.";
		FriendsPost postfromfriend = new FriendsPost(date, content, user);
		System.out.println(postfromfriend);
		
		System.out.println(postfromfriend.contains("first"));
		System.out.println(postfromfriend.contains("HKUST"));

	}
	
}
