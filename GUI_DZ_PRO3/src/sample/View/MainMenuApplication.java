package sample.View;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuApplication extends Application {

    private VBox root;
    private Button buttonNewGame;
    private Button buttonHighScores;
    private Button buttonExit;
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 300, 275));
        this.buttonNewGame = new Button("New Game");
        this.buttonHighScores = new Button("High Scores");
        this.buttonExit = new Button("Exit");
        root.getChildren().addAll(buttonNewGame, buttonHighScores, buttonExit);
        setButtonDimensions();
        addActionListenersToButtons();
        primaryStage.show();

    }

    public void setButtonDimensions() {
        buttonNewGame.setPrefHeight(root.heightProperty().doubleValue() / 3);
        buttonHighScores.setPrefHeight(root.heightProperty().doubleValue() / 3);
        buttonExit.setPrefHeight(root.heightProperty().doubleValue() / 3);

        buttonNewGame.setPrefWidth(root.widthProperty().doubleValue() - 10);
        buttonHighScores.setPrefWidth(root.widthProperty().doubleValue() - 10);
        buttonExit.setPrefWidth(root.widthProperty().doubleValue() - 10);

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            double height = (double) newValue;
            buttonNewGame.setPrefHeight(height / (root.getChildren().size()));
            buttonHighScores.setPrefHeight(height / (root.getChildren().size()));
            buttonExit.setPrefHeight(height / (root.getChildren().size()));

        });
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double width = (double) newValue;
            buttonNewGame.setPrefWidth(width - 10);
            buttonHighScores.setPrefWidth(width - 10);
            buttonExit.setPrefWidth(width - 10);

        });
    }

    public void addActionListenersToButtons() {
        buttonNewGame.setOnAction(event -> {
            GameParametersApplication gameParametersApplication = new GameParametersApplication();
            try {
                gameParametersApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttonHighScores.setOnAction(event -> {
            HighScoresApplication highScoresApplication = new HighScoresApplication();
            try {
                highScoresApplication.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttonExit.setOnAction(event -> {
//          is this correct way of closing this app?
            Platform.exit();
        });
    }

}
