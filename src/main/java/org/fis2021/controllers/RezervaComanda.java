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
    private Button buttonComanda;

    @FXML
    private Button backButton;

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

    @FXML
    private void loadComanda(){
        try {
            Stage stage = (Stage) buttonComanda.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Comanda.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Comanda - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadLogin() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Autentificare - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

