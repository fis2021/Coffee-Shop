package org.fis2021.controllers;

import javafx.fxml.FXML;
import org.fis2021.exceptions.ProductAlreadyExists;
import org.fis2021.services.ProductService;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdaugaProdus {
    @FXML
    private TextField produs;
    @FXML
    private TextField pret;
    @FXML
    private Label errMessage;

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
}