package sample.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameParametersApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Game Parameters");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        Label labelParameters = new Label("Specify width and height of game window below:");
        Label labelWidthOfGameWindow = new Label("Width:");
        TextField textFieldWidth = new TextField();
        Label labelHeightOfGameWindow = new Label("Height:");
        TextField textFieldHeight = new TextField();
        Button buttonGetParameters = new Button("Continue");


        buttonGetParameters.setOnAction(event -> {
            int width = Integer.parseInt(textFieldWidth.getText());
            int height = Integer.parseInt(textFieldHeight.getText());
            GameWindowApplication gameWindowApplication = new GameWindowApplication(width, height);
            gameWindowApplication.start(primaryStage);
        });

        root.getChildren().addAll(labelParameters, labelWidthOfGameWindow, textFieldWidth, labelHeightOfGameWindow, textFieldHeight, buttonGetParameters);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
