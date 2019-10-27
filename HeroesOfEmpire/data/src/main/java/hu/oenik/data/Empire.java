/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thrawn
 */

@Entity
@Table(name="empire")
public class Empire {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    
    String name;
    String description;
    Long level;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Empire_ID")
    List<Population> population = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="empire_produce")
    List<Stock> produce= new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="empire_warehouse")
    List<Stock> warehouse= new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Empire_ID")
    List<Building> buildings= new ArrayList<>();
    
    EnvironmentTypes environmentType;
    
    @ManyToOne
    @JoinColumn(name="USER_ID")
    User user;
    
    public Empire() {
    }

    public Empire(String name, String description, Long level, User u) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.user = u;
    }

    public Empire(String name, String description, Long level, List<Population> population, List<Stock> produce, List<Stock> warehouse, List<Building> buildings, EnvironmentTypes environmentType) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.population = population;
        this.produce = produce;
        this.warehouse = warehouse;
        this.buildings = buildings;
        this.environmentType = environmentType;
    }  


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
//    public Empire(String name, String description, EnvironmentTypes envType )
//    {
//        this.name = name;
//        this.description = description;
//        this.level = new Long(1);        
//        this.population = new ArrayList<Population>();
//        this.produce = new ArrayList<Stock>();
//        this.warehouse = new ArrayList<Stock>();
//        this.buildings = new ArrayList<Building>();
//        environmentType = envType;
//        GenerateEnvironment(envType);
//       
//    }
    
//    private void GenerateEnvironment(EnvironmentTypes envType){
//        for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){                     
//                  produce.add(new Stock(s,(long)(5)));                     
//                 }
//        switch(envType){
//            case Mountainous:
//                for (People p : PeopleRepository.getInstance().getPeople())
//                {
//                 if(p.getName().equals("Miner")){
//                 population.add(new Population(p,(long)30));
//                 
//                }
//                 else{
//                     population.add(new Population(p,(long)10));
//                 }
//                }       
//                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
//                     if(s.getName().equals("Stone")){
//                        warehouse.add(new Stock(s,(long)(10)));
//                        
//                     }
//                     else{
//                         warehouse.add(new Stock(s,(long)(5)));
//                     }
//                 }                
//                
//                break;
//            case Flatlands:
//                for (People p : PeopleRepository.getInstance().getPeople())
//                {
//                 if(p.getName().equals("Farmer")){
//                 population.add(new Population(p,(long)30));
//                 
//                }
//                 else{
//                     population.add(new Population(p,(long)10));
//                 }
//                }                 
//                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
//                     if(s.getName().equals("Food")){
//                        warehouse.add(new Stock(s,(long)(10)));                        
//                     }
//                     else{
//                         warehouse.add(new Stock(s,(long)(5)));
//                     }
//                 }
//                
//                break;
//            case Forest:
//                for (People p : PeopleRepository.getInstance().getPeople())
//                {
//                 if(p.getName().equals("Farmer")){
//                 population.add(new Population(p,(long)30));                 
//                }
//                 else{
//                     population.add(new Population(p,(long)10));
//                 }
//                }                 
//                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
//                     if(s.getName().equals("Food")){
//                        warehouse.add(new Stock(s,(long)(10)));                       
//                     }
//                     else{
//                         warehouse.add(new Stock(s,(long)(5)));
//                     }
//                 }
//                
//                break;
//                
//            case Budapest:
//                for (People p : PeopleRepository.getInstance().getPeople())
//                {
//                 if(p.getName().equals("Soldier")){
//                 population.add(new Population(p,(long)20));
//                                  
//                }
//                 else if(p.getName().equals("Badass soldier")){
//                     population.add(new Population(p,(long)10));
//                 }
//                
//                 else{
//                     population.add(new Population(p,(long)10));
//                 }
//                }                
//                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
//                     if(s.getName().equals("Gold")){
//                        warehouse.add(new Stock(s,(long)(10)));                        
//                     }
//                     else{
//                         warehouse.add(new Stock(s,(long)(5)));
//                     }
//                 }
//                
//                break;
//            case Beach:
//                for (People p : PeopleRepository.getInstance().getPeople())
//                {
//                 if(p.getName().equals("Worker")){
//                 population.add(new Population(p,(long)20));
//                 
//                }
//                 else if(p.getName().equals("Soldier")){
//                     population.add(new Population(p,(long)10));
//                 }
//                 else{
//                     population.add(new Population(p,(long)10));
//                 }
//                }
//                 for (NaturalAsset s:NaturalAssetRepository.getInstance().getAssets()){
//                     if(s.getName().equals("Gold")){
//                        warehouse.add(new Stock(s,(long)(10)));
//                     }
//                     else{
//                         warehouse.add(new Stock(s,(long)(5)));
//                     }
//                 }                               
//                break;
//        }
//    }
//    
//    public boolean ConstructNewBuilding(){
//    //TODO
//        return true;
//    }
//    
//    public void TimeChanged(){
//        //TODO valami ilyesminek kéne történie körről körre?
//        for(Population p : population){
//         p.quantity++;
//        }
//        for(Stock w : warehouse){            
//            for (Stock p: produce) {
//                if(w.getAsset().getName()==p.getAsset().getName())
//                    p.quantity+=p.quantity;
//            }       
//        }
//    }

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

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }    

    public EnvironmentTypes getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(EnvironmentTypes environmentType) {
        this.environmentType = environmentType;
    }    
        
}