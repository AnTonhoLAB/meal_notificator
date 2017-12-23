package com.mealnotificator.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.State;
import com.mealnotificator.model.Week;

import com.mealnotificator.util.CalendarToMatrices;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author george
 */
public class CalendarViewController implements Initializable {
    
    @FXML
    private Label lbYear;
    @FXML
    private Label lbMonth;
    @FXML
    private TableView <Week> tbCalendar;
    @FXML
    private TableColumn<Week, String> tbDomingo;
    @FXML
    private TableColumn<Week, String> tbSegunda;
    @FXML
    private TableColumn<Week, String> tbTerca;
    @FXML
    private TableColumn<Week, String> tbQuarta;
    @FXML
    private TableColumn<Week, String> tbQuinta;
    @FXML
    private TableColumn<Week, String> tbSexta;
    @FXML
    private TableColumn<Week, String> tbSabado;
    
    
    CalendarToMatrices c = new CalendarToMatrices();
    ObservableList w; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lbYear.setAlignment(Pos.BASELINE_CENTER);
            lbMonth.setAlignment(Pos.BASELINE_CENTER);
            
        try {  
            updateDate();
            populateCalendar();
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
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

        
//        HibernateDAO hD = new HibernateDAO(new State());
//        ArrayList<State> sa = (ArrayList<State>) hD.findAll();
//        
//        for (State state : sa) {
//             System.out.println(state.getName());
//        }
    }
    
    private void updateDate() throws ParseException{
        lbYear.setText(""+c.getYear());
        String[] strMonth = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        lbMonth.setText(strMonth[c.getMonth() - 1]);
        w = FXCollections.observableArrayList(c.getWeeks());
        updateCalendar();
    }

    private void populateCalendar() throws ParseException {
        this.tbDomingo.setCellValueFactory( new PropertyValueFactory<>("domingo"));
        this.tbSegunda.setCellValueFactory( new PropertyValueFactory<>("segunda"));
        this.tbTerca.setCellValueFactory( new PropertyValueFactory<>("terca"));
        this.tbQuarta.setCellValueFactory( new PropertyValueFactory<>("quarta"));
        this.tbQuinta.setCellValueFactory( new PropertyValueFactory<>("quinta"));
        this.tbSexta.setCellValueFactory( new PropertyValueFactory<>("sexta"));
        this.tbSabado.setCellValueFactory( new PropertyValueFactory<>("sabado"));
        
        updateCalendar();
        
        }
    
    private void updateCalendar(){
        this.tbCalendar.setItems(this.w);
   
    }
    
}
