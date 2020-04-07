package com.company;

import javax.swing.*;
import java.awt.*;

public class Okno {

    JPanel jPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawLine(0,0,getWidth()-1,getHeight()-1);
            g.drawLine(0,getHeight()-1,getWidth()-1,0);
        }
    };
}
