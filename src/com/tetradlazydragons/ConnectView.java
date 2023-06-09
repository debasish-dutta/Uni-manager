package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

import java.sql.*;
import java.sql.DriverManager;

public class ConnectView implements ActionListener {
    JLabel head, hostLabel, portLabel, dbLabel, usrLabel, pwdLabel, sslLabel;
    JTextField hostF, portF, dbF, usrF, pwdF;
    Checkbox ssl;
    String useSsl;
    JButton connectBtn, backBtn;
    JFrame f = new JFrame("DataBase Connect Form");
    String bgcolor = "#1F2E54", bgcolor2 = "#ACB1D6";

    ConnectView() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.decode(bgcolor2));
        MenuBar menu = new MenuBar();
        f.setJMenuBar(menu.createMenuBar());

        head = new JLabel("CONNECT DATABASE ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setForeground(Color.decode(bgcolor));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        hostLabel = new JLabel("host:");
        hostLabel.setBounds(50, 150, 100, 20);
        hostLabel.setForeground(Color.decode(bgcolor));
        hostF = new JTextField();
        hostF.setBounds(200, 150, 250, 20);
        hostF.setText("localhost");
        f.add(hostLabel);
        f.add(hostF);

        portLabel = new JLabel("port:");
        portLabel.setForeground(Color.decode(bgcolor));
        portLabel.setBounds(50, 180, 100, 20);
        portF = new JTextField();
        portF.setBounds(200, 180, 250, 20);
        portF.setText("3306");
        f.add(portLabel);
        f.add(portF);

        dbLabel = new JLabel("database:");
        dbLabel.setForeground(Color.decode(bgcolor));
        dbLabel.setBounds(50, 210, 100, 20);
        dbF = new JTextField();
        dbF.setBounds(200, 210, 250, 20);
        dbF.setText("student_management_system");
        f.add(dbLabel);
        f.add(dbF);

        usrLabel = new JLabel("user:");
        usrLabel.setForeground(Color.decode(bgcolor));
        usrLabel.setBounds(50, 240, 100, 20);
        usrF = new JTextField();
        usrF.setBounds(200, 240, 250, 20);
        usrF.setText("root");
        f.add(usrLabel);
        f.add(usrF);

        pwdLabel = new JLabel("password:");
        pwdLabel.setForeground(Color.decode(bgcolor));
        pwdLabel.setBounds(50, 270, 100, 20);
        pwdF = new JTextField();
        pwdF.setBounds(200, 270, 250, 20);
        pwdF.setText(" ");
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
        connectBtn.setForeground(Color.WHITE);
        connectBtn.setBackground(Color.decode(bgcolor));
        connectBtn.setBorderPainted(false);
        connectBtn.setOpaque(true);
        f.add(connectBtn);
        connectBtn.addActionListener(this);

        backBtn = new JButton("Back");
        backBtn.setBounds(600, 669, 150, 40);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(Color.decode(bgcolor));
        backBtn.setBorderPainted(false);
        backBtn.setOpaque(true);
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
            final String pwd = pwdF.getText();
            if (useSsl == null)
                useSsl = "false";

            String databaseUrl = "jdbc:mysql://" + host + ":" + port + "/" + db
                    + "?&useSSL=" + useSsl;
            // System.out.println(databaseUrl);
            if (user.equals("") || pwd.equals("") || databaseUrl.equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Fill empty fields", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                DBHandler.setLogin(user);
                DBHandler.setPassword(pwd);
                DBHandler.setDatabaseUrl(databaseUrl);
            }

            if (DBHandler.createTables()) {
                JOptionPane.showMessageDialog(new JFrame(), "connectionEstablished",
                        "success", JOptionPane.INFORMATION_MESSAGE);

                // Open a new window where you can manage the table and close the old one
                new Home();
                f.dispose();

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "connection not established", "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // public static void main(String args[]) {
    // // DbConnect db = new DbConnect();
    // // db.setVisible(true);
    // new DbConnect();
    // }
}
