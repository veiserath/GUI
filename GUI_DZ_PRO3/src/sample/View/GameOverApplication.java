package sample.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.GameTime;
import sample.Model.HighScores;

public class GameOverApplication extends Application {

    private GameTime gameTime;
    private int score;
    private int width;
    private int height;

    public GameOverApplication(GameTime gameTime, int score, int width, int height) {

        this.gameTime = gameTime;
        this.score = score;
        this.width = width;
        this.height = height;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Game Over");
        primaryStage.setScene(new Scene(root, 300, 275));
        Label labelYourName = new Label("Type your name below: ");
        TextField textFieldYourName = new TextField();
        Button buttonSaveYourRank = new Button("Save your rank!");


        buttonSaveYourRank.setOnAction(event -> {
            String name = textFieldYourName.getText();
            HighScores highScores = new HighScores();
            highScores.addRank(name, score, gameTime.getTotalRankingTime(), width, height);
            HighScoresApplication highScoresApplication = new HighScoresApplication(highScores);
            try {
                highScoresApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(labelYourName, textFieldYourName, buttonSaveYourRank);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
