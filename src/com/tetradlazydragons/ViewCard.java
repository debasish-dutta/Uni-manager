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

    JLabel head, rollNolabel, namelabel, doblabel, phonelabel, emaillabel, genderlabel, photolabel, piclabel, presaddrlabel, permaddrlabel,
           fatherlabel, motherlabel, gphonelabel, courseheaderlabel, reglabel, deptlabel, batchlabel, courselabel, addressLabel;
    JTextArea sname, sdob, sphone, semail,sgender, fname, mname, gphone, spreadd, spermadd, reg, roll, batch, dept, course;       

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

        rollNolabel = new JLabel("Roll No. : " );
        namelabel = new JLabel("Name : ");
        doblabel = new JLabel("Date of Birth : " );
        phonelabel = new JLabel("Phone No : ");
        emaillabel = new JLabel("Email : " );
        genderlabel = new JLabel("Gender : " );
        fatherlabel = new JLabel("Father's Name : " );
        motherlabel = new JLabel("Mother's Name : " );
        gphonelabel = new JLabel("Guardian Phone No : " );

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Courier", Font.BOLD, 20));
        presaddrlabel = new JLabel("Present Address : " );
        permaddrlabel = new JLabel("Permanent Address : " );


        photolabel = new JLabel("Passport Photo : ");

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

        reglabel = new JLabel("Registration No : ");
        batchlabel = new JLabel("Batch : ");
        deptlabel = new JLabel("Department : ");
        courselabel = new JLabel("Course : ");
        rollNolabel.setBounds(50, 100, 1500, 15);
        f.add(rollNolabel);
        namelabel.setBounds(50, 120, 150, 15);
        f.add(namelabel);
        doblabel.setBounds(50, 140, 260, 15);
        f.add(doblabel);
        phonelabel.setBounds(50, 160, 260, 15);
        f.add(phonelabel);
        emaillabel.setBounds(50, 180, 260, 15);
        f.add(emaillabel);
        genderlabel.setBounds(50, 200, 260, 15);
        f.add(genderlabel);
        fatherlabel.setBounds(50, 220, 260, 15);
        f.add(fatherlabel);
        motherlabel.setBounds(50, 240, 260, 15);
        f.add(motherlabel);
        gphonelabel.setBounds(50, 260, 260, 15);
        f.add(gphonelabel);
        addressLabel.setBounds(50, 280, 260, 30);
        f.add(addressLabel);
        presaddrlabel.setBounds(50, 320, 260, 20);
        f.add(presaddrlabel);
        permaddrlabel.setBounds(50, 360, 300, 20);
        f.add(permaddrlabel);

        photolabel.setBounds(400, 100, 260, 15);
        f.add(photolabel);
        piclabel.setBounds(350, 120, 260, 140);

        f.add(piclabel);
        courseheaderlabel.setBounds(400, 280, 150, 30);
        f.add(courseheaderlabel);
        reglabel.setBounds(400, 320, 150, 15);
        f.add(reglabel);
        batchlabel.setBounds(400, 340, 150, 15);
        f.add(batchlabel);
        deptlabel.setBounds(400, 360, 150, 15);
        f.add(deptlabel);

        courselabel.setBounds(400, 380, 150, 15);
        f.add(courselabel);

        roll = new JTextArea(rollNo.toString());
        roll.setBounds(200, 100, 150, 15);
        roll.setEditable(false);
        f.add(roll);
        String studname = studentData[2].toString();
        sname = new JTextArea(studname);
        sname.setBounds(200, 120, 150, 15);
        sname.setEditable(false);
        f.add(sname);
        String studdob = studentData[3].toString();
        sdob = new JTextArea(studdob);
        sdob.setBounds(200, 140, 150, 15);
        sdob.setEditable(false);
        f.add(sdob);
        String studph = studentData[4].toString();
        sphone = new JTextArea(studph);
        sphone.setBounds(200, 160, 150, 15);
        sphone.setEditable(false);
        f.add(sphone);
        String studemail = studentData[5].toString();
        semail = new JTextArea(studemail);
        semail.setBounds(200, 180, 150, 15);
        semail.setEditable(false);
        f.add(semail);
        String studgen = studentData[6].toString();
        sgender = new JTextArea(studgen);
        sgender.setBounds(200, 200, 150, 15);
        sgender.setEditable(false);
        f.add(sgender);
        String studfname = studentData[9].toString();
        fname = new JTextArea(studfname);
        fname.setBounds(200, 220, 150, 15);
        fname.setEditable(false);
        f.add(fname);
        String studmname = studentData[10].toString();
        mname = new JTextArea(studmname);
        mname.setBounds(200, 240, 150, 15);
        mname.setEditable(false);
        f.add(mname);
        String studgph = studentData[11].toString();
        gphone = new JTextArea(studgph);
        gphone.setBounds(200, 260, 150, 15);
        gphone.setEditable(false);
        f.add(gphone);

        String studpreadd = studentData[7].toString();
        spreadd = new JTextArea(studpreadd);
        spreadd.setBounds(200, 320, 150, 40);
        spreadd.setEditable(false);
        f.add(spreadd);
        String studperadd = studentData[12].toString();
        spermadd = new JTextArea(studperadd);
        spermadd.setBounds(200, 360, 150, 40);
        spermadd.setEditable(false);
        f.add(spermadd);

        String studreg = studentData[8].toString();
        reg = new JTextArea(studreg);
        reg.setBounds(550, 320, 150, 15);
        reg.setEditable(false);
        f.add(reg);
        String studbatch = studentData[14].toString();
        batch = new JTextArea(studbatch);
        batch.setBounds(550, 340, 150, 15);
        batch.setEditable(false);
        f.add(batch);
        String studdept = studentData[15].toString();
        dept = new JTextArea(studdept);
        dept.setBounds(550, 360, 150, 15);
        dept.setEditable(false);
        f.add(dept);
        String studdeg = studentData[13].toString();
        course = new JTextArea(studdeg + " " + studdept);
        course.setBounds(550, 380, 150, 15);
        course.setEditable(false);
        f.add(course);


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
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {

        }
        if (e.getActionCommand().equals("Cancel")) {

        }
    }

}
