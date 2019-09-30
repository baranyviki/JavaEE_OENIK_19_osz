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
public class WarehouseRepository {
     public static final WarehouseRepository instance = new WarehouseRepository();
    
   private List<Stock> stocks = new ArrayList<Stock>();
    
    public WarehouseRepository (){
        stocks.add(new Stock(new NaturalAsset("Stone", "Mostly used for build buildings"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Gold", "Mostly used for train soldiers and pay for the ladies..i mean pray"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Wood", "Mostly used for build buildings"),(long)5));
        stocks.add(new Stock(new NaturalAsset("Food", "nyam"),(long)5));
    }
    
    public static WarehouseRepository getInstance()
    {
        return instance;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
    
}
