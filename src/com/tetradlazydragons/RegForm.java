import javax.swing.*;
public class RegForm {
    JLabel l1,l2,l3,l4,l5,l6,a1,a2,a3;
    JTextField t1,t2,t3,t4,ta1,ta2,ta3;
    JRadioButton r1,r2;
    JButton b;
    RegForm(){
        JFrame f = new JFrame("Registration Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Name:");
        l1.setBounds(50,100,150,20);
        t1 = new JTextField();
        t1.setBounds(200,100,200,20);
        l2 = new JLabel("DOB:");
        l2.setBounds(50,130,150,20);
        t2 = new JTextField();
        t2.setBounds(200,130,200,20);
        l3 = new JLabel("Phone No:");
        l3.setBounds(50,160,150,20);
        t3 = new JTextField();
        t3.setBounds(200,160,200,20);
        l4 = new JLabel("Email:");
        l4.setBounds(50,190,150,20);
        t4 = new JTextField();
        t4.setBounds(200,190,200,20);
        l5 =new JLabel("Gender:");
        l5.setBounds(50, 220, 150, 20);
        r1=new JRadioButton(" Male"); 
        r1.setBounds(200,220,100, 20);
        r2=new JRadioButton(" Female"); 
        r2.setBounds(360,220,100, 20);
        l6 = new JLabel("Present Address:");
        l6.setBounds(50,250,150,20);
      
        a1 = new JLabel("Street:");
        a1.setBounds(50,280,150,20);
        ta1 = new JTextField();
        ta1.setBounds(200,280,200,20);
        a2 = new JLabel("District:");
        a2.setBounds(50,310,150,20);
        ta2 = new JTextField();
        ta2.setBounds(200,310,200,20);
        a3 = new JLabel("State:");
        a3.setBounds(50,340,150,20);
        ta3 = new JTextField();
        ta3.setBounds(200,340,200,20);

        b = new JButton("Submit");
        b.setBounds(50,500,150,40);
        
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);
        f.add(l5);
        f.add(r1);
        f.add(r2);
        f.add(l6);
        f.add(a1);
        f.add(a2);
        f.add(a3);
        f.add(ta1);
        f.add(ta2);
        f.add(ta3);
        f.add(b);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    public static void main(String args []){
        new RegForm();
    }
}

        