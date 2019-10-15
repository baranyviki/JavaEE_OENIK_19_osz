/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Species;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Viki
 */
public class SpeciesRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    //private List<Species> species = new ArrayList<>();   

    public List<Species> getSpecies() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT s FROM Species s", Species.class).getResultList();
    }

    public void add(Species s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

}
