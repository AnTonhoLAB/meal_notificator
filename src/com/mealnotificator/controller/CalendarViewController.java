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
import javafx.geometry.Pos;
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
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbYear.setAlignment(Pos.BASELINE_CENTER);
        lbMonth.setAlignment(Pos.BASELINE_CENTER);
        updateDate();
    }    
    
     @FXML
    private void btNextMonth(ActionEvent event) throws ParseException {
        c.nextCalendar();
        updateDate();
    }
    
     @FXML
    private void btPreviousMonth(ActionEvent event) throws ParseException {
        c.previousCalendar();
        updateDate();
    }
    
    private void updateDate(){
        lbYear.setText(""+c.getYear());
        String[] strMonth = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        lbMonth.setText(strMonth[c.getMonth() - 1]);
    }
    
}
