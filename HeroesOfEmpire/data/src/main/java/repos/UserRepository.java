/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import exceptions.RegistrationException;
import exceptions.LoginException;
import hu.oenik.data.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Viki
 */
public class UserRepository {

   // @GeneratedValue(strategy = GenerationType.AUTO)
   // @Id
   // private long id;

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public List<User> getUsers() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void add(User pUser) {
        em.getTransaction().begin();
        em.persist(pUser);
        em.getTransaction().commit();
    }
    
    public void Update(User u)
    {
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }
    
    public User getUser(String pName, String pPassword) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root rt = cq.from(User.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("name"), pName), cb.equal(rt.get("password"), pPassword)));
        return (User) em.createQuery(cq).getSingleResult();
    }

    public User getUserByName(String pName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root rt = cq.from(User.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("name"), pName));
        
        Object result = em.createQuery(cq).getSingleResult();
        if( result  != null ){
            return (User) result;
        }
        
        return null;
    }
    

    
    public UserRepository() {

    }
}