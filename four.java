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
public class four extends JFrame implements ActionListener {
	JButton que;
	JButton dl;
	JButton submit;
	JButton cancel;
	JTextField tf_que;
	JLabel l_que;
	JTextField ans;
	JLabel sno1;
	JLabel sno2;
	JLabel sno3;
	JLabel sno4;
	JLabel an;
	JTextField option1;
	JTextField option2;
	JTextField option3;
	JTextField option4;
	public four() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin - Questions adding page");
		ans = new JTextField();
		an = new JLabel("Answer -->");
		dl = new JButton("Refresh DB");
		que = new JButton("Add Question");
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		tf_que = new JTextField();
		l_que = new JLabel("Post Question");
		option1 = new JTextField();
		option2 = new JTextField();
		option3 = new JTextField();
		option4 = new JTextField();
		sno1 = new JLabel("1.");
		sno2 = new JLabel("2.");
		sno3 = new JLabel("3.");
		sno4 = new JLabel("4.");
		an.setBounds(110,150,80,30);
		dl.setBounds(400,250,150,30);
		dl.setBackground(Color.black);
		dl.setForeground(Color.white);
		l_que.setForeground(Color.red);
		l_que.setBounds(100, 20, 150, 30);
		tf_que.setBounds(100, 50, 300, 80);
		que.setBounds(400,200,150,30);
		option1.setBounds(130,150,80,30);
		option2.setBounds(130,200,80,30);
		option3.setBounds(130,250,80,30);
		option4.setBounds(130,300,80,30);
		ans.setBounds(200,150,80,30);
		sno1.setBounds(100,150,80,30);
		sno2.setBounds(100,200,80,30);
		sno3.setBounds(100,250,80,30);
		sno4.setBounds(100,300,80,30);
		que.setBackground(Color.black);
		que.setForeground(Color.white);
		que.addActionListener(this);
		submit.setBounds(420, 350, 100, 30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		cancel.setBounds(420,300,100,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		l_que.setFont(new Font("Courier",Font.BOLD,15));
		cancel.addActionListener(this);
		dl.addActionListener(this);
		add(tf_que);
		add(l_que);
		add(que);
		add(submit);
		add(cancel);
		//add(option1);
		//add(option2);
		//add(option3);
		//add(option4);
		//add(sno1);
		//add(sno2);	
		//add(an);
		add(dl);
		//add(ans);
		//add(sno3);
		//add(sno4);
		setLayout(null);
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new four();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == que) {
			JOptionPane.showMessageDialog(four.this,
	                "Question added successfully"
	                + " to the database",
	                " ",
	                JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource() == submit) {
			this.dispose();
			new zero();
		}
		if (e.getSource().equals(que)) {
			String question = tf_que.getText().toString();
			String op1 = option1.getText().toString();
			String op2 = option2.getText().toString();
			String op3 = option3.getText().toString();
			String op4 = option4.getText().toString();
			String answer  = ans.getText().toString();
			try{
				Class.forName("com.mysql.cj.jdbc.Driver"); // step1
				String mysqlUrl = "jdbc:mysql://localhost:3306/project";
				// step2
				Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
				// System.out.println("Connection established......");
				// step3
				PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, question);
				ps.setString(3, op1);
				ps.setString(4, op2);
				ps.setString(5, op3);
				ps.setString(6, op4);
				ps.setString(7, answer);
				// step4
				ps.execute();
				// step5
				con.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			
			tf_que.setText("");
			option1.setText("");
			option2.setText("");
			option3.setText("");
			option4.setText("");
			ans.setText("");
		}if(e.getSource() == cancel) {
			JOptionPane.showMessageDialog(four.this,
	                "Recent question has been deleted from Database",
	                " ",
	                JOptionPane.INFORMATION_MESSAGE);
			try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // step1
			String mysqlUrl = "jdbc:mysql://localhost:3306/project";
			// step2
			Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
			PreparedStatement ps1 = con.prepareStatement("delete from project.question ORDER BY qno DESC LIMIT 1");
			ps1.execute();
			// step5
			con.close();
			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource() == dl) {
			JOptionPane.showMessageDialog(four.this,
	                "All question has been deleted from Database",
	                " ",
	                JOptionPane.INFORMATION_MESSAGE);
			try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // step1
			String mysqlUrl = "jdbc:mysql://localhost:3306/project";
			// step2
			Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
			PreparedStatement ps2 = con.prepareStatement("truncate table project.question;");
			ps2.execute();
			// step5
			con.close();
			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource() == submit) {
			JOptionPane.showMessageDialog(four.this,
	                "All question has been added to the Database",
	                " ",
	                JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}
}