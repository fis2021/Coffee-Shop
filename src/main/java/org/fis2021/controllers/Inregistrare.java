package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis2021.exceptions.UsernameAlreadyExists;
import org.fis2021.services.UserService;

import java.io.IOException;

public class Inregistrare {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Cafenea");
        role.getSelectionModel().select(0);
    }

    @FXML
    public void handleRegisterAction() {
        try {
            if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
                registrationMessage.setText("Campurile trebuie completate!");
                return;
            }
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Contul a fost creat cu succes!");
        } catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}