package com.tetradlazydragons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class MenuBar implements ActionListener {
    JMenuBar menuBar;
    JMenu fileM, stdM, helpM, ghM;
    JMenuItem saveItem, connectItem, disconnectItem, exitItem,
            addItem, updateItem, searchItem, deleItem,
            infoItem, licenseItem, codeItem;

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        fileM = new JMenu("File");
        stdM = new JMenu("Student");
        helpM = new JMenu("Help");
        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        connectItem = new JMenuItem("Connect Db");
        connectItem.addActionListener(this);
        disconnectItem = new JMenuItem("Disconnect Db");
        disconnectItem.addActionListener(this);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        addItem = new JMenuItem("Add Student");
        addItem.addActionListener(this);
        updateItem = new JMenuItem("Update Student");
        updateItem.addActionListener(this);
        searchItem = new JMenuItem("Find Student");
        searchItem.addActionListener(this);
        deleItem = new JMenuItem("Delete Student");
        deleItem.addActionListener(this);
        infoItem = new JMenuItem("Get Started");
        infoItem.addActionListener(this);
        licenseItem = new JMenuItem("View License");
        licenseItem.addActionListener(this);
        codeItem = new JMenuItem("View Code");
        codeItem.addActionListener(this);

        ImageIcon githubIcon = new ImageIcon("assets/icons/github-mark.png");
        Image ic = githubIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        githubIcon = new ImageIcon(ic);

        menuBar.add(fileM);
        menuBar.add(stdM);
        menuBar.add(helpM);
        menuBar.add(Box.createHorizontalGlue());
        ghM = new JMenu("");
        ghM.setIcon(githubIcon);
        menuBar.add(ghM);
        ghM.addActionListener(this);

        fileM.add(saveItem);
        fileM.add(connectItem);
        fileM.add(disconnectItem);
        fileM.add(exitItem);
        stdM.add(addItem);
        stdM.add(updateItem);
        stdM.add(searchItem);
        stdM.add(deleItem);
        helpM.add(infoItem);
        helpM.add(licenseItem);
        helpM.add(codeItem);

        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveItem) {

        }
        if (e.getSource() == connectItem) {

        }
        if (e.getSource() == disconnectItem) {

        }
        if (e.getSource() == exitItem) {

        }
        if (e.getSource() == addItem) {

        }
        if (e.getSource() == updateItem) {

        }
        if (e.getSource() == searchItem) {

        }
        if (e.getSource() == deleItem) {

        }
        if (e.getSource() == infoItem) {

        }
        if (e.getSource() == licenseItem) {

        }
        if (e.getSource() == codeItem) {

        }
        if (e.getSource() == ghM) {
            System.out.println("btn");
            try {
                String url = "github.com"; // capture the URL when the user presses the button.
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI oURL = new URI(url);
                desktop.browse(oURL);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
