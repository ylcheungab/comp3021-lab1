package base;

import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable {
	private Date date;
	private String content;
	
	public void load(String filepath){
		
	}
	
	public void save(String filepath){
		
	}
	
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	/**
	 * date getter
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * date setter
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Content getter
	 * @return
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * Content setter
	 * @param content
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 * output all info within the class
	 */
	@Override
	public String toString() {
		return "Posted on " + this.date + "\n" + "content: " + this.content;
	}
	
	/**
	 * check equality of two object
	 * @return true = equal, false = not equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	
	/**
	 * changes as overriding the equals()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}
	
	/**
	 * check the if contents contain the keywords
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		return this.getContent().contains(keyword);
	}
	
	/**
	 * the value 0 if the argument Date is equal to this Date;
	 * a value less than 0 if this Date is before the Date argument;
	 * and a value greater than 0 if this Date is after the Date argument
	 */
	@Override
	public int compareTo(Post p){
		return this.date.compareTo(p.date);
	}
	
}


