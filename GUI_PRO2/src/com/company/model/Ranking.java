package com.company.model;

import javax.swing.*;
import java.io.*;

public class Ranking implements Serializable {

    public DefaultListModel<String> highScoresData;

    public Ranking() {
        this.highScoresData = readData();
    }

    public void saveData() {

        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("highscores.obj"));
            objectOutputStream.writeObject(highScoresData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public DefaultListModel<String> readData() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("highscores.obj"));
            DefaultListModel<String> highScoresData = (DefaultListModel<String>) (objectInputStream.readObject());
            objectInputStream.close();
            return highScoresData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addRank(String name, long time, long infected, long cured, long died, String difficulty) {

        long formula = 0;
        if (difficulty.equals("Beginner")){
            formula = cured*100-infected-time-died;
        }
        else if (difficulty.equals("Intermediate")){
            formula = cured*200-infected-time-died;
        }
        else if (difficulty.equals("Expert")){
            formula = cured*300-infected-time-died;
        }
        this.highScoresData.addElement(name + " ranking: " + formula);
        saveData();
    }
}
