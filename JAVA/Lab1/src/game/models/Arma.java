/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.models;

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
}
