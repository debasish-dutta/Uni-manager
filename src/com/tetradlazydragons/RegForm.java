package com.tetradlazydragons;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.text.*;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class RegForm implements ActionListener {
    JLabel head, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, a1, a2, a3, a4, a5, a6, lc, lc1, lc2, lc3;
    JTextField t1, t2, t3, t4, t8, t9, t10, ta1, ta2, ta4, ta5, ct1;
    JRadioButton r1, r2;
    JComboBox c1, c2;
    JComboBox<String> deptComboBox;
    JComboBox<String> courseComboBox;
    JButton b, b1;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    Hashtable<String, String[]> subItems = new Hashtable<String, String[]>();

    RegForm() {
        JFrame f = new JFrame("Registration Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        head = new JLabel("NEW STUDENT REGISTRATION ");
        head.setFont(new Font("Courier", Font.BOLD, 30));
        head.setBounds(260, 20, 600, 30);
        f.add(head);

        l1 = new JLabel("Name:");
        l1.setBounds(50, 100, 150, 20);
        t1 = new JTextField();
        t1.setBounds(200, 100, 200, 20);
        f.add(l1);
        f.add(t1);

        l2 = new JLabel("DOB:");
        l2.setBounds(50, 130, 150, 20);
        // t2 = new JTextField();
        // t2.setBounds(200, 130, 200, 20);
        f.add(l2);
        // f.add(t2);

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
        datePicker.setBounds(200, 130, 200, 20);
        f.add(datePicker);
        /* End Date picker */

        l3 = new JLabel("Phone No:");
        l3.setBounds(50, 160, 150, 20);
        t3 = new JTextField();
        t3.setBounds(200, 160, 200, 20);
        f.add(l3);
        f.add(t3);

        l4 = new JLabel("Email:");
        l4.setBounds(50, 190, 150, 20);
        t4 = new JTextField();
        t4.setBounds(200, 190, 200, 20);
        f.add(l4);
        f.add(t4);

        l5 = new JLabel("Gender:");
        l5.setBounds(50, 220, 150, 20);
        r1 = new JRadioButton(" Male");
        r1.setBounds(200, 220, 100, 20);
        r2 = new JRadioButton(" Female");
        r2.setBounds(360, 220, 100, 20);
        f.add(l5);
        f.add(r1);
        f.add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        l6 = new JLabel("Present Address:");
        l6.setBounds(50, 250, 150, 20);
        f.add(l6);

        a1 = new JLabel("Street:");
        a1.setBounds(50, 280, 150, 20);
        ta1 = new JTextField();
        ta1.setBounds(200, 280, 200, 20);
        f.add(a1);
        f.add(ta1);

        a2 = new JLabel("District:");
        a2.setBounds(50, 310, 150, 20);
        ta2 = new JTextField();
        ta2.setBounds(200, 310, 200, 20);
        f.add(a2);
        f.add(ta2);

        a3 = new JLabel("State:");
        a3.setBounds(50, 340, 150, 20);
        String states[] = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat",
                "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerela",
                "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana", "Tripura", "Uttar Pradesh", "Uttrakhand",
                "West Bengal" };
        c1 = new JComboBox(states);
        c1.setBounds(200, 340, 200, 20);
        f.add(a3);
        f.add(c1);

        l7 = new JLabel("Permanent Address:");
        l7.setBounds(500, 250, 150, 20);
        f.add(l7);

        a4 = new JLabel("Street:");
        a4.setBounds(500, 280, 150, 20);
        ta4 = new JTextField();
        ta4.setBounds(700, 280, 200, 20);
        f.add(a4);
        f.add(ta4);

        a5 = new JLabel("District:");
        a5.setBounds(500, 310, 150, 20);
        ta5 = new JTextField();
        ta5.setBounds(700, 310, 200, 20);
        f.add(a5);
        f.add(ta5);

        a6 = new JLabel("State:");
        a6.setBounds(500, 340, 150, 20);
        c2 = new JComboBox(states);
        c2.setBounds(700, 340, 200, 20);
        f.add(a6);
        f.add(c2);

        l8 = new JLabel("Father's Name:");
        l8.setBounds(500, 100, 150, 20);
        t8 = new JTextField();
        t8.setBounds(700, 100, 200, 20);
        f.add(l8);
        f.add(t8);

        l9 = new JLabel("Mother's Name:");
        l9.setBounds(500, 130, 150, 20);
        t9 = new JTextField();
        t9.setBounds(700, 130, 200, 20);
        f.add(l9);
        f.add(t9);

        l10 = new JLabel("Guardian's Phone No:");
        l10.setBounds(500, 160, 150, 20);
        t10 = new JTextField();
        t10.setBounds(700, 160, 200, 20);
        f.add(l10);
        f.add(t10);

        lc = new JLabel("Course Details:");
        lc.setBounds(50, 370, 150, 20);
        f.add(lc);

        lc1 = new JLabel("Batch:");
        lc1.setBounds(50, 400, 150, 20);
        ct1 = new JTextField();
        ct1.setBounds(200, 400, 200, 20);
        f.add(lc1);
        f.add(ct1);

        lc2 = new JLabel("Department:");
        lc2.setBounds(50, 430, 150, 20);
        f.add(lc2);
        String[] dept = { "Select Department", "Arabic", "Assamese", "Bengali", "Bodo", "Communication & Journalism",
                "Economics", "Education", "English", "English Language Teaching", "Foreign Language", "Hindi",
                "History", "Library & Information Science", "Linguistics", "Modern Indian Language & Literary Studies",
                "Persian", "Philosophy", "Political Science", "Psycology", "Sanskrit", "Sociology", "Women's Studies",

                "Anthropology", "Botany", "Chemistry", "Environmental Science", "Geography", "Geological Sciences",
                "Mathematics",
                "Physics", "Statistics", "Zoology",

                "Biotechnology", "Computer Science", "Electronics & Communication Technology",
                "Instrumentation and USIC",
                "Electronics and Communication Engineering", "Applied Science", "Information Technology",

                "Commerce", "Business Administration", "Law" };
        deptComboBox = new JComboBox<String>(dept);
        deptComboBox.setBounds(200, 430, 250, 20);
        deptComboBox.addActionListener(this);

        deptComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        f.add(deptComboBox);

        lc3 = new JLabel("Course:");
        lc3.setBounds(50, 460, 150, 20);
        f.add(lc3);
        courseComboBox = new JComboBox<String>();
        courseComboBox.setBounds(200, 460, 250, 20);
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
        String[] subItems30 = { "Select Course", "B.Sc. Physics", "M.Sc. Physics", "M.Sc. Radiological Science" };
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
        String[] subItems39 = { "Select Course", "B.Tech Information Technology", "M.Tech. Information Technology" };
        subItems.put(dept[39], subItems39);

        String[] subItems40 = { "Select Course", "B.Com.", "M.Com." };
        subItems.put(dept[40], subItems40);
        String[] subItems41 = { "Select Course", "B.BA.", "M.BA." };
        subItems.put(dept[41], subItems41);
        String[] subItems42 = { "Select Course", "LL.B.", "LL.M." };
        subItems.put(dept[42], subItems42);

        b = new JButton("Submit");
        b.setBounds(300, 500, 150, 40);
        f.add(b);
        b1 = new JButton("Clear");
        b1.setBounds(500, 500, 150, 40);
        f.add(b1);

        f.setSize(1000, 800);
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

        if (o == null) {
            courseComboBox.setModel(new DefaultComboBoxModel());
        } else {
            courseComboBox.setModel(new DefaultComboBoxModel((String[]) o));
        }
    }

    public static void main(String args[]) {
        new RegForm();
    }
}
