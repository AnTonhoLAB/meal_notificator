/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mealnotificator.model.bo;

import com.mealnotificator.dao.HibernateDAO;
import com.mealnotificator.model.Address;
import com.mealnotificator.model.City;
import com.mealnotificator.model.Instituition;
import com.mealnotificator.model.State;
import java.util.ArrayList;

/**
 *
 * @author George
 */
public class InstituitionBO {
     private HibernateDAO hDao;
    
    public InstituitionBO(){
       this.hDao = new HibernateDAO(new Instituition());  
    }

    private void validate(Instituition i) throws Exception{
        if(i.getName().length() < 1)
            throw new Exception("Coloque um nome na instituição");
        if(i.getCnpj().length() < 8)
             throw new Exception("Coloque um cnpj válido");
        if(i.getCoordinatorName().length() < 2)
            throw new Exception("Coloque um nome para o coordenador");
     
        if(i.getAddress().getStreet().length() < 5)
            throw new Exception("Coloque um nome para a rua com no minimo 5 letras");
        if(i.getAddress().getNumber() <= 0)
            throw new Exception("Coloque um numero maior que 0");
        if(i.getAddress().getCity().getName().length() < 5)
            throw new Exception("Coloque uma cidade com no minimo 5 letras");
        if(i.getAddress().getCity().getState().getName().length() < 4)
            throw new Exception("Escolha um Estado");
        
    }

    public void save(Instituition i) throws Exception{
        validate(i);
        i.setAddress(getAddress(i.getAddress()));
        
        this.hDao.save(i);
    }

    private Address getAddress(Address ad) throws Exception{
        
        HibernateDAO sDao = new HibernateDAO(new State());
        HibernateDAO cDao = new HibernateDAO (new City());
        HibernateDAO aDao = new HibernateDAO (new Address());
 
     
    ArrayList<State> states = (ArrayList<State>) sDao.findAll();
      try {
         
           System.out.println(ad.getCity());
       
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
