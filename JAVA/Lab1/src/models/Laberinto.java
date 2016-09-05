/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Random;

import controllers.GestorLaberinto;

/**
 *
 * @author degva
 */
public class Laberinto {
    // que es final? :v
    private final int size_m;
    private final int size_n;
    private final int max_size = 20;
    private final float pct_enemigo;
    // NOTA: podriamos usar un arreglo de listas
    // ArrayList<Celda> pero como hacerlo 2D?
    public Celda[][] laberinto;
    private final int[] niveles_enemigo;
      
    
    public Laberinto() {
                       
        Random rnd = new Random();
        // max_size is the maximum and the 2 is our minimum 
        size_m = rnd.nextInt(max_size) + 2;
        size_n = rnd.nextInt(max_size) + 2;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        // esto esta siendo seteado en el gestor!!
        laberinto = new Celda[2 * size_m + 2][2 * size_n + 2];        
        pct_enemigo = rnd.nextFloat();        
        // un arreglo con los niveles posibles de los enemigos que puedan
        // en el laberinto
        niveles_enemigo = new int[size_m / 2];       
    }

    /**
     * @return the size_m
     */
    public int getSize_m() {
        return size_m;
    }

    /**
     * @return the size_n
     */
    public int getSize_n() {
        return size_n;
    }

    /**
     * @return the pct_enemigo
     */
    public float getPct_enemigo() {
        return pct_enemigo;
    }

    /**
     * @return the laberinto
     */
    public Celda[][] getLaberinto() {
        return laberinto;
    }

    /**
     * @param laberinto the laberinto to set
     */
    public void setLaberinto(Celda[][] laberinto) {
        this.laberinto = laberinto;
    }

    /**
     * @return the niveles_enemigo
     */
    public int[] getNiveles_enemigo() {
        return niveles_enemigo;
    }
    
    public Celda getCelda(int x, int y) {
        return laberinto[x][y];
    }
}
