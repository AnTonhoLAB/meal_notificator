/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.controller;

import com.mealnotificator.model.Meal;
import com.mealnotificator.model.bo.MealBO;
import com.mealnotificator.util.InstituitionToOpen;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author George
 */
public class AddMealViewController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private TextArea taDescricao;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    private void btSalvar(ActionEvent event) throws ParseException, Exception {
      MealBO mBO = new MealBO();
     
          
        try { 
            Meal m = new Meal();
            m.setName(this.tfNome.getText());
            m.setDescription(this.taDescricao.getText());
           m.setMealDate(new Date());
           m.setInstituition(InstituitionToOpen.getInstance().getInstituition());
     
         mBO.save(m);
            
            WindowController.getInstance().closeAddMeal();
            WindowController.getInstance().unfreeze();
        
        } catch (Exception e) {
            System.out.println(e.toString());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(e.getMessage());
            alert.setResizable(true);
            Optional<ButtonType> result = alert.showAndWait();
        }        
        
    }
    
}
