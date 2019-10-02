package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viki
 */
public class User {
    private String name,userName,password;
    private Boolean admin;
    private List<Hero> heroes = new ArrayList<>();
    private List<Empire> empires = new ArrayList<>();
 
    
    public User(String name, String userName, String password, Boolean admin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }

    public User(String userName, String password, Boolean admin) {
        this.userName = userName;
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

    public String GetUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
