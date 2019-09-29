/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

/**
 *
 * @author Viki
 */
public class Quality {
    String name, description;
    Ability ability;

    public Quality(String name, String description, Ability ability) {
        this.name = name;
        this.description = description;
        this.ability = ability;
    }

    public Quality() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    
}
