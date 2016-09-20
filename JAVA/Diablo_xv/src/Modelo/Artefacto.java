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
public class Artefacto implements ObjetoGrafico {
    private String _nombre;
    private final int _posX;
    private final int _posY;
    private final char _elementoGrafico;
    
    public Artefacto(String nombre, int posX, int posY, char elemGraf) {
        _posX = posX;
        _posY = posY;
        _elementoGrafico = elemGraf;
        _nombre = nombre;
    }
    
    @Override
    public void Dibujar() {
        System.out.print(_elementoGrafico);
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

    public int getPosX() {
        return _posX;
    }

    public int getPosY() {
        return _posY;
    }       
}
