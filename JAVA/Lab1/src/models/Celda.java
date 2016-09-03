/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.TipoCelda;

/**
 *
 * @author degva
 */
public class Celda {
    /*
     * Si tipo es 1: adentro, 2: Anterior, 3: Siguiente o 4: Pared
     **/
    private TipoCelda tipo;

    public Celda (TipoCelda tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tipo
     */
    public TipoCelda getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }
    
}