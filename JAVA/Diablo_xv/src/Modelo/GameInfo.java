/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author wperezp
 */
public class GameInfo {
    
    private boolean gameON;
    private int idxLaberinto;
    private int idxLaberintoAnterior;
    
    public GameInfo(){
        gameON = true;
        idxLaberinto = 0;
        idxLaberintoAnterior = 0;
    }
    
    public boolean GameIsNotOver(){
        return gameON;
    }
    
    public void Next(){
        idxLaberinto += 1;
        if (idxLaberintoAnterior != 0)
            idxLaberintoAnterior += 1;
    }
    
    public void Back(){
        if (idxLaberinto > 0)
            idxLaberinto -= 1;
        if (idxLaberintoAnterior > 0)
            idxLaberintoAnterior -= 1;
    }
    
    public int LaberintoActual() {
        return idxLaberinto;
    }
    
    public int LaberintoAnterior(){
        return idxLaberintoAnterior;
    }
}
