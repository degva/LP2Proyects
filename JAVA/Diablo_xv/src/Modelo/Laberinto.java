
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;
import Facilidades.Aliado;



/**
 *
 * @author degva
 */
public class Laberinto {
    
    private final int _sizeM;
    private final int _sizeN;
    private float _pctEnemigo;
    public Celda[][] _laberinto;
    private int[] _nivelesEnemigo;
    
    private IntPair _anterior;
    private IntPair _siguiente;
   
    private ArrayList<Enemigo> _listaEnemigos;
    private ArrayList<Artefacto> _listaArtefactos;
    
    private Aliado _aliado;
    
    public Laberinto(int sizeM, int sizeN) {
        Random rnd = new Random();

        this._sizeM = sizeM;
        this._sizeN = sizeN;
        
        _laberinto = new Celda[_sizeM + 1][_sizeN + 1];
        
        for (int i =0; i < _sizeM; i++) {
            for (int j = 0; j < _sizeN; j++) {
                _laberinto[i][j] = new Celda(null);
            }
        }
        
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

    public void AgregarArtefacto(Artefacto a){
        _laberinto[a.GetPosX()][a.GetPosY()].SetContenido(a);
        _listaArtefactos.add(a);
    }
    
    public void AgregarAliado(Aliado aliado){
        this._laberinto[aliado.GetPosX()][aliado.GetPosY()].SetContenido(aliado);
        this._aliado = aliado;
    }
    
    
    public Aliado GetAliado(){        
        return _aliado;
    }
    
    public void AgregarEnemigo(Enemigo e){
        _laberinto[e.GetPosX()][e.GetPosY()].SetContenido(e);
        _listaEnemigos.add(e);
    }
    
    public void SetTipoCelda(int x, int y, Sprite tipoCelda){
        _laberinto[x][y].SetTipo(tipoCelda);
    }
    
    public Sprite GetTipoCelda(int x, int y){
        return _laberinto[x][y].GetTipo();
    }
    
    public void setTipoContenido(int x, int y, Sprite tipoContenido){
        _laberinto[x][y].SetContenido(tipoContenido);
    }
    
    public Sprite getContenidoCelda(int x, int y){
        return _laberinto[x][y].GetContenido();
    }
    
    //verifica que la celda este vacia
    public Boolean celdaVacia(int x, int y){
        return ((_laberinto[x][y].GetTipo() instanceof Pasadizo) && (_laberinto[x][y].GetContenido() == null));
    }
    
    public Celda getCelda(int x, int y) {
        return _laberinto[x][y];
    }
    
    public void SetAnterior(IntPair coordenada){
        _anterior = new IntPair(coordenada.x, coordenada.y);
    }
    
    
    public IntPair DevolverAnterior() {
        return _anterior;
    }
    
    public void SetSiguiente(IntPair coordenada){
        _siguiente = new IntPair(coordenada.x, coordenada.y);
    }
    
    public IntPair DevolverSiguiente() {        
        return  _siguiente;
    }
    
    public Enemigo obtenerEnemigoActual(int x, int y){
        Enemigo e = _listaEnemigos.get(0); 
        for (int i = 0; i < _listaEnemigos.size(); i++) {
            e = _listaEnemigos.get(i);
            if (e.GetPosX() == x && e.GetPosY() == y)
                break;
        }
        return e;
    }
    
    public void retornarEnemigoActual(Enemigo eNew){
        Enemigo e;
        int posX = eNew.GetPosX();
        int posY = eNew.GetPosY();
        if (eNew.GetVidaActual() <= 0) setTipoContenido(posX, posY, null);
    }
    
    public Artefacto obtenerArtefactoActual(int x, int y){
        int i;
        Artefacto a = _listaArtefactos.get(0); 
        for (i = 0; i < _listaArtefactos.size(); i++) {
            a = _listaArtefactos.get(i);
            if (a.GetPosX() == x && a.GetPosY() == y)
                break;
        }
        setTipoContenido(x, y, null);
        return a;
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
}
