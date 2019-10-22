/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the     editor.
 */
package repos;

import hu.oenik.data.Building;
import hu.oenik.data.NaturalAsset;
import hu.oenik.data.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Thrawn
 */
public class BuildingRepository {
//    public static final BuildingRepository instance = new BuildingRepository();
//    
//    private List<Building> buildings = new ArrayList<>();
    
    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    
//    public BuildingRepository(){
//        
//    }

    public BuildingRepository() {
//        buildings.add(new Building("Barrack", "Trains soldiers",CreateStockRequirements(1),(long)30));        
//        buildings.add(new Building("Farm", "",CreateStockRequirements(2),(long)40));         
//        buildings.add(new Building("Blacksmith", "",CreateStockRequirements(3),(long)60));
//        buildings.add(new Building("Mine", "",CreateStockRequirements(4),(long)50));
//        buildings.add(new Building("Lumberyard", "",CreateStockRequirements(5),(long)40));
//        buildings.add(new Building("Townhall", "",CreateStockRequirements(6),(long)70));
        
    }
    
    public List<Building> getBuildings() {
        return em.createQuery("SELECT h FROM Building h", Building.class).getResultList();
    }
    
    public void add(Building bu){
        em.getTransaction().begin();
        for (Stock h : bu.getProduce()) {
            em.persist(h);
        }
        em.persist(bu);
        em.getTransaction().commit();
    }
    
//   
    

    
}
