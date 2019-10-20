<<<<<<< Updated upstream:HeroesOfEmpire/data/src/main/java/empire/PopulationRepository.java
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
public class PopulationRepository {
    public static final PopulationRepository instance = new PopulationRepository();
    
    private List<Population> population = new ArrayList<>();
    
    private PopulationRepository (){
        population.add(new Population(new People("Miner","people who likes minecraft"),(long)10));
        population.add(new Population(new People("Farmer","they produces your food"),(long)10));
        population.add(new Population(new People("Soldier","normal figther guys"),(long)10));
        population.add(new Population(new People("Badass soldier","they can kill you in a brutal way"),(long)10));
        population.add(new Population(new People("Worker","man for constructions"),(long)10));
    }
    
    public static PopulationRepository getInstance()
    {
        return instance;
    }

    public List<Population> getPopulation() {
        return population;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.People;
import hu.oenik.data.Population;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Thrawn
 */
public class PopulationRepository {
 private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
  
         
    private PopulationRepository (){
        /*
        population.add(new Population(new People("Miner","people who likes minecraft"),(long)10));
        population.add(new Population(new People("Farmer","they produces your food"),(long)10));
        population.add(new Population(new People("Soldier","normal figther guys"),(long)10));
        population.add(new Population(new People("Badass soldier","they can kill you in a brutal way"),(long)10));
        population.add(new Population(new People("Worker","man for constructions"),(long)10));
        */
    }
    
   public List<Population> getPopulation() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT p FROM Population p", Population.class).getResultList();
    }
    
}
>>>>>>> Stashed changes:HeroesOfEmpire/data/src/main/java/repos/PopulationRepository.java
