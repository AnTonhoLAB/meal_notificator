/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.util;

import com.mealnotificator.model.Instituition;

/**
 *
 * @author George
 */
public class InstituitionToOpen {
    Instituition i; 
    
    private static InstituitionToOpen instance;
    
     public static InstituitionToOpen getInstance(){
        if(instance == null)
            instance = new InstituitionToOpen();
           return instance;
    }
     
    public Instituition getInstituition(){
       return this.i;
   } 
   
    public void setInstituition(Instituition i){
        this.i = i;
    }
}
