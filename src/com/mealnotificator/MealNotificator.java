/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator;

import com.mealnotificator.controller.WindowController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author george
 */
public class MealNotificator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        WindowController.getInstance().start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
