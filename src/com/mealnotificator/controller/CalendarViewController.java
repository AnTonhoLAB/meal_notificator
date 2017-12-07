package com.mealnotificator.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mealnotificator.util.CalendarToMatrices;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author george
 */
public class CalendarViewController implements Initializable {
    
    @FXML
    private Label lbYear;
    @FXML
    private Label lbMonth;
    
    
    
    CalendarToMatrices c = new CalendarToMatrices();
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
       // lbYear.setText(c.Y);
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
