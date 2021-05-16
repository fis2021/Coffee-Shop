package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.fis2021.models.Order;
import org.fis2021.models.User;
import org.fis2021.services.ComandaService;
import org.fis2021.services.RezervareService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ridicare {
    @FXML
    private ChoiceBox ora;
    @FXML
    private TextField nume;
    @FXML
    private DatePicker data;
    @FXML
    private Label errMessage;
    @FXML
    private Button backButton;

    public void initialize(){
        ComandaService.initService();
        ora.getItems().addAll("10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00");
        ora.getSelectionModel().select("10:00");
    }

    private void resetForm(){
        ora.getSelectionModel().select("10:00");
        data.getEditor().clear();
        nume.clear();
    }

    public boolean verifyDisponibility() {
        ArrayList<Order> ordList = ComandaService.getAll();
        List<Order> auxList = ordList.stream().filter((Order e) -> e.getData().equals(data.getValue().toString())).collect(Collectors.toList());
        auxList = auxList.stream().filter((Order e) -> e.getOra().equals(ora.getSelectionModel().getSelectedItem())).collect(Collectors.toList());
        ordList = new ArrayList<Order>(auxList);

        int contor=0;

        for(Order r : ordList){
            contor++;
        }

        if(contor > 10) return false;

        return true;
    }

    public void addOrd(){
        if(verifyDisponibility()) {
            Stage stage = (Stage) data.getScene().getWindow();
            User currentUser = (User) stage.getUserData();
            ComandaService.addOrd(currentUser.getUsername(), nume.getText(),data.getValue().toString(), (String) ora.getSelectionModel().getSelectedItem());
            errMessage.setText("Comanda plasata cu succes!");
            resetForm();
        }

        else{
            errMessage.setText("Prea multe comenzi existente la ora si data aleasa!");
            resetForm();
        }
    }

    @FXML
    private void loadComanda(){
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/Comanda.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Comanda - Coffee Shop");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
