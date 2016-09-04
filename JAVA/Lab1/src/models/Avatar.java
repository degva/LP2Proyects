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
public class Avatar {
    private int posicionX;
    private int posicionY;
    //Nivel indica el nuemro de laberinto en el que se encuentra
    private int nivel;
    private int vidaMaxima;
    private int vidaActual;
    private Saco saco;
    /*
    En el documento habla de el arma del avatar y de la armadura del avatar
    pero no los he puesto como datos miembros porque creo que eso va dentro 
    del saco
    */
    
    public Avatar(int posicionX, int poscionY){
        this.posicionX = posicionX;
        this.posicionY = poscionY;
        //Asi aseguramos que cada vez que se cree un Avatar, empieze del primer laberinto
        this.nivel = 1; 
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

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
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
     * @return the vidaActual
     */
    public int getVidaActual() {
        return vidaActual;
    }

    /**
     * @param vidaActual the vidaActual to set
     */
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    /*
    En estos metodos solo se hace la consulta, asumo que la autirizacion
    de si se mueve o no se hace ene laberinto o en gestor de laberinto.
    Si creen que esa confirmacion se debe hacer aca, diganme para implementarlo
    */
    public void moveUp(){
        this.posicionY--;
    }
    
    public void moveDown(){
        this.posicionY++;
    }
    
    public void moveRight(){
        this.posicionX++;
    }
    
    public void moveLeft(){
        this.posicionX--;
    }
    
    //Aumentar nivel
    public void levelUp(){
        this.nivel++;
    }
        
    //Reocger Artefacto
    public void recogerArtefacto(Artefacto newArtefacto){
        saco.agregarArtefacto(newArtefacto);
    }
    
    /*
    Creo que avatar debe tener un metodo atacar enemigo, pero no tengo muy
    claro que debe hacer.
    */
    
    //Atacar enemigo
    public void atacarEnemigo(){
        
    }
    
}
