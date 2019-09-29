package hu.oenik.data;

import java.util.ArrayList;

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
    private String name,loginName,password;
    private Boolean admin;
    ArrayList<Hero> heroes;

    
    public User(String name, String loginName, String password, Boolean admin) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.admin = admin;
    }

    public User(String loginName, String password, Boolean admin) {
        this.loginName = loginName;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }
    
    
}
