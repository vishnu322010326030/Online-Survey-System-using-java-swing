package second;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class userque1 extends JFrame implements ActionListener{
	JButton start;
	JLabel heading;
	JLabel heading2;
	JButton next;
	JButton submit_survey;
	JTextField ans;
	JLabel que;
	JLabel op1;
	
	JLabel qu1;
	JLabel qu2;
	JLabel qu3;
	JLabel qu4;
	
	JLabel op2;
	JLabel op3;
	JLabel op4;
	JLabel quest;
	JPanel questionPanel;
	int i=0;
	public userque1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		next = new JButton("Next");
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		qu1 = new JLabel("1.");
		qu2 = new JLabel("2.");
		qu3 = new JLabel("3.");
		qu4 = new JLabel("4.");
		qu1.setBounds(80,150,80,30);
		qu2.setBounds(80, 200, 80, 30);
		qu3.setBounds(80, 250, 80, 30);
		qu4.setBounds(80, 300, 80, 30);
		heading = new JLabel("ONLINE SURVEY");
		heading2 = new JLabel("Click on next to start the survey");
		quest = new JLabel("Question :");
		quest.setBounds(100, 20, 300, 80);
		quest.setForeground(Color.red);
		heading2.setBounds(150,50,300,100);
		heading2.setFont(new Font("Courier",Font.BOLD,15));
		heading.setFont(new Font("Courier",Font.BOLD,20));
		heading.setBounds(200,20,300,40);
		heading.setForeground(Color.red);
		submit_survey = new JButton("submit survey");		
		next.setBounds(400,300,150,30);
		submit_survey.setBounds(400,450,150,30);
    	submit_survey.addActionListener(this);
    	next.addActionListener(this);
		questionPanel = new JPanel(); // Initialize the panel
        questionPanel.setLayout(null); // Use null layout for precise positioning
        questionPanel.setBounds(0, 0, 600, 600);
        add(questionPanel);
		add(next);
		
		questionPanel.add(heading);
		questionPanel.add(heading2);
		
		setLayout(null);  
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		userque1 u=new userque1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == next) {
        	
        	dispose();
        	new usernew();
        }
		
	}
	

}