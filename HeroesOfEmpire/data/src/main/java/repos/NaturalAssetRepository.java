/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.NaturalAsset;
import hu.oenik.data.Species;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Thrawn
 */
public class NaturalAssetRepository {
    
    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();
    
    public NaturalAssetRepository() {
    }
    
    public List<NaturalAsset> getAssets() {
        return em.createQuery("SELECT s FROM NaturalAsset s", NaturalAsset.class).getResultList();
    }
    
    public void add(NaturalAsset n) {
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
    }
    
}
