package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.text.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.sql.*;
import java.sql.DriverManager;

public class UpdateForm implements ActionListener {

        JLabel head, namelabel, doblabel, phonelabel, emaillabel, genderlabel, presaddrlabel,
                        permaddrlabel,
                        addresslabel,
                        fatherlabel,
                        motherlabel, gphonelabel, presstlabel, presdistlabel, presstatlabel, prespinlabel, permstlabel,
                        permdistlabel,
                        permstatlabel, permpinlabel, courseheaderlabel, reglabel, rolllabel, deptlabel, batchlabel,
                        courselabel;
        static JLabel piclabel, piclabel2;
        static JTextField sname, sdob, sphone, semail, fname, mname, gphone, spresst, spresdist, sprespin, spermst,
                        spermdist, date,
                        spermpin, reg, roll,
                        batch, course;
        static JRadioButton maleradio, femaleradio, genderfradio;
        static JComboBox<String> presstatecombo, permstatecombo;
        static JComboBox<String> deptComboBox, courseComboBox;
        JButton submitbtn, clearbtn, backbtn, uploadbtn;
        JDatePanelImpl datePanel;
        static JDatePickerImpl datePicker;
        static File photoFile;
        static String fileName;
        Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();
        Connection con = null;
        PreparedStatement pst = null;

        JFrame f = new JFrame("Update Student");
        JPanel studentPanel, picPanel, addressPanel, coursePanel;
        String bgcolor = "#1F2E54", bgcolor2 = "#ACB1D6";

