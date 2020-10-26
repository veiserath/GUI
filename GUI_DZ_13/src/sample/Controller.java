package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
    @FXML
    public TextField textFieldLogin;
    @FXML
    public TextField textFieldPassword;
    @FXML
    public Label labelLoginStatus;
    @FXML
    public Button buttonLogIn;

    String login;
    String password;

    Map<String, String> loginCredentials;

    public Controller() {

        this.loginCredentials = new HashMap<>();
        this.buttonLogIn = new Button();
        loginCredentials.put("Michal", "123Michal033");
        this.labelLoginStatus = new Label();
//        this.buttonLogIn.setOnAction(event -> {
//
//        });
    }


    public boolean findCombination(Map<String, String> loginCredentials, String login, String password) {

        Iterator it = loginCredentials.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals(login) && pair.getValue().equals(password)) {
                return true;
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return false;
    }
    public void methoda(){
        System.out.println("Clicked");
        login = textFieldLogin.getText();
        password = textFieldPassword.getText();
        if (findCombination(loginCredentials, login, password)) {
            labelLoginStatus.setText("Login successful");
        } else if (!findCombination(loginCredentials, login, password)) {
            labelLoginStatus.setText("Wrong combination");
        }
    }

}


