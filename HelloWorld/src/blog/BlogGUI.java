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
import javax.swing.JTextField;

import base.Post;
import base.User;

public class BlogGUI extends JFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private User user;
	private Blog myBlog = new Blog(user);
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private int wordDownCount;
	private JLabel postingDesc;
		
	private String desc;
	
	public BlogGUI() {
		user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea("What's on your mind?");
		postTextArea.addKeyListener(this);
		
		postContent = new JTextField("Here is my posts!");
		postContent.setEditable(false);
		postContent.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		
		post = new JButton("Post");
		post.setBackground(Color.lightGray);
		post.addActionListener(this);
		
		refresh = new JButton("Refresh");
		refresh.setBackground(Color.cyan);
		refresh.addActionListener(this);
		
		wordDownCount = 200 - postContent.getText().length();
		desc = "You can still input " + wordDownCount + " Characters.";
	}

	public void setWindow() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(post);
		buttonPanel.add(refresh);
		
		JPanel postingPanel = new JPanel();
		postingDesc = new JLabel(desc);
		postingPanel.setLayout(new BoxLayout(postingPanel, BoxLayout.Y_AXIS));
		postingPanel.setBorder(BorderFactory.createTitledBorder(desc));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == post){
			Date date = new Date();
			Post post = new Post(date, postTextArea.getText());
			myBlog.post(post);
		}else if (e.getSource() == refresh){
			postContent.setText(myBlog.toString());
		}
	}

	public void refreshCharInt(){
		wordDownCount = 200 - postContent.getText().length();
		desc = "You can still input " + wordDownCount + " Characters.";
		postingDesc.repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		refreshCharInt();		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		refreshCharInt();		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		refreshCharInt();		
	}
}