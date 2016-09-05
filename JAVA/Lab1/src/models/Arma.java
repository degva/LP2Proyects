/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author degva
 */
public class Arma extends Artefacto {
    private int _dano_min;
    private int _dano_max;

    /**
     *
     * @param dmin
     * @param dmax
     */
    public Arma(int dmin, int dmax, int tipo) {
        super(tipo);
        this._dano_max = dmax;
        this._dano_min = dmin;
    }
    
    /**
     * @return the _dano_min
     */
    public int getDano_min() {
        return _dano_min;
    }

    /**
     * @param _dano_min the _dano_min to set
     */
    public void setDano_min(int _dano_min) {
        this._dano_min = _dano_min;
    }

    /**
     * @return the _dano_max
     */
    public int getDano_max() {
        return _dano_max;
    }

    /**
     * @param _dano_max the _dano_max to set
     */
    public void setDano_max(int _dano_max) {
        this._dano_max = _dano_max;
    }
    
    @Override
    public String toString(){
        return "Arma: " + getNombre() + " " + getDano_min() + "/" + getDano_max();
    }


}
