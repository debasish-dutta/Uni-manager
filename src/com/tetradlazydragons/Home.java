package com.tetradlazydragons;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
    JPanel heading;
    JButton DBbtn, regbtn, searchbtn, updatebtn, exitbtn;
    String bgColor = "#1F2E54";

    Home() {
        JFrame f = new JFrame("Uni Manager");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("assets/icons/unimanagerhome.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuBar menu = new MenuBar();
        f.setJMenuBar(menu.createMenuBar());

        /*
         * DBbtn = new JButton("Connect DataBase");
         * DBbtn.setBounds(60, 469, 200, 200);
         * f.add(DBbtn);
         * 
         * DBbtn.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * ConnectView db = new ConnectView();
         * // db.show();
         * // db.setVisible(true);
         * //f.dispose();
         * 
         * }
         * });
         */

        regbtn = new JButton("Add Student");
        regbtn.setFont(new Font("Courier", Font.BOLD, 15));
        regbtn.setBorderPainted(false);
        regbtn.setOpaque(true);
        regbtn.setBackground(Color.decode(bgColor));
        regbtn.setForeground(Color.WHITE);
        regbtn.setBounds(700, 100, 200, 100);
        f.add(regbtn);
        regbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RegForm reg = new RegForm();
                // studentDetails.setVisible(true);
                f.dispose();

            }
        });

        searchbtn = new JButton("Search Student");
        searchbtn.setBounds(700, 300, 200, 100);
        searchbtn.setFont(new Font("Courier", Font.BOLD, 15));
        searchbtn.setBorderPainted(false);
        searchbtn.setOpaque(true);
        searchbtn.setBackground(Color.decode(bgColor));
        searchbtn.setForeground(Color.WHITE);
        f.add(searchbtn);
        searchbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SearchForm reg = new SearchForm();
                // studentDetails.setVisible(true);
                f.dispose();

            }
        });

        /*
         * updatebtn = new JButton("Update");
         * updatebtn.setBounds(960, 469, 200, 200);
         * f.add(updatebtn);
         * updatebtn.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * UpdateForm reg = new UpdateForm();
         * // studentDetails.setVisible(true);
         * f.dispose();
         * 
         * }
         * });
         */

        exitbtn = new JButton("Exit");
        exitbtn.setBounds(700, 500, 200, 100);
        exitbtn.setFont(new Font("Courier", Font.BOLD, 15));
        exitbtn.setBorderPainted(false);
        exitbtn.setOpaque(true);
        exitbtn.setForeground(Color.WHITE);
        exitbtn.setBackground(Color.decode(bgColor));

        f.add(exitbtn);
        exitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    // public void actionPerformed(ActionEvent e) {
    // if (e.getSource().getClass().equals(JButton.class)) {

    // }
    // }

    public static void main(String args[]) {
        new Home();
    }
}
