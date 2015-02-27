package test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;


public class TestBlog {
	/**
	 * get user's input
	 * @return
	 */
	public String getInput(){
		String line = "";
		System.out.print("Enter the promt: ");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args){
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Blog myBlog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			
			if (prompt.startsWith("list"))
				myBlog.list();
			else if(prompt.startsWith("post")){
				//TODO: get content
				
				Date date = new Date();
				Post post = new Post(date, content);
				myBlog.post(post);
			}else if(prompt.startsWith("delete")){
				//TODO: get content
				
				myBlog.delete(index);
			}
		}
		
	}
}

