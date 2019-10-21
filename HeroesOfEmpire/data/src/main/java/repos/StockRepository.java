/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.Stock;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Thrawn
 */
public class StockRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("heroesPU").createEntityManager();

    public StockRepository() {
        //stocks.add(new Stock(new NaturalAsset("Stone", "Mostly used for build buildings"),(long)10));
        //stocks.add(new Stock(new NaturalAsset("Gold", "Mostly used for train soldiers and pay for the ladies..i mean pray"),(long)10));
        //stocks.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)10));
        //stocks.add(new Stock(new NaturalAsset("Food", "nyam"),(long)10));
    }

    public List<Stock> getStocks() {
        //class-ra hivatkozunk.
        return em.createQuery("SELECT s FROM Stock s ORDER BY name", Stock.class).getResultList();
    }

    public Stock getStock(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Stock.class);
        Root rt = cq.from(Stock.class);
        cq.select(rt);
        cq.where(cb.equal(rt.get("id"), id));
        return (Stock) em.createQuery(cq).getSingleResult();
    }

}
