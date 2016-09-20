/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import Modelo.Artefacto;
import Modelo.Celda;
import Modelo.Enemigo;
import Modelo.Laberinto;

/**
 *
 * @author Gina
 */
public class GestorLaberinto {
    
    public static final int MAX_SIZE_LAB = 10;
    public static final int NRO_ARTEFACTOS = 10; // LUEGO SE VA A QUITAR, MIENTRAS TANTO... -----------------------------------------------------
    
    public GestorLaberinto() {
        
    }
    
    public Laberinto CrearLaberinto(){
        
        
        Random rnd = new Random();
        
        int aux = (int)(Math.random()*MAX_SIZE_LAB+5);
        
        int sizeM = 2*aux+1;
        int sizeN = sizeM;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        Laberinto newLaberinto = new Laberinto(sizeM, sizeN);
        newLaberinto.setPctEnemigo(rnd.nextFloat());
        
        return newLaberinto;
    }
    
    //NO SE QUE HACER CON EL DEVUELVE RANDOM ADYACENTE, LO HAGO DEPSUES C: --------------------------------------------------------------
    
    public void CrearListaArtefactos(Laberinto l) {
        Random rnd = new Random();
        int max_i = l.getSizeM();
        int max_j = l.getSizeN();

        int art_i, art_j;
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares pls :'
            art_i = (rnd.nextInt(max_i/2)*2 +1);
            art_j = (rnd.nextInt(max_j/2)*2 +1);
            //Modificar el constructor de artefacto
            // **D* Gina, creo que necesitamos un nuevo gestor. Ya qe no podemos crear
            // un artefacto ya que es una clase general. Deberiamos crear un
            // arma/armadura esas cosas :v
            /*
            Artefacto a = GestorArtefacto()
            // Artefacto a = new Artefacto("Artefacto " + i);
            */
    
            //l.agregarArtefacto(a); SI NO NO COMPILA
            
            //Aqui tambien hay algo que modificar---------------------------------------------------------------------------
            // **D* Gina, esto lo iba a hacer Fabricio
            /*
            l.getCelda(art_i, art_j).setTipoContenido(3);
            */
        }
        
    }
    
    public void CrearListaEnemigos(Laberinto l) {
        Random rnd = new Random();
        int max_i = l.getSizeM();
        int max_j = l.getSizeN();
        // hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        //la formula puede ir cambiando
        int nroEnemigos = Math.round((l.getPctEnemigo()* max_i * max_j)/20);
        int ene_i, ene_j;
        int niveles_Enemigo[] = l.getNivelesEnemigo();
        for(int i=0; i< nroEnemigos; i++){
            //voy a considerar que los enemigos aparezcan en los nodos (impares)xd
            //porque sino tendria que estar probando para cada celda que no 
            //sea una pared
            // **D* Gina, realmente necesitamos una funcion que devuelve una celda
            // totalmente vacia. Si no, podrias estar sobreescribiendo un artefacto
            // con un enemigo :v
            ene_i = (rnd.nextInt(max_i/2)*2 +1);
            ene_j = (rnd.nextInt(max_j/2)*2 +1);
            //Creamos el enemigo
            //Aqui hay que modificar el constructor de enemigo--------------------------------------------------------------
            /*
            Enemigo e = new Enemigo (ene_i,ene_j, "Enemigo", niveles_Enemigo[rnd.nextInt(max_i)]);
            */
            
            //l.agregarEnemigo(e); ESTO SI SE QUEDA, PERO ASI PORQUE SINO NO COMPILA
            
            //Aqui tambien hay algo que modificar---------------------------------------------------------------------------
            // **D* Gina, esto lo iba a hacer Fabricio x2
            /*
            l.getCelda(ene_i, ene_j).setTipoContenido(2);
            */
        } 
    }
    
    public void MoverEnemigos() {
        
    }
    
    public IntPair DevolverAnterior(Laberinto lab) {
        
    }
    
    public IntPair DevolverSiguiente(Laberinto lab) {
        
    } 
}
