/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author degva
 */
public class Laberinto {
    
    public static final int MAX_SIZE_LAB = 10;
    
    private final int _sizeM;
    private final int _sizeN;
    private final float _pctEnemigo;
    private Celda[][] _laberinto;
    private final int[] _nivelesEnemigo;
    
    private ArrayList<Enemigo> _listaEnemigos;
    private ArrayList<Artefacto> _listaArtefactos;
    
    public Laberinto() {
        Random rnd = new Random();
        
        int aux = (int)(Math.random()*MAX_SIZE_LAB+5);
        
        _sizeM = 2*aux+1;
        _sizeN = _sizeM;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        // esto esta siendo seteado en el gestor!!
        _laberinto = new Celda[_sizeM + 1][_sizeN + 1];
        _pctEnemigo = rnd.nextFloat();
        
        // un arreglo con los niveles posibles de los enemigos que puedan
        // en el laberinto
        _nivelesEnemigo = new int[_sizeM];
        //estamos usando el ancho como total de niveles posibles xdxd
        for(int i =0; i < _sizeM; i++) 
            _nivelesEnemigo[i]= rnd.nextInt(10) +1; //arreglo de posible niveles            
        
        _listaEnemigos = new ArrayList<>();
        _listaArtefactos = new ArrayList<>();
    }

    /**
     * @return the _sizeM
     */
    public int getSizeM() {
        return _sizeM;
    }

    /**
     * @return the _sizeN
     */
    public int getSizeN() {
        return _sizeN;
    }

    /**
     * @return the _pctEnemigo
     */
    public float getPctEnemigo() {
        return _pctEnemigo;
    }

    /**
     * @return the _laberinto
     */
    public Celda[][] getLaberinto() {
        return _laberinto;
    }

    /**
     * @param _laberinto the _laberinto to set
     */
    public void setLaberinto(Celda[][] _laberinto) {
        this._laberinto = _laberinto;
    }

    /**
     * @return the _nivelesEnemigo
     */
    public int[] getNivelesEnemigo() {
        return _nivelesEnemigo;
    }

    /**
     * @return the _listaEnemigos
     */
    public ArrayList<Enemigo> getListaEnemigos() {
        return _listaEnemigos;
    }

    /**
     * @return the _listaArtefactos
     */
    public ArrayList<Artefacto> getListaArtefactos() {
        return _listaArtefactos;
    }
    
    public Celda getCelda(int x, int y) {
        return _laberinto[x][y];
    }

    public void agregarEnemigo(Enemigo e){
        this.getListaEnemigos().add(e);
    }
    
    public void agregarArtefacto(Artefacto a){
        this.getListaArtefactos().add(a);
    }
}
