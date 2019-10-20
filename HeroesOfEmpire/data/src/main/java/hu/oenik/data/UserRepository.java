/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

<<<<<<< Updated upstream:HeroesOfEmpire/data/src/main/java/hu/oenik/data/UserRepository.java
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
=======
import exceptions.RegistrationException;
import exceptions.LoginException;
import hu.oenik.data.User;
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
>>>>>>> Stashed changes:HeroesOfEmpire/data/src/main/java/repos/UserRepository.java

/**
 *
 * @author Viki
 */
<<<<<<< Updated upstream:HeroesOfEmpire/data/src/main/java/hu/oenik/data/UserRepository.java
//@Singleton
public class UserRepository {

    public static final UserRepository instance = new UserRepository();
    private List<User> users = new ArrayList<>();

    public void registration(String fullName,String userName, String pPassword) throws RegistrationException {
        for (User u : users) {
            if (u.getName().equals(userName)) {
                throw new RegistrationException();
            }
        }
        User nUser = new User(fullName,userName, pPassword, false);
        users.add(nUser);
    }

    public User login(String pUserName, String pPass) throws LoginException{
        for (User u : users) {
            if (u.GetUserName().equals(pUserName) && u.getPassword().equals(pPass)) {
                return u;
            }
        }
        throw new LoginException();
    }

    public UserRepository() {
        users.add(new User("Eleven","el","11",false));
        
    }

=======
@Entity
@Table(name = "users")
public class UserRepository {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

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
        return (User) em.createQuery(cq).getSingleResult();
    }

    public UserRepository() {

    }

>>>>>>> Stashed changes:HeroesOfEmpire/data/src/main/java/repos/UserRepository.java
}
