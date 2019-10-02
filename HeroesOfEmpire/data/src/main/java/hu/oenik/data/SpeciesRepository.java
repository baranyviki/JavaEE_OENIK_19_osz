/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Viki
 */
public class SpeciesRepository {

    private List<Species> species = new ArrayList<>();

    //  public SpeciesRepository() {
    //  species.add(new Species("Human", "Bold"));        
    //  species.add(new Species("Dwarf", "Strong"));        
    //  species.add(new Species("Elder Blood", "Chosen ones"));        
    //  species.add(new Species("Mutant", "Wolf School Witcher"));
    //   }
    
    
    public List<Species> getSpecies() {
        return species;
    }

    public void add(Species s)
    {
    
    }
    
}
