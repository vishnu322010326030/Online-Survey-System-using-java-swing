package second;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class zero extends JFrame implements ActionListener {
	JLabel message;
	JButton Admin;
	JButton User;
	JButton report;
	JLabel qu;
	public zero() {
		setTitle("Welcome Admin / user");
		report = new JButton("SHOW REPORT");
		report.setBounds(300,150,150,30);
		report.setForeground(Color.white);
		report.setBackground(Color.black);
		report.addActionListener(this);
		qu = new JLabel("Are you a user or an admin?");
		JFrame frame = new JFrame("Welcome to Online Survey system");
		frame.setSize(600,600);
		qu.setFont(new Font("Courier",Font.BOLD,15));
		qu.setBounds(30,50,300,100);
        ImageIcon image1 = new ImageIcon("C:\\Users\\soulh\\Desktop\\personals\\or.jpg");
        frame.add(new JLabel(image1));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		message = new JLabel("Online Survey System");
		message.setFont(new Font("Courier",Font.BOLD,20));
		Admin = new JButton("ADMIN");
		User = new JButton("USER");
		message.setBounds(200,20,300,40);
		Admin.setBounds(80,150,100,30);
		User.setBounds(190,150,100,30);
		Admin.setForeground(Color.white);
		Admin.setBackground(Color.black);
		User.setBackground(Color.black);
		User.setForeground(Color.white);
		message.setForeground(Color.gray);
		Admin.addActionListener(this);
		User.addActionListener(this);
		add(Admin);
		add(User);
		add(message);
		add(report);
		add(qu);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	public static void main(String[] args) {
		zero ze = new zero();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Admin) {
			this.dispose();
			new admin_login();
		}
		if(e.getSource() == User) {
			dispose();
			new Onee();
		}
		if(e.getSource() == report) {
			new report();
			this.dispose();
		}
		
	}

}