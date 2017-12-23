/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.controller;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Address;
import com.mealnotificator.model.City;
import com.mealnotificator.model.Instituition;
import com.mealnotificator.model.State;
import com.mealnotificator.model.User;
import com.mealnotificator.model.bo.InstituitionBO;
import com.mealnotificator.model.bo.UserBO;
import com.mealnotificator.util.InstituitionToOpen;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author George
 */
public class AddUserViewController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfCidade;
    @FXML
    private ComboBox cbEstado;
    
   
     ArrayList<State> allStates;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populeStates();
    }    
    
    
    @FXML
    private void btAdd(ActionEvent event) throws ParseException, Exception {
       UserBO uBO = new UserBO();
     
        try { 
            User u = new User();
            u.setName(this.tfNome.getText());
            u.setEmail(this.tfEmail.getText());
                Address a = new Address();
                a.setStreet(tfRua.getText());
                a.setNumber(getNumber());
                a.setCity(getCity());
            u.setAddress(a);
            u.setInstituition(InstituitionToOpen.getInstance().getInstituition());
            uBO.save(u);
            
            WindowController.getInstance().closeAddUser();
            WindowController.getInstance().unfreeze();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(e.getMessage());
            alert.setResizable(true);
            Optional<ButtonType> result = alert.showAndWait();
        }        
        
    }
    
     private int getNumber(){
        int o;
        try {
            
            o = Integer.parseInt(tfNumero.getText());
        } catch (Exception e) {
            o = 0;
        }
            return o;
    }
    
    private City getCity(){
        City c = new City();
       
        try {
            c.setName(tfCidade.getText());
            c.setState(getState());
        } catch (Exception e) {
            c.setName("");
            c.setState(getState());
        }
       
        return c;
    }
    
    private State getState(){
        State st = new State();
        
        try {
            st.setName(cbEstado.getSelectionModel().getSelectedItem().toString());
        } catch (Exception e) {
            st.setName("");
        }
        return st;
    }
    
    private void populeStates(){
        HibernateDAO sDao = new HibernateDAO(new State());
        this.allStates = (ArrayList<State>) sDao.findAll();
        ArrayList<String> stateNames = new ArrayList<>();
        
        for (State state : allStates) {
            stateNames.add(state.getName());
        }
        
        ObservableList obsStates= FXCollections.observableList(stateNames);
        cbEstado.getItems().clear();
        cbEstado.setItems(obsStates);
    }
    
}
