
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
    
    private final int sizeM;
    private final int sizeN;
    public Celda[][] laberinto;
    private int[] nivelesEnemigo;
    
    private IntPair anterior;
    private IntPair siguiente;
   
    private ArrayList<Enemigo> listaEnemigos;
    private ArrayList<Artefacto> listaArtefactos;
    
    private Aliado aliado;
    
    public static final int MAX_SIZE_LAB = 10;
    
    public Laberinto() {
        Random rnd = new Random();
        int rndAux = (int) (Math.random()*MAX_SIZE_LAB+5);
        this.sizeM = 2*rndAux+1;
        this.sizeN = sizeM;
        
        laberinto = new Celda[sizeM + 1][sizeN + 1];
        
        for (int i =0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                laberinto[i][j] = new Celda(null);
            }
        }
        
        nivelesEnemigo = new int[sizeM];
        for(int i =0; i < sizeM; i++) 
            nivelesEnemigo[i]= rnd.nextInt(10) +1;
        
        listaEnemigos = new ArrayList<>();
        listaArtefactos = new ArrayList<>();
    }
        
    /**
     * @return the sizeM
     */
    public int getSizeM() {
        return sizeM;
    }

    /**
     * @return the sizeN
     */
    public int getSizeN() {
        return sizeN;
    }

    public void AgregarArtefacto(Artefacto a){
        laberinto[a.GetPosX()][a.GetPosY()].SetContenido(a);
        listaArtefactos.add(a);
    }
    
    public void AgregarAliado(Aliado aliado){
        this.laberinto[aliado.GetPosX()][aliado.GetPosY()].SetContenido(aliado);
        this.aliado = aliado;
    }
    
    
    public Aliado GetAliado(){        
        return aliado;
    }
    
    public void AgregarEnemigo(Enemigo e){
        laberinto[e.GetPosX()][e.GetPosY()].SetContenido(e);
        listaEnemigos.add(e);
    }
    
    public void SetTipoCelda(int x, int y, Sprite tipoCelda){
        laberinto[x][y].SetTipo(tipoCelda);
    }
    
    public Sprite GetTipoCelda(int x, int y){
        return laberinto[x][y].GetTipo();
    }
    
    public void setTipoContenido(int x, int y, Sprite tipoContenido){
        laberinto[x][y].SetContenido(tipoContenido);
    }
    
    public Sprite getContenidoCelda(int x, int y){
        return laberinto[x][y].GetContenido();
    }
    
    //verifica que la celda este vacia
    public Boolean celdaVacia(int x, int y){
        return ((laberinto[x][y].GetTipo() instanceof Pasadizo) && (laberinto[x][y].GetContenido() == null));
    }
    
    public Celda getCelda(int x, int y) {
        return laberinto[x][y];
    }
    
    public void SetAnterior(IntPair coordenada){
        anterior = new IntPair(coordenada.x, coordenada.y);
    }
    
    
    public IntPair DevolverAnterior() {
        return anterior;
    }
    
    public void SetSiguiente(IntPair coordenada){
        siguiente = new IntPair(coordenada.x, coordenada.y);
    }
    
    public IntPair DevolverSiguiente() {        
        return  siguiente;
    }
    
    public Enemigo obtenerEnemigoActual(int x, int y){
        Enemigo e = listaEnemigos.get(0); 
        for (int i = 0; i < listaEnemigos.size(); i++) {
            e = listaEnemigos.get(i);
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
        Artefacto a = listaArtefactos.get(0); 
        for (i = 0; i < listaArtefactos.size(); i++) {
            a = listaArtefactos.get(i);
            if (a.GetPosX() == x && a.GetPosY() == y)
                break;
        }
        setTipoContenido(x, y, null);
        return a;
    }

    /**
     * @return the listaEnemigos
     */
    public ArrayList<Enemigo> getListaEnemigos() {
        return listaEnemigos;
    }

    /**
     * @return the listaArtefactos
     */
    public ArrayList<Artefacto> getListaArtefactos() {
        return listaArtefactos;
    }
}
