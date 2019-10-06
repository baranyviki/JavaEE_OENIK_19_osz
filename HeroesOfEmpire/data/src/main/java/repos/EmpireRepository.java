/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Empire;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thrawn
 */
public class EmpireRepository {

    private List<Empire> empires = new ArrayList<>();

    public EmpireRepository() {
        //todo
    }

    public List<Empire> getEmpires() {
        return empires;
    }

    public void add(Empire emp) {
        empires.add(emp);
    }

    public void remove(int empireIdx) {
        empires.remove(empireIdx);
    }
    /*
    public void createEmpire(String name, String description, EnvironmentTypes envType )
    {
        Empire emp = new Empire(name,description,envType);
        empires.add(emp);
    }
     */
}
