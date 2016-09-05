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
    private int tipo;
    private String nombre;

    public Artefacto (int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
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
}
