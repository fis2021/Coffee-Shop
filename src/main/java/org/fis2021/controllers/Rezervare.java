package org.fis2021.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.fis2021.models.Booking;

public class Rezervare {

    @FXML
    private ChoiceBox CB;
    @FXML
    private ChoiceBox ora;

    public void initialize(){
        CB.getItems().addAll(1, 2, 3, 4);
        CB.getSelectionModel().select(0);
        ora.getItems().addAll("10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00");
        ora.getSelectionModel().select("10:00");
    }
    public Object getChoice() {
        return ora.getSelectionModel().getSelectedItem();
    }

    public void VerifyDisponibility() {

    }




}
