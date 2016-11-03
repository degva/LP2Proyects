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
public class Artefacto implements Sprite {
    private String _nombre;
    private int _posX;
    private int _posY;
    private final char _elementoGrafico;
    
    public Artefacto(String nombre, int posX, int posY, char elemGraf) {
        _posX = posX;
        _posY = posY;
        _elementoGrafico = elemGraf;
        _nombre = nombre;
    }
    
    @Override
    public String GetSpriteType() {
        return "artefacto";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this._nombre = nombre;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }

    /**
     * @return the _posX
     */
    public int getPosX() {
        return _posX;
    }

    public void setPosX(int x) {
        _posX = x;
    }
    /**
     * @return the _posY
     */
    public int getPosY() {
        return _posY;
    }
    public void setPosY(int y) {
        _posY = y;
    }
    
}
