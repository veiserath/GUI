package com.company.view;

import javax.swing.*;
import java.awt.*;

public class UserMessage {

    public UserMessage(String message) {
        Frame frame = new Frame();
        JOptionPane.showMessageDialog(frame, message);
    }
}
