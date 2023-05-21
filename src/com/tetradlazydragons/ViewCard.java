package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.text.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.cj.jdbc.Blob;

import java.sql.*;
import java.sql.DriverManager;

public class ViewCard implements ActionListener {
    JLabel head, rollNolabel, namelabel, doblabel, phonelabel, emaillabel, genderlabel, photolabel, piclabel,
            presaddrlabel, permaddrlabel,
            fatherlabel, motherlabel, gphonelabel, courseheaderlabel, reglabel, deptlabel, batchlabel, courselabel,
            addressLabel;
    JButton backbtn, printbtn;

    JPanel f, leftPanel, rightPanel, buttonsPanel;

    ViewCard(Object rollNo) {

        JFrame f = new JFrame("View Student");
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // MenuBar menu = new MenuBar();
        // f.setJMenuBar(menu.createMenuBar());
        System.out.println(rollNo);

        Object[] studentData = DBHandler.viewStudent(rollNo.toString());
        for (Object objArray : studentData) {
            System.out.println(objArray);
        }

        head = new JLabel("STUDENT DETAILS");
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setBounds(250, 20, 600, 40);
        f.add(head);

        rollNolabel = new JLabel("Roll No. : " + rollNo.toString());
        namelabel = new JLabel("Name : " + studentData[2]);
        doblabel = new JLabel("Date of Birth : " + studentData[3]);
        phonelabel = new JLabel("Phone No : " + studentData[4]);
        emaillabel = new JLabel("Email : " + studentData[5]);
        genderlabel = new JLabel("Gender : " + studentData[6]);
        fatherlabel = new JLabel("Father's Name : " + studentData[9]);
        motherlabel = new JLabel("Mother's Name : " + studentData[10]);
        gphonelabel = new JLabel("Guardian Phone No : " + studentData[11]);
        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Courier", Font.BOLD, 20));
        presaddrlabel = new JLabel("Present Address : " + studentData[7]);
        permaddrlabel = new JLabel("Permanent Address : " + studentData[12]);

        // piclabel.setIcon(new ImageIcon(studentData[16]));
        BufferedImage img = DBHandler.viewImage(rollNo.toString());
        ImageIcon icon;
        if (img != null) {
            icon = new ImageIcon(img);
        } else {
            icon = new ImageIcon("assets/icons/user.png");
        }
        piclabel = new JLabel(icon);
        courseheaderlabel = new JLabel("Course Details");
        courseheaderlabel.setFont(new Font("Courier", Font.BOLD, 20));
        reglabel = new JLabel("Registration No : " + studentData[8]);
        batchlabel = new JLabel("Batch : " + studentData[14]);
        deptlabel = new JLabel("Course : " + studentData[13] + " " + studentData[15]);

        namelabel.setBounds(50, 100, 260, 10);
        f.add(namelabel);
        doblabel.setBounds(50, 120, 260, 10);
        f.add(doblabel);
        phonelabel.setBounds(50, 140, 260, 10);
        f.add(phonelabel);
        emaillabel.setBounds(50, 160, 260, 10);
        f.add(emaillabel);
        genderlabel.setBounds(50, 180, 260, 10);
        f.add(genderlabel);
        fatherlabel.setBounds(50, 200, 260, 10);
        f.add(fatherlabel);
        motherlabel.setBounds(50, 220, 260, 10);
        f.add(motherlabel);
        gphonelabel.setBounds(50, 240, 260, 10);
        f.add(gphonelabel);
        addressLabel.setBounds(50, 260, 260, 30);
        f.add(addressLabel);
        presaddrlabel.setBounds(50, 300, 260, 20);
        f.add(presaddrlabel);
        permaddrlabel.setBounds(50, 340, 300, 20);
        f.add(permaddrlabel);

        piclabel.setBounds(350, 120, 260, 120);
        f.add(piclabel);
        courseheaderlabel.setBounds(400, 260, 260, 30);
        f.add(courseheaderlabel);
        reglabel.setBounds(400, 300, 260, 10);
        f.add(reglabel);
        batchlabel.setBounds(400, 320, 260, 10);
        f.add(batchlabel);
        deptlabel.setBounds(400, 340, 260, 10);
        f.add(deptlabel);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(250, 500, 300, 40);
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
