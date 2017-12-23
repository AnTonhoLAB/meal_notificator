package com.mealnotificator.model;
// Generated Dec 21, 2017 4:42:31 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Instituition generated by hbm2java
 */
@Entity
@Table(name="instituition"
    ,catalog="MealManager"
)
public class Instituition  implements java.io.Serializable {


     private Integer idInstituition;
     private Address address;
     private String name;
     private String cnpj;
     private String coordinatorName;
     private Set<Meal> meals = new HashSet<Meal>(0);
     private Set<User> users = new HashSet<User>(0);

    public Instituition() {
    }

    public Instituition(Address address, String name, String cnpj, String coordinatorName, Set<Meal> meals, Set<User> users) {
       this.address = address;
       this.name = name;
       this.cnpj = cnpj;
       this.coordinatorName = coordinatorName;
       this.meals = meals;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idInstituition", unique=true, nullable=false)
    public Integer getIdInstituition() {
        return this.idInstituition;
    }
    
    public void setIdInstituition(Integer idInstituition) {
        this.idInstituition = idInstituition;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAddress")
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    
    @Column(name="name", length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public Set<Meal> getMeals() {
        return this.meals;
    }
    
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="instituition")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}

