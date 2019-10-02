/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import hu.oenik.data.NaturalAsset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thrawn
 */
public class NaturalAssetRepository {
    
    private List<NaturalAsset> assets = new ArrayList<>();
    
    public NaturalAssetRepository() {
    }
    
    public List<NaturalAsset> getAssets() {
        return assets;
    }
    
    public void add(NaturalAsset n) {
        assets.add(n);
    }
    
}
