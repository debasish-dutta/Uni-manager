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
    JButton DBbtn, regbtn, searchbtn, updatebtn, exitbtn;

    Home() {
        JFrame f = new JFrame("Uni Manager");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        head = new JLabel("UNI MANAGER ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        DBbtn = new JButton("Connect DataBase");
        DBbtn.setBounds(60, 469, 200, 200);
        f.add(DBbtn);

        DBbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DbConnect db = new DbConnect();
                // db.show();
                // db.setVisible(true);
                f.dispose();

            }
        });

        regbtn = new JButton("Add Student");
        regbtn.setBounds(360, 469, 200, 200);
        f.add(regbtn);
        regbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RegForm reg = new RegForm();
                // studentDetails.setVisible(true);
                f.dispose();

            }
        });

        searchbtn = new JButton("Search Student");
        searchbtn.setBounds(660, 469, 200, 200);
        f.add(searchbtn);
        searchbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SearchForm reg = new SearchForm();
                // studentDetails.setVisible(true);
                f.dispose();

            }
        });

        updatebtn = new JButton("Update");
        updatebtn.setBounds(960, 469, 200, 200);
        f.add(updatebtn);
        updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                UpdateForm reg = new UpdateForm();
                // studentDetails.setVisible(true);
                f.dispose();

            }
        });

        exitbtn = new JButton("Exit");
        exitbtn.setBounds(539, 689, 169, 69);
        f.add(exitbtn);
        exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
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
