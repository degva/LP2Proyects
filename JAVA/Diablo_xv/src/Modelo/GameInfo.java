/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Fam. Pérez Portilla
 */
public class GameInfo {
    
    public boolean gameOver;
    private String nombre;
    private int idxLaberinto;
    private int idxLaberintoAnterior;
    
    public GameInfo(){
        gameOver = false;
        idxLaberinto = 0;
        idxLaberintoAnterior = 0;
        nombre = "";
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
