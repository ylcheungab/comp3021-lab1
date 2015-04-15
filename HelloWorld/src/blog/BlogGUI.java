package blog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import base.Post;
import base.User;

public class BlogGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private User user;
	private Blog myBlog = new Blog(user);
	private JFrame mainFrame;
	private JTextArea postTextArea;//input
	private JTextArea postContent;//output
	private JButton refresh;
	private JButton post;
	private int wordDownCount;
	private JLabel postingDesc;
		
	private String desc;
	
	public BlogGUI() {
		user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea("What's on your mind?");
		postTextArea.addKeyListener(new lengthListener());
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		
		postContent = new JTextArea("Here is my posts!");
		postContent.setEditable(false);
		postContent.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		postContent.setEditable(false);
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);
		
		post = new JButton("Post");
		post.setBackground(Color.lightGray);
		post.addActionListener(new postListener());
		
		refresh = new JButton("Refresh");
		refresh.setBackground(Color.cyan);
		refresh.addActionListener(new refreshListener());
		
		wordDownCount = 140 - postTextArea.getText().length();
		desc = "You can still input " + wordDownCount + " Characters.";
	}

	public void setWindow() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(post);
		buttonPanel.add(refresh);
		
		JPanel postingPanel = new JPanel();
		postingDesc = new JLabel(desc);
		postingPanel.setLayout(new BoxLayout(postingPanel, BoxLayout.Y_AXIS));
		postingPanel.add(postTextArea);
		postingPanel.add(buttonPanel);
		
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
		mainFrame.add(postingDesc);
		mainFrame.add(postingPanel);
		mainFrame.add(postContent);
		
		mainFrame.setSize(700, 700);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}

	class postListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String content = postTextArea.getText();
			Date date = new Date();
			if (content.length() > 140)
				postTextArea.setText("Error: the length of post exceeds 140");
			else if (content.length() < 0)
				postTextArea.setText("Error: the post should not be empty");
			else {
				Post post = new Post(date, content);
				myBlog.post(post);
				//myBlog.save("Desktop/blog.pot");
			}
		}
	}
	
	class refreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//myBlog.load("Desktop/blog.pot");
			postContent.setText(myBlog.toString());
		}
	}
	
	class lengthListener implements KeyListener{
		@Override
		public void keyReleased(KeyEvent e) {
			wordDownCount = 140 - postTextArea.getText().length();
			if (wordDownCount < 0){
				desc = "post exceeds 140 Characters!";
				post.setEnabled(false);
			}else{
				desc = "You can still input " + wordDownCount + " Characters.";
				post.setEnabled(true);
			}
			postingDesc.setText(desc);
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}
}