/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Empire;
import hu.oenik.data.Hero;
import hu.oenik.data.Hybrid;
import hu.oenik.data.Population;
import hu.oenik.data.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Thrawn
 */
public class EmpireRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    public EmpireRepository() {
        
    }

    public List<Empire> getEmpires() {
        return em.createQuery("SELECT e FROM Empire e", Empire.class).getResultList();
    }

    public void add(Empire emp) {
        em.getTransaction().begin();
//        for (Stock s : emp.getWarehouse()) {
//            em.persist(s);
//        }
         for (Population p : emp.getPopulation()) {
            em.persist(p);
        }
        for (Stock s : emp.getProduce()) {
            em.persist(s);
        }
        em.persist(emp);
        em.getTransaction().commit();
    }

    public void remove(int empireIdx) {
        //empires.remove(empireIdx);
    }
    /*
    public void createEmpire(String name, String description, EnvironmentTypes envType )
    {
        Empire emp = new Empire(name,description,envType);
        empires.add(emp);
    }
     */
}
