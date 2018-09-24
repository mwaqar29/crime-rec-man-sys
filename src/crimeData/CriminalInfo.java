package crimeData;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CriminalInfo extends JFrame implements ActionListener {
    JLabel lbl_cid, lbl_fname, lbl_lname, lbl_crm_com, lbl_dob, lbl_state, lbl_city, lbl_title;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton btn_add, btn_update, btn_delete, btn_search, btn_exit, btn_logout;

    Connection con;
    Statement st;
    ResultSet rs;

    CriminalInfo() {
        super("Criminal Information");
        setLayout(null);

        lbl_title = new JLabel("Criminal Information", JLabel.CENTER);
        add(lbl_title);
        lbl_title.setBounds(165, 30, 250, 30);
        lbl_title.setFont(new Font("Dialog", Font.BOLD, 25));

        lbl_cid = new JLabel("Criminal ID :");
        add(lbl_cid);
        lbl_cid.setBounds(100, 80, 100, 30);

        t1 = new JTextField();
        add(t1);
        t1.setBounds(230, 85, 250, 22);
        t1.setToolTipText("Enter Criminal ID");

        lbl_fname = new JLabel("First Name :");
        add(lbl_fname);
        lbl_fname.setBounds(100, 120, 100, 30);

        t2 = new JTextField();
        add(t2);
        t2.setBounds(230, 125, 250, 22);
        t2.setToolTipText("Enter First Name");

        lbl_lname = new JLabel("Last Name :");
        add(lbl_lname);
        lbl_lname.setBounds(100, 160, 100, 30);

        t3 = new JTextField();
        add(t3);
        t3.setBounds(230, 165, 250, 22);
        t3.setToolTipText("Enter Last Name");

        lbl_crm_com = new JLabel("Crime :");
        add(lbl_crm_com);
        lbl_crm_com.setBounds(100, 200, 100, 30);

        t4 = new JTextField();
        add(t4);
        t4.setBounds(230, 205, 250, 22);
        t4.setToolTipText("Enter Crime Commited");

        lbl_dob = new JLabel("Date Of Birth :");
        add(lbl_dob);
        lbl_dob.setBounds(100, 240, 150, 30);

        t5 = new JTextField();
        add(t5);
        t5.setBounds(230, 245, 250, 22);
        t5.setToolTipText("Enter Date Of Birth");

        lbl_state = new JLabel("State :");
        add(lbl_state);
        lbl_state.setBounds(100, 280, 100, 30);

        t6 = new JTextField();
        add(t6);
        t6.setBounds(230, 285, 250, 22);
        t6.setToolTipText("Enter State");
        
        lbl_city = new JLabel("City :");
        add(lbl_city);
        lbl_city.setBounds(100, 320, 100, 30);
        
        t7 = new JTextField();
        add(t7);
        t7.setBounds(230, 325, 250, 22);
        t7.setToolTipText("Enter City");

        btn_add = new JButton("Add");
        add(btn_add);
        btn_add.setBounds(70, 365, 100, 30);

        btn_delete = new JButton("Delete");
        add(btn_delete);
        btn_delete.setBounds(190, 365, 100, 30);

        btn_search = new JButton("Search");
        add(btn_search);
        btn_search.setBounds(310, 365, 100, 30);

        btn_exit = new JButton("Cancel");
        add(btn_exit);
        btn_exit.setBounds(430, 365, 100, 30);
        
        btn_logout = new JButton("LOGOUT");
        add(btn_logout);
        btn_logout.setBounds(250, 415, 100, 30);

        btn_add.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_search.addActionListener(this);
        btn_exit.addActionListener(this);
        btn_logout.addActionListener(this);
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/crime_man_sys", "root", "");

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return con;
    }

    public void insertRecord() {
        if (t1.getText().length() == 0 || t2.getText().length() == 0 || t3.getText().length() == 0 || t4.getText().length() == 0 || t5.getText().length() == 0 || t6.getText().length() == 0 || t7.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Fill Out All The Fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            con = getConnection();
            String query = "insert into info values('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "')";
            
            try {
                st = con.createStatement();
                st.executeUpdate(query);
                
                st.close();
                con.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(null, "Record Saved Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
        }
    }

    public void deleteRecord() {
        if (t1.getText().length() == 0 || t2.getText().length() == 0 || t3.getText().length() == 0 || t4.getText().length() == 0 || t5.getText().length() == 0 || t6.getText().length() == 0 || t7.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter The ID and Search the Record First to Delete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            con = getConnection();
            int rply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete Record ?", "Delete", JOptionPane.YES_NO_OPTION);

            if (rply == JOptionPane.YES_OPTION) {
                String query = "delete from info where id = '" + t1.getText() + "'";

                try {
                    st = con.createStatement();
                    st.executeUpdate(query);

                    st.close();
                    con.close();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
            }
        }
    }
    
    public void searchRecord() {
        if (t1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter The ID and Click on 'Search' Button", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            con = getConnection();
            String cid = null, fname = null, lname = null, crime = null, dob = null, city = null, state = null;
            String query = "select * from info where id like '" + t1.getText() + "'";

            try {
                st = con.createStatement();
                rs = st.executeQuery(query);

                while (rs.next()) {
                    cid = rs.getString("id");
                    fname = rs.getString("fname");
                    lname = rs.getString("lname");
                    crime = rs.getString("crime");
                    dob = rs.getString("dob");
                    state = rs.getString("state");
                    city = rs.getString("city");
                }
                rs.close();
                st.close();
                con.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

            t1.setText(cid);
            t2.setText(fname);
            t3.setText(lname);
            t4.setText(crime);
            t5.setText(dob);
            t6.setText(state);
            t7.setText(city);

            if (t1.getText().equals("") && t2.getText().equals("") && t3.getText().equals("") && t4.getText().equals("") && t5.getText().equals("") && t6.getText().equals("") && t7.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Search Record Not Found\nPlease Enter Valid ID", "Error", JOptionPane.ERROR_MESSAGE);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Search Record Found", "Message", JOptionPane.INFORMATION_MESSAGE);
                t1.setText(cid);
                t2.setText(fname);
                t3.setText(lname);
                t4.setText(crime);
                t5.setText(dob);
                t6.setText(state);
                t7.setText(city);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_add) {
            insertRecord();
        }

        if (e.getSource() == btn_delete) {
            deleteRecord();
        }

        if (e.getSource() == btn_search) {
            searchRecord();
        }

        if (e.getSource() == btn_exit) {
            int reply = JOptionPane.showConfirmDialog(null, "Are You Sure Want To Exit ?", "Message", JOptionPane.YES_NO_OPTION);
            
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        
        if (e.getSource() == btn_logout) {
            int reply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To LOGOUT?", "Message", JOptionPane.YES_NO_OPTION);
            
            if (reply == JOptionPane.YES_OPTION) {
                dispose();
                
                Login l1 = new Login();
                
                l1.setVisible(true);
                l1.setBounds(400, 100, 400, 325);
                l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }
}