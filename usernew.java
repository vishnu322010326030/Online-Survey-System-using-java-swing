package second;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class usernew extends JFrame implements ActionListener{
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JLabel que1;
	JLabel que2;
	JLabel que3;
	JLabel que4;
	JLabel que5;
	JLabel que6;
	JLabel desc;
	JLabel desc1;
	JLabel desc2;
	JLabel desc3;
	JLabel desc4;
	JLabel desc5;
	JLabel desc6;
	JLabel desc7;
	JLabel det;
	
	
	JPanel questionPanel;
	
	JButton b1;
	JButton b2;
	JButton ss;
	
	int i=1;
	public usernew() {
		
		  
		desc = new JLabel("Survey policies");
		desc1 = new JLabel("Survey must not request or contain:");
		desc2 = new JLabel("1. Offensive and inappropriate content and language");
		desc3 = new JLabel("2. Push-polling or promotion");
		desc4 = new JLabel("3. Adult material");
		desc5 = new JLabel("4. Sensitive subjects");
		desc6 = new JLabel("5. Sensitive subjects like for race, ethnicity, religious beliefs, political beliefs");
		
		desc.setBounds(100,20,300,300);
		desc1.setBounds(100,60,300,300);
		desc2.setBounds(120,100,300,300);
		desc3.setBounds(120,130,300,300);
		desc4.setBounds(120,160,300,300);
		desc5.setBounds(120,190,300,300);
		desc6.setBounds(120,220,300,300);
		desc.setFont(new Font("Courier",Font.BOLD,20));
		desc1.setFont(new Font("Courier",Font.BOLD,15));
		desc.setForeground(Color.red);
		questionPanel = new JPanel(); // Initialize the panel
        questionPanel.setLayout(null); // Use null layout for precise positioning
        questionPanel.setBounds(0, 0, 900, 900);
        add(questionPanel);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf1 = new JTextField();
		tf1.setBounds(380,100,80,30);
		tf1.addActionListener((ActionListener) this);
		//questionPanel.add(tf1);
		
		tf2=new JTextField();
		tf2.setBounds(380,200,80,30);
		tf2.addActionListener((ActionListener) this);
		//questionPanel.add(tf2);
		
		tf3=new JTextField();
		tf3.setBounds(380,300,80,30);
		tf3.addActionListener((ActionListener) this);
		//questionPanel.add(tf3);
		
		tf4=new JTextField();
		tf4.setBounds(380,400,80,30);
		tf4.addActionListener((ActionListener) this);
		//questionPanel.add(tf4);
		
		tf5=new JTextField();
		tf5.setBounds(380,500,80,30);
		tf5.addActionListener((ActionListener) this);
		//questionPanel.add(tf5);
		
		tf6=new JTextField();
		tf6.setBounds(380,600,80,30);
		tf6.addActionListener((ActionListener) this);
		//questionPanel.add(tf6);
		
		b1 = new JButton("Yes i agree");
        b1.setBounds(600,500,100,50);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this); //first step
		questionPanel.add(desc);
		questionPanel.add(desc1);
		questionPanel.add(desc2);
		questionPanel.add(desc3);
		questionPanel.add(desc4);
		questionPanel.add(desc5);
		questionPanel.add(desc6);
		questionPanel.add(b1);
		
		setLayout(null);  
		setSize(800,800);
		setLocationRelativeTo(null);
		setVisible(true);
	
		
	}
	public static void main(String args[]) {
		usernew u=new usernew();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String name = tf1.getText().toString();
			String age = tf2.getText().toString();
			String total_family = tf3.getText().toString();
			String number_males = tf4.getText().toString();
			String number_females = tf5.getText().toString();
			String annual_ctc = tf6.getText().toString();
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver"); // step1
				String mysqlUrl = "jdbc:mysql://localhost:3306/project";
				// step2
				Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
				
				// System.out.println("Connection established......");
				
				// step3
				java.sql.Statement stmt;
			    stmt = con.createStatement();
			    
			    
			    String query1 = "select Question from question where qno='"+i+"' ";
				ResultSet rs1 = stmt.executeQuery(query1);
				rs1.next();
				    String res1 = rs1.getString(1);
				    que1 = new JLabel();
				    que1.setText(res1);
			        que1.setVisible(true);
			        que1.setBounds(100,100,150,30);
			        questionPanel.add(que1);
			        
			        String query2 = "select Question from question where qno='"+2+"' ";
			        ResultSet rs2 = stmt.executeQuery(query2);
				    rs2.next();
					String res2 = rs2.getString(1);
					que2 = new JLabel();
					que2.setText(res2);
				    que2.setBounds(100, 170, 300, 80);
				    que2.setVisible(true);
				    questionPanel.add(que2);
				    
				    String query3 = "select Question from question where qno='"+3+"' ";
			        ResultSet rs3 = stmt.executeQuery(query3);
				    rs3.next();
					String res3 = rs3.getString(1);
					que3 = new JLabel();
					que3.setText(res3);
				    que3.setBounds(100, 270, 300, 80);
				    que3.setVisible(true);
				    questionPanel.add(que3);
				    
				    String query4 = "select Question from question where qno='"+4+"' ";
			        ResultSet rs4 = stmt.executeQuery(query4);
				    rs4.next();
					String res4 = rs4.getString(1);
					que4 = new JLabel();
					que4.setText(res4);
				    que4.setBounds(100, 370, 300, 80);
				    que4.setVisible(true);
				    questionPanel.add(que4);
			        
				    String query5 = "select Question from question where qno='"+5+"' ";
			        ResultSet rs5 = stmt.executeQuery(query5);
				    rs5.next();
					String res5 = rs5.getString(1);
					que5 = new JLabel();
					que5.setText(res5);
				    que5.setBounds(100, 470, 300, 80);
				    que5.setVisible(true);
				    questionPanel.add(que5);
				    
				    String query7 = "select max(qno) from question";
			        ResultSet rs7 = stmt.executeQuery(query7);
				    rs7.next();
					int res7 = rs7.getInt(1);
				    
				    
				    String query6 = "select Question from question where qno='"+res7+"' ";
			        ResultSet rs6 = stmt.executeQuery(query6);
				    rs6.next();
					String res6 = rs6.getString(1);
					que6 = new JLabel();
					que6.setText(res6);
				    que6.setBounds(100,570, 300, 80);
				    que6.setVisible(true);
				    questionPanel.add(que6);
				    
				    
			        
			        det = new JLabel("Please fill your details in the blanks accordingly");
			        det.setBounds(100,30,600,30);
			        det.setFont(new Font("Courier",Font.BOLD,20));
			        det.setForeground(Color.red);
			           
			        desc7 = new JLabel("IF YOU AGREE THAT ALL THE DETAILS ENTERED ARE CORRECT THEN PLEASE CLICK AGREE TO SUBMIT");
			        desc7.setBounds(100,670, 700, 80);
			        desc7.setForeground(Color.blue);
			        
			        ss = new JButton("Logout");
			        ss.setBounds(550,600,200,50);
					ss.setBackground(Color.black);
					ss.setForeground(Color.white);
					ss.addActionListener(this);
			        
			        
			        
			        questionPanel.removeAll();
			        questionPanel.add(que1);
			        questionPanel.add(que2);
			        questionPanel.add(que3);
			        questionPanel.add(que4);
			        questionPanel.add(que5);
			        questionPanel.add(que6);
			        questionPanel.add(b1);
			        questionPanel.add(tf1);
			        questionPanel.add(tf2);
			        questionPanel.add(tf3);
			        questionPanel.add(tf4);
			        questionPanel.add(tf5);
			        questionPanel.add(tf6);
			        questionPanel.add(det);
			        questionPanel.add(ss);
			        questionPanel.add(desc7);
			        
			        questionPanel.repaint();
				
				
				
				
				
				
				
				
				
				PreparedStatement ps = con.prepareStatement("insert into answer values(?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, age);
				ps.setString(3, total_family);
				ps.setString(4, number_males);
				ps.setString(5, number_females);
				ps.setString(6, annual_ctc);
				// step4
				ps.execute();
				// step5
				con.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		}
		if(e.getSource() == ss) {
			JOptionPane.showMessageDialog(usernew.this,
	                "All details are added",
	                "congratulations",
	                JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new zero();
		}
		
	}

}