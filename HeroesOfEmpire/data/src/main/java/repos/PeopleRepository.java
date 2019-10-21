/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.People;
import hu.oenik.data.Species;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Thrawn
 */
public class PeopleRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public PeopleRepository() {

    }

    public List<People> getPeople() {
        return em.createQuery("SELECT s FROM People s", People.class).getResultList();
    }

    public void add(People p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

}
