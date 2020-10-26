package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.font.FontFamily;

public class TextEditor extends Application {
    Font font;

    public TextEditor() {
         this.font = new Font(12);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane flowPane = new FlowPane();
        VBox vBox = new VBox();

        TextArea textArea = new TextArea();
        Button underlined = new Button("U");
        Button bold = new Button("B");
        Button backgroundColor = new Button("Background color");
        Button textColor = new Button("Text color");
        TextField textField = new TextField("Rozmiar pisma");
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "Calibri", "Times New Roman", "Arial")
        );

        flowPane.getChildren().addAll(underlined,bold,backgroundColor,textColor,textField,choiceBox);

        vBox.getChildren().addAll(flowPane,textArea);

        Scene scene = new Scene(vBox);

        Font font = new Font("verdana",12);

        underlined.setOnAction(event -> {
            textArea.setStyle("-fx-background-color: green;");
            textArea.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));

        });

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                // set the text for the label to the selected item

                textArea.setFont(Font.font ("Verdana", 20));
//                textArea.setFont(Font.font(FontWeight.BOLD));
            }
        });
        primaryStage.setTitle("Text editor");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();







    }

    public static void main(String[] args) {
        launch(args);
    }
}
