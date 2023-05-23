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

    JPanel buttonsPanel,viewPanel;
    String bgcolor = "#1F2E54", bgcolor2 = "#ACB1D6", bgcolor3 = "#212A3E" ;

    JFrame f = new JFrame("View Student");
   

    ViewCard(Object rollNo) {    
        f.getContentPane().setBackground(Color.decode(bgcolor2));

        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // MenuBar menu = new MenuBar();
        // f.setJMenuBar(menu.createMenuBar());
        System.out.println(rollNo);

        Object[] studentData = DBHandler.viewStudent(rollNo.toString());

        head = new JLabel("STUDENT DETAILS");
        head.setFont(new Font("Courier", Font.BOLD, 40));
        head.setForeground(Color.decode(bgcolor));
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

        photolabel = new JLabel("Student Photo : ");

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
        rollNolabel.setBounds(50, 90, 120, 15);
        rollNolabel.setForeground(Color.decode(bgcolor));
        f.add(rollNolabel);
        namelabel.setBounds(50, 110, 120, 15);
        namelabel.setForeground(Color.decode(bgcolor));
        f.add(namelabel);
        doblabel.setBounds(50, 130, 120, 15);
        doblabel.setForeground(Color.decode(bgcolor));
        f.add(doblabel);
        phonelabel.setBounds(50, 150, 120, 15);
        phonelabel.setForeground(Color.decode(bgcolor));
        f.add(phonelabel);
        emaillabel.setBounds(50, 170, 120, 15);
        emaillabel.setForeground(Color.decode(bgcolor));
        f.add(emaillabel);
        genderlabel.setBounds(50, 210, 120, 15);
        genderlabel.setForeground(Color.decode(bgcolor));
        f.add(genderlabel);
        fatherlabel.setBounds(50, 230, 120, 15);
        fatherlabel.setForeground(Color.decode(bgcolor));
        f.add(fatherlabel);
        motherlabel.setBounds(50, 250, 120, 15);
        motherlabel.setForeground(Color.decode(bgcolor));
        f.add(motherlabel);
        gphonelabel.setBounds(50, 270, 140, 15);
        gphonelabel.setForeground(Color.decode(bgcolor));
        f.add(gphonelabel);

        addressLabel.setBounds(50, 290, 250, 30);
        addressLabel.setForeground(Color.decode(bgcolor));
        f.add(addressLabel);
        presaddrlabel.setBounds(50, 330, 140, 15);
        presaddrlabel.setForeground(Color.decode(bgcolor));
        f.add(presaddrlabel);
        permaddrlabel.setBounds(50, 370, 140, 15);
        permaddrlabel.setForeground(Color.decode(bgcolor));
        f.add(permaddrlabel);

        photolabel.setBounds(420, 100, 260, 15);
        photolabel.setForeground(Color.decode(bgcolor));
        f.add(photolabel);
        piclabel.setBounds(420, 120, 150, 150);
        f.add(piclabel);

        courseheaderlabel.setBounds(420, 290, 250, 30);
        courseheaderlabel.setForeground(Color.decode(bgcolor));
        f.add(courseheaderlabel);
        reglabel.setBounds(420, 330, 120, 15);
        reglabel.setForeground(Color.decode(bgcolor));
        f.add(reglabel);
        batchlabel.setBounds(420, 350, 120, 15);
        batchlabel.setForeground(Color.decode(bgcolor));
        f.add(batchlabel);
        deptlabel.setBounds(420, 370, 120, 15);
        deptlabel.setForeground(Color.decode(bgcolor));
        f.add(deptlabel);
        courselabel.setBounds(420, 390, 120, 15);
        courselabel.setForeground(Color.decode(bgcolor));
        f.add(courselabel);

        roll = new JTextArea(rollNo.toString());
        roll.setForeground(Color.decode(bgcolor3));
        roll.setOpaque(false);
        roll.setBounds(180, 90, 170, 15);
        roll.setEditable(false);
        f.add(roll);
        String studname = studentData[2].toString();
        sname = new JTextArea(studname);
        sname.setForeground(Color.decode(bgcolor3));
        sname.setOpaque(false);
        sname.setBounds(180, 110, 170, 15);
        sname.setEditable(false);
        f.add(sname);
        String studdob = studentData[3].toString();
        sdob = new JTextArea(studdob);
        sdob.setForeground(Color.decode(bgcolor3));
        sdob.setOpaque(false);
        sdob.setBounds(180, 130, 170, 15);
        sdob.setEditable(false);
        f.add(sdob);
        String studph = studentData[4].toString();
        sphone = new JTextArea(studph);
        sphone.setForeground(Color.decode(bgcolor3));
        sphone.setOpaque(false);
        sphone.setBounds(180, 150, 170, 15);
        sphone.setEditable(false);
        f.add(sphone);
        String studemail = studentData[5].toString();
        semail = new JTextArea(studemail);
        semail.setForeground(Color.decode(bgcolor3));
        semail.setOpaque(false);
        semail.setBounds(180, 170, 170, 30);
        semail.setLineWrap(true);
        semail.setWrapStyleWord(true);
        semail.setEditable(false);
        f.add(semail);
        String studgen = studentData[6].toString();
        sgender = new JTextArea(studgen);
        sgender.setForeground(Color.decode(bgcolor3));
        sgender.setOpaque(false);
        sgender.setBounds(180, 210, 170, 15);
        sgender.setEditable(false);
        f.add(sgender);
        String studfname = studentData[9].toString();
        fname = new JTextArea(studfname);
        fname.setForeground(Color.decode(bgcolor3));
        fname.setOpaque(false);
        fname.setBounds(180, 230, 170, 15);
        fname.setEditable(false);
        f.add(fname);
        String studmname = studentData[10].toString();
        mname = new JTextArea(studmname);
        mname.setForeground(Color.decode(bgcolor3));
        mname.setOpaque(false);
        mname.setBounds(180, 250, 170, 15);
        mname.setEditable(false);
        f.add(mname);
        String studgph = studentData[11].toString();
        gphone = new JTextArea(studgph);
        gphone.setForeground(Color.decode(bgcolor3));
        gphone.setOpaque(false);
        gphone.setBounds(180, 270, 170, 15);
        gphone.setEditable(false);
        f.add(gphone);

        String studpreadd = studentData[7].toString();
        spreadd = new JTextArea(studpreadd);
        spreadd.setForeground(Color.decode(bgcolor3));
        spreadd.setOpaque(false);
        spreadd.setLineWrap(true);
        spreadd.setWrapStyleWord(true);
        spreadd.setBounds(180, 330, 170, 35);
        spreadd.setEditable(false);
        f.add(spreadd);
        String studperadd = studentData[12].toString();
        spermadd = new JTextArea(studperadd);
        spermadd.setForeground(Color.decode(bgcolor3));
        spermadd.setOpaque(false);
        spermadd.setLineWrap(true);
        spermadd.setWrapStyleWord(true);
        spermadd.setBounds(180, 370, 170, 35);
        spermadd.setEditable(false);
        f.add(spermadd);

        String studreg = studentData[8].toString();
        reg = new JTextArea(studreg);
        reg.setForeground(Color.decode(bgcolor3));
        reg.setOpaque(false);
        reg.setBounds(550, 330, 170, 15);
        reg.setEditable(false);
        f.add(reg);
        String studbatch = studentData[14].toString();
        batch = new JTextArea(studbatch);
        batch.setForeground(Color.decode(bgcolor3));
        batch.setOpaque(false);
        batch.setBounds(550, 350, 170, 15);
        batch.setEditable(false);
        f.add(batch);
        String studdept = studentData[15].toString();
        dept = new JTextArea(studdept);
        dept.setForeground(Color.decode(bgcolor3));
        dept.setOpaque(false);
        dept.setBounds(550, 370, 170, 15);
        dept.setEditable(false);
        f.add(dept);
        String studdeg = studentData[13].toString();
        course = new JTextArea(studdeg + " " + studdept);
        course.setForeground(Color.decode(bgcolor3));
        course.setOpaque(false);
        course.setBounds(550, 390, 170, 15);
        course.setEditable(false);
        f.add(course);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(250, 450, 300, 40);
        buttonsPanel.setBackground(Color.decode(bgcolor2));
        buttonsPanel.setLayout(new GridLayout(1, 3, 20, 5));
        backbtn = new JButton("Cancel");
        backbtn.setForeground(Color.WHITE);
        backbtn.setBackground(Color.decode("#1F2E54"));
        backbtn.setBorderPainted(false);
        backbtn.setOpaque(true);
        buttonsPanel.add(backbtn);
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        printbtn = new JButton("Print");
        printbtn.setForeground(Color.WHITE);
        printbtn.setBackground(Color.decode("#1F2E54"));
        printbtn.setBorderPainted(false);
        printbtn.setOpaque(true);
        buttonsPanel.add(printbtn);
        printbtn.addActionListener(this);

        updatebtn = new JButton("Update");
        updatebtn.setForeground(Color.WHITE);
        updatebtn.setBackground(Color.decode("#1F2E54"));
        updatebtn.setBorderPainted(false);
        updatebtn.setOpaque(true);
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
