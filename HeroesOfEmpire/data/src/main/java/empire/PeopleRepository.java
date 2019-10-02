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
public class PeopleRepository {
    
    public static final PeopleRepository instance = new PeopleRepository();
    
    private List<People> people = new ArrayList<>();
    
    private PeopleRepository (){
        people.add(new People("Miner","people who likes minecraft"));
        people.add(new People("Farmer","they produces your food"));
        people.add(new People("Soldier","normal figther guys"));
        people.add(new People("Badass soldier","they can kill you in a brutal way"));
        people.add(new People("Worker","man for constructions"));
    }
    
    public static PeopleRepository getInstance()
    {
        return instance;
    }

    public List<People> getPeople() {
        return people;
    }

   
    
    
}
