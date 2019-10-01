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
public class EmpireRepository {
    public static final EmpireRepository instance = new EmpireRepository();
    
    private List<EmpireRepository> empires = new ArrayList<>();

    public EmpireRepository() {
        //todo
        
    }

    public static EmpireRepository getInstance (){
    return instance;
    }

    public List<EmpireRepository> getAssets() {
        return empires;
    }
    
}
