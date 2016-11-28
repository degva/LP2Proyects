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
public abstract class Entidad implements Sprite {
    
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
    
    public void Mover(int dx, int dy) {
        posX += dx;
        posY += dy;
    }    
    

    /**
     * @return the nombre
     */
    public String GetNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the posX
     */
    public int GetPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void SetPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int GetPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void SetPosY(int posY) {
        this.posY = posY;
    }
    
    public IntPair GetPosition(){
        return new IntPair(posX, posY);
    }

    /**
     * @return the nivel
     */
    public int GetNivel() {
        return nivel;
    }
    
    /**
     * @param nivel the nivel to set
     */
    public void SetNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the vidaActual
     */
    public int GetVidaActual() {
        return vidaActual;
    }

    /**
     * @param vidaActual the vidaActual to set
     */
    public void SetVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
    
    
    public void SetPosXY(IntPair pair){
        SetPosX(pair.x);
        SetPosY(pair.y);
    }

    /**
     * @return the vidaMaxima
     */
    public int GetVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * @param vidaMaxima the vidaMaxima to set
     */
    public void SetVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

}
