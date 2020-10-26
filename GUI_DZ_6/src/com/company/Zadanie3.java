package com.company;



import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Zadanie3 extends JFrame {
    public Zadanie3() {
        System.out.println("Pick a number to get layout: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        JPanel jPanel = new JPanel();
        JButton jButton1 = new JButton("Przycisk1");
        JButton jButton2 = new JButton("Przycisk 2");
        JButton jButton3 = new JButton("P3");
        JButton jButton4 = new JButton("P 4");
        JButton jButton5 = new JButton("Duzy przycisk o numerze 5");

        switch (input){
            case 1:
                jPanel.setLayout(new BorderLayout());
                jPanel.add(jButton1, BorderLayout.PAGE_START);
                jPanel.add(jButton2, BorderLayout.LINE_START);
                jPanel.add(jButton3, BorderLayout.LINE_END);
                jPanel.add(jButton4, BorderLayout.PAGE_END);
                jPanel.add(jButton5, BorderLayout.CENTER);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;

            case 2:
                jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            case 3:
                jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            case 4:
                jPanel.setLayout(new FlowLayout());
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            case 5:
                jPanel.setLayout(new GridLayout(1,5));
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            case 6:
                jPanel.setLayout(new GridLayout(5,1));
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            case 7:
                jPanel.setLayout(new GridLayout(3,2));
                jPanel.add(jButton1);
                jPanel.add(jButton2);
                jPanel.add(jButton3);
                jPanel.add(jButton4);
                jPanel.add(jButton5);
                break;
            default:
                System.out.println("Nie ma takiej opcji.");
        }

        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        add(jPanel);



    }
}
