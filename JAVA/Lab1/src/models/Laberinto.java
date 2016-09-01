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
    private final float pct_enemigo;
    
    // NOTA: podriamos usar un arreglo de listas
    // ArrayList<Celda> pero como hacerlo 2D?
    private Celda[][] laberinto;
    private final int[] niveles_enemigo;
    
    private GestorLaberinto gestor;
    
    public Laberinto(int max_size) {
        Random rnd = new Random();
        size_m = rnd.nextInt(max_size);
        size_n = rnd.nextInt(max_size);
        
        // creamos el arreglo de 2 dimensiones del laberinto
        // this.laberinto = new Celda[2 * size_m + 1][2 * size_n + 1];
        
        pct_enemigo = rnd.nextFloat();
        
        // un arreglo con los niveles posibles de los enemigos que puedan
        // en el laberinto
        niveles_enemigo = new int[size_m / 2];
        
        // llamar funcion que crea el laberinto usando el controlador GestorLaberinto
        gestor.generarLaberinto(laberinto, size_m, size_n);
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
    
}
