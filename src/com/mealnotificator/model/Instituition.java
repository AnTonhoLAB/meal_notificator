package com.mealnotificator.model;
// Generated Dec 13, 2017 5:09:03 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Instituition generated by hbm2java
 */
@Entity
@Table(name="instituition"
    ,catalog="MealManager"
)
public class Instituition  implements java.io.Serializable {


     private int idUser;
     private User user;
     private String cnpj;
     private String coordinatorName;
     private Set<Person> persons = new HashSet<Person>(0);
     private Set<Meal> meals = new HashSet<Meal>(0);

    public Instituition() {
    }

	
    public Instituition(User user) {
        this.user = user;
    }
    public Instituition(User user, String cnpj, String coordinatorName, Set<Person> persons, Set<Meal> meals) {
       this.user = user;
       this.cnpj = cnpj;
       this.coordinatorName = coordinatorName;
       this.persons = persons;
       this.meals = meals;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="idUser", unique=true, nullable=false)
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="cnpj", length=20)
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    @Column(name="coordinatorName", length=50)
    public String getCoordinatorName() {
        return this.coordinatorName;
    }
    
    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="instituition")
    public Set<Person> getPersons() {
        return this.persons;
    }
    
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="instituition")
    public Set<Meal> getMeals() {
        return this.meals;
    }
    
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }




}


