package crimeData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, lbl_title;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;
    Statement st;
    Connection con;

    Register() {
        super("Registration Form");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_title = new JLabel("Register Here", JLabel.CENTER);
        add(lbl_title);
        lbl_title.setBounds(85, 20, 200, 40);
        lbl_title.setFont(new Font("Dialog", Font.BOLD, 25));

        l1 = new JLabel("UserName :");
        add(l1);
        l1.setBounds(30, 70, 100, 30);

        t1 = new JTextField();
        add(t1);
        t1.setBounds(130, 75, 200, 22);
        t1.setToolTipText("Enter UserName");

        l2 = new JLabel("Password :");
        add(l2);
        l2.setBounds(30, 100, 100, 30);

        t2 = new JPasswordField();
        add(t2);
        t2.setBounds(130, 105, 200, 22);
        t2.setToolTipText("Enter Password");

        l3 = new JLabel("Email :");
        add(l3);
        l3.setBounds(30, 130, 100, 30);

        t3 = new JTextField();
        add(t3);
        t3.setBounds(130, 135, 200, 22);
        t3.setToolTipText("Enter Email");

        l4 = new JLabel("Mobile No: ");
        add(l4);
        l4.setBounds(30, 160, 200, 30);

        t4 = new JTextField();
        add(t4);
        t4.setBounds(130, 165, 200, 22);
        t4.setToolTipText("Enter Mobile No");

        b1 = new JButton("Register");
        add(b1);
        b1.setBounds(75, 220, 100, 30);

        b2 = new JButton("Cancel");
        add(b2);
        b2.setBounds(205, 220, 100, 30);
        
        b3 = new JButton("Back To Login");
        add(b3);
        b3.setBounds(130, 260, 120, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/crime_man_sys", "root", "");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {
                String str_user = t1.getText();
                String str_pass = t2.getText();
                String str_email = t3.getText();
                String str_mobile = t4.getText();

                if (str_user.length() == 0 || str_pass.length() == 0 || str_email.length() == 0 || str_mobile.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please Fill Out All The Fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String query = ("insert into reg values('" + str_user + "','" + str_pass + "','" + str_email + "','" + str_mobile + "')");
                    st = con.createStatement();
                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Registration Successful...", "Message", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    
                    Login lg = new Login();
                    
                    lg.setVisible(true);
                    lg.setBounds(400, 100, 400, 325);
                    lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    st.close();
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        if (e.getSource() == b2) {
            int reply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit ?", "Message", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        
        if (e.getSource() == b3) {
            dispose();
            
            Login l1 = new Login();
            
            l1.setVisible(true);
            l1.setBounds(400, 100, 400, 325);
            l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}