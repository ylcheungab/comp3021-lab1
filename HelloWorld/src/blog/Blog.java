package blog;

import java.util.ArrayList;
import java.util.Calendar;

import base.*;

/**
 * @author YatLaam
 *
 */
public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog (User user){
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	/**
	 * user getter
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * user setter
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * allPost getter
	 * @return
	 */
	public ArrayList<Post> getAllPosts() {
		return allPosts;
	}
	
	/**
	 * allPost setter
	 * @param allPosts
	 */
	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	
	/**
	 * to creates new post for the blog
	 * @param post
	 */
	public void post(Post p){
		if(this.allPosts.add(p)){
			System.out.println("A new post");
			System.out.println("At: " + p.getDate());
			System.out.println(p.getContent());
		}
		else
			System.out.println("Adding post failure.");
	}

	/**
	 * list all posts in the blog
	 */
	public void list(){
		if(!allPosts.isEmpty()){
			for (int i = 0; i < allPosts.size(); i++){
				System.out.println("Post [" + i + "]: " + allPosts.get(i).toString());
			}
		}else{
			System.out.println("There has no posts here.");
		}
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		if( index < 0 || index >= this.allPosts.size())
			System.out.println("Invalid index.");
		else{
			System.out.println("Post " + allPosts.get(index).getContent() + " deleted.");
			this.allPosts.remove(index);
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return user + "'s allPosts:" + allPosts;
	}
	
	public void search(int month, String someone){
		
		Calendar cal = Calendar.getInstance();
		//search from all posts
		for (Post p : allPosts){
			//get the current post's month
			//(note that Calendar.Month starts with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if (postMonth == month - 1 && p.getContent().contains(someone))
				System.out.println(p.toString());
		}
	}

}
