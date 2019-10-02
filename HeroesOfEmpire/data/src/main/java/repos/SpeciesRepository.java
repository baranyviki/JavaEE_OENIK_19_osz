/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Species;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viki
 */
public class SpeciesRepository {
    private List<Species> species = new ArrayList<>();
    
    public List<Species> getSpecies() {
        return species;
    }
    public void add(Species s)
    {
        species.add(s);
    }  
    
}
