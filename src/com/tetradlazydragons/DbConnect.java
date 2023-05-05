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
    JLabel head, hostLabel, portLabel, dbLabel, usrLabel, pwdLabel, sslLabel;
    JTextField hostF, portF, dbF, usrF, pwdF;
    Checkbox ssl;
    String useSsl;
    JButton connectBtn, backBtn;

    DbConnect() {
        JFrame f = new JFrame("DataBase Connect Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuBar menu = new MenuBar();
        f.setJMenuBar(menu.createMenuBar());

        head = new JLabel("CONNECT DATABASE ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        hostLabel = new JLabel("host:");
        hostLabel.setBounds(50, 150, 100, 20);
        hostF = new JTextField();
        hostF.setBounds(200, 150, 250, 20);
        f.add(hostLabel);
        f.add(hostF);

        portLabel = new JLabel("port:");
        portLabel.setBounds(50, 180, 100, 20);
        portF = new JTextField();
        portF.setBounds(200, 180, 250, 20);
        f.add(portLabel);
        f.add(portF);

        dbLabel = new JLabel("database:");
        dbLabel.setBounds(50, 210, 100, 20);
        dbF = new JTextField();
        dbF.setBounds(200, 210, 250, 20);
        f.add(dbLabel);
        f.add(dbF);

        usrLabel = new JLabel("user:");
        usrLabel.setBounds(50, 240, 100, 20);
        usrF = new JTextField();
        usrF.setBounds(200, 240, 250, 20);
        f.add(usrLabel);
        f.add(usrF);

        pwdLabel = new JLabel("password:");
        pwdLabel.setBounds(50, 270, 100, 20);
        pwdF = new JTextField();
        pwdF.setBounds(200, 270, 250, 20);
        f.add(pwdLabel);
        f.add(pwdF);

        ssl = new Checkbox("use ssl");
        ssl.setBounds(50, 299, 169, 20);
        f.add(ssl);
        ssl.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                useSsl = (e.getStateChange() == 1 ? "true" : "flase");
            }
        });

        connectBtn = new JButton("Connect");
        connectBtn.setBounds(400, 669, 150, 40);
        f.add(connectBtn);
        connectBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(600, 669, 150, 40);
        f.add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home home = new Home();
                f.dispose();
            }
        });

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().equals(JButton.class)) {
            String host = hostF.getText();
            String port = portF.getText();
            String db = dbF.getText();
            String user = usrF.getText();
            String pwd = pwdF.getText();

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=" + useSsl;

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

    // public static void main(String args[]) {
    // // DbConnect db = new DbConnect();
    // // db.setVisible(true);
    // new DbConnect();
    // }
}
