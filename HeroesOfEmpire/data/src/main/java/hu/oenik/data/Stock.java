/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

/**
 *
 * @author Thrawn
 */
public class Stock {
    NaturalAsset asset;
    Long quantity;

    public Stock(NaturalAsset asset, Long quantity) {
        this.asset = asset;
        this.quantity = quantity;
    }

    public NaturalAsset getAsset() {
        return asset;
    }

    public void setAsset(NaturalAsset asset) {
        this.asset = asset;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
}
