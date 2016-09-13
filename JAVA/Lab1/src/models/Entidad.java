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
public class Entidad {
    private String nombre;
    private int posicionX;
    private int posicionY;
    private int nivel;
    private int vidaActual;
    private int vidaMaxima;
    
    public Entidad(int posicionX, int poscionY, String nombre, int nivel, int vidaMaxima){
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = poscionY;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
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
    
    Antes estos metodos solo estaban en Avatar, ahora estan en entidad porque segun el texto
    va a haber un momento en el que los enemigos se muevan
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
    
    @Override
    public String toString(){
        return getNombre() + " " + getNivel();
    }
    
}
