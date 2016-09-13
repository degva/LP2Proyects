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
    private int x;
    private int y;
    private TipoCelda tipo;    
    private int tipoContenido; //0 = anterior, 1 = siguiente,  2 = enemigo, 3= artefacto
    private int activarAnterior;

    public Celda (int x, int y, TipoCelda tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.tipoContenido = -1; //valor default
        activarAnterior = 0;
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

    public int getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(int tipoContenido) {
        this.tipoContenido = tipoContenido;
    }        

    public int getActivarAnterior() {
        return activarAnterior;
    }

    public void setActivarAnterior(int activarAnterior) {
        this.activarAnterior = activarAnterior;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    
}
