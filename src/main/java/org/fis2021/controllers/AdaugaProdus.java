package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.fis2021.exceptions.ProductAlreadyExists;
import org.fis2021.services.ProductService;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdaugaProdus {
    @FXML
    private TextField produs;
    @FXML
    private TextField pret;
    @FXML
    private Label errMessage;
    @FXML
    private Button backButton;

    public void initialize(){
        ProductService.initService();
    }

    @FXML
    private void resetForm(){
        produs.clear();
        pret.clear();
    }

    public void addProduct(){
        try {
            ProductService.addProduct(produs.getText(), Float.parseFloat(pret.getText()));
            errMessage.setText("Produsul a fost adaugat in meniu!");
            resetForm();
        }
        catch(ProductAlreadyExists e) {
            errMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void loadModificaMeniu(){
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/ModificaMeniu.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Modifica Meniu - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}