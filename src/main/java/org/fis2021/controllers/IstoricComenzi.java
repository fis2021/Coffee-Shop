package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.fis2021.models.Order;
import org.fis2021.services.ComandaService;

import java.io.IOException;
import java.util.ArrayList;

public class IstoricComenzi {

    @FXML
    private ListView myList;

    @FXML
    private Button backButton;

    public void setListContent(){
        ComandaService.initService();
        ArrayList<Order> orders = ComandaService.getAll();
        for(Order o : orders){
            myList.getItems().add(o.getNume() + "; " + o.getData().toString() + "; "+o.getOra().toString());
        }
    }
    @FXML
    public void loadVeziIstoric(){
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/VeziIstoric.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Vezi Istoric - CoffeeShop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}