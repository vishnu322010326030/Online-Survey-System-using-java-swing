package second;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Onee extends JFrame implements ActionListener{
	JButton btn_submit;
	JLabel labe;
	JButton login;
	JButton alogin;
	JButton btn_exit;
	JTextField tf_username;
	JTextField tf_password;
	JLabel l_registration;
	JLabel l_username;
	JLabel l_password;
	JLabel mail;
	JTextField email;
	public Onee(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mail = new JLabel("E-mail");
		email = new JTextField();
		email.setBounds(300,140,80,30);
		mail.setBounds(120,140,80,30);
		setTitle("Registration");
		alogin = new JButton("Admin login");
		alogin.setBounds(330,250,150,30);
		alogin.setForeground(Color.white);
		alogin.setBackground(Color.black);
		login = new JButton("User Login");
		login.setBounds(330,200,150,30);
		login.setForeground(Color.white);
		login.setBackground(Color.black);
        labe = new JLabel("Note: Use numbers and special characters for a strong password");
		l_registration = new JLabel("REGISTRATION FROM");
		l_registration.setForeground(Color.red);
		labe.setBounds(50,280,400,40);
		labe.setForeground(Color.red);
		l_registration.setBounds(230,0,250,40);
		l_username = new JLabel("USERNAME");
		l_username.setBounds(120,40,80,30);
		tf_username = new JTextField();
		tf_username.setBounds(300,40,80,30);
		l_password = new JLabel("CREATE PASSWORD");
		l_password.setBounds(100,90,200,30);
		tf_password = new JTextField();
		tf_password.setBounds(300,90,80,30);
		btn_submit = new JButton("SUBMIT");
		btn_submit.setBounds(100,200,100,30);
		btn_submit.setForeground(Color.white);
		btn_submit.setBackground(Color.black);
		btn_submit.addActionListener(this);
		btn_exit = new JButton("EXIT");
		btn_exit.setBounds(225,200,80,30);
		btn_exit.setForeground(Color.white);
		btn_exit.setBackground(Color.black);
		btn_exit.addActionListener(this);
		login.addActionListener(this);
		add(btn_submit);
		add(btn_exit);
		add(tf_username);
		add(tf_password);
		add(l_username);
		add(l_password);
		add(labe);
		add(l_registration);
		add(login);
		//add(alogin);
		add(email);
		add(mail);
		setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
	} 
	@Override
	public void actionPerformed(ActionEvent e){
		String name= tf_username.getText().toString();
		if(e.getSource() == login) {
			this.dispose();
			new sec();
		}
		if (e.getSource() == btn_submit) {
			String use = tf_username.getText().toString();
			String pas = tf_password.getText().toString();
			try{
				Class.forName("com.mysql.cj.jdbc.Driver"); // step1
				String mysqlUrl = "jdbc:mysql://localhost:3306/authentication";
				// step2
				Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
				// System.out.println("Connection established......");
				// step3
				PreparedStatement ps = con.prepareStatement("insert into usercreds values(?,?)");
				ps.setString(1, use);
				ps.setString(2, pas);
				
				// step4
				ps.execute();
				// step5
				con.close();
			} catch (Exception ea) {
				ea.printStackTrace();
			}
			
			tf_username.setText("");
			tf_password.setText("");
			this.dispose();
			new sec();
		}
		if(e.getSource() == btn_exit) {
			dispose();
		}
		
	}
}



