package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.fis2021.models.Booking;
import org.fis2021.models.User;
import org.fis2021.services.RezervareService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Rezervare {

    @FXML
    private ChoiceBox CB;
    @FXML
    private ChoiceBox ora;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label errMessage;
    @FXML
    private Button backButton;

    public void initialize(){
        RezervareService.initService();
        CB.getItems().addAll(1, 2, 3, 4);
        CB.getSelectionModel().select(0);
        ora.getItems().addAll("10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00");
        ora.getSelectionModel().select("10:00");
    }

    private void resetForm(){
        CB.getSelectionModel().select(0);
        ora.getSelectionModel().select("10:00");
        datePicker.getEditor().clear();
        nameField.clear();
    }

    public boolean verifyDisponibility() {
        ArrayList<Booking> resList = RezervareService.getAll();
        List<Booking> auxList = resList.stream().filter((Booking e) -> e.getData().equals(datePicker.getValue().toString())).collect(Collectors.toList());
        auxList = auxList.stream().filter((Booking e) -> e.getOra().equals(ora.getSelectionModel().getSelectedItem())).collect(Collectors.toList());
        resList = new ArrayList<Booking>(auxList);

        int totalPers = 0;

        for(Booking r : resList){
            totalPers += r.getNrPers();
        }

        if(totalPers + (Integer) CB.getSelectionModel().getSelectedItem() > 10) return false;

        return true;
    }

    public void addRes(){
        if(verifyDisponibility()) {
            Stage stage = (Stage) datePicker.getScene().getWindow();
            User currentUser = (User) stage.getUserData();
            RezervareService.addRes(currentUser.getUsername(), nameField.getText(), (Integer) CB.getSelectionModel().getSelectedItem(), datePicker.getValue().toString(), (String) ora.getSelectionModel().getSelectedItem());
            errMessage.setText("Rezervare finalizata cu succes!");
            resetForm();
        }

        else{
            errMessage.setText("Nu mai sunt locuri disponibile la ora si data aleasa!");
            resetForm();
        }
    }

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
