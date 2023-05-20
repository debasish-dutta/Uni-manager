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
        codeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://github.com/debasish-dutta/Uni-manager/tree/master/src/com/tetradlazydragons";
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        ImageIcon githubIcon = new ImageIcon("assets/icons/github-mark.png");
        Image ic = githubIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        githubIcon = new ImageIcon(ic);

        menuBar.add(fileM);
        menuBar.add(stdM);
        menuBar.add(helpM);
        menuBar.add(Box.createHorizontalGlue());
        ghM = new JMenu("");
        ghM.setIcon(githubIcon);
        ghM.setFocusable(false);
        menuBar.add(ghM);
        ghM.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url = "https://github.com/debasish-dutta/Uni-manager/tree/master/src/com/tetradlazydragons";
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

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
            new ConnectView();
        }
        if (e.getSource() == disconnectItem) {

        }
        if (e.getSource() == exitItem) {

        }
        if (e.getSource() == addItem) {
            new RegForm();
        }
        if (e.getSource() == updateItem) {
            new SearchForm();
        }
        if (e.getSource() == searchItem) {
            new SearchForm();
        }
        if (e.getSource() == deleItem) {
            new SearchForm();
        }
        if (e.getSource() == infoItem) {

        }
        if (e.getSource() == licenseItem) {
            new License();
        }
    }
}
