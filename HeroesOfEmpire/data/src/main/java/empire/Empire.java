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
    List<Building> buildings;

    
    public Empire(String name, String description, EnvironmentTypes envType )
    {
        this.name = name;
        this.description = description;
        this.level = new Long(1);        
        this.population = new ArrayList<Population>();
        this.produce = new ArrayList<Stock>();
        this.warehouse = new ArrayList<Stock>();
        this.buildings = new ArrayList<Building>();
        GenerateEnvironment(envType);
    }
    
    private void GenerateEnvironment(EnvironmentTypes envType){
        
        switch(envType){
            case Mountainous:
                for (People p : PeopleRepository.getInstance().getPeople())
                {
                 if(p.getName().equals("Miner")){
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                }
                 else{
                     population.add(new Population(p,(long)10));
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Stone")){
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                     }
                     else{
                         produce.add(new Stock(s,(long)(5)));
                     }
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Stone")){
                        warehouse.add(new Stock(s,(long)(5)));
                        warehouse.add(new Stock(s,(long)(5)));
                     }
                     else{
                         warehouse.add(new Stock(s,(long)(5)));
                     }
                 }
                }
               
                break;
            case Flatlands:
                for (People p : PeopleRepository.getInstance().getPeople())
                {
                 if(p.getName().equals("Farmer")){
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                }
                 else{
                     population.add(new Population(p,(long)10));
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Food")){
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                     }
                     else{
                         produce.add(new Stock(s,(long)(5)));
                     }
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Food")){
                        warehouse.add(new Stock(s,(long)(5)));
                        warehouse.add(new Stock(s,(long)(5)));
                     }
                     else{
                         warehouse.add(new Stock(s,(long)(5)));
                     }
                 }
                }
                break;
            case Forest:
                for (People p : PeopleRepository.getInstance().getPeople())
                {
                 if(p.getName().equals("Farmer")){
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                }
                 else{
                     population.add(new Population(p,(long)10));
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Food")){
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                     }
                     else{
                         produce.add(new Stock(s,(long)(5)));
                     }
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Food")){
                        warehouse.add(new Stock(s,(long)(5)));
                        warehouse.add(new Stock(s,(long)(5)));
                     }
                     else{
                         warehouse.add(new Stock(s,(long)(5)));
                     }
                 }
                }
                break;
                
            case Budapest:
                for (People p : PeopleRepository.getInstance().getPeople())
                {
                 if(p.getName().equals("Soldier")){
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                 
                }
                 else if(p.getName().equals("Badass soldier")){
                     population.add(new Population(p,(long)10));
                 }
                 else{
                     population.add(new Population(p,(long)10));
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Gold")){
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                     }
                     else{
                         produce.add(new Stock(s,(long)(5)));
                     }
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Gold")){
                        warehouse.add(new Stock(s,(long)(5)));
                        warehouse.add(new Stock(s,(long)(5)));
                     }
                     else{
                         warehouse.add(new Stock(s,(long)(5)));
                     }
                 }
                }
                break;
            case Beach:
                for (People p : PeopleRepository.getInstance().getPeople())
                {
                 if(p.getName().equals("Worker")){
                 population.add(new Population(p,(long)10));
                 population.add(new Population(p,(long)10));
                 
                }
                 else if(p.getName().equals("Soldier")){
                     population.add(new Population(p,(long)10));
                 }
                 else{
                     population.add(new Population(p,(long)10));
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Food")){
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                         produce.add(new Stock(s,(long)(10)));
                     }
                     else{
                         produce.add(new Stock(s,(long)(5)));
                     }
                 }
                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
                     if(s.getName().equals("Gold")){
                        warehouse.add(new Stock(s,(long)(5)));
                        warehouse.add(new Stock(s,(long)(5)));
                     }
                     else{
                         warehouse.add(new Stock(s,(long)(5)));
                     }
                 }
                }                
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
