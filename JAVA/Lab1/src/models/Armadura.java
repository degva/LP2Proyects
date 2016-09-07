/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Gina
 */
public class Armadura extends Artefacto {
    private int defensa;
    
    public Armadura (String nombre, int defensa){
        super(nombre);
        this.defensa = defensa;
    }

    /**
     * @return the defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    @Override
    public String toString(){
        return "Armadura: " + getNombre() + " " + getDefensa();
    }

    
}
