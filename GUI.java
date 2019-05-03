package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class GUI extends JFrame{
    private String word;

    private String checkPalindrome() {
        Stack stack = new Stack();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String invertedWord = "";

        while (!stack.isEmpty()) {
            try {
                invertedWord = invertedWord + stack.pop();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(word);
        System.out.println(invertedWord);
        if (word.equals(invertedWord)) {
            return "It's a palindrome";
        } else {
            return "It's not a palindrome";
        }
    }

    public GUI() {
        this.setTitle("Palindrome_GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JLabel label = new JLabel();
        label.setText("Word:");

        JTextField field = new JTextField();
        field.setText("                      ");
        field.setSize(100, 40);

        panel.add(label);
        panel.add(field);

        JButton button = new JButton();
        button.setText("Verify");

        JLabel label1 = new JLabel();

        this.add(panel, BorderLayout.CENTER);
        this.add(button, BorderLayout.BEFORE_LINE_BEGINS);
        this.add(label1, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                word = field.getText().toLowerCase().replaceAll("\\s+","");;
                label1.setText(checkPalindrome());
            }
        });

        this.setSize(400, 250);
        this.setVisible(true);
    }
}
