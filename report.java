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

import javax.swing.JLabel;
import javax.swing.JPanel;


public class report extends JFrame implements ActionListener{
	
	JLabel heading;
	JButton ok;
	
	JLabel que1;
	JLabel que2;
	JLabel que3;
	JLabel que4;
	JLabel que5;
	JLabel que6;
	JLabel ques1;
	JLabel ques2;
	JLabel ques3;
	JLabel ques4;
	JLabel ques5;
	JLabel ques6;
	JButton Generate_report;
	JPanel questionPanel;
	
	public report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		questionPanel = new JPanel(); // Initialize the panel
        questionPanel.setLayout(null); // Use null layout for precise positioning
        questionPanel.setBounds(0,0,700,700);
        add(questionPanel);
		ok = new JButton("OK");
		Generate_report = new JButton("Generate_report");
		ques1 = new JLabel("How many number of families attempted the survey");
		ques2 = new JLabel("What is the average age of the person who filled this form");
		ques3 = new JLabel("Total number of males");
		ques4 = new JLabel("Total number females");
		ques5 = new JLabel("What is the average CTC");
		ques6 = new JLabel("How many families have annual CTC greater than 500000");
		heading = new JLabel("SURVEY REPORT");
		
		ques1.setBounds(80,0,300,300);
		ques2.setBounds(80,50,350,300);
		ques3.setBounds(80,100,300,300);
		ques4.setBounds(80,150,350,300);
		ques5.setBounds(80,200,300,300);
		ques6.setBounds(80,250,350,300);
		
		heading.setFont(new Font("Courier",Font.BOLD,20));
		heading.setBounds(230,20,300,40);
		heading.setForeground(Color.red);
		Generate_report.setBounds(530,550,150,30);
		Generate_report.addActionListener(this);
		Generate_report.setBackground(Color.black);
		Generate_report.setForeground(Color.white);
		ok.setBounds(550,600,80,30);
		ok.setBackground(Color.black);
		ok.setForeground(Color.white);
    	ok.addActionListener(this);
    	
    	questionPanel.add(heading);
    	questionPanel.add(ques1);
    	questionPanel.add(ques2);
    	questionPanel.add(ques3);
    	questionPanel.add(ques4);
    	questionPanel.add(ques5);
    	questionPanel.add(ques6);
    	questionPanel.add(Generate_report);
		setLayout(null);  
		setSize(700,700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		report u=new report();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ok) {
        	
        	dispose();
        	new zero();
        }
		
		
		if(e.getSource() == Generate_report) {
			dispose();
			setVisible(true);
			try{
				Class.forName("com.mysql.cj.jdbc.Driver"); // step1
				String mysqlUrl = "jdbc:mysql://localhost:3306/project";
				// step2
				Connection con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
				
				// System.out.println("Connection established......");
				
				// step3
				java.sql.Statement stmt;
			    stmt = con.createStatement();
			    
			    
			    String query1 = "select count(*) from answer";
				ResultSet rs1 = stmt.executeQuery(query1);
				rs1.next();
				    String res1 = rs1.getString(1);
				    que1 = new JLabel();
				    que1.setText(res1);
			        que1.setVisible(true);
			        que1.setBounds(500,0,300,300);
			        que1.setForeground(Color.red);
			        questionPanel.add(que1);
			        
			        String query2 = "select avg(age) from answer";
					ResultSet rs2 = stmt.executeQuery(query2);
					rs2.next();
					    String res2 = rs2.getString(1);
					    que2 = new JLabel();
					    que2.setText(res2);
				        que2.setVisible(true);
				        que2.setBounds(500,50,300,300);
				        que2.setForeground(Color.red);
				        questionPanel.add(que2);
				        
				        
				        String query3 = "select sum(males) from answer";
				        ResultSet rs3 = stmt.executeQuery(query3);
					    rs3.next();
						String res3 = rs3.getString(1);
						que3 = new JLabel();
						que3.setText(res3);
					    que3.setBounds(500,100,300,300);
					    que3.setForeground(Color.red);
					    que3.setVisible(true);
					    questionPanel.add(que3);
					    
					    String query4 = "select sum(females) from answer";
				        ResultSet rs4 = stmt.executeQuery(query4);
					    rs4.next();
						String res4 = rs4.getString(1);
						que4 = new JLabel();
						que4.setText(res4);
					    que4.setBounds(500,150,300,300);
					    que4.setForeground(Color.red);
					    que4.setVisible(true);
					    questionPanel.add(que4);
				        
					    String query5 = "select avg(annual_CTC) from answer";
				        ResultSet rs5 = stmt.executeQuery(query5);
					    rs5.next();
						String res5 = rs5.getString(1);
						que5 = new JLabel();
						que5.setText(res5);
					    que5.setBounds(500,200,300,300);
					    que5.setForeground(Color.red);
					    que5.setVisible(true);
					    questionPanel.add(que5);
					    
					    String query6 = "SELECT COUNT(*) AS family_count FROM project.answer WHERE annual_ctc > 500000";
				        ResultSet rs6 = stmt.executeQuery(query6);
					    rs6.next();
						String res6 = rs6.getString(1);
						que6 = new JLabel();
						que6.setText(res6);
					    que6.setBounds(500,250,300,300);
					    que6.setForeground(Color.red);
					    que6.setVisible(true);
					    questionPanel.add(que6);
					    
					    
					    
				        questionPanel.removeAll();
				        questionPanel.add(que1);
				        questionPanel.add(que2);
				        questionPanel.add(que3);
				        questionPanel.add(que4);
				        questionPanel.add(que5);
				        questionPanel.add(que6);
				        
				        questionPanel.add(ques1);
				        questionPanel.add(ques2);
				        questionPanel.add(ques3);
				        questionPanel.add(ques4);
				        questionPanel.add(ques5);
				        questionPanel.add(ques6);
				        questionPanel.add(heading);
				        questionPanel.add(ok);
				        
				        questionPanel.repaint();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			
		}
		
	}
	

}