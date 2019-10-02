/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;
import hu.oenik.data.HeroRepository;
import hu.oenik.data.Species;
import hu.oenik.data.SpeciesRepository;
import hu.oenik.data.User;
import hu.oenik.data.UserRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Viki
 */
@ApplicationScoped //ebből egy példány lesz csak
public class Application {

    @ApplicationScoped
    @Produces
    public UserRepository createUserRepository() {
        UserRepository ur = new UserRepository();
        ur.add(new User("a", "a", "a", false));
        ur.add(new User("Eleven", "el", "11", false));
        return ur;
    }

    @ApplicationScoped
    @Produces
    public SpeciesRepository createSpeciesRepository() {
        SpeciesRepository sr = new SpeciesRepository();
        try {
            sr.add(new Species("Human", "Bold"));
            sr.add(new Species("Dwarf", "Strong")); 
            sr.add(new Species("Elder Blood", "Chosen ones"));
            sr.add(new Species("Mutant", "Wolf School Witcher"));            
            
        } catch (Exception e) {            
        }

        return sr;
    }

    @ApplicationScoped
    @Produces
    public HeroRepository createHeroRepository() {
        HeroRepository ur = new HeroRepository();
        return ur;
    }

}
