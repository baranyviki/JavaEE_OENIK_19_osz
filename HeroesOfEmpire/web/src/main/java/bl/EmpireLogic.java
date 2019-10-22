/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import hu.oenik.data.Building;
import hu.oenik.data.Empire;
import hu.oenik.data.EnvironmentTypes;
import hu.oenik.data.NaturalAsset;
import hu.oenik.data.People;
import hu.oenik.data.Population;
import hu.oenik.data.Stock;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import repos.BuildingRepository;
import repos.NaturalAssetRepository;
import repos.PeopleRepository;

/**
 *
 * @author Viki
 */
@ApplicationScoped
public class EmpireLogic {

    PeopleRepository peopleRepository;
    NaturalAssetRepository nautralAssetRepository;
    BuildingRepository buildingRepository;
    Random rand = new Random();
    
    public EmpireLogic(PeopleRepository peopleRepository, NaturalAssetRepository nautralAssetRepository,BuildingRepository buildingRepository) {
        this.peopleRepository = peopleRepository;
        this.nautralAssetRepository = nautralAssetRepository;
        this.buildingRepository = buildingRepository;
    }
    
    
    
    public Empire EmpireFactory(String name, String description, EnvironmentTypes envType) {
        Empire emp = GenerateEmpireWithEnvironment(envType);
        emp.setName(name);
        emp.setDescription(description);
        emp.setEnvironmentType(envType);
        emp.setLevel(1L);
        return emp;
    }

    private Empire GenerateEmpireWithEnvironment(EnvironmentTypes envType) {
        Empire empire = new Empire();
       
        for (Building b :buildingRepository.getBuildings()){
           if(b.getName().equals("Townhall"))
            empire.getBuildings().add(new Building());
        }
        
        for (NaturalAsset s : nautralAssetRepository.getAssets()) {
            int r = rand.nextInt(11);
            empire.getProduce().add(new Stock(s, (long) (10*r)));
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
//                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
//                    if (s.getName().equals("Stone")) {
//                        empire.getWarehouse().add(new Stock(s, (long) (10)));
//
//                    } else {
//                        empire.getWarehouse().add(new Stock(s, (long) (5)));
//                    }
//                }
//                

                break;
            case Flatlands:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));

                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
//                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
//                    if (s.getName().equals("Food")) {
//                        empire.getWarehouse().add(new Stock(s, (long) (10)));
//                    } else {
//                        empire.getWarehouse().add(new Stock(s, (long) (5)));
//                    }
//                }

                break;
            case Forest:
                for (People p : peopleRepository.getPeople()) {
                    if (p.getName().equals("Farmer")) {
                        empire.getPopulation().add(new Population(p, (long) 30));
                    } else {
                        empire.getPopulation().add(new Population(p, (long) 10));
                    }
                }
//                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
//                    if (s.getName().equals("Food")) {
//                        empire.getWarehouse().add(new Stock(s, (long) (10)));
//                    } else {
//                        empire.getWarehouse().add(new Stock(s, (long) (5)));
//                    }
//                }

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
//                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
//                    if (s.getName().equals("Gold")) {
//                        empire.getWarehouse().add(new Stock(s, (long) (10)));
//                    } else {
//                        empire.getWarehouse().add(new Stock(s, (long) (5)));
//                    }
//                }

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
//                for (NaturalAsset s : nautralAssetRepository.getAssets()) {
//                    if (s.getName().equals("Gold")) {
//                        empire.getWarehouse().add(new Stock(s, (long) (10)));
//                    } else {
//                        empire.getWarehouse().add(new Stock(s, (long) (5)));
//                    }
//                }
                break;
        }
        return empire;
    }

    public boolean ConstructNewBuilding() {
        //TODO
        return true;
    }

//    public void TimeChanged(Empire emp) {
//        //TODO valami ilyesminek kéne történie körről körre?
//        
//        for (Population p : emp.getPopulation()) {
//            p.setQuantity(p.getQuantity()+1L);
//        }
//        for (Stock w : emp.getWarehouse()) {
//            for (Stock p : emp.getProduce()) {
//                if (w.getAsset().getName().equals(p.getAsset().getName())) {
//                   w.setQuantity(w.getQuantity()+p.getQuantity());
//                }
//            }
//        }
//    }
}
