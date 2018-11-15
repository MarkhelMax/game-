package com.markhel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Display implements ActionListener {

    public Display(String name) {
        initComponents(name);
    }

    private JFrame window;

    private void initComponents(String name) {
        window = new JFrame(name);
        window.setSize(200, 100);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JButton button = new JButton("Click me!");
        button.setVisible(true);
        button.setLocation(12, 12);
        button.setSize(165, 50);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Don't touch me!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });
        window.getContentPane().add(button);
        window.getContentPane().add(new JLabel("Hello"));
    }

    public void actionPerformed(ActionEvent action) {
    }

}

