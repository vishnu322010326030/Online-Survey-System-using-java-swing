package second;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Userque extends JFrame implements ActionListener {
    JButton start;
    JButton next;
    JButton submit;
    JTextField ans;
    JPanel questionPanel; // Container to hold the labels
    int i = 1;

    public Userque() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit = new JButton("1 = 0");
        start = new JButton("start");
        next = new JButton("i++");
        start.setBackground(Color.lightGray);

        start.setBounds(400, 300, 150, 30);
        add(start);

        submit.setBounds(400, 350, 150, 30);

        next.setBackground(Color.lightGray);
        next.addActionListener(this);
        start.addActionListener(this);
        submit.addActionListener(this);
        next.setBounds(400, 400, 150, 30);
        add(next);
        add(submit);

        questionPanel = new JPanel(); // Initialize the panel
        questionPanel.setLayout(null); // Use null layout for precise positioning
        questionPanel.setBounds(0, 0, 600, 600);
        add(questionPanel);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Userque u = new Userque();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            i++;
        }
        if (e.getSource() == submit) {
            i = 0;
        }
        if (e.getSource() == start) {
            if (i > 1) {
                this.dispose();
            }
            System.out.println(i);
            String mysqlUrl = "jdbc:mysql://localhost:3306/project";
            Connection con;
            try {
                con = DriverManager.getConnection(mysqlUrl, "root", "vishnu");
                java.sql.Statement stmt;
                stmt = con.createStatement();
                String query = "select count(*) from question";
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                int count = rs.getInt(1);

                String query1 = "select Question from question where qno='" + i + "' ";
                ResultSet rs1 = stmt.executeQuery(query1);
                rs1.next();
                String res = rs1.getString(1);
                JLabel que = new JLabel();
                que.setText(res);
                que.setVisible(true);
                que.setBounds(100, 50, 300, 80);
                questionPanel.add(que);

                String query2 = "select op1 from question where qno='" + i + "' ";
                ResultSet rs2 = stmt.executeQuery(query2);
                rs2.next();
                String res2 = rs2.getString(1);
                JLabel op1 = new JLabel();
                op1.setText(res2);
                op1.setVisible(true);
                op1.setBounds(100, 150, 80, 30);
                questionPanel.add(op1);

                String query3 = "select op2 from question where qno='" + i + "' ";
                ResultSet rs3 = stmt.executeQuery(query3);
                rs3.next();
                String res3 = rs3.getString(1);
                JLabel op2 = new JLabel();
                op2.setText(res3);
                op2.setVisible(true);
                op2.setBounds(100, 200, 80, 30);
                questionPanel.add(op2);

                String query4 = "select op3 from question where qno='" + i + "' ";
                ResultSet rs4 = stmt.executeQuery(query4);
                rs4.next();
                String res4 = rs4.getString(1);
                JLabel op3 = new JLabel();
                op3.setText(res4);
                op3.setVisible(true);
                op3.setBounds(100, 250, 80, 30);
                questionPanel.add(op3);

                String query5 = "select op4 from question where qno='" + i + "' ";
                ResultSet rs5 = stmt.executeQuery(query5);
                rs5.next();
                String res5 = rs5.getString(1);
                JLabel op4 = new JLabel();
                op4.setText(res5);
                op4.setVisible(true);
                op4.setBounds(100, 300, 80, 30);
                questionPanel.add(op4);

                // Remove the previous labels from the panel
                questionPanel.removeAll();
                // Add the new labels to the panel
                questionPanel.add(que);
                questionPanel.add(op1);
                questionPanel.add(op2);
                questionPanel.add(op3);
                questionPanel.add(op4);

                // Repaint the panel to reflect the changes
                questionPanel.repaint();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
