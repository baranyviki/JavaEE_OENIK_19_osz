/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

/**
 *
 * @author Viki
 */
public class Hybrid {
    Species species;
    byte percent;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public byte getPercent() {
        return percent;
    }

    public void setPercent(byte percent) {
        this.percent = percent;
    }

    public Hybrid(Species species, byte percent) {
        this.species = species;
        this.percent = percent;
    }
}
