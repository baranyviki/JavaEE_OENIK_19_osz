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
    
    private List<Empire> empires = new ArrayList<>();

    private EmpireRepository() {
        //todo
    }

    public static EmpireRepository getInstance (){
    return instance;
    }

    public List<Empire> getEmpires() {
        return empires;
    }
    /*
    public void createEmpire(String name, String description, EnvironmentTypes envType )
    {
        Empire emp = new Empire(name,description,envType);
        empires.add(emp);
    }
    */
}
