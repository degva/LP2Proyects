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
    
    private int ataque;
    private int defensa;

    
    public Enemigo(String nombre, int posicionX, int poscionY, int nivel){
        super(posicionX,poscionY,nombre,nivel, nivel * 2);
        super.SetVidaActual(nivel * 2);
        ataque = this.GetNivel() * 2; 
        defensa = this.GetNivel(); 
    }
    
    @Override
    public String GetSpriteType() {
        return "enemigo";
    }

    /**
     * @return the ataque
     */
    public int GetAtaque() {
        return ataque;
    }
    
    public void SetAtaque(int ataque){
        this.ataque = ataque;
    }

    /**
     * @return the defensa
     */
    public int GetDefensa() {
        return defensa;
    }

}
