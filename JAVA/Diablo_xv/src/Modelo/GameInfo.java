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
    private boolean winner;
    private int idxLaberinto;
    private int idxLaberintoAnterior;
    private final int numeroDeLaberintos;
    
    public GameInfo(int nLabs){
        gameON = true;
        winner = false;
        idxLaberinto = 0;
        idxLaberintoAnterior = 0;
        numeroDeLaberintos = nLabs;
    }
    
    public boolean GameIsNotOver(){
        return gameON;
    }
    
    public void GameOff(){
        gameON = false;
    }
    
    public void Next(){
        idxLaberinto += 1;
        if (idxLaberintoAnterior != 0)
            idxLaberintoAnterior += 1;
        if (idxLaberinto == numeroDeLaberintos){
            idxLaberinto -= 1;
            winner = true;
            gameON = false;
        }
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
