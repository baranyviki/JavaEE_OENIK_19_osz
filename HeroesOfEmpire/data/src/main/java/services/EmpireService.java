/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import hu.oenik.data.Building;
import hu.oenik.data.Empire;
import hu.oenik.data.EnvironmentTypes;
import hu.oenik.data.NaturalAsset;
import hu.oenik.data.People;
import hu.oenik.data.Population;
import hu.oenik.data.Stock;
import hu.oenik.data.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Singleton;
import javax.inject.Inject;
import repos.BuildingRepository;
import repos.EmpireRepository;
import repos.NaturalAssetRepository;
import repos.PeopleRepository;

/**
 *
 * @author Viki
 */
@Singleton
public class EmpireService {

    @Inject
    EmpireRepository empireRepository;

    @Inject
    PeopleRepository peopleRepository;

    @Inject
    NaturalAssetRepository nautralAssetRepository;
    
    @Inject
    BuildingRepository buildingsRepo;

    Random rand = new Random();

    public EmpireService() {
    }

//    public Empire EmpireFactory(String name, String description, EnvironmentTypes envType) {
//        Empire emp = GenerateEmpireWithEnvironment(envType);
//        emp.setName(name);
//        emp.setDescription(description);
//        emp.setEnvironmentType(envType);
//        emp.setLevel(1L);
//        return emp;
//    }
    
    public Empire getEmpire(Long empID) {
        return empireRepository.getEmpireByID(empID);
    }
    
    public void removeEmpire(Long empireID) throws Exception {
        empireRepository.remove(empireID);
        
    }
    
    public void addBuilding(long empireID,String building){
        Building bu = new Building();
        switch(building){
            case "Barrack":
               bu.setName(building);
               bu.setDescription("Trains soldiers");
               bu.setBuildingTime((long)2);
               bu.setProduce(CreateStockRequirements(1));
               
                      
               break; 
        }
        
        Empire emp =getEmpire(empireID);
        emp.getBuildings().add(bu);
        empireRepository.Update(emp);
    }
    private ArrayList<Stock> CreateStockRequirements(int b){ 
       ArrayList<Stock> req = new ArrayList<Stock>();
       List<NaturalAsset> nats = nautralAssetRepository.getAssets();
        switch(b){
            case 1:
                
                 for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        req.add(new Stock(s, (long) (40)));

                    } else if (s.getName().equals("Gold")){
                        req.add(new Stock(s, (long) (20)));
                    }
                    else if (s.getName().equals("Wood")){
                        req.add(new Stock(s, (long) (30)));
                    }
                }
                break;
            case 2:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)10));
                
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)30));
                break;
            case 3:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)50));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)10));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)40));
                break;
            case 4:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)20));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)10));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)30));
                break;
            case 5:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)30));                
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)10));
                break;
            case 6:
                req.add(new Stock(new NaturalAsset("Stone","Mostly used for build buildings"),(long)50));
                req.add(new Stock(new NaturalAsset("Gold", "Mostly used for train the soldiers"),(long)50));
                req.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)50));
                break;
        }        
        return req;
    }

    public Empire addEmpire(String name, String description, EnvironmentTypes envType, User user) {
        Empire emp = GenerateEmpireWithEnvironment(envType);
        emp.setName(name);
        emp.setDescription(description);
        emp.setEnvironmentType(envType);
        emp.setLevel(1L);
        emp.setUser(user);
        user.addEmpire(emp);        
        empireRepository.add(emp);
        return emp;
    }

    private Empire GenerateEmpireWithEnvironment(EnvironmentTypes envType) {
        Empire empire = new Empire();
        List<NaturalAsset> nats = nautralAssetRepository.getAssets();
        for (NaturalAsset s : nautralAssetRepository.getAssets()) {
            int r = rand.nextInt(11);
            empire.getProduce().add(new Stock(s, (long) (10 * r)));
        }
        switch (envType) {
            case Mountainous:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Miner")) {
                        empire.getPopulation().add(new Population(p, (long) 30));

                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Stone")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));

                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case Flatlands:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));

                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Food")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case Forest:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Food")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;

            case Budapest:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 20));

                    } else if (p.getName().equals("Badass soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Gold")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }

                break;
            case Beach:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Worker")) {
                        empire.getPopulation().add(new Population(p, (long) 20));

                    } else if (p.getName().equals("Soldier")) {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
                    if (s.getName().equals("Gold")) {
                        empire.getWarehouse().add(new Stock(s, (long) (10)));
                    } else {
                        empire.getWarehouse().add(new Stock(s, (long) (5)));
                    }
                }
                break;
        }
        return empire;
    }

    public boolean ConstructNewBuilding() {
        //TODO
        return true;
    }

    public void TimeChanged(Empire emp) {
        //TODO valami ilyesminek kéne történie körről körre?

        for (Population p : emp.getPopulation()) {
            p.setQuantity(p.getQuantity() + 1L);
        }
        for (Stock w : emp.getWarehouse()) {
            for (Stock p : emp.getProduce()) {
                if (w.getAsset().getName().equals(p.getAsset().getName())) {
                    w.setQuantity(w.getQuantity() + p.getQuantity());
                }
            }
        }
    }

}
