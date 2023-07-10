	package second;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	
	import javax.swing.JTextField;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	public class forgetpass extends JFrame implements ActionListener{
		JButton btn_submit;
		JButton btn_exit;
		JTextField tf_username;
		JTextField tf_password;
		JTextField tf_ReEnterPassword;
		JLabel l_ForgetPassword;
		JLabel l_username;
		JLabel l_password;
		JLabel mail;
		JTextField email;
		JLabel l_ReEnterPassword;
		JLabel l_label;
		public forgetpass(){
			mail = new JLabel("E-mail");
			email = new JTextField();
			email.setBounds(300,200,80,30);
			mail.setBounds(120,200,200,30);
			l_label = new JLabel("Note: Use numbers and special characters for a strong password");
			l_label.setBounds(50, 330, 400, 40);
			l_label.setForeground(Color.red);
			l_ForgetPassword = new JLabel("Forget Password Form");
			l_ForgetPassword.setForeground(Color.RED);
			l_ForgetPassword.setBounds(160,0,250,40);
			l_username = new JLabel("USERNAME");
			l_username.setBounds(120,100,80,30);
			l_ReEnterPassword = new JLabel("Re-Enter Password");
			l_ReEnterPassword.setBounds(100, 200, 150, 30);
			tf_username = new JTextField();
			tf_username.setBounds(300,100,80,30);	
			l_password = new JLabel("Create Password");
			l_password.setBounds(100,150,200,30);
			tf_password = new JTextField();
			tf_password.setBounds(300,150,80,30);
			tf_ReEnterPassword = new JTextField();
			tf_ReEnterPassword.setBounds(300,200,80,30);
			btn_submit = new JButton("SUBMIT");
			btn_submit.setBounds(150,250,100,30);
			btn_submit.setForeground(Color.BLACK);
			btn_submit.setBackground(Color.BLUE);
			btn_submit.addActionListener(this);
			btn_exit = new JButton("Exit");
			btn_exit.setBounds(270,250,80,30);
			btn_exit.setForeground(Color.RED);
			btn_exit.setBackground(Color.white);
			btn_exit.addActionListener(this);
			l_ForgetPassword.setFont(new Font("Courier",Font.BOLD,20));
			add(btn_submit);
			add(btn_exit);
			add(tf_username);
			add(tf_password);
			add(l_username);
			add(email);
			add(l_password);
			add(mail);
			//add(l_ReEnterPassword);
			//add(tf_ReEnterPassword);
			add(l_label);
			add(l_ForgetPassword);
			setLayout(null);
			setSize(600,450);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public static void main(String[] args) {
			forgetpass fp = new forgetpass();
		}
		
		@Override
		public void actionPerformed(ActionEvent b){
			if (b.getSource() == btn_submit) {
				String use = tf_username.getText().toString();
				String pas = tf_password.getText().toString();
				try{
					Class.forName("com.mysql.cj.jdbc.Driver"); // step1
					String mysqlUrl = "jdbc:mysql://localhost:3306/authentication";
					// step2
					Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
					// System.out.println("Connection established......");
					// step3
					PreparedStatement ps = con.prepareStatement("insert into authen values(?,?)");
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
				tf_ReEnterPassword.setText("");
				this.dispose();
				new admin_login();
			}
			if(b.getSource() == btn_exit) {
				dispose();
				new zero();
			}
		}
	}