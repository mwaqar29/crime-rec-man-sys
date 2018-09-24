package crimeData;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener {
    JLabel jl1;
    JButton jb1, jb2, jb3;
    
    Welcome() {
        super("Welcome");
        setLayout(null);
        
        jl1 = new JLabel("Welcome To Crime Records Management System");
        add(jl1);
        jl1.setForeground(Color.BLUE);
        jl1.setBounds(25, 20, 600, 30);
        jl1.setFont(new Font("Dialog", Font.BOLD, 20));
        
        jb1 = new JButton("Login");
        add(jb1);
        jb1.setBounds(60, 100, 120, 30);

        jb2 = new JButton("Register");
        add(jb2);
        jb2.setBounds(200, 100, 120, 30);

        jb3 = new JButton("Exit");
        add(jb3);
        jb3.setBounds(340, 100, 120, 30);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            dispose();  
            
            Login l1 = new Login();
            
            l1.setVisible(true);
            l1.setBounds(400, 100, 400, 325);
            l1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        if (e.getSource() == jb2) {
            dispose();
            
            Register rg = new Register();
            
            rg.setVisible(true);
            rg.setBounds(400, 100, 400, 400);
            rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        
        if (e.getSource() == jb3) {
            int reply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit ?", "Message", JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        Welcome w = new Welcome();
        w.setVisible(true);
        w.setBounds(400, 100, 535, 200);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
