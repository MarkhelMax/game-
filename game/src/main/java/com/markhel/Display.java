package com.markhel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Display implements ActionListener {

    public Display(String name) {
        initComponents(name);
    }

    private JFrame window;

    private void initComponents(String name) {
        window = new JFrame(name);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Menu menu = new Menu();
        window.setJMenuBar(menu.createMenu());
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
        window.setVisible(true);
        window.pack();
        window.setExtendedState(MAXIMIZED_BOTH);
    }

    public void actionPerformed(ActionEvent action) {
    }

}

