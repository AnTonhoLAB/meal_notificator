/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.model.bo;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Meal;

/**
 *
 * @author George
 */
public class MealBO {
    private HibernateDAO hDao;
    
    public MealBO(){
       this.hDao = new HibernateDAO(new Meal());  
    }
    
    
    private void validate(Meal m) throws Exception{
        if (m.getName().length() < 3)
            throw new Exception ("Colocque um nome com no minimo 3 letras");
         if (m.getDescription().length() < 20)
            throw new Exception ("Colocque uma descriçãp com no minimo 20 letras");
    }
    
    public void save(Meal m) throws Exception{
        validate(m);
        this.hDao.save(m);
    }
}
