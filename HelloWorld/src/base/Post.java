package base;

import java.util.Date;

public class Post {
	/**
	 * param, constructer
	 */
	private Date pdate;
	private String pcontent;
	
	public Post(Date date, String content){
		pdate = date;
		pcontent = content;
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public String getContent(){
		return pcontent;
	}
	
	public void setContent(String content){
		pcontent = content;
	}
	
	/**
	 * add info to content
	 */
	public String toString(){
		return pdate + " " + this;
	}
	
	/**
	 * check equality of two object
	 */
	public boolean equals(Object o){
		boolean ans = true;
		if (this == o) 
			ans = true;
		
		if (o == null) 
			ans = false;
		
		if (o.getClass() != getClass())
			ans = false;
		
		Post post = (Post) o;
		if (this.pcontent != post.pcontent)
			ans = false;
		
		return ans;
	}
	
	public int hashCode(){
		int hashcode = 0;
		
		return hashcode;
	}
	
	/**
	 * check the if contents contain the keywords
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		return this.getContent().contains(keyword);
	}
}


