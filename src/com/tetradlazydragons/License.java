package com.tetradlazydragons;

import javax.swing.*;
import java.awt.*;

public class License extends JFrame {
    public License() {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MIT License");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int Width = 800;
        int Height = 600;

        int textAreaWidth = Width / 2;
        int textAreaHeight = Height / 2;
        int textAreaX = (Width - textAreaWidth) / 2;
        int textAreaY = (Height - textAreaHeight) / 2;

        JTextArea textArea = new JTextArea();
        textArea.setText("MIT License\n" +
                "Copyright (c)\n" +
                "Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
                "of this software and associated documentation files (the \"Software\"), to deal\n" +
                "in the Software without restriction, including without limitation the rights\n" +
                "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
                "copies of the Software, and to permit persons to whom the Software is\n" +
                "furnished to do so, subject to the following conditions:\n" +
                "\n" +
                "The above copyright notice and this permission notice shall be included in all\n" +
                "copies or substantial portions of the Software.\n" +
                "\n" +
                "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
                "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
                "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
                "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
                "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
                "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n" +
                "SOFTWARE.");

        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(textAreaX, textAreaY, textAreaWidth, textAreaHeight);

        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
        setSize(Width, Height);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(License::new);
    }
}
