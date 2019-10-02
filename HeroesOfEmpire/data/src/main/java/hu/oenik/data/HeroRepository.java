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
public class HeroRepository {
   
    private List<Hero> heroes = new ArrayList<>();
    
    public List<Hero> getHeroes(){
    return heroes;
    }
    
    public void add(Hero h){
    heroes.add(h);
    }

}
