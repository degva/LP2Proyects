/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * NOTA: ESTA CLASE NO SE USA PARA EL PRIMER LAB
 * se supone que desde aqui puedes agregar el artefacto a el Saco?
 * @author degva
 */
public class Artefacto {
    /*
     * The artifact can be:
     * Armor, Weapons or Potions.
     **/
    private String nombre;
    private int posicionX;
    private int posicionY;

    public Artefacto (String nombre) {
        this.nombre  = nombre;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the posicionX
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * @param posicionX the posicionX to set
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * @return the posicionY
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * @param posicionY the posicionY to set
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
}
