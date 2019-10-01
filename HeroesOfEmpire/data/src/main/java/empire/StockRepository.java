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
public class StockRepository {
    public static final StockRepository instance = new StockRepository();
    
    private List<Stock> stocks = new ArrayList<Stock>();
    
    private StockRepository (){
        stocks.add(new Stock(new NaturalAsset("Stone", "Mostly used for build buildings"),(long)10));
        stocks.add(new Stock(new NaturalAsset("Gold", "Mostly used for train soldiers and pay for the ladies..i mean pray"),(long)10));
        stocks.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)10));
        stocks.add(new Stock(new NaturalAsset("Food", "nyam"),(long)10));
    }
    
    public static StockRepository getInstance()
    {
        return instance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
    
}
