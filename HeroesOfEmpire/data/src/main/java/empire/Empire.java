/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empire;

import java.util.ArrayList;
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
    
    public Empire(String name, String description, EnvironmentTypes envType )
    {
        this.name = name;
        this.description = description;
        this.level = new Long(1);        
        this.population = new ArrayList<Population>();
        this.produce = new ArrayList<Stock>();
        this.warehouse = new ArrayList<Stock>();
        GenerateEnvironment(envType);
    }
    
    private void GenerateEnvironment(EnvironmentTypes envType){
        
        switch(envType){
            case Mountainous:
                for (Population p : PopulationRepository.getInstance().getPopulation())
                {
                 if(p.getPeople().getName().equals("Miner")){
                 population.add(p);population.add(p);population.add(p);
                }
                 else{
                     population.add(p);
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Stone")){
                         produce.add(s);produce.add(s);produce.add(s);
                     }
                     else{
                         produce.add(s);
                     }
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Stone")){
                         warehouse.add(s);warehouse.add(s);
                     }
                     else{
                         warehouse.add(s);
                     }
                 }
                }
               
                break;
            case Flatlands:
                for (Population p : PopulationRepository.getInstance().getPopulation())
                {
                 if(p.getPeople().getName().equals("Farmer")){
                 population.add(p);population.add(p);population.add(p);
                }
                 else{
                     population.add(p);
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Food")){
                         produce.add(s);produce.add(s);produce.add(s);
                     }
                     else{
                         produce.add(s);
                     }
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Food")){
                         warehouse.add(s);warehouse.add(s);
                     }
                     else{
                         warehouse.add(s);
                     }
                 }
                }
                break;
            case Forest:
                for (Population p : PopulationRepository.getInstance().getPopulation())
                {
                 if(p.getPeople().getName().equals("Worker")){
                 population.add(p);population.add(p);population.add(p);
                }
                 else{
                     population.add(p);
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Wood")){
                         produce.add(s);produce.add(s);produce.add(s);
                     }
                     else{
                         produce.add(s);
                     }
                 }
                 for (Stock s:StockRepository.getInstance().getStocks()){
                     if(s.getAsset().getName().equals("Wood")){
                         warehouse.add(s);warehouse.add(s);
                     }
                     else{
                         warehouse.add(s);
                     }
                 }
                }
                break;
                
            case Budapest:
                
                break;
            case Beach:
                
                break;
        }
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
