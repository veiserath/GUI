package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Addition extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button buttonAdd = new Button("Add them together!");

        TextField textFieldFirstElement = new TextField();
        TextField textFieldSecondElement = new TextField();

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(textFieldFirstElement,textFieldSecondElement,buttonAdd);

        Scene scene = new Scene(flowPane);

        buttonAdd.setOnAction(event -> {
            double result = Double.parseDouble(textFieldFirstElement.getText()) + Double.parseDouble(textFieldSecondElement.getText());
            buttonAdd.setText(Double.toString(result));
        });

        primaryStage.sizeToScene();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Addition");
        primaryStage.show();

    }
}
