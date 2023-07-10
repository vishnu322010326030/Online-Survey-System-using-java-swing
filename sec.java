package second;
//what is wrong in my code its not showing anything
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class sec extends JFrame implements ActionListener{
	JLabel lab;
	JLabel username;
	JLabel password;
	JButton fp;
	JButton exit;
	JButton submit;
	JTextField userfield;
	JTextField passfield;
	public sec(){
		setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		lab = new JLabel("LOG-IN Page");
		fp = new JButton("Forget Password ?");
		exit = new JButton("EXIT");
		username = new JLabel("USERNAME");
		password = new JLabel("PASSWORD");
		submit = new JButton("SUBMIT");
		userfield = new JTextField();
		passfield = new JTextField();
		fp.setBounds(50,280,150,30);
		fp.setBackground(Color.white);
		fp.setForeground(Color.BLUE);
		exit.setBounds(290,200,100,40);
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		lab.setBounds(250,0,100,50);
		lab.setForeground(Color.red);
		username.setBounds(150,100,80,30);
		password.setBounds(150,150,100,30);
		submit.setBounds(160,200,100,40);
		userfield.setBounds(300,100,80,30);
		passfield.setBounds(300,150,80,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		fp.addActionListener(this);
		exit.addActionListener(this);
		add(username);
		add(exit);
		add(password);
		add(submit);
		add(userfield);
		add(passfield);
		add(lab);
		add(fp);
		setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		sec s = new sec();
	}
	
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submit) {
			try {
				String url = "jdbc:mysql://localhost:3306/authentication";
				String username = "root";
				String password = "vishnu";
				Connection connection;
				connection = DriverManager.getConnection(url, username, password);
				String username1 = userfield.getText();
				String password1 = passfield.getText();
				String sql = "SELECT * FROM usercreds WHERE username = ? AND password = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username1);
				statement.setString(2, password1);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
				    // Credentials are valid
				    this.dispose();
				    new userque1();
				} else {
					JOptionPane.showMessageDialog(sec.this,
			                "Register First",
			                "Invalid Credentials",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			
		}
		if(e.getSource() == fp) {
			this.dispose();
			new Onee();
		}
	}
}