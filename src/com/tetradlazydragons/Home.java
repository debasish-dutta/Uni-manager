package com.tetradlazydragons;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.sql.*;
import java.sql.DriverManager;

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

                new DbConnect();
                // db.show();
                // db.setVisible(true);
                f.setVisible(false);
                // dispose();

            }
        });

        reg = new JButton("Add Student");
        reg.setBounds(400, 469, 200, 200);
        f.add(reg);
        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new RegForm();
                f.setVisible(false);
                // studentDetails.setVisible(true);
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
