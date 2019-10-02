/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empire;

import java.util.List;

/**
 *
 * @author Thrawn
 */
public class Building {
    String name;
    String description;
    List<Stock> produce;
    Long buildingTime;

    public Building(String name, String description, List<Stock> produce, Long buildingTime) {
        this.name = name;
        this.description = description;
        this.produce = produce;
        this.buildingTime = buildingTime;
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

    public List<Stock> getProduce() {
        return produce;
    }

    public void setProduce(List<Stock> produce) {
        this.produce = produce;
    }

    public Long getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(Long buildingTime) {
        this.buildingTime = buildingTime;
    }
    
    
}
