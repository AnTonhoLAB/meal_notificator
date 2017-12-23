/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.model.bo;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Address;
import com.mealnotificator.model.City;
import com.mealnotificator.model.State;
import com.mealnotificator.model.User;
import java.util.ArrayList;

/**
 *
 * @author George
 */
public class UserBO {
    
    private HibernateDAO hDao;
    
    public UserBO(){
       this.hDao = new HibernateDAO(new User());  
    }
    
    

    private void validate(User u) throws Exception{
        if(u.getName().length() < 1)
            throw new Exception("Coloque um nome na instituição");
        if(u.getEmail().length() <5 )
             throw new Exception("Coloque um email com mais de 5 letras");
        if(!u.getEmail().contains("@"))
             throw new Exception("Coloque @ no email");
          if(!u.getEmail().contains(".com"))
             throw new Exception("Coloque .com no email");
        if(u.getAddress().getStreet().length() < 5)
            throw new Exception("Coloque um nome para a rua com no minimo 5 letras");
        if(u.getAddress().getNumber() <= 0)
            throw new Exception("Coloque um numero maior que 0");
        if(u.getAddress().getCity().getName().length() < 5)
            throw new Exception("Coloque uma cidade com no minimo 5 letras");
        if(u.getAddress().getCity().getState().getName().length() < 4)
            throw new Exception("Escolha um Estado");
        
    }
    
    public void save(User u) throws Exception{
        validate(u);
        u.setAddress(getAddress(u.getAddress()));
        
        this.hDao.save(u);
    }
    
       private Address getAddress(Address ad) throws Exception{
        
        HibernateDAO sDao = new HibernateDAO(new State());
        HibernateDAO cDao = new HibernateDAO (new City());
        HibernateDAO aDao = new HibernateDAO (new Address());
 
     
    ArrayList<State> states = (ArrayList<State>) sDao.findAll();
      try {
         
           
       
       for (State state : states) {
           System.out.println(state.getName());
           if (state.getName().contains(ad.getCity().getState().getName()))
               ad.getCity().setState(state);
        }
      
       cDao.save(ad.getCity());
       aDao.save(ad);
          
     } catch (Exception e) {
          System.out.println(e.getMessage());
     }
    
       
       return ad;
 }
    
    
}
