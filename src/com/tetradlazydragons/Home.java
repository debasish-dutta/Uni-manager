package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

public class Home {
    JLabel head;
    JButton DB, reg;

    Home() {
        JFrame f = new JFrame("Uni Manager");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        head = new JLabel("UNi MANAGER ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        DB = new JButton("Connect DataBase");
        DB.setBounds(400, 169, 200, 200);
        f.add(DB);

        DB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DbConnect db = new DbConnect();
                // db.show();
                db.setVisible(true);
                // dispose();

            }
        });

        reg = new JButton("Add Student");
        reg.setBounds(400, 469, 200, 200);
        f.add(reg);
        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RegForm studentDetails = new RegForm();
                studentDetails.setVisible(true);

                // dispose();

            }
        });

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    // public void actionPerformed(ActionEvent e) {
    // if (e.getSource().getClass().equals(JButton.class)) {

    // }
    // }

    public static void main(String args[]) {
        new Home();
    }
}
