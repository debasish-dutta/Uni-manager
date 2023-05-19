package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.text.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.*;
import java.sql.DriverManager;

public class ViewCard implements ActionListener {
    JLabel head, rollNolabel;
    JButton backbtn, printbtn;
    JPanel buttonsPanel;

    ViewCard(Object rollNo) {

        JFrame f = new JFrame("View Student");
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // MenuBar menu = new MenuBar();
        // f.setJMenuBar(menu.createMenuBar());
        System.out.println(rollNo);

        head = new JLabel("STUDENT ");
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setBounds(450, 20, 600, 40);
        f.add(head);

        head = new JLabel(rollNo.toString());
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setBounds(450, 70, 600, 40);
        f.add(head);

        Object[] studentData = DBHandler.viewStudent(rollNo.toString());

        for (Object objArray : studentData) {
            System.out.println(objArray);
        }
        // System.out.println(java.util.Arrays.toString(studentData));

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(280, 500, 300, 40);
        buttonsPanel.setLayout(new GridLayout(1, 3, 20, 5));
        backbtn = new JButton("Cancel");
        buttonsPanel.add(backbtn);
        backbtn.addActionListener(this);

        printbtn = new JButton("Print");
        buttonsPanel.add(printbtn);
        printbtn.addActionListener(this);

        f.add(buttonsPanel);

        f.setSize(900, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {

        }
        if (e.getActionCommand().equals("Cancel")) {

        }
    }

}
