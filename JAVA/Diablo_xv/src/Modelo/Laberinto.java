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
    
    //public static final int MAX_SIZE_LAB = 10;
    
    private int _sizeM;
    private int _sizeN;
    private float _pctEnemigo;
    public Celda[][] _laberinto;
    private int[] _nivelesEnemigo;
    
    private ArrayList<Enemigo> _listaEnemigos;
    private ArrayList<Artefacto> _listaArtefactos;
    
    public Laberinto(int sizeM, int sizeN) {
        Random rnd = new Random();

        this._sizeM = sizeM;
        this._sizeN = sizeN;
        
        _laberinto = new Celda[_sizeM + 1][_sizeN + 1];
        _nivelesEnemigo = new int[_sizeM];
        for(int i =0; i < _sizeM; i++) 
            _nivelesEnemigo[i]= rnd.nextInt(10) +1;
        
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
     * @param _pctEnemigo the _pctEnemigo to set
     */
    public void setPctEnemigo(float _pctEnemigo) {
        this._pctEnemigo = _pctEnemigo;
    }

    /**
     * @return the _laberinto
     */
   
    public Celda[][] getLaberinto() {
        return _laberinto;
    }

    /**
     * @return the _nivelesEnemigo
     */
    public int[] getNivelesEnemigo() {
        return _nivelesEnemigo;
    }
    
    public void agregarEnemigo(Enemigo e){
        _listaEnemigos.add(e);
    }
    
    public void agregarArtefacto(Artefacto a){
        _listaArtefactos.add(a);
    }
    
    /*
    public Celda getCelda(int x, int y){
        return _laberinto[x][y];
    }
*/
    public void setTipoCelda(int x, int y, Celda nuevaCelda){
        _laberinto[x][y] = nuevaCelda;
    }

}
