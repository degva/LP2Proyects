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
public class Enemigo extends Entidad {
    
    private final char _elementoGrafico;
    private int ataque;
    private int defensa;
    
    public Enemigo(String nombre, int posicionX, int poscionY, int nivel){
        super(posicionX,poscionY,nombre,nivel, nivel * 2);
        super.setVidaActual(nivel * 2);
        ataque = this.getNivel() * 2; 
        defensa = this.getNivel(); 
        _elementoGrafico = 'E';
    }
    
    @Override
    public String GetSpriteType() {
        return "enemigo";
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
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
    

}
