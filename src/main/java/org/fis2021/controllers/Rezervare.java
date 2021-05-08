package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.fis2021.exceptions.InvalidCredentials;
import org.fis2021.models.User;
import org.fis2021.services.UserService;

import java.io.IOException;

public class Rezervare {

    @FXML
    private ChoiceBox CB;

    public void initialize(){
        CB.getItems().addAll(1, 2, 3, 4);
        CB.getSelectionModel().select(0);
    }


}