        UpdateForm() {
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().setBackground(Color.decode(bgcolor2));
                MenuBar menu = new MenuBar();
                f.setJMenuBar(menu.createMenuBar());

                head = new JLabel("UPDATE STUDENT ");
                head.setFont(new Font("Courier", Font.BOLD, 30));
                head.setForeground(Color.decode("#1F2E54"));
                head.setBounds(400, 20, 600, 30);
                f.add(head);

                studentPanel = new JPanel();
                studentPanel.setBackground(Color.decode("#374873"));
                studentPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
                studentPanel.setBounds(20, 60, 940, 200);

                namelabel = new JLabel("Name:");
                namelabel.setBounds(50, 100, 150, 20);
                namelabel.setForeground(Color.WHITE);
                sname = new JTextField();
                sname.setBounds(200, 100, 250, 20);
                f.add(namelabel);
                f.add(sname);

                doblabel = new JLabel("DOB:");
                doblabel.setBounds(50, 130, 150, 20);
                doblabel.setForeground(Color.WHITE);
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
                // datePicker.setBounds(200, 130, 250, 20);
                date = new JTextField();
                date.setBounds(200, 130, 250, 20);
                f.add(datePicker);
                f.add(date);
                /* End Date picker */

                phonelabel = new JLabel("Phone No:");
                phonelabel.setBounds(50, 160, 150, 20);
                phonelabel.setForeground(Color.WHITE);
                sphone = new JTextField();
                sphone.setBounds(200, 160, 250, 20);
                f.add(phonelabel);
                f.add(sphone);

                emaillabel = new JLabel("Email:");
                emaillabel.setBounds(50, 190, 150, 20);
                emaillabel.setForeground(Color.WHITE);
                semail = new JTextField();
                semail.setBounds(200, 190, 250, 20);
                f.add(emaillabel);
                f.add(semail);

                genderlabel = new JLabel("Gender:");
                genderlabel.setBounds(50, 220, 150, 20);
                genderlabel.setForeground(Color.WHITE);
                maleradio = new JRadioButton(" Male");
                maleradio.setBounds(200, 220, 70, 20);
                femaleradio = new JRadioButton(" Female");
                femaleradio.setBounds(270, 220, 90, 20);
                genderfradio = new JRadioButton(" Gender-fluid");
                genderfradio.setBounds(350, 220, 120, 20);
                f.add(genderlabel);
                f.add(maleradio);
                f.add(femaleradio);
                f.add(genderfradio);
                // regbtn.setBorderPainted(false);
                maleradio.setOpaque(true);
                femaleradio.setOpaque(true);
                genderfradio.setOpaque(true);
                ButtonGroup bg = new ButtonGroup();
                bg.add(maleradio);
                bg.add(femaleradio);
                bg.add(genderfradio);

                fatherlabel = new JLabel("Father's Name:");
                fatherlabel.setForeground(Color.WHITE);
                fatherlabel.setBounds(500, 100, 150, 20);
                fname = new JTextField();
                fname.setBounds(700, 100, 250, 20);
                f.add(fatherlabel);
                f.add(fname);

                motherlabel = new JLabel("Mother's Name:");
                motherlabel.setBounds(500, 130, 150, 20);
                motherlabel.setForeground(Color.WHITE);
                mname = new JTextField();
                mname.setBounds(700, 130, 250, 20);
                f.add(motherlabel);
                f.add(mname);

                gphonelabel = new JLabel("Guardian's Phone No:");
                gphonelabel.setBounds(500, 160, 150, 20);
                gphonelabel.setForeground(Color.WHITE);
                gphone = new JTextField();
                gphone.setBounds(700, 160, 250, 20);
                f.add(gphonelabel);
                f.add(gphone);

                piclabel = new JLabel();
                piclabel.setBounds(1040, 60, 150, 150);
                piclabel2 = new JLabel();
                piclabel2.setBounds(1000, 80, 150, 150);
                uploadbtn = new JButton("Upload");
                uploadbtn.setBounds(1020, 235, 100, 20);
                uploadbtn.setBorderPainted(false);
                uploadbtn.setOpaque(true);
                uploadbtn.setForeground(Color.WHITE);
                uploadbtn.setBackground(Color.decode(bgcolor));
                f.add(piclabel);
                f.add(piclabel2);
                f.add(uploadbtn);
                uploadbtn.addActionListener(this);

                addressPanel = new JPanel();
                addressPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
                addressPanel.setBackground(Color.decode("#374873"));
                addressPanel.setBounds(20, 270, 1140, 200);

                addresslabel = new JLabel("ADDRESS DETAILS");
                addresslabel.setFont(new Font("Courier", Font.BOLD, 20));
                addresslabel.setBounds(100, 290, 250, 30);
                addresslabel.setForeground(Color.WHITE);
                f.add(addresslabel);

                presaddrlabel = new JLabel("Present Address:");
                presaddrlabel.setFont(new Font("Courier", Font.BOLD, 15));
                presaddrlabel.setForeground(Color.WHITE);
                presaddrlabel.setBounds(100, 325, 200, 20);
                f.add(presaddrlabel);

                presstlabel = new JLabel("Street:");
                presstlabel.setForeground(Color.WHITE);
                presstlabel.setBounds(100, 360, 150, 20);
                spresst = new JTextField();
                spresst.setBounds(250, 360, 250, 20);
                f.add(presstlabel);
                f.add(spresst);

                presdistlabel = new JLabel("District:");
                presdistlabel.setForeground(Color.WHITE);
                presdistlabel.setBounds(100, 385, 150, 20);
                spresdist = new JTextField();
                spresdist.setBounds(250, 385, 250, 20);
                f.add(presdistlabel);
                f.add(spresdist);

                prespinlabel = new JLabel("Pin:");
                prespinlabel.setBounds(100, 435, 150, 20);
                prespinlabel.setForeground(Color.WHITE);
                sprespin = new JTextField();
                sprespin.setBounds(250, 435, 250, 20);
                f.add(prespinlabel);
                f.add(sprespin);

                presstatlabel = new JLabel("State:");
                presstatlabel.setForeground(Color.WHITE);
                presstatlabel.setBounds(100, 410, 150, 20);
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
                presstatecombo.setBounds(250, 410, 250, 20);
                f.add(presstatlabel);
                f.add(presstatecombo);

                permaddrlabel = new JLabel("Permanent Address:");
                permaddrlabel.setFont(new Font("Courier", Font.BOLD, 15));
                permaddrlabel.setForeground(Color.WHITE);
                permaddrlabel.setBounds(600, 325, 200, 20);
                f.add(permaddrlabel);

                permstlabel = new JLabel("Street:");
                permstlabel.setForeground(Color.WHITE);
                permstlabel.setBounds(600, 360, 150, 20);
                spermst = new JTextField();
                spermst.setBounds(800, 360, 250, 20);
                f.add(permstlabel);
                f.add(spermst);

                permdistlabel = new JLabel("District:");
                permdistlabel.setForeground(Color.WHITE);
                permdistlabel.setBounds(600, 385, 150, 20);
                spermdist = new JTextField();
                spermdist.setBounds(800, 385, 250, 20);
                f.add(permdistlabel);
                f.add(spermdist);

                permstatlabel = new JLabel("State:");
                permstatlabel.setForeground(Color.WHITE);
                permstatlabel.setBounds(600, 410, 150, 20);
                permstatecombo = new JComboBox(states);
                permstatecombo.setBounds(800, 410, 250, 20);
                f.add(permstatlabel);
                f.add(permstatecombo);

                permpinlabel = new JLabel("Pin:");
                permpinlabel.setForeground(Color.WHITE);
                permpinlabel.setBounds(600, 435, 150, 20);
                spermpin = new JTextField();
                spermpin.setBounds(800, 435, 250, 20);
                f.add(permpinlabel);
                f.add(spermpin);

                coursePanel = new JPanel();
                coursePanel.setBounds(20, 480, 1140, 160);
                coursePanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE));
                coursePanel.setBackground(Color.decode("#374873"));

                courseheaderlabel = new JLabel("COURSE DETAILS");
                courseheaderlabel.setFont(new Font("Courier", Font.BOLD, 20));
                courseheaderlabel.setForeground(Color.WHITE);
                courseheaderlabel.setBounds(100, 490, 250, 30);
                f.add(courseheaderlabel);

                reglabel = new JLabel("Registration No:");
                reglabel.setForeground(Color.WHITE);
                reglabel.setBounds(100, 520, 150, 20);
                reg = new JTextField();
                reg.setBounds(250, 520, 250, 20);
                f.add(reglabel);
                f.add(reg);

                rolllabel = new JLabel("Roll No:");
                rolllabel.setForeground(Color.WHITE);
                rolllabel.setBounds(100, 550, 150, 20);
                roll = new JTextField();
                roll.setBounds(250, 550, 250, 20);
                f.add(rolllabel);
                f.add(roll);

                batchlabel = new JLabel("Batch:");
                batchlabel.setForeground(Color.WHITE);
                batchlabel.setBounds(100, 580, 150, 20);
                batch = new JTextField();
                batch.setBounds(250, 580, 250, 20);
                f.add(batchlabel);
                f.add(batch);

                deptlabel = new JLabel("Department:");
                deptlabel.setForeground(Color.WHITE);
                deptlabel.setBounds(600, 550, 150, 20);
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
                deptComboBox.setBounds(800, 550, 250, 20);
                deptComboBox.setOpaque(true);
                deptComboBox.addActionListener(this);

                deptComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
                f.add(deptComboBox);

                courselabel = new JLabel("Course:");
                courselabel.setForeground(Color.WHITE);
                courselabel.setBounds(600, 580, 150, 20);
                f.add(courselabel);
                courseComboBox = new JComboBox<String>();
                courseComboBox.setBounds(800, 490, 250, 20);
                courseComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
                course = new JTextField();
                course.setBounds(800, 580, 250, 20);
                f.add(course);

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
                submitbtn.setBounds(500, 660, 150, 40);
                submitbtn.setForeground(Color.WHITE);
                submitbtn.setBackground(Color.decode(bgcolor));
                submitbtn.setBorderPainted(false);
                submitbtn.setOpaque(true);
                f.add(submitbtn);
                submitbtn.addActionListener(this);

                clearbtn = new JButton("Clear");
                clearbtn.setBounds(300, 660, 150, 40);
                clearbtn.setForeground(Color.WHITE);
                clearbtn.setBackground(Color.decode(bgcolor));
                clearbtn.setBorderPainted(false);
                clearbtn.setOpaque(true);
                f.add(clearbtn);

                backbtn = new JButton("Back");
                backbtn.setBounds(700, 660, 150, 40);
                backbtn.setForeground(Color.WHITE);
                backbtn.setBackground(Color.decode(bgcolor));
                backbtn.setBorderPainted(false);
                backbtn.setOpaque(true);
                f.add(backbtn);
                backbtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                // new SearchForm();
                                f.dispose();
                        }
                });

                f.add(studentPanel);
                f.add(addressPanel);
                f.add(coursePanel);

                f.setSize(1200, 800);
                f.setLayout(null);
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

                if (e.getSource() == uploadbtn) {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                                try {
                                        photoFile = fileChooser.getSelectedFile();
                                        fileName = photoFile.getAbsolutePath();
                                        BufferedImage picture = ImageIO.read(photoFile);
                                        piclabel.setIcon(new ImageIcon(picture));
                                        f.add(piclabel);
                                } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "ERROR");
                                }
                        }
                }

                if (e.getActionCommand().equals("Submit")) {
                        String adminPwd = JOptionPane.showInputDialog(null, "Enter Admin Password.", "Alert",
                                        JOptionPane.WARNING_MESSAGE);
                }

                try {
                        if (DBHandler.updateStudents(roll.getText())) {
                                JOptionPane.showMessageDialog(null,
                                                "studentSuccessfullyUpdated",
                                                "success",
                                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "somethingWrongInput",
                                                "error", JOptionPane.ERROR_MESSAGE);
                        }
                } catch (HeadlessException | FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
        }

}
