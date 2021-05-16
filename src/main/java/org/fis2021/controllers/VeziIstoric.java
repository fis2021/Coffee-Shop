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
    private Button backButton;

    public void loadCafeneaHomePage(){
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

    @FXML
    private Button buton;

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
