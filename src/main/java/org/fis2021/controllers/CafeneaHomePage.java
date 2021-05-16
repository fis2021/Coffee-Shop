package org.fis2021.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Button buttonModificaMeniu;
    @FXML
    private Button backButton;

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

    @FXML
    public void loadModificaMeniu(){
        try {
            Stage stage = (Stage) buttonModificaMeniu.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/ModificaMeniu.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Modifica Meniu - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadLogin(){
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
