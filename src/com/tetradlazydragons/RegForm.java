package com.tetradlazydragons;

import javax.swing.*;
public class RegForm {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,a1,a2,a3,a4,a5,a6;
    JTextField t1,t2,t3,t4,t8,t9,t10,ta1,ta2,ta4,ta5;
    JRadioButton r1,r2;
    JComboBox c1,c2;
    JButton b;
    RegForm(){
        JFrame f = new JFrame("Registration Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Name:");
        l1.setBounds(50,100,150,20);
        t1 = new JTextField();
        t1.setBounds(200,100,200,20);
        f.add(l1);
        f.add(t1);

        l2 = new JLabel("DOB:");
        l2.setBounds(50,130,150,20);
        t2 = new JTextField();
        t2.setBounds(200,130,200,20);
        f.add(l2);
        f.add(t2);

        l3 = new JLabel("Phone No:");
        l3.setBounds(50,160,150,20);
        t3 = new JTextField();
        t3.setBounds(200,160,200,20);
        f.add(l3);
        f.add(t3);

        l4 = new JLabel("Email:");
        l4.setBounds(50,190,150,20);
        t4 = new JTextField();
        t4.setBounds(200,190,200,20);
        f.add(l4);
        f.add(t4);

        l5 =new JLabel("Gender:");
        l5.setBounds(50, 220, 150, 20);
        r1=new JRadioButton(" Male"); 
        r1.setBounds(200,220,100, 20);
        r2=new JRadioButton(" Female"); 
        r2.setBounds(360,220,100, 20);
        f.add(l5);
        f.add(r1);
        f.add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        l6 = new JLabel("Present Address:");
        l6.setBounds(50,250,150,20);
        f.add(l6);

        a1 = new JLabel("Street:");
        a1.setBounds(50,280,150,20);
        ta1 = new JTextField();
        ta1.setBounds(200,280,200,20);
        f.add(a1);
        f.add(ta1);

        a2 = new JLabel("District:");
        a2.setBounds(50,310,150,20);
        ta2 = new JTextField();
        ta2.setBounds(200,310,200,20);
        f.add(a2);
        f.add(ta2);
        

        a3 = new JLabel("State:");
        a3.setBounds(50,340,150,20);
        String states[] = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerela","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telengana","Tripura","Uttar Pradesh","Uttrakhand","West Bengal" };
        c1 = new JComboBox(states);
        c1.setBounds(200,340,200,20);
        f.add(a3);
        f.add(c1);

        
        l7 = new JLabel("Permanent Address:");
        l7.setBounds(500,250,150,20);
        f.add(l7);

        a4 = new JLabel("Street:");
        a4.setBounds(500,280,150,20);
        ta4 = new JTextField();
        ta4.setBounds(700,280,200,20);
        f.add(a4);
        f.add(ta4);

        a5 = new JLabel("District:");
        a5.setBounds(500,310,150,20);
        ta5 = new JTextField();
        ta5.setBounds(700,310,200,20);
        f.add(a5);
        f.add(ta5);
        

        a6 = new JLabel("State:");
        a6.setBounds(500,340,150,20);
        c2 = new JComboBox(states);
        c2.setBounds(700,340,200,20);
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


        b = new JButton("Submit");
        b.setBounds(50,700,150,40);
        f.add(b);
      
         
        f.setSize(1000,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    public static void main(String args []){
        new RegForm();
    }
}

        