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
public class Enemigo implements Entidad {
    private int _posX;
    private int _posY;
    private final char _elementoGrafico;
    
    public Enemigo(int posX, int posY, char elemGraf) {
        _posX = posX;
        _posY = posY;
        _elementoGrafico = elemGraf;
    }
    
    @Override
    public void Dibujar() {
        System.out.print(_elementoGrafico);
    }
    
    @Override
    public void Mover(int dx, int dy) {
        setPosX(getPosX() + dx);
        setPosY(getPosY() + dy);
    }
    
    /**
     * @return the _posX
     */
    public int getPosX() {
        return _posX;
    }

    /**
     * @param _posX the _posX to set
     */
    public void setPosX(int _posX) {
        this._posX = _posX;
    }

    /**
     * @return the _posY
     */
    public int getPosY() {
        return _posY;
    }

    /**
     * @param _posY the _posY to set
     */
    public void setPosY(int _posY) {
        this._posY = _posY;
    }
}
