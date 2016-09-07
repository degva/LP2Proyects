/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author degva
 */
public class Laberinto {
    
    
    //public static final int MAX_ENEMIES = 5;
    public static final int MAX_SIZE_LAB = 10;
    
    // que es final? :v -> funciona como constante para la clase, creo :'v
    private final int size_m;
    private final int size_n;
    private final float pct_enemigo;
    public Celda[][] laberinto;
    private final int[] niveles_enemigo;
    
    private ArrayList<Enemigo> lista_enemigos;
    private ArrayList<Artefacto> lista_artefactos;
    
    public Laberinto() {
                       
        Random rnd = new Random();
        
        int aux = (int)(Math.random()*MAX_SIZE_LAB+5);
        
        // now laberinth is a square
        size_m = 2*aux+1;
        size_n = size_m;
        //size_m = 20; // hey que fue aqui :( no more random?
        //size_n = 20; // jajajaja lo hice para testear algo, y me olvide de borrarlo xd sorry (8)
        
        // creamos el arreglo de 2 dimensiones del laberinto
        // esto esta siendo seteado en el gestor!!
        laberinto = new Celda[size_m + 1][size_n + 1];
        pct_enemigo = rnd.nextFloat();
        // un arreglo con los niveles posibles de los enemigos que puedan
        // en el laberinto
        niveles_enemigo = new int[size_m];
        //estamos usando el ancho como total de niveles posibles xdxd
        for(int i =0; i < size_m; i++) 
            niveles_enemigo[i]= rnd.nextInt(10) +1; //arreglo de posible niveles            
        
        lista_enemigos = new ArrayList<>();
        lista_artefactos = new ArrayList<>();
        
        
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

    public void agregarEnemigo(Enemigo e){
        this.getLista_enemigos().add(e);
    }
    
    public void agregarArtefacto(Artefacto a){
        this.lista_artefactos.add(a);
    }

    /**
     * @return the lista_enemigos
     */
    public ArrayList<Enemigo> getLista_enemigos() {
        return lista_enemigos;
    }
    
    
}

