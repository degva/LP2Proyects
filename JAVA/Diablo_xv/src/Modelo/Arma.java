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
    private int _dano_min;
    private int _dano_max;

    /**
     *
     * @param nombre
     * @param pX
     * @param pY
     * @param dmin
     * @param dmax
     */
    public Arma(String nombre, int pX, int pY, int dmin, int dmax) {
        super(nombre, pX, pY, 'a');
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
     * @param _dano_min the _dano_min to set
     */
    public void SetMinDamage(int _dano_min) {
        this._dano_min = _dano_min;
    }

    /**
     * @return the _dano_max
     */
    public int GetMaxDamage() {
        return _dano_max;
    }

    /**
     * @param _dano_max the _dano_max to set
     */
    public void SetMaxDamage(int _dano_max) {
        this._dano_max = _dano_max;
    }
    
    @Override
    public String toString(){
        return "Arma: " + getNombre() + " " + GetMinDamage() + "/" + GetMaxDamage();
    }
}
