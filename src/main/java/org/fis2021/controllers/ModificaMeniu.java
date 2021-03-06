package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ModificaMeniu {
    @FXML
    private Button buttonAdaugaProdus;
    @FXML
    private Button backButton;

    @FXML
    private void loadAdaugaProdus(){
        try {
            Stage stage = (Stage) buttonAdaugaProdus.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/AdaugaProdus.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Adauga Produs - Coffee Shop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadCafeneaHomePage(){
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/CafeneaHomePage.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Coffee Shop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
