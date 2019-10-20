/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;
import hu.oenik.data.NaturalAsset;
import hu.oenik.data.People;
import repos.HeroRepository;
import repos.SpeciesRepository;
import hu.oenik.data.User;
import repos.UserRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import repos.EmpireRepository;
import repos.NaturalAssetRepository;
import repos.PeopleRepository;

/**
 *
 * @author Viki
 */
@ApplicationScoped //ebből egy példány lesz csak
public class ApplicationConfiguration {

    @ApplicationScoped
    @Produces
    public UserRepository createUserRepository() {
        UserRepository ur = new UserRepository();
        ur.add(new User("viki","viki",false));
        return ur;
    }

    @ApplicationScoped
    @Produces
    public SpeciesRepository createSpeciesRepository() {
        SpeciesRepository sr = new SpeciesRepository();
        return sr;
    }

    @ApplicationScoped
    @Produces
    public HeroRepository createHeroRepository() {
        HeroRepository ur = new HeroRepository();
        return ur;
    }

     @ApplicationScoped
    @Produces
    public PeopleRepository createPeopleRepository() {
        PeopleRepository people = new PeopleRepository();
        people.add(new People("Miner","people who likes minecraft"));
        people.add(new People("Farmer","they produces your food"));
        people.add(new People("Soldier","normal figther guys"));
        people.add(new People("Badass soldier","they can kill you in a brutal way"));
        people.add(new People("Worker","man for constructions"));
        return people;
    }
      
    @ApplicationScoped
    @Produces
    public NaturalAssetRepository createNaturalAssetRepository() {
        NaturalAssetRepository nat = new NaturalAssetRepository();
        nat.add(new NaturalAsset("Stone", "Mostly used for build buildings"));
        nat.add(new NaturalAsset("Gold", "Mostly used for train the soldiers"));
        nat.add(new NaturalAsset("Wood", "Mostly used for build buildings"));
        nat.add(new NaturalAsset("Food", "nyam"));
        return nat;
    }
    
    @ApplicationScoped
    @Produces
    public EmpireRepository createEmpireRepository() {
        EmpireRepository emp = new EmpireRepository();
        return emp;
    }
    
}
