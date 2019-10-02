/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.People;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thrawn
 */
public class PeopleRepository {
    
    private List<People> people = new ArrayList<>();
    
    public PeopleRepository (){
        
    }

    public List<People> getPeople() {
        return people;
    }

   public void add(People p)
   {
       people.add(p);
   }
    
}
