package sample.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Model.HighScores;

import java.util.ArrayList;

public class HighScoresApplication extends Application {

    HighScores highScores;


    public HighScoresApplication(HighScores highScores) {
        this.highScores = highScores;
    }

    public HighScoresApplication() {
        this.highScores = new HighScores();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane root = new FlowPane();
        primaryStage.setTitle("High Scores - higher is better:");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);

        ListView<String> highScoresList = new ListView<>();

        loadData(highScores.getHighScoresData(), highScoresList);
        root.getChildren().add(highScoresList);
        highScoresList.setPrefWidth(scene.getWidth());
        highScoresList.setPrefHeight(scene.getHeight());
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public void loadData(ArrayList<String> highScoresData, ListView<String> highScoresList) {
        for (String element : highScoresData) {
            highScoresList.getItems().add(element);
        }
    }

}
