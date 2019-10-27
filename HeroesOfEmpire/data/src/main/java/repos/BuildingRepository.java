/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Building;
import hu.oenik.data.NaturalAsset;
import hu.oenik.data.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Thrawn
 */
public class BuildingRepository {
    
    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public BuildingRepository() {
        /*
        buildings.add(new Building("Barrack", "Trains soldiers",CreateStockRequirements(1),(long)30));        
        buildings.add(new Building("Farm", "",CreateStockRequirements(2),(long)40));         
        buildings.add(new Building("Blacksmith", "",CreateStockRequirements(3),(long)60));
        buildings.add(new Building("Mine", "",CreateStockRequirements(4),(long)50));
        buildings.add(new Building("Lumberyard", "",CreateStockRequirements(5),(long)40));
        buildings.add(new Building("Townhall", "",CreateStockRequirements(6),(long)70));
        */        
    }
    
   public List<Building> getBuildings() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT s FROM Building s ORDER BY name", Building.class).getResultList();
    }
    
   public Building getBuilding(int id)
   {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Building.class);
        Root rt = cq.from(Building.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("id"), id));
        return (Building) em.createQuery(cq).getSingleResult();
   }
   
   public void add(Building b) {
        em.getTransaction().begin();
        
        for (Stock p : b.getProduce()) {
            em.persist(p);
        }
        em.persist(b);
        em.getTransaction().commit();
    }
   
}
