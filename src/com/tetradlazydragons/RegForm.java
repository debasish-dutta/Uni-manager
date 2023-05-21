package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.sql.*;
import java.sql.DriverManager;

public class RegForm implements ActionListener {
        JLabel head, namelabel, doblabel, phonelabel, emaillabel, genderlabel, photolabel, piclabel, presaddrlabel,
                        permaddrlabel,
                        fatherlabel, motherlabel, gphonelabel, presstlabel, presdistlabel, presstatlabel, prespinlabel,
                        permstlabel,
                        permdistlabel, permstatlabel, permpinlabel, courseheaderlabel, reglabel, rolllabel, deptlabel,
                        batchlabel,
                        courselabel;
        static JTextField sname, sdob, sphone, semail, fname, mname, gphone, spresst, spresdist, sprespin, spermst,
                        spermdist,
                        spermpin, reg, roll,
                        batch;
        static JRadioButton maleradio, femaleradio, genderfradio;
        static JComboBox<String> presstatecombo, permstatecombo;
        static JComboBox<String> deptComboBox, courseComboBox;
        JButton submitbtn, clearbtn, backbtn;
        JDatePanelImpl datePanel;
        static JDatePickerImpl datePicker;
        JButton uploadPic;
        static File photoFile;
        static String filename;
        Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();
        Connection con = null;
        PreparedStatement pst = null;

        JFrame f = new JFrame("Registration Form");
        JPanel studentPanel, picPanel, addressPanel, coursePanel;

