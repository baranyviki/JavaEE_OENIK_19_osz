/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import repos.HeroRepository;
import repos.SpeciesRepository;

/**
 *
 * @author Viki
 */
@Stateless
public class HeroService {

    @Inject
    HeroRepository heroRepository;

    public Hero add(Hero pHero) {
        if (pHero != null && pHero.getHybrids() != null) {
            byte b = 0;
            for (Hybrid hy : pHero.getHybrids()) {
                b += hy.getPercent();
            }
            if (b == 10) {
                heroRepository.add(pHero);
            }
        }

        return pHero;
    }

    public List<Hero> getHeroes() {
        return heroRepository.getHeroes();
    }

}
