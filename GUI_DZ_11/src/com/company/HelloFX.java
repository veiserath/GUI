package com.company;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class HelloFX extends Application {
    boolean clicked;

    public HelloFX() {
        this.clicked = false;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Hello world");
        button.setOnAction(event -> {
            if (!clicked){
                button.setText("Hi!");
                clicked = true;
            }
            else{
                button.setText("Hello world");
                clicked = false;
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root,200,200);


        primaryStage.setTitle("Hello world");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }

}
