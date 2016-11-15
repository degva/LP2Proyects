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

    private boolean gameON = true;
    private boolean winner = false;
    private boolean onColission = false;
    private int idxLaberinto = 0;
    private int idxLaberintoAnterior = 0;
    private int numeroDeLaberintos = 0;
    private int contador = 0;
    private static GameInfo INSTANCE = null;
    
    
    protected GameInfo(){
    }
    
    public static GameInfo Get(){
        if (INSTANCE == null)
            INSTANCE = new GameInfo();
        return INSTANCE;
    }
    
    public void SetNumeroDeLaberintos(int n){
        numeroDeLaberintos = n;
    }
    
    public boolean GameIsNotOver(){
        return gameON;
    }
    
    public boolean PlayerHasWon(){
        return (gameON == false && winner == true);
    }
    
    public void GameOff(){
        gameON = false;
    }
    
    public void LevelUp(){
        idxLaberinto += 1;
        if (idxLaberintoAnterior != 0)
            idxLaberintoAnterior += 1;
        if (getIdxLaberinto() == numeroDeLaberintos){
            idxLaberinto -= 1;
            winner = true;
            gameON = false;
        }
    }
    
    public void LevelDown(){
        if (getIdxLaberinto() > 0)
            idxLaberinto -= 1;
        if (idxLaberintoAnterior > 0)
            idxLaberintoAnterior -= 1;
    }
    
    public int LaberintoActual() {
        return getIdxLaberinto();
    }
    
    public int LaberintoAnterior(){
        return idxLaberintoAnterior;
    }
    
    /**
     * @return the onColission
     */
    public boolean isOnColission() {
        return onColission;
    }

    /**
     * @param onColission the onColission to set
     */
    public void setOnColission(boolean onColission) {
        this.onColission = onColission;
    }

    /**
     * @return the contador
     */
    public synchronized int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public synchronized void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * @return the idxLaberinto
     */
    public int getIdxLaberinto() {
        return idxLaberinto;
    }

}
