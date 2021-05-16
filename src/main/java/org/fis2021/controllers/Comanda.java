package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class Comanda {
    @FXML
    private Button buttonRidicare;

    @FXML
    private Button buttonLivrare;

    @FXML
    private Button backButton;

    @FXML
    private void loadRidicare(){
        try {
            Stage stage = (Stage) buttonRidicare.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Ridicare.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Comanda - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadLivrare(){
        try {
            Stage stage = (Stage) buttonLivrare.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Livrare.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Comanda - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadHomePage() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Rezerva-Comanda.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Coffee Shop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
