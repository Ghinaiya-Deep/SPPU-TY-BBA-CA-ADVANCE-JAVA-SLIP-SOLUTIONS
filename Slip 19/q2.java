import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class q2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton btnShow;

    public q2() {
        setTitle("Student Record Viewer");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Labels and TextFields
        add(new JLabel("Roll No:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Name:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Percentage:"));
        t3 = new JTextField();
        add(t3);

        btnShow = new JButton("Show First Record");
        add(btnShow);
        btnShow.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Load JDBC-ODBC Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Connect using DSN name (Replace "studentdsn" with your actual DSN)
            Connection con = DriverManager.getConnection("jdbc:odbc:slip19");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            if (rs.next()) {
                t1.setText(rs.getString("rno"));
                t2.setText(rs.getString("sname"));
                t3.setText(rs.getString("per"));
            } else {
                JOptionPane.showMessageDialog(this, "No records found.");
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new q2();
    }
}
