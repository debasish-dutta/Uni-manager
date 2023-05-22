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

public class SearchForm implements ActionListener {

    JLabel head, searchlabel;
    JTextField searchtf;
    JButton submitbtn, delbtn, viewbtn, backbtn;
    static JTable viewTable;
    static DefaultTableModel tableModel;
    JPanel headingPanel, searchPanel, tablepanel, buttonsPanel;

    SearchForm() {
        JFrame f = new JFrame("Search Student");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuBar menu = new MenuBar();
        f.setJMenuBar(menu.createMenuBar());

        head = new JLabel("FIND STUDENT ");
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setForeground(Color.decode("#1F2E54"));
        head.setBounds(450, 20, 600, 40);
        f.add(head);

        searchPanel = new JPanel();
        searchPanel.setBounds(170, 80, 800, 30);
        searchPanel.setLayout(new GridLayout(1, 3, 50, 5));

        searchlabel = new JLabel("Search:",JLabel.RIGHT);   
        searchlabel.setFont(new Font("Courier", Font.CENTER_BASELINE, 15));   
        searchlabel.setForeground(Color.decode("#1F2E54"));  
        searchtf = new JTextField();        
        searchPanel.add(searchlabel);
        searchPanel.add(searchtf);
        submitbtn = new JButton("Search");
        searchPanel.add(submitbtn);
        submitbtn.addActionListener(this);
        f.add(searchPanel);

        tablepanel = new JPanel();
        tablepanel.setBounds(0, 150, 1200, 400);

        tableModel = new DefaultTableModel();
        viewTable = new JTable(tableModel);
        tableModel.addColumn("Roll No");
        tableModel.addColumn("Name");
        tableModel.addColumn("Date Of Birth");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Email");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Department");
        TableColumn column;
        for (int i = 0; i < viewTable.getColumnCount(); i++) {
            column = viewTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(200); // Set the preferred width of columns
        }

        JScrollPane scrollPane = new JScrollPane(viewTable);
        scrollPane.setPreferredSize(new Dimension(1000, 300));
        tablepanel.add(scrollPane);
        f.add(tablepanel);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(300, 600, 600, 40);
        buttonsPanel.setLayout(new GridLayout(1, 3, 20, 5));
        delbtn = new JButton("Delete");
        buttonsPanel.add(delbtn);
        delbtn.addActionListener(this);

        viewbtn = new JButton("View");
        buttonsPanel.add(viewbtn);
        viewbtn.addActionListener(this);

        backbtn = new JButton("Back");
        buttonsPanel.add(backbtn);
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home home = new Home();
                f.dispose();
            }
        });
        f.add(buttonsPanel);

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Delete")) {
            Object rollNo = 0;
            int selectedRowIndex = viewTable.getSelectedRow();
            if (selectedRowIndex == -1) {
                JOptionPane.showMessageDialog(null, "Nothing is selected", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                rollNo = viewTable.getValueAt(selectedRowIndex, 0);
            }
            Boolean del = false;
            String adminPwd = JOptionPane.showInputDialog(null, "Enter Admin Password.", "Alert",
                    JOptionPane.WARNING_MESSAGE);
            if (adminPwd.equals("123")) {
                int yes = JOptionPane.showConfirmDialog(null, "Are you sure", "Warning",
                        JOptionPane.WARNING_MESSAGE);

                if (yes == JOptionPane.YES_OPTION) {
                    if (DBHandler.deleteStudent(rollNo.toString())) {
                        JOptionPane.showMessageDialog(null, "Successfully Deleted.", "Alert",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error", "Alert", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong password", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Search")) {
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            java.util.List<Object[]> studentData = DBHandler.searchStudents(searchtf.getText());
            for (Object[] objArray : studentData) {
                tableModel.addRow(objArray);
            }
        }
        if (e.getActionCommand().equals("View")) {
            // Object rollNo = viewTable.getValueAt(selectedRowIndex, 0);
            Object rollNo = null;
            int selectedRowIndex = viewTable.getSelectedRow();
            if (selectedRowIndex == -1) {
                JOptionPane.showMessageDialog(null, "Nothing is selected", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                rollNo = viewTable.getValueAt(selectedRowIndex, 0);
            }
            // System.out.println(rollNo);

            ViewCard card = new ViewCard(rollNo);
        }

    }
}
