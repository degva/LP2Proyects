/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author degva
 */
public class Arma extends Artefacto {
    private final int _dano_min;
    private final int _dano_max;

    /**
     *
     * @param nombre
     * @param pX
     * @param pY
     * @param dmin
     * @param dmax
     */
    public Arma(String nombre, int pX, int pY, int dmin, int dmax) {
        super(nombre, pX, pY);
        this._dano_max = dmax;
        this._dano_min = dmin;
    }
    
    /**
     * @return the _dano_min
     */
    public int GetMinDamage() {
        return _dano_min;
    }

    /**
     * @return the _dano_max
     */
    public int GetMaxDamage() {
        return _dano_max;
    }
    
}