        RegForm() {

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MenuBar menu = new MenuBar();
                f.setJMenuBar(menu.createMenuBar());

                head = new JLabel("NEW STUDENT REGISTRATION ");
                head.setFont(new Font("Courier", Font.BOLD, 30));
                head.setBounds(400, 20, 600, 30);
                f.add(head);

                studentPanel = new JPanel();
                Border blackline = BorderFactory.createTitledBorder("Student Details:");
                studentPanel.setBounds(20, 60, 940, 200);
                studentPanel.setBorder(blackline);

                namelabel = new JLabel("Name:");
                namelabel.setBounds(50, 100, 150, 20);
                sname = new JTextField();
                sname.setBounds(200, 100, 250, 20);
                f.add(namelabel);
                f.add(sname);

                doblabel = new JLabel("DOB:");
                doblabel.setBounds(50, 130, 150, 20);
                // sdob = new JTextField();
                // sdob.setBounds(200, 130, 200, 20);
                f.add(doblabel);
                // f.add(sdob);

                /* Adding JDatePicker date picker */
                UtilDateModel model = new UtilDateModel();
                // model.setDate(1999, 01, 02);
                // model.setSelected(true);
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                datePanel = new JDatePanelImpl(model, p);
                datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                datePicker.setBounds(200, 130, 250, 20);
                f.add(datePicker);
                /* End Date picker */

                phonelabel = new JLabel("Phone No:");
                phonelabel.setBounds(50, 160, 150, 20);
                sphone = new JTextField();
                sphone.setBounds(200, 160, 250, 20);
                f.add(phonelabel);
                f.add(sphone);

                emaillabel = new JLabel("Email:");
                emaillabel.setBounds(50, 190, 150, 20);
                semail = new JTextField();
                semail.setBounds(200, 190, 250, 20);
                f.add(emaillabel);
                f.add(semail);

                genderlabel = new JLabel("Gender:");
                genderlabel.setBounds(50, 220, 150, 20);
                maleradio = new JRadioButton(" Male");
                maleradio.setBounds(190, 220, 100, 20);
                femaleradio = new JRadioButton(" Female");
                femaleradio.setBounds(260, 220, 100, 20);
                genderfradio = new JRadioButton(" Gender-fluid");
                genderfradio.setBounds(340, 220, 150, 20);
                f.add(genderlabel);
                f.add(maleradio);
                f.add(femaleradio);
                f.add(genderfradio);
                ButtonGroup bg = new ButtonGroup();
                bg.add(maleradio);
                bg.add(femaleradio);
                bg.add(genderfradio);

                fatherlabel = new JLabel("Father's Name:");
                fatherlabel.setBounds(500, 100, 150, 20);
                fname = new JTextField();
                fname.setBounds(700, 100, 250, 20);
                f.add(fatherlabel);
                f.add(fname);

                motherlabel = new JLabel("Mother's Name:");
                motherlabel.setBounds(500, 130, 150, 20);
                mname = new JTextField();
                mname.setBounds(700, 130, 250, 20);
                f.add(motherlabel);
                f.add(mname);

                gphonelabel = new JLabel("Guardian's Phone No:");
                gphonelabel.setBounds(500, 160, 150, 20);
                gphone = new JTextField();
                gphone.setBounds(700, 160, 250, 20);
                f.add(gphonelabel);
                f.add(gphone);

                photolabel = new JLabel("Photo");
                photolabel.setBounds(1040, 60, 150, 20);
                piclabel = new JLabel();
                piclabel.setBounds(1000, 80, 150, 150);
                uploadPic = new JButton("Upload");
                uploadPic.setBounds(1020, 235, 100, 20);
                f.add(photolabel);
                f.add(piclabel);
                f.add(uploadPic);
                uploadPic.addActionListener(this);

                addressPanel = new JPanel();
                Border blackline2 = BorderFactory.createTitledBorder("Address Details:");
                addressPanel.setBounds(20, 270, 1140, 150);
                addressPanel.setBorder(blackline2);

                presaddrlabel = new JLabel("Present Address:");
                presaddrlabel.setBounds(100, 280, 150, 20);
                f.add(presaddrlabel);

                presstlabel = new JLabel("Street:");
                presstlabel.setBounds(100, 305, 150, 20);
                spresst = new JTextField();
                spresst.setBounds(250, 305, 250, 20);
                f.add(presstlabel);
                f.add(spresst);

                presdistlabel = new JLabel("District:");
                presdistlabel.setBounds(100, 330, 150, 20);
                spresdist = new JTextField();
                spresdist.setBounds(250, 330, 250, 20);
                f.add(presdistlabel);
                f.add(spresdist);

                prespinlabel = new JLabel("Pin:");
                prespinlabel.setBounds(100, 380, 150, 20);
                sprespin = new JTextField();
                sprespin.setBounds(250, 380, 250, 20);
                f.add(prespinlabel);
                f.add(sprespin);

                presstatlabel = new JLabel("State:");
                presstatlabel.setBounds(100, 355, 150, 20);
                String states[] = { "Select State", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
                                "Chhattisgarh",
                                "Goa", "Gujarat",
                                "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerela",
                                "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
                                "Odisha", "Punjab",
                                "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana", "Tripura", "Uttar Pradesh",
                                "Uttrakhand",
                                "West Bengal" };

                presstatecombo = new JComboBox(states);
                presstatecombo.setBounds(250, 355, 250, 20);
                f.add(presstatlabel);
                f.add(presstatecombo);

                permaddrlabel = new JLabel("Permanent Address:");
                permaddrlabel.setBounds(600, 280, 150, 20);
                f.add(permaddrlabel);

                permstlabel = new JLabel("Street:");
                permstlabel.setBounds(600, 305, 150, 20);
                spermst = new JTextField();
                spermst.setBounds(800, 305, 250, 20);
                f.add(permstlabel);
                f.add(spermst);

                permdistlabel = new JLabel("District:");
                permdistlabel.setBounds(600, 330, 150, 20);
                spermdist = new JTextField();
                spermdist.setBounds(800, 330, 250, 20);
                f.add(permdistlabel);
                f.add(spermdist);

                permstatlabel = new JLabel("State:");
                permstatlabel.setBounds(600, 355, 150, 20);
                permstatecombo = new JComboBox(states);
                permstatecombo.setBounds(800, 355, 250, 20);
                f.add(permstatlabel);
                f.add(permstatecombo);

                permpinlabel = new JLabel("Pin:");
                permpinlabel.setBounds(600, 380, 150, 20);
                spermpin = new JTextField();
                spermpin.setBounds(800, 380, 250, 20);
                f.add(permpinlabel);
                f.add(spermpin);

                coursePanel = new JPanel();
                Border blackline3 = BorderFactory.createTitledBorder("Course Details:");
                coursePanel.setBounds(20, 420, 1140, 150);
                coursePanel.setBorder(blackline3);

                reglabel = new JLabel("Registration No:");
                reglabel.setBounds(100, 455, 150, 20);
                reg = new JTextField();
                reg.setBounds(250, 455, 250, 20);
                f.add(reglabel);
                f.add(reg);

                rolllabel = new JLabel("Roll No:");
                rolllabel.setBounds(100, 480, 150, 20);
                roll = new JTextField();
                roll.setBounds(250, 480, 250, 20);
                f.add(rolllabel);
                f.add(roll);

                batchlabel = new JLabel("Batch:");
                batchlabel.setBounds(100, 505, 150, 20);
                batch = new JTextField();
                batch.setBounds(250, 505, 250, 20);
                f.add(batchlabel);
                f.add(batch);

                deptlabel = new JLabel("Department:");
                deptlabel.setBounds(600, 480, 150, 20);
                f.add(deptlabel);
                String[] dept = { "Select Department", "Arabic", "Assamese", "Bengali", "Bodo",
                                "Communication & Journalism",
                                "Economics", "Education", "English", "English Language Teaching", "Foreign Language",
                                "Hindi",
                                "History", "Library & Information Science", "Linguistics",
                                "Modern Indian Language & Literary Studies",
                                "Persian", "Philosophy", "Political Science", "Psycology", "Sanskrit", "Sociology",
                                "Women's Studies",

                                "Anthropology", "Botany", "Chemistry", "Environmental Science", "Geography",
                                "Geological Sciences",
                                "Mathematics",
                                "Physics", "Statistics", "Zoology",

                                "Biotechnology", "Computer Science", "Electronics & Communication Technology",
                                "Instrumentation and USIC",
                                "Electronics and Communication Engineering", "Applied Science",
                                "Information Technology",

                                "Commerce", "Business Administration", "Law" };
                deptComboBox = new JComboBox<String>(dept);
                deptComboBox.setBounds(800, 480, 250, 20);
                deptComboBox.addActionListener(this);

                deptComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
                f.add(deptComboBox);

                courselabel = new JLabel("Course:");
                courselabel.setBounds(600, 505, 150, 20);
                f.add(courselabel);
                courseComboBox = new JComboBox<String>();
                courseComboBox.setBounds(800, 505, 250, 20);
                courseComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
                f.add(courseComboBox);

                String[] subItems1 = { "Select Course", "B.A. Arabic", "M.A. Arabic" };
                subItems.put(dept[1], subItems1);
                String[] subItems2 = { "Select Course", "B.A. Assamese", "M.A. Assamese" };
                subItems.put(dept[2], subItems2);
                String[] subItems3 = { "Select Course", "B.A. Bengali", "M.A. Bengali" };
                subItems.put(dept[3], subItems3);
                String[] subItems4 = { "Select Course", "B.A. Bodo", "M.A. Bodo" };
                subItems.put(dept[4], subItems4);
                String[] subItems5 = { "Select Course", "B.A. Mass Communication", "M.A. Mass Communication" };
                subItems.put(dept[5], subItems5);
                String[] subItems6 = { "Select Course", "B.A. Economics", "M.A. Economics", "B.Sc. Economics",
                                "M.Sc. Economics" };
                subItems.put(dept[6], subItems6);
                String[] subItems7 = { "Select Course", "B.A. Education ", "M.A. Education", "B.Sc. Education",
                                "M.Sc. Education" };
                subItems.put(dept[7], subItems7);
                String[] subItems8 = { "Select Course", "B.A. English", "M.A. English" };
                subItems.put(dept[8], subItems8);
                String[] subItems9 = { "Select Course", "B.A. English Language & ELT", "M.A. English Language & ELT" };
                subItems.put(dept[9], subItems9);
                String[] subItems10 = { "Select Course", "B.A. European Studies", "M.A. European Studies" };
                subItems.put(dept[10], subItems10);
                String[] subItems11 = { "Select Course", "B.A. Hindi", "M.A. Hindi" };
                subItems.put(dept[11], subItems11);
                String[] subItems12 = { "Select Course", "B.A. History", "M.A. History" };
                subItems.put(dept[12], subItems12);
                String[] subItems13 = { "Select Course", "B.A. LISc.", "M.A. LISc." };
                subItems.put(dept[13], subItems13);
                String[] subItems14 = { "Select Course", "B.A. Linguistics", "M.A. Linguistics" };
                subItems.put(dept[14], subItems14);
                String[] subItems15 = { "Select Course", "B.A. Comparitive Indian Literature",
                                "M.A. Comparitive Indian Literature" };
                subItems.put(dept[15], subItems15);
                String[] subItems16 = { "Select Course", "B.A. Persian", "M.A. Persian" };
                subItems.put(dept[16], subItems16);
                String[] subItems17 = { "Select Course", "B.A. Philosophy", "M.A. Philosophy" };
                subItems.put(dept[17], subItems17);
                String[] subItems18 = { "Select Course", "B.A. Political Science", "M.A. Political Science" };
                subItems.put(dept[18], subItems18);
                String[] subItems19 = { "Select Course", "B.A. Psychology", "M.A. Psychology", "B.Sc. Psychology",
                                "M.Sc. Psychology" };
                subItems.put(dept[19], subItems19);
                String[] subItems20 = { "Select Course", "B.A. Sanskrit", "M.A. Sanskrit" };
                subItems.put(dept[20], subItems20);
                String[] subItems21 = { "Select Course", "B.A. Sociology", "M.A. Sociology" };
                subItems.put(dept[21], subItems21);
                String[] subItems22 = { "Select Course", "B.A. Women's Studies", "M.A. Women's Studies" };
                subItems.put(dept[22], subItems22);

                String[] subItems23 = { "Select Course", "B.A. Anthropology", "M.A. Anthropology", "B.Sc. Anthropology",
                                "M.Sc. Anthropology" };
                subItems.put(dept[23], subItems23);
                String[] subItems24 = { "Select Course", "B.Sc. Botany", "M.Sc. Botany", "B.Sc. Microbiology",
                                "M.Sc. Microbiology" };
                subItems.put(dept[24], subItems24);
                String[] subItems25 = { "Select Course", "B.Sc. Chemistry", "M.Sc. Chemistry" };
                subItems.put(dept[25], subItems25);
                String[] subItems26 = { "Select Course", "B.Sc. Environmental Science", "M.Sc. Environmental Science" };
                subItems.put(dept[26], subItems26);
                String[] subItems27 = { "Select Course", "B.A. Geography", "M.A. Geography", "B.Sc. Geography",
                                "M.Sc. Geography" };
                subItems.put(dept[27], subItems27);
                String[] subItems28 = { "Select Course", "B.Sc. Geology", "M.Sc. Geology" };
                subItems.put(dept[28], subItems28);
                String[] subItems29 = { "Select Course", "B.A. Mathematics", "M.A. Mathematics", "B.Sc. Mathematics",
                                "M.Sc. Mathematics" };
                subItems.put(dept[29], subItems29);
                String[] subItems30 = { "Select Course", "B.Sc. Physics", "M.Sc. Physics",
                                "M.Sc. Radiological Science" };
                subItems.put(dept[30], subItems30);
                String[] subItems31 = { "Select Course", "B.Sc. Statistics", "M.Sc. Statistics" };
                subItems.put(dept[31], subItems31);
                String[] subItems32 = { "Select Course", "B.Sc. Zoology", "M.Sc. Zoology", "B.Sc. Wildlife Science",
                                "M.Sc. Wildlife Science" };
                subItems.put(dept[32], subItems32);

                String[] subItems33 = { "Select Course", "B.Sc. Biotechnology", "M.Sc. Biotechnology" };
                subItems.put(dept[33], subItems33);
                String[] subItems34 = { "Select Course", "B.Sc. Computer Science", "M.Sc. Computer Science",
                                "B.Sc. Information Technology", "M.Sc. Information Technology" };
                subItems.put(dept[34], subItems34);
                String[] subItems35 = { "Select Course", "B.Sc. Electronics & Communication Technology",
                                "M.Sc. Electronics & Communication Technology",
                                "M.Sc. Micro Electronics and Advance Communication" };
                subItems.put(dept[35], subItems35);
                String[] subItems36 = { "Select Course", "M.Sc Instrumentation & Applied Physics" };
                subItems.put(dept[36], subItems36);
                String[] subItems37 = { "Select Course", "B.Tech Signal Pocessing and Communication",
                                "M.Tech. Signal Pocessing and Communicatio", "B.Tech Signal Processing and VLSI",
                                "M.Tech. Signal Processing and VLSI" };
                subItems.put(dept[37], subItems37);
                String[] subItems38 = { "Select Course", "B.Tech Material Science and Technology",
                                "M.Tech. Material Science and Technology" };
                subItems.put(dept[38], subItems38);
                String[] subItems39 = { "Select Course", "B.Tech Information Technology",
                                "M.Tech. Information Technology" };
                subItems.put(dept[39], subItems39);

                String[] subItems40 = { "Select Course", "B.Com.", "M.Com." };
                subItems.put(dept[40], subItems40);
                String[] subItems41 = { "Select Course", "B.BA.", "M.BA." };
                subItems.put(dept[41], subItems41);
                String[] subItems42 = { "Select Course", "LL.B.", "LL.M." };
                subItems.put(dept[42], subItems42);

                submitbtn = new JButton("Submit");
                submitbtn.setBounds(500, 600, 150, 40);
                f.add(submitbtn);
                submitbtn.addActionListener(this);

                clearbtn = new JButton("Clear");
                clearbtn.setBounds(300, 600, 150, 40);
                f.add(clearbtn);

                backbtn = new JButton("Back");
                backbtn.setBounds(700, 600, 150, 40);
                f.add(backbtn);
                backbtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Home home = new Home();
                                f.dispose();
                        }
                });

                f.add(studentPanel);
                f.add(addressPanel);
                f.add(coursePanel);

                f.setSize(1200, 800);
                f.setLayout(null);
                f.setResizable(false);
                f.setVisible(true);
        }

        public class DateLabelFormatter extends AbstractFormatter {
                private String datePattern = "yyyy-MM-dd";
                private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

                @Override
                public Object stringToValue(String text) throws ParseException {
                        return dateFormatter.parseObject(text);
                }

                @Override
                public String valueToString(Object value) throws ParseException {
                        if (value != null) {
                                Calendar cal = (Calendar) value;
                                return dateFormatter.format(cal.getTime());
                        }
                        return "";
                }
        }

        public void actionPerformed(ActionEvent e) {
                String item = (String) deptComboBox.getSelectedItem();
                Object o = subItems.get(item);
                String data = "";
                if (e.getSource().getClass().equals(JComboBox.class)) {
                        if (o == null) {
                                courseComboBox.setModel(new DefaultComboBoxModel());
                        } else {
                                courseComboBox.setModel(new DefaultComboBoxModel((String[]) o));
                        }
                        System.out.println("course ->" + courseComboBox.getSelectedIndex() + " "
                                        + courseComboBox.getSelectedObjects().toString() + " ");
                }

                if (e.getSource() == uploadPic) {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                                try {
                                        photoFile = fileChooser.getSelectedFile();
                                        filename = photoFile.getAbsolutePath();
                                        BufferedImage picture = ImageIO.read(photoFile);

                                        piclabel.setIcon(new ImageIcon(picture));
                                        f.add(piclabel);
                                } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "ERROR");
                                }
                        }
                }

                if (e.getSource() == submitbtn) {

                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                        String phoneRegex = "^[0-9]{10}$";
                        String pinRegex = "^[1-9][0-9]{5}$";

                        Pattern emailPattern = Pattern.compile(emailRegex);
                        Pattern phonePattern = Pattern.compile(phoneRegex);
                        Pattern pinPattern = Pattern.compile(pinRegex);
                        Matcher ematcher = emailPattern.matcher(semail.getText());
                        Matcher spmatcher = phonePattern.matcher(sphone.getText());
                        Matcher gpmatcher = phonePattern.matcher(gphone.getText());
                        Matcher pinmatcher = pinPattern.matcher(spermpin.getText());
                        Matcher pppinmatcher = pinPattern.matcher(sprespin.getText());
                        if (!ematcher.matches()) {
                                // Valid email format
                                System.out.println("INValid email");
                                JOptionPane.showMessageDialog(null, "Add proper email", "Alert",
                                                JOptionPane.WARNING_MESSAGE);
                                return;
                        }
                        if (!pinmatcher.matches() || !pppinmatcher.matches()) {
                                // Valid email format
                                System.out.println("INValid pin");
                                JOptionPane.showMessageDialog(null, "Add proper pincode", "Alert",
                                                JOptionPane.WARNING_MESSAGE);
                                return;
                        }
                        if (!spmatcher.matches() || !gpmatcher.matches()) {
                                // Valid email format
                                System.out.println("INValid phone");
                                JOptionPane.showMessageDialog(null, "Add proper phone number", "Alert",
                                                JOptionPane.WARNING_MESSAGE);
                                return;
                        }

                        try {
                                // Class.forName("com.mysql.cj.jdbc.Driver");
                                // String query = "INSERT INTO `student_data`(id, `roll no`, `name`, `date of
                                // birth`, `phone`, email, gender, `present address`, `registration no`, `father
                                // name`, `mother name`, `guardian phone`, `permanent address`, degree, batch,
                                // department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                // con = DriverManager.getConnection(
                                // "jdbc:mysql://localhost:3306/student_management_system?useSSL=false",
                                // "root",
                                // "111222344");
                                // pst = con.prepareStatement(query);

                                // String id = java.util.UUID.randomUUID().toString();
                                // Date dob = (Date) datePicker.getModel().getValue();
                                // // java.sql.Date dob = (java.sql.Date) datePicker.getModel().getValue();
                                // String sgender = "";
                                // if (maleradio.isSelected()) {
                                // sgender = "Male";
                                // } else if (femaleradio.isSelected()) {
                                // sgender = "Female";
                                // } else if (genderfradio.isSelected()) {
                                // sgender = "Gender-Fluid";
                                // } else {
                                // sgender = "";
                                // }
                                // String presAdd = spresst.getText() + "' " + spresdist.getText()
                                // + "' " + presstatecombo.getItemAt(presstatecombo.getSelectedIndex())
                                // + ", "
                                // + sprespin.getText();
                                // String permAdd = spermst.getText() + "' "
                                // + spermdist.getText()
                                // + "' " + permstatecombo.getItemAt(permstatecombo.getSelectedIndex())
                                // + "' "
                                // + spermpin.getText();
                                // String course = courseComboBox.getItemAt(courseComboBox.getSelectedIndex());
                                // String degree = course.replaceAll("(?<=\s).*", "");

                                // pst.setString(1, id);
                                // pst.setString(2, roll.getText());
                                // pst.setString(3, sname.getText());
                                // pst.setDate(4, new java.sql.Date(dob.getTime()));
                                // pst.setString(5, sphone.getText());
                                // pst.setString(6, semail.getText());
                                // pst.setString(7, sgender);
                                // pst.setString(8, presAdd);
                                // pst.setString(9, reg.getText());
                                // pst.setString(10, fname.getText());
                                // pst.setString(11, mname.getText());
                                // pst.setString(12, gphone.getText());
                                // pst.setString(13, permAdd);
                                // pst.setString(14, degree);
                                // pst.setString(15, batch.getText());
                                // pst.setString(16, deptComboBox.getItemAt(deptComboBox.getSelectedIndex()));

                                // data = id + roll + sname.getText() + dob + sphone.getText() +
                                // semail.getText() + sgender
                                // + presAdd + reg.getText() + fname.getText() + mname.getText()
                                // + gphone.getText() + permAdd
                                // + degree
                                // + batch.getText()
                                // + deptComboBox.getItemAt(deptComboBox.getSelectedIndex()) + course;
                                // // if (sname.getText().equals("") || sentry.getText().equals("") ||
                                // // semail.getText().equals("")
                                // // || scontact.getText().equals("") || shome.getText().equals("")) {
                                // // JOptionPane.showMessageDialog(null, "Fill all the details :(");
                                // // } else {
                                // int result = pst.executeUpdate();
                                // System.out.println(result + " records affected");
                                // con.close();
                                // JOptionPane.showMessageDialog(null, "Student added Successfully :)");
                                // dispose();
                                // Menu menu = new Menu();
                                // menu.show();
                                // }

                                if (DBHandler.addStudent()) {
                                        JOptionPane.showMessageDialog(null,
                                                        "studentSuccessfullyAdded",
                                                        "success",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "somethingWrongInput",
                                                        "error", JOptionPane.ERROR_MESSAGE);
                                }
                        } catch (Exception ex) {
                                System.out.println(ex);
                                System.out.println(data);
                                System.out.println(pst);
                                JOptionPane.showMessageDialog(null, ex);
                        }
                }
        }

        // public static void main(String args[]) {
        // // RegForm std = new RegForm();
        // new RegForm();
        // // std.setVisible(true);
        // }
}