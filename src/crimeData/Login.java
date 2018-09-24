package crimeData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, lbl_title;
    JTextField t1, t2;
    JButton b1, b2, b3;
    ResultSet rs;
    Statement st;
    Connection con;

    Login() {
        super("Login Form");
        setLayout(null);

        lbl_title = new JLabel("Login Here", JLabel.CENTER);
        add(lbl_title);
        lbl_title.setBounds(85, 20, 200, 30);
        lbl_title.setFont(new Font("Dialog", Font.BOLD, 25));

        l1 = new JLabel("User Name :");
        add(l1);
        l1.setBounds(40, 70, 170, 30);

        t1 = new JTextField();
        t1.setToolTipText("Enter UserName");
        add(t1);
        t1.setBounds(140, 75, 200, 22);

        l2 = new JLabel("Password   :");
        add(l2);
        l2.setBounds(40, 105, 150, 20);

        t2 = new JPasswordField();
        t2.setToolTipText("Enter Password");
        add(t2);
        t2.setBounds(140, 105, 200, 22);

        b1 = new JButton("Login");
        add(b1);
        b1.setBounds(80, 150, 100, 30);

        b2 = new JButton("Cancel");
        add(b2);
        b2.setBounds(200, 150, 100, 30);

        b3 = new JButton("Create New Account");
        add(b3);
        b3.setBounds(115, 200, 150, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/crime_man_sys", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = "", s2 = "";
            String user = t1.getText();
            String pass = t2.getText();

            if (user.length() == 0 || pass.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please Enter Username and Password", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    st = con.createStatement();
                    rs = st.executeQuery("select * from reg where username='" + t1.getText() + "' AND password='" + t2.getText() + "'");

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Error Message", JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                        t2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Succesful!", "Message", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        
                        CriminalInfo ci = new CriminalInfo();
                        
                        ci.setVisible(true);
                        ci.setBounds(400, 100, 600, 550);
                        ci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        rs.close();
                        st.close();
                        con.close();
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

        if (e.getSource() == b2) {
            int reply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit ?", "Message", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION)
                System.exit(0);
        }

        if (e.getSource() == b3) {
            dispose();
            
            Register rg = new Register();
            
            rg.setVisible(true);
            rg.setBounds(400, 100, 400, 400);
            rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}