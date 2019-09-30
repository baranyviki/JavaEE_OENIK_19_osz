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
public class BuildingRepository {
    public static final BuildingRepository instance = new BuildingRepository();
    
    private List<Building> buildings = new ArrayList<>();

    public BuildingRepository() {
        buildings.add(new Building("Barrack", "Trains soldiers",CreateStockRequirements(1),(long)30));        
//        buildings.add(new Building("Gold", "Mostly used for train soldiers and pay for the ladies..i mean pray"));         
//        buildings.add(new Building("Wood", "Mostly used for build buildings"));       
//        buildings.add(new Building("Food", "nyam")); 
        
    }
    
    private ArrayList<Stock> CreateStockRequirements(int b){ //TODO ez így szar
        ArrayList<Stock> req = new ArrayList<Stock>();
        switch(b){
            case 1:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)40));
                break;
        }
        
        return req;
    }

    public static BuildingRepository getInstance (){
    return instance;
    }

    public List<Building> getAssets() {
        return buildings;
    }
}
