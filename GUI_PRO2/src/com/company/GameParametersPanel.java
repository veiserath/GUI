package com.company;

import javax.swing.*;

public class VirusAdvancementPanel {
    JLabel labelVirusAdvancement;

    public VirusAdvancementPanel() {
        VirusAdvancement virusAdvancement = new VirusAdvancement();
        this.labelVirusAdvancement.setText("Infected: " + virusAdvancement.infected + " cured: " + virusAdvancement.cured + " died: " + virusAdvancement.cured);
    
    }
}
