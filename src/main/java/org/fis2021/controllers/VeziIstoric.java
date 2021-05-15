package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VeziIstoric {
    @FXML
    private Button buton;
    @FXML
    private Button backButton;

    @FXML
    void loadIstoricComenzi(){
        try {
            Stage stage = (Stage) buton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/IstoricComenzi.fxml"));
            Parent istoricComenziRoot = loader.load();
            IstoricComenzi controller = loader.getController();
            controller.setListContent();
            Scene scene = new Scene(istoricComenziRoot, 640, 480);
            stage.setTitle("Istoric Comenzi - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
