package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie1 extends JFrame {
//    co robi invoke later i paintComponent nadpisujemy w klasie anonimowej
    public Zadanie1() throws HeadlessException {
        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0,0,getWidth()-1,getHeight()-1);
                g.drawLine(0,getHeight()-1,getWidth()-1,0);
            }
        };

        add(jPanel);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
}
