/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.controller;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Instituition;
import com.mealnotificator.util.InstituitionToOpen;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author George
 */
public class MainViewController implements Initializable {

    ObservableList instituitionsList;   
    HibernateDAO hDAO = new HibernateDAO(new Instituition());
    
    @FXML
    private TableView <Instituition> tvInstituition;
    @FXML
    private TableColumn<Instituition, String> tbInstituition;
    @FXML
    private TableColumn<Instituition, String> tbUsers;
    @FXML
    private TableColumn<Instituition, String> tbAddress;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        attTbInstituition();
        populateTbInstituition();
    }    
    
    @FXML
    private void btAddInstituition(ActionEvent event) throws Exception{
      WindowController.getInstance().freeze(((Node)(event.getSource())).getScene().getWindow());
      WindowController.getInstance().AddInstituition();
  
    }
    
    @FXML
    private void btOpenInstituition(ActionEvent event) throws Exception{
    
        try {
            InstituitionToOpen.getInstance().setInstituition(tvInstituition.getSelectionModel().getSelectedItem());
            WindowController.getInstance().OpenInstituition();
             System.out.println("a");
            WindowController.getInstance().freeze(((Node)(event.getSource())).getScene().getWindow());
          
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("selecione uma instituição para ser aberta");
            alert.setResizable(true);
            Optional<ButtonType> result = alert.showAndWait();
        }
          
    }
    
    @FXML
    private void btUpdate(ActionEvent event) throws Exception{
        attTbInstituition();
    }

    private void populateTbInstituition() {
        tbInstituition.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbUsers.setCellValueFactory(new Callback<CellDataFeatures<Instituition, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Instituition, String> c) {        
               int number = c.getValue().getUsers().size();
               return new SimpleStringProperty(String.valueOf(number));                
            }
        }); 
                
        tbAddress.setCellValueFactory(new Callback<CellDataFeatures<Instituition, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Instituition, String> c) {
               return new SimpleStringProperty(c.getValue().getAddress().getStreet());                
            }
        }); 
        
        attTbInstituition();
    }
    
    private void attTbInstituition(){
        this.instituitionsList = FXCollections.observableArrayList(hDAO.findAllWithoutClose());
        this.tvInstituition.setItems(instituitionsList);           
    }
    
}
