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
    
    private final int _sizeM;
    private final int _sizeN;
    private float _pctEnemigo;
    private Celda[][] _laberinto;
    private int[] _nivelesEnemigo;
    
    private final ArrayList<Enemigo> _listaEnemigos;
    private final ArrayList<Artefacto> _listaArtefactos;
    
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
    
    public Celda getCelda(int x, int y) {
        return _laberinto[x][y];
    }

    public IntPair DevolverAnterior() {
        IntPair aux = null;
        for (int i = 0; i < this.getSizeM(); i++) {
            for (int j = 0; j < this.getSizeN(); j++) {
                if ( this.getCelda(i, j).getTipo() instanceof Anterior) {
                    aux = new IntPair(i,j);
                }
            }
        }
        return aux;
    }
    
    public IntPair DevolverSiguiente() {
        IntPair aux = null;
        for (int i = 0; i < this.getSizeM(); i++) {
            for (int j = 0; j < this.getSizeN(); j++) {
                if ( this.getCelda(i, j).getTipo() instanceof Siguiente) {
                    aux = new IntPair(i,j);
                }
            }
        }
        return aux;
    }
    
    public Enemigo obtenerEnemigoActual(int x, int y){
        // a esta funcion se le va a pasar la ubicacion del avatar
        // para asi poder detectar a que enemigo de la lista se refiere
        Enemigo e = _listaEnemigos.get(0); 
        for (int i = 0; i < _listaEnemigos.size(); i++) {
            e = _listaEnemigos.get(i);
            if (e.getPosX() == x && e.getPosY() == y)
                break;
        }
        return e;
    }
    
    public void retornarEnemigoActual(Enemigo eNew){
        Enemigo e;
        int i;
        int posX = eNew.getPosX();
        int posY = eNew.getPosY();
        
        for (i = 0; i < _listaEnemigos.size(); i++) {
            e = _listaEnemigos.get(i);
            if (e.getPosX() == posX && e.getPosY() == posY)
                break;
        }
        if (eNew.vida <= 0) _listaEnemigos.remove(i); // eliminar de la lista si muere
        else _listaEnemigos.set(i, eNew);
         
        
    }
    public Artefacto obtenerArtefactoActual(int x, int y){
        // a esta funcion se le va a pasar la ubicacion del avatar
        // para asi poder detectar a que enemigo de la lista se refiere
        int i;
        Artefacto a = _listaArtefactos.get(0); 
        for (i = 0; i < _listaArtefactos.size(); i++) {
            a = _listaArtefactos.get(i);
            if (a.getPosX() == x && a.getPosY() == y)
                break;
        }
        //se quita el artefacto de la lista, 
        //para que luego el render no lo imprima
        _listaArtefactos.remove(i);
        return a;
    }
    
    
    
}
