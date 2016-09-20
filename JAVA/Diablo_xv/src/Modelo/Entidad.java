/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gina
 */
public class Entidad implements ObjetoGrafico {
    
    private String nombre;
    private int posX;
    private int posY;
    private int nivel;
    private int vidaActual;
    private int vidaMaxima;
    
    public Entidad(int posicionX, int posicionY, String nombre, int nivel, int vidaMaxima){
        this.nombre = nombre;
        this.posX = posicionX;
        this.posY = posicionY;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
    }

            
    /*
    En estos metodos solo se hace la consulta, asumo que la autirizacion
    de si se mueve o no se hace ene laberinto o en gestor de laberinto.
    Si creen que esa confirmacion se debe hacer aca, diganme para implementarlo
    
    Antes estos metodos solo estaban en Avatar, ahora estan en entidad porque segun el texto
    va a haber un momento en el que los enemigos se muevan
    */
    
    
    
    public void Mover(int dx, int dy) {
        setPosX(getPosX() + dx);
        setPosY(getPosY() + dy);
    }
    
    @Override
    public void Dibujar() {
        //
    }
    
    @Override
    public String toString(){
        return getNombre() + " " + getNivel();
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
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
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

    
}