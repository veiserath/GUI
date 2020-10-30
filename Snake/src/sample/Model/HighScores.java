package sample.Model;

import java.io.*;
import java.util.ArrayList;

public class HighScores implements Serializable {

    private ArrayList<String> highScoresData;

    public HighScores() {
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

    public ArrayList<String> readData() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("highscores.obj"));
            ArrayList<String> highScoresData = (ArrayList<String>) (objectInputStream.readObject());
            objectInputStream.close();
            return highScoresData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addRank(String name, int score, long time, int width, int height) {
        long formula = score - time - width * height;
        this.highScoresData.add(name + " : " + formula);
        saveData();
    }

    public ArrayList<String> getHighScoresData() {
        return highScoresData;
    }
}


