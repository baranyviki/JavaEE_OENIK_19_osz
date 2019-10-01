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
        buildings.add(new Building("Farm", "",CreateStockRequirements(2),(long)40));         
        buildings.add(new Building("Blacksmith", "",CreateStockRequirements(3),(long)60));
        buildings.add(new Building("Mine", "",CreateStockRequirements(4),(long)50));
        buildings.add(new Building("Lumberyard", "",CreateStockRequirements(5),(long)40));
        buildings.add(new Building("Townhall", "",CreateStockRequirements(6),(long)70));
        
    }
    
    private ArrayList<Stock> CreateStockRequirements(int b){ //TODO ezt is repoból kéne?
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

    public static BuildingRepository getInstance (){
    return instance;
    }

    public List<Building> getAssets() {
        return buildings;
    }
}
