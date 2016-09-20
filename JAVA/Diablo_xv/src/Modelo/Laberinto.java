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
    
    private IntPair _anterior;
    private IntPair _siguiente;
   
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

    public void agregarArtefacto(Artefacto a){
        _laberinto[a.getPosX()][a.getPosY()].setContenido(a);
        _listaArtefactos.add(a);
    }
    
    public void agregarEnemigo(Enemigo e){
        _laberinto[e.getPosX()][e.getPosY()].setContenido(e);
        _listaEnemigos.add(e);
    }
    
    public void setTipoCelda(int x, int y, Celda nuevaCelda){
        _laberinto[x][y] = nuevaCelda;
    }
    
    public ObjetoGrafico getTipoCelda(int x, int y){
        return _laberinto[x][y].getTipo();
    }
    
    public ObjetoGrafico getContenidoCelda(int x, int y){
        return _laberinto[x][y].getContenido();
    }
    
    //verifica que la celda este vacia
    public Boolean celdaVacia(int x, int y){
        return ((_laberinto[x][y].getTipo() instanceof Pasadizo) && (_laberinto[x][y].getContenido() == null));
    }

}
