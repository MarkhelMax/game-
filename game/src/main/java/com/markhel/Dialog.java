package com.markhel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Dialog {

    JPanel panel;
    JLabel name_label, nick_label, message;
    JTextField name_text;
    JTextField nick_text;
    JButton submit;
    JFrame frame;
    JPanel main;
    DocumentListener checkListener;

    Dialog() {
        checkListener = setupListener();
        name_label = new JLabel();
        name_label.setText("Введите имя , сударь  :");
        name_text = new JTextField();
        name_text.getDocument().addDocumentListener(checkListener);


                // Password

                nick_label = new JLabel();
        nick_label.setText("Желаемый ник : ");
        nick_text = new JTextField();
        nick_text.getDocument().addDocumentListener(checkListener);
        // Submit

        submit = new JButton("Вписать");
        submit.setEnabled(false);

                panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

        panel.add(name_label);
        panel.add(name_text);
        panel.add(nick_label);
        panel.add(nick_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = name_text.getText();
                String nickname = nick_text.getText();
                if (userName.trim().equals("admin") && nickname.trim().equals("admin")) {
                    Display display = new Display("Hello Max");
                    frame.dispose();
                } else {
                    message.setText("Ваш ник не найден");
                    message.setForeground(Color.RED);
                }
            }
        });
        main = new JPanel();
        main.add(panel);
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(main, BorderLayout.CENTER);
        frame.setTitle("Please Login Here !");
        frame.setSize(350, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);



    }

    private DocumentListener setupListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkInputs();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkInputs();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkInputs();
            }

            void checkInputs(){
                String userName = name_text.getText();
                String nickname = nick_text.getText();
                if (userName.trim().length() > 0 && nickname.trim().length() > 0){
                    submit.setEnabled(true);
                } else {
                    submit.setEnabled(false);
                }
                message.setText("");
            }
        };
    }

    public static void main(String[] args) {
        new Dialog();
    }

}

