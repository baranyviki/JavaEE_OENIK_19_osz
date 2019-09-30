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
public class Empire {
    String name;
    String description;
    Long level;
    List<Population> population;
    List<Stock> produce;
    List<Stock> warehouse;

    public Empire(String name, String description, Long level, List<Population> population, List<Stock> produce, List<Stock> warehouse) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.population = population;
        this.produce = produce;
        this.warehouse = warehouse;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public List<Population> getPopulation() {
        return population;
    }

    public void setPopulation(List<Population> population) {
        this.population = population;
    }

    public List<Stock> getProduce() {
        return produce;
    }

    public void setProduce(List<Stock> produce) {
        this.produce = produce;
    }

    public List<Stock> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Stock> warehouse) {
        this.warehouse = warehouse;
    }
    
    
}
