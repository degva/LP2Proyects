/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Random;

/**
 *
 * @author degva
 */
public class Laberinto {
    
    /*
    TODO: 
        - Lista de Enemigos (Se usa en Dibujador.java:69
        - Lista de Artefactos
    */
    
    public static final int MAX_SIZE_LAB = 10;
    
    // que es final? :v
    private final int size_m;
    private final int size_n;
    private final float pct_enemigo;
    // NOTA: podriamos usar un arreglo de listas
    // ArrayList<Celda> pero como hacerlo 2D?
    public Celda[][] laberinto;
    private final int[] niveles_enemigo;
      
    
    public Laberinto() {
                       
        Random rnd = new Random();
        
        int aux = (int)(Math.random()*MAX_SIZE_LAB+5);
        
        // now laberinth is a square
        size_m = 2*aux+1;
        size_n = size_m;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        // esto esta siendo seteado en el gestor!!
        laberinto = new Celda[size_m + 1][size_n + 1];
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
