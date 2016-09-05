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
public class Avatar extends Entidad{
    private int vidaMaxima;
    private Saco saco;
    private Armadura armaduraActual; 
    private Arma armaActual;

   
    public Avatar(int posicionX, int poscionY, String nombre, int nivel){
        super(posicionX,poscionY,nombre,nivel);
        super.setVidaActual(100);
        this.vidaMaxima = 100;
    }
        
    /**
     * @return the vidaMaxima
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * @param vidaMaxima the vidaMaxima to set
     */
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
    
    /**
     * @return the saco
     */
    public Saco getSaco() {
        return saco;
    }
    
    /**
     * @param saco the saco to set
     */
    public void setSaco(Saco saco) {
        this.saco = saco;
    }

    /**
     * @return the armaduraActual
     */
    public Armadura getArmaduraActual() {
        return armaduraActual;
    }

    /**
     * @param armaduraActual the armaduraActual to set
     */
    public void setArmaduraActual(Armadura armaduraActual) {
        this.armaduraActual = armaduraActual;
    }

    /**
     * @return the armaActual
     */
    public Arma getArmaActual() {
        return armaActual;
    }

    /**
     * @param armaActual the armaActual to set
     */
    public void setArmaActual(Arma armaActual) {
        this.armaActual = armaActual;
    }


    /*
    //Aumentar nivel
    public void levelUp(){
        this.nivel++;
    }
    */
        
    //Reocger Artefacto
    public void recogerArtefacto(Artefacto newArtefacto){
        getSaco().agregarArtefacto(newArtefacto);
    }
    
    /*
    Creo que avatar debe tener un metodo atacar enemigo, pero no tengo muy
    claro que debe hacer.
    */
    //Atacar enemigo
    public void atacarEnemigo(){
        
    }
    
    //Cambiar armadura
    //Cambiar arma

  
}
