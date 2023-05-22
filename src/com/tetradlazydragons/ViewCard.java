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
import java.util.Date;

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
    JTextArea sname, sdob, sphone, semail, sgender, fname, mname, gphone, spreadd, spermadd, reg, roll, batch, dept,
            course;

    JButton backbtn, printbtn, updatebtn;

    JPanel buttonsPanel;

    JFrame f = new JFrame("View Student");

    ViewCard(Object rollNo) {

        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // MenuBar menu = new MenuBar();
        // f.setJMenuBar(menu.createMenuBar());
        System.out.println(rollNo);

        Object[] studentData = DBHandler.viewStudent(rollNo.toString());

        head = new JLabel("STUDENT DETAILS");
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setBounds(200, 20, 600, 40);
        f.add(head);

        rollNolabel = new JLabel("Roll No. : ");
        namelabel = new JLabel("Name : ");
        doblabel = new JLabel("Date of Birth : ");
        phonelabel = new JLabel("Phone No : ");
        emaillabel = new JLabel("Email : ");
        genderlabel = new JLabel("Gender : ");
        fatherlabel = new JLabel("Father's Name : ");
        motherlabel = new JLabel("Mother's Name : ");
        gphonelabel = new JLabel("Guardian Phone No : ");

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Courier", Font.BOLD, 20));
        presaddrlabel = new JLabel("Present Address : ");
        permaddrlabel = new JLabel("Permanent Address : ");

        photolabel = new JLabel("Passport Photo : ");

        BufferedImage img = DBHandler.viewImage(rollNo.toString());
        ImageIcon icon;
        if (img != null) {
            icon = new ImageIcon(img);
        } else {
            icon = new ImageIcon("assets/icons/user.jpeg");
        }
        piclabel = new JLabel(icon);
        courseheaderlabel = new JLabel("Course Details");
        courseheaderlabel.setFont(new Font("Courier", Font.BOLD, 20));

        reglabel = new JLabel("Registration No : ");
        batchlabel = new JLabel("Batch : ");
        deptlabel = new JLabel("Department : ");
        courselabel = new JLabel("Course : ");
        rollNolabel.setBounds(50, 90, 1500, 15);
        f.add(rollNolabel);
        namelabel.setBounds(50, 110, 150, 15);
        f.add(namelabel);
        doblabel.setBounds(50, 130, 260, 15);
        f.add(doblabel);
        phonelabel.setBounds(50, 150, 260, 15);
        f.add(phonelabel);
        emaillabel.setBounds(50, 170, 260, 15);
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

        photolabel.setBounds(420, 100, 260, 15);
        f.add(photolabel);
        piclabel.setBounds(420, 120, 260, 140);

        f.add(piclabel);
        courseheaderlabel.setBounds(420, 280, 250, 30);
        f.add(courseheaderlabel);
        reglabel.setBounds(420, 320, 150, 15);
        f.add(reglabel);
        batchlabel.setBounds(420, 340, 150, 15);
        f.add(batchlabel);
        deptlabel.setBounds(420, 360, 150, 15);
        f.add(deptlabel);
        courselabel.setBounds(420, 380, 150, 15);
        f.add(courselabel);

        roll = new JTextArea(rollNo.toString());
        roll.setOpaque(false);
        roll.setBounds(200, 90, 170, 15);
        roll.setEditable(false);
        f.add(roll);
        String studname = studentData[2].toString();
        sname = new JTextArea(studname);
        sname.setOpaque(false);
        sname.setBounds(200, 110, 170, 15);
        sname.setEditable(false);
        f.add(sname);
        String studdob = studentData[3].toString();
        sdob = new JTextArea(studdob);
        sdob.setOpaque(false);
        sdob.setBounds(200, 130, 170, 15);
        sdob.setEditable(false);
        f.add(sdob);
        String studph = studentData[4].toString();
        sphone = new JTextArea(studph);
        sphone.setOpaque(false);
        sphone.setBounds(200, 150, 170, 15);
        sphone.setEditable(false);
        f.add(sphone);
        String studemail = studentData[5].toString();
        semail = new JTextArea(studemail);
        semail.setOpaque(false);
        semail.setBounds(200, 170, 170, 25);
        semail.setLineWrap(true);
        semail.setWrapStyleWord(true);
        semail.setEditable(false);
        f.add(semail);
        String studgen = studentData[6].toString();
        sgender = new JTextArea(studgen);
        sgender.setOpaque(false);
        sgender.setBounds(200, 200, 170, 15);
        sgender.setEditable(false);
        f.add(sgender);
        String studfname = studentData[9].toString();
        fname = new JTextArea(studfname);
        fname.setOpaque(false);
        fname.setBounds(200, 220, 170, 15);
        fname.setEditable(false);
        f.add(fname);
        String studmname = studentData[10].toString();
        mname = new JTextArea(studmname);
        mname.setOpaque(false);
        mname.setBounds(200, 240, 170, 15);
        mname.setEditable(false);
        f.add(mname);
        String studgph = studentData[11].toString();
        gphone = new JTextArea(studgph);
        gphone.setOpaque(false);
        gphone.setBounds(200, 260, 170, 15);
        gphone.setEditable(false);
        f.add(gphone);

        String studpreadd = studentData[7].toString();
        spreadd = new JTextArea(studpreadd);
        spreadd.setOpaque(false);
        spreadd.setLineWrap(true);
        spreadd.setWrapStyleWord(true);
        spreadd.setBounds(200, 320, 170, 35);
        spreadd.setEditable(false);
        f.add(spreadd);
        String studperadd = studentData[12].toString();
        spermadd = new JTextArea(studperadd);
        spermadd.setOpaque(false);
        spermadd.setLineWrap(true);
        spermadd.setWrapStyleWord(true);
        spermadd.setBounds(200, 360, 170, 35);
        spermadd.setEditable(false);
        f.add(spermadd);

        String studreg = studentData[8].toString();
        reg = new JTextArea(studreg);
        reg.setOpaque(false);
        reg.setBounds(570, 320, 170, 15);
        reg.setEditable(false);
        f.add(reg);
        String studbatch = studentData[14].toString();
        batch = new JTextArea(studbatch);
        batch.setOpaque(false);
        batch.setBounds(570, 340, 170, 15);
        batch.setEditable(false);
        f.add(batch);
        String studdept = studentData[15].toString();
        dept = new JTextArea(studdept);
        dept.setOpaque(false);
        dept.setBounds(570, 360, 170, 15);
        dept.setEditable(false);
        f.add(dept);
        String studdeg = studentData[13].toString();
        course = new JTextArea(studdeg + " " + studdept);
        course.setOpaque(false);
        course.setBounds(570, 380, 170, 15);
        course.setEditable(false);
        f.add(course);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(250, 500, 300, 40);
        buttonsPanel.setLayout(new GridLayout(1, 3, 20, 5));
        backbtn = new JButton("Cancel");
        buttonsPanel.add(backbtn);
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        printbtn = new JButton("Print");
        buttonsPanel.add(printbtn);
        printbtn.addActionListener(this);

        updatebtn = new JButton("Update");
        buttonsPanel.add(updatebtn);
        updatebtn.addActionListener(this);

        f.add(buttonsPanel);
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {
            f.dispose();

            new UpdateForm();
            Object[] studentData = DBHandler.viewStudent(roll.getText());
            String[] presAddr = studentData[7].toString().split(",\\s*");
            String[] permAddr = studentData[12].toString().split(",\\s*");

            UpdateForm.sname.setText(studentData[2].toString());
            // UpdateForm.model.setDate(studentData[3].toString());

            UpdateForm.sphone.setText(studentData[4].toString());
            UpdateForm.semail.setText(studentData[5].toString());
            UpdateForm.fname.setText(studentData[9].toString());
            UpdateForm.mname.setText(studentData[10].toString());
            UpdateForm.gphone.setText(studentData[11].toString());
            UpdateForm.spresst.setText(presAddr[0].trim());
            UpdateForm.spresdist.setText(presAddr[1].trim());
            UpdateForm.presstatecombo.setSelectedItem(presAddr[2].trim());
            UpdateForm.sprespin.setText(presAddr[3].trim());
            UpdateForm.spermst.setText(permAddr[0].trim());
            UpdateForm.spermdist.setText(permAddr[1].trim());
            UpdateForm.permstatecombo.setSelectedItem(permAddr[2].trim());
            UpdateForm.spermpin.setText(permAddr[3].trim());
            UpdateForm.reg.setText(studentData[8].toString());
            UpdateForm.batch.setText(studentData[14].toString());

            UpdateForm.deptComboBox.setSelectedItem(studentData[15].toString());
            System.out.print(studentData[13].toString());
            UpdateForm.course.setText(studentData[13].toString() + " " + studentData[15].toString());
            // Date dob = (Date) studentData[3];
            UpdateForm.date.setText(studentData[3].toString());
            // UpdateForm.datePicker.getModel().setValue(dob);
            // UpdateForm.datePicker.getModel().setDate(1999, 01, 02);
            // UpdateForm.datePicker.getModel().setSelected(true);

            if (studentData[6].toString().equals("Male")) {
                UpdateForm.maleradio.setSelected(true);
            } else if (studentData[6].toString().equals("Female")) {
                UpdateForm.femaleradio.setSelected(true);
            } else {
                UpdateForm.genderfradio.setSelected(true);
            }
            // System.out.print(studentData[6].toString());

            UpdateForm.roll.setText(studentData[1].toString());
            // UpdateForm.courseComboBox.setSelectedItem(studentData[16].toString());

            BufferedImage img = DBHandler.viewImage(roll.getText());
            ImageIcon icon = new ImageIcon(img);
            UpdateForm.piclabel = new JLabel(icon);
        }
        if (e.getActionCommand().equals("Cancel")) {
            f.dispose();
        }
    }

}
