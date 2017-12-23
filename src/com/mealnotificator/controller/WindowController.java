/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 *
 * @author George
 */
public class WindowController {
    private Window win;
    
    private Stage addInstStage;
    private Stage openInstStage;
    private Stage addUserStage;
    private Stage addMealStage;
    private Stage openCalendarStage;
    
    private static WindowController instance;
    
     public static WindowController getInstance(){
        if(instance == null)
            instance = new WindowController();
           return instance;
    }
     
     public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/MainView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
     
     public void AddInstituition() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/AddInstituitionView.fxml"));
            this.addInstStage = new Stage();
            
            this.addInstStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            this.addInstStage.setScene(scene);
            this.addInstStage.setResizable(false);
            
            this.addInstStage.show();
            // configura ação apos a propria janela ser fechada
            this.addInstStage.setOnCloseRequest((WindowEvent t) -> {
                t.consume();
                WindowController.getInstance().unfreeze();
                this.addInstStage.close();
            });
        
    }
      public void AddUser() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/AddUserView.fxml"));
            this.addUserStage = new Stage();
            
            this.addUserStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            this.addUserStage.setScene(scene);
            this.addUserStage.setResizable(false);
            
            this.addUserStage.show();
            // configura ação apos a propria janela ser fechada
            this.addUserStage.setOnCloseRequest((WindowEvent t) -> {
                t.consume();
                WindowController.getInstance().unfreeze();
                this.addUserStage.close();
            });
        
    }
      
       public void AddMeal() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/AddMealView.fxml"));
            this.addMealStage = new Stage();
            
            this.addMealStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            this.addMealStage.setScene(scene);
            this.addMealStage.setResizable(false);
            
            this.addMealStage.show();
            // configura ação apos a propria janela ser fechada
            this.addMealStage.setOnCloseRequest((WindowEvent t) -> {
                t.consume();
                WindowController.getInstance().unfreeze();
                this.addMealStage.close();
            });
        
    }
     
     
     
     public void OpenInstituition() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/InstituitionView.fxml"));
            this.openInstStage = new Stage();
            
            this.openInstStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            this.openInstStage.setScene(scene);
            this.openInstStage.setResizable(false);
            
            this.openInstStage.show();
            // configura ação apos a propria janela ser fechada
            this.openInstStage.setOnCloseRequest((WindowEvent t) -> {
                t.consume();
                WindowController.getInstance().unfreeze();
                this.openInstStage.close();
            });
        
    }
     
     public void OpenCalendar() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/com/mealnotificator/view/CalendarView.fxml"));
            this.openCalendarStage = new Stage();
            
            this.openCalendarStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            this.openCalendarStage.setScene(scene);
            this.openCalendarStage.setResizable(false);
            
            this.openCalendarStage.show();
            // configura ação apos a propria janela ser fechada
            this.openCalendarStage.setOnCloseRequest((WindowEvent t) -> {
                t.consume();
                WindowController.getInstance().unfreeze();
                this.openCalendarStage.close();
            });
        
    }
     
    public void freeze(Window window){
       this.win = window;
       window.setOpacity(0.7);
    }
    
    public void unfreeze(){
        this.win.setOpacity(1);     
    }


    void closeAddInstituition() {
        this.addInstStage.close();
        this.unfreeze();
     }
    
    void closeInstituition() {
        this.addInstStage.close();
        this.unfreeze();
     }

    void closeAddUser() {
        this.addUserStage.close();
    }
    
    void closeAddMeal() {
        this.addMealStage.close();
    }
    
    void closeCalendar() {
        this.openCalendarStage.close();
    }
}
