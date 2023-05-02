package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

import java.sql.*;
import java.sql.DriverManager;

public class DbConnect implements ActionListener {
    JLabel head, urlLabel, usrLabel, pwdLabel;
    JTextField urlF, usrF, pwdF;

    JButton connectBtn;

    DbConnect() {
        JFrame f = new JFrame("DataBase Connect Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        head = new JLabel("CONNECT DATABASE ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        urlLabel = new JLabel("url:");
        urlLabel.setBounds(50, 100, 150, 20);
        urlF = new JTextField();
        urlF.setBounds(200, 100, 250, 20);
        f.add(urlLabel);
        f.add(urlF);

        usrLabel = new JLabel("user:");
        usrLabel.setBounds(50, 100, 150, 20);
        usrF = new JTextField();
        usrF.setBounds(200, 100, 250, 20);
        f.add(urlLabel);
        f.add(usrF);

        pwdLabel = new JLabel("password:");
        pwdLabel.setBounds(50, 300, 150, 20);
        pwdF = new JTextField();
        pwdF.setBounds(200, 300, 250, 20);
        f.add(pwdLabel);
        f.add(pwdF);

        connectBtn = new JButton("Connect");
        connectBtn.setBounds(300, 569, 150, 40);
        f.add(connectBtn);
        connectBtn.addActionListener(this);

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().equals(JButton.class)) {
            String url = urlF.getText();
            String user = usrF.getText();
            String pwd = pwdF.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pwd);
                System.out.println(con);
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void main(String args[]) {
        // DbConnect db = new DbConnect();
        // db.setVisible(true);
        new DbConnect();
    }
}
