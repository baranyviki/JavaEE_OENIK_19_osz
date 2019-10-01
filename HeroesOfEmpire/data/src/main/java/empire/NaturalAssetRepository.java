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
public class NaturalAssetRepository {
    
    public static final NaturalAssetRepository instance = new NaturalAssetRepository();
    
    private List<NaturalAsset> assets = new ArrayList<>();

    public NaturalAssetRepository() {
        assets.add(new NaturalAsset("Stone", "Mostly used for build buildings"));        
        assets.add(new NaturalAsset("Gold", "Mostly used for train the soldiers"));         
        assets.add(new NaturalAsset("Wood", "Mostly used for build buildings"));       
        assets.add(new NaturalAsset("Food", "nyam")); 
        
    }

    public static NaturalAssetRepository getInstance (){
    return instance;
    }

    public List<NaturalAsset> getAssets() {
        return assets;
    }
    
}
