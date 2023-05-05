package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

import java.sql.*;
import java.sql.DriverManager;

public class SearchForm implements ActionListener {

    JLabel head, searchlabel;
    JTextField searchtf;
    JButton submitbtn, delbtn, backbtn;

    SearchForm() {
        JFrame f = new JFrame("Search Student");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuBar menu = new MenuBar();
        f.setJMenuBar(menu.createMenuBar());

        head = new JLabel("FIND STUDENT ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(400, 20, 600, 30);
        f.add(head);

        searchlabel = new JLabel("Search:");
        searchlabel.setBounds(300, 100, 150, 20);
        searchtf = new JTextField();
        searchtf.setBounds(450, 100, 350, 20);
        f.add(searchlabel);
        f.add(searchtf);

        submitbtn = new JButton("Search");
        submitbtn.setBounds(500, 569, 150, 40);
        f.add(submitbtn);
        submitbtn.addActionListener(this);

        delbtn = new JButton("Delete");
        delbtn.setBounds(300, 569, 150, 40);
        f.add(delbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(700, 569, 150, 40);
        f.add(backbtn);
        backbtn.addActionListener(new ActionListener() {
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

        }
    }
}
