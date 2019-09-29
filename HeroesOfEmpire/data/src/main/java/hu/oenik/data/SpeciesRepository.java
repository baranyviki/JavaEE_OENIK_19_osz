/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viki
 */
public class SpeciesRepository {
    
    
    public static final SpeciesRepository instance = new SpeciesRepository();
    
    private List<Species> species = new ArrayList<>();

    public SpeciesRepository() {
        species.add(new Species("Human", "Bold"));        
        species.add(new Species("Dwarf", "Strong"));        
        species.add(new Species("Elder Blood", "Chosen ones"));        
        species.add(new Species("Mutant", "Wolf School Witcher"));
        
    }

    public static SpeciesRepository getInstance (){
    return instance;
    }

    public List<Species> getSpecies() {
        return species;
    }
   
    
}
