package com.tetradlazydragons;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;

public class GetStarted extends JFrame {
    private JPanel topicsPanel;
    private JPanel howToPanel;
    JTextArea howToTextArea;
    String bgcolor = "#374873", bgcolor2 = "#1F2E54", bgcolor3 = "#ACB1D6";

    GetStarted() {
        setTitle("Getting Started");
        setLayout(new BorderLayout());
        initComponents();
        addComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        topicsPanel = new JPanel(new GridLayout(0, 1));
        howToPanel = new JPanel(new BorderLayout());
        howToTextArea = new JTextArea("UNIMANAGER - \n Streamline the Academic Journey");
        howToTextArea.setFont(new Font("Courier", Font.PLAIN, 18));
        howToTextArea.setForeground(Color.decode(bgcolor));
        howToTextArea.setLineWrap(true);
        howToTextArea.setWrapStyleWord(true);
        howToTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(howToTextArea);
        howToPanel.add(scrollPane, BorderLayout.CENTER);

        // Create topic buttons and add action listeners
        JButton topic1Button = new JButton("About the APP");
        topic1Button.setForeground(Color.WHITE);
        topic1Button.setBackground(Color.decode(bgcolor2));
        topic1Button.setBorderPainted(false);
        topic1Button.setOpaque(true);
        topic1Button.addActionListener(e -> {
            String howToContent = "The app section of UniManager is a feature that allows authorized users to edit, view, and delete student details within the system. Additionally, it provides an option to connect to a database for efficient data management."
                    + "\n UniManager empowers administrators and authorized users to effectively manage student details, providing them with the necessary tools for data editing, viewing, and deletion while ensuring a secure and streamlined experience through the integration with a database.\n\n"
                    + "\n Here's an overview of the functionalities in the app section:";
            howToTextArea.setText(howToContent);
        });

        JButton topic2Button = new JButton("Database");
        topic2Button.setForeground(Color.WHITE);
        topic2Button.setBackground(Color.decode(bgcolor2));
        topic2Button.setBorderPainted(false);
        topic2Button.setOpaque(true);
        topic2Button.addActionListener(e -> {
            String howToContent = "UniManager offers the capability to connect to a database, which serves as a centralized storage for student data. By connecting to a database, the application can efficiently manage large amounts of information, provide data security, and enable reliable data retrieval and storage.\n"
                    +

                    "\n Connecting to a database allows for seamless integration with other systems and provides a robust foundation for data management within UniManager. It facilitates data consistency, scalability, and ease of use.\n\n"
                    +
                    " Step1 - Click on the File option on the menu\n" +
                    " Step2 - Select the Connect db button\n" +
                    " Step3 - Fill the required fields\n" +
                    " Step4 - Click on connect\n";
            howToTextArea.setText(howToContent);
        });
        JButton topic3Button = new JButton("Adding Student");
        topic3Button.setForeground(Color.WHITE);
        topic3Button.setBackground(Color.decode(bgcolor2));
        topic3Button.setBorderPainted(false);
        topic3Button.setOpaque(true);
        topic3Button.addActionListener(e -> {
            String howToContent = "How to add a student\n" +
                    "Step1 - Connect the database\n" +
                    "Step2 - Click on search or Add student from Home\n" +
                    "Step3 - Fill in the form and click submit";
            howToTextArea.setText(howToContent);
        });
        JButton topic4Button = new JButton("Searching Student");
        topic4Button.setForeground(Color.WHITE);
        topic4Button.setBackground(Color.decode(bgcolor2));
        topic4Button.setBorderPainted(false);
        topic4Button.setOpaque(true);
        topic4Button.addActionListener(e -> {
            String howToContent = "Users can access and view the complete information of any student stored in the system. This feature allows for quick retrieval of student data, which can be helpful for various administrative purposes.\n\n"
                    +
                    "Step1 - Search the student whom details you want to view\n" +
                    "Step2 - Select the student\n" +
                    "Step3 - Click on view";
            howToTextArea.setText(howToContent);
        });
        JButton topic5Button = new JButton("Updating Student");
        topic5Button.setForeground(Color.WHITE);
        topic5Button.setBackground(Color.decode(bgcolor2));
        topic5Button.setBorderPainted(false);
        topic5Button.setOpaque(true);
        topic5Button.addActionListener(e -> {
            String howToContent = "Authorized users can modify the information of individual students. This includes fields such as name, contact details, address, course enrollment, and any other relevant information.\n\nHow to update a student\n"
                    +

                    "Step1 - Connect the database\n" +
                    "Step2 - Click on search student from Home\n" +
                    "Step3 - Click on view to view the complete student card\n" +
                    "Step4 - Go to the update button\n" +
                    "Step5 - Fill in all the details on the update form";
            howToTextArea.setText(howToContent);
        });
        JButton topic6Button = new JButton("Deleting Student");
        topic6Button.setForeground(Color.WHITE);
        topic6Button.setBackground(Color.decode(bgcolor2));
        topic6Button.setBorderPainted(false);
        topic6Button.setOpaque(true);
        topic6Button.addActionListener(e -> {
            String howToContent = "In certain situations, it may be necessary to remove a student's information from the system. The app section provides the functionality to delete student records when required, ensuring data accuracy and compliance with privacy regulations.\n\n"
                    +

                    "Step1 - Search the mentioned student\n" +
                    "Step2 - After finding the required student select the student details\n" +
                    "Step3 - Click on Delete";
            howToTextArea.setText(howToContent);
        });
        JButton topic7Button = new JButton("About the Devs");
        topic7Button.setForeground(Color.WHITE);
        topic7Button.setBackground(Color.decode(bgcolor2));
        topic7Button.setBorderPainted(false);
        topic7Button.setOpaque(true);
        topic7Button.addActionListener(e -> {
            String howToContent = "How to use Topic :\n\nDev 1: Debasish Dutta\nDev 2: Neeharika Sonowal\nDev 3: Rhituraj Deori\nDev 4: Jyotishman Bhagawati";
            howToTextArea.setText(howToContent);
        });

        // Add topic buttons to the topics panel
        topicsPanel.add(topic1Button);
        topicsPanel.add(topic2Button);
        topicsPanel.add(topic3Button);
        topicsPanel.add(topic4Button);
        topicsPanel.add(topic5Button);
        topicsPanel.add(topic6Button);
        topicsPanel.add(topic7Button);
    }

    private void addComponents() {
        getContentPane().add(topicsPanel, BorderLayout.WEST);
        getContentPane().add(howToPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GetStarted::new);
    }
}
