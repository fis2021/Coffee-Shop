package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CafeneaHomePage {
    @FXML
    private Button buttonVeziIstoric;

    @FXML
    public void loadVeziIstoric(){
        try {
            Stage stage = (Stage) buttonVeziIstoric.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/VeziIstoric.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Vezi Istoric - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
