package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viki
 */
@Entity
@Table(name="user")
public class User {
    private String name,password;
    private Boolean admin;
    @OneToMany
    private List<Hero> heroes = new ArrayList<>();
    @OneToMany
    private List<Empire> empires = new ArrayList<>();
    
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
 
    
    public User(String name, String password, Boolean admin) {
        this.name = name;
        this.password = password;
        this.admin = admin;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
    
       public List<Empire> getEmpires() {
        return empires;
    }

    public void setEmpires(List<Empire> empires) {
        this.empires = empires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
