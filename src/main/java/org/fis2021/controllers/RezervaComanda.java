package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RezervaComanda {
    @FXML
    private Button buttonRezervare;

    @FXML
    private void loadRezervare(){
        try {
            Stage stage = (Stage) buttonRezervare.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Rezervare.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Rezervare - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
