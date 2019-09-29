/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;

/**
 *
 * @author Viki
 */
public class Hero {

    String name, description;
    ArrayList<Hybrid> hybrids;
    ArrayList<Quality> qualities;

    public Hero(String name, String description, ArrayList<Hybrid> hybrids, ArrayList<Quality> qualities) {
        this.name = name;
        this.description = description;
        this.hybrids = hybrids;
        this.qualities = qualities;
    }

    public Hero(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Hero() {
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

    public ArrayList<Hybrid> getHybrids() {
        return hybrids;
    }

    public void setHybrids(ArrayList<Hybrid> hybrids) {
        this.hybrids = hybrids;
    }

    public ArrayList<Quality> getQualities() {
        return qualities;
    }

    public void setQualities(ArrayList<Quality> qualities) {
        this.qualities = qualities;
    }

}
