/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.controller;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Instituition;
import com.mealnotificator.model.Meal;
import com.mealnotificator.model.User;
import com.mealnotificator.util.InstituitionToOpen;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author George
 */
public class InstituitionViewController implements Initializable {

    @FXML
    private TableView <User> tvUsuarios; 
    @FXML
    private TableColumn <User, String> tbNome;
    @FXML
    private TableColumn <User, String> tbEmail;
    
    
    @FXML
    private TableView <Meal> tvRef; 
    @FXML
    private TableColumn <Meal, String> tbRef;
    @FXML
    private TableColumn <Meal, String> tbData;
    
    
    
    Instituition i; 
    public ObservableList<User> users;
    public ObservableList<Meal> meals;
    
    HibernateDAO hd = new HibernateDAO(new Instituition());
    HibernateDAO hM = new HibernateDAO(new Meal());
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        i = InstituitionToOpen.getInstance().getInstituition();
        users = FXCollections.observableArrayList(i.getUsers());
        meals =  FXCollections.observableArrayList(i.getMeals());
     
        populateTableView();
        populateMeals();
    }    
    
    @FXML
    private void btAddUser(ActionEvent event) throws Exception{
       
        WindowController.getInstance().AddUser();
    }
    @FXML
    private void btUpdateUser(ActionEvent event) throws Exception{
      
        attUserTable();
    }
    
     @FXML
    private void btAddRef(ActionEvent event) throws Exception{
      
        WindowController.getInstance().AddMeal();
    }
     @FXML
    private void btUpdateRef(ActionEvent event) throws Exception{
      
        attRef();
    }
    @FXML
    private void btCalendar(ActionEvent event) throws Exception{
      WindowController.getInstance().OpenCalendar();
    }
    
    private void populateTableView() {
      this.tbNome.setCellValueFactory(new PropertyValueFactory<>("name"));
      this.tbEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
      attUserTable();
    }
    
    private void populateMeals() {
        this.tbRef.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tbData.setCellValueFactory(new PropertyValueFactory<>("date"));
      attRef();
    }
    
    private void attUserTable() {
        
        ArrayList<Instituition> ins = (ArrayList<Instituition>) hd.findAllWithoutClose();
        for (Instituition in : ins) {
            if (i.getIdInstituition() == in.getIdInstituition()){
                i = in;
            }
        }
                 
         users = FXCollections.observableArrayList(i.getUsers());
         this.tvUsuarios.setItems(users);   
    }
    
    private void attRef(){
        ArrayList<Instituition> ins = (ArrayList<Instituition>) hd.findAllWithoutClose();
        for (Instituition in : ins) {
            if (i.getIdInstituition() == in.getIdInstituition()){
                i = in;
            }
        }
        meals = FXCollections.observableArrayList(i.getMeals());
        this.tvRef.setItems(meals);
    }

    
    
    
    
    
}
