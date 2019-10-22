/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thrawn
 */
@Entity
@Table(name = "buildings")
public class Building {
    String name;
    String description;
    
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @OneToMany
    List<Stock> produce;
    Long buildingTime;
    
    public Building(){
        
    }

    public Building(String name, String description, int pr, Long buildingTime) {
        this.name = name;
        this.description = description;
        this.produce = CreateStockRequirements(pr);
        this.buildingTime = buildingTime;
    }
     private ArrayList<Stock> CreateStockRequirements(int b){ 
        ArrayList<Stock> req = new ArrayList<Stock>();
        switch(b){
            case 1:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)40));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)20));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)30));
                break;
            case 2:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)10));
                
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)30));
                break;
            case 3:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)50));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)10));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)40));
                break;
            case 4:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)20));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)10));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)30));
                break;
            case 5:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)30));                
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)10));
                break;
            case 6:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)50));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)50));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)50));
                break;
        }
        
        return req;
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
