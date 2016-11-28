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
public class Armadura extends Artefacto {
    private int _defensa;
    
    public Armadura (String nombre, int posX, int posY, int defensa){
        super(nombre, posX, posY);
        this._defensa = defensa;
    }
    
    /**
     * @return the defensa
     */
    public int GetDefensa() {
        return _defensa;
    }
}
