/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import Modelo.*;

/**
 *
 * @author Gina
 */

public class GestorLaberinto {
    
    public static final int MAX_SIZE_LAB = 10;
    public static final int NRO_ARTEFACTOS = 10; // LUEGO SE VA A QUITAR, MIENTRAS TANTO... -----------------------------------------------------
    
    public GestorLaberinto() {
        
    }
    
    public Laberinto CrearLaberinto(int numeroLaberinto){
        Random rnd = new Random();
        
        /*  Inicializamos el laberinto  */
        int aux = (int)(Math.random()*MAX_SIZE_LAB+5);
        int sizeM = 2*aux+1;
        int sizeN = sizeM;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        Laberinto nuevoLaberinto = new Laberinto(sizeM, sizeN);
        nuevoLaberinto.setPctEnemigo(rnd.nextFloat());
        
        /*Ahora generamos el laberinto*/
        
        //inicializamos todas las celdas como PARED
        for (int i = 0; i < nuevoLaberinto.getSizeM(); i++) {
            for (int j = 0; j < nuevoLaberinto.getSizeN(); j++) {
                //FALTA EL TIPO CELDA, CUANDO SE DESCOMENTE VERIFICAR LA FUNCION SET CELDA
                //nuevoLaberinto.setCelda(i, j, nuevaCelda);
            }
        }
        
        for (int i = 0; i < nuevoLaberinto.getSizeM(); i++) {
            for (int j = 0; j < nuevoLaberinto.getSizeN(); j++) {
                //FALTA EL TIPO CELDA
                //nuevoLaberinto.setCelda(i, j, nuevaCelda);
            } 
        }
        
        //****************
        //Inicia el DFS 
        //****************
        
        // creamos una pila
        Stack<IntPair> pilaCeldas = new Stack<>();
        // tomamos un valor random
        int x = rnd.nextInt(nuevoLaberinto.getSizeM()/4);
        // x y y son iguales siempre y "random"
        int rx = 2*x+1;
        int ry = rx;
        
        // marcamos celda como ADENTRO y la ponemos en la pila
        //lab[rx][ry].setTipo(TipoCelda.ADENTRO); --------------------------------------------
        pilaCeldas.push(new IntPair(rx,ry));
        
        // algunos auxiliares para el while...
        IntPair aux1, aux2;
        
        //ESTO ESTA EN TRUE GG
        /*
        while(!pilaCeldas.empty()) {
            // 3.1 tomamos la ultima apilada
            aux1 = pilaCeldas.peek();
            // 3.2 y 3.2.1 tomamos uno de los adjacentes aleatoriamente
            //-----------------------------------------------------------------------
            //aux2 = this.devuelveRandomAdjacente(lab, aux1.x, aux1.y, nuevoLaberinto.getSizeM(), nuevoLaberinto.getSizeN(), 2, TipoCelda.AFUERA);
            
            // 3.3 si bota -1 entonces significa que no hay adyacentes. Entonces,
            // hacemos pop 
            if (aux2.x == -1) {
                pilaCeldas.pop();
            } else {
                // 3.2.2 hacemos caminito
                int puente_x = ( aux1.x + aux2.x )/2;
                int puente_y = ( aux1.y + aux2.y )/2;
                //lab[puente_x][puente_y].setTipo(TipoCelda.ADENTRO); ------------------- ESTO HAY QUE CAMBIARLO TOTALMENTE
                
                // 3.2.3 marcamos el adyacente como adentro tambien
                //lab[aux2.x][aux2.y].setTipo(TipoCelda.ADENTRO); ----------------------tambien hay que cambiarlo totalmente
                
                // 3.2.4 apilamos v
                pilaCeldas.push(aux2);                
            }
        }
        */
        
        /*AGREGRA LO QUE DIJO WILLIAM*/
    
        CrearListaEnemigos(nuevoLaberinto, numeroLaberinto);
        CrearListaArtefactos(nuevoLaberinto, numeroLaberinto);
        
        return nuevoLaberinto;
    }
    
    //NO SE QUE HACER CON EL DEVUELVE RANDOM ADYACENTE, LO HAGO DEPSUES C: --------------------------------------------------------------
    /*Agregra anterio y siguiente*/
    
    public void CrearListaArtefactos(Laberinto l, int numeroLaberitno) {
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();

        int artX, artY;
        GestorArtefacto gestorArt = new GestorArtefacto();
        
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares
            //definimos las coordenadas donde van a estar los artefactos
            artX = (rnd.nextInt(maxX/2)*2 +1);
            artY = (rnd.nextInt(maxY/2)*2 +1);
            
            //verificamos que las cordenadas no esten ocupadas
            Celda auxCelda = new Celda(l.getTipoCelda(artX, artY));
            auxCelda.setContenido(l.getContenidoCelda(artX, artY));
            
            if(l.celdaVacia(artX, artY)){ //si la celda es del tipo pasadizo y esta vacia
                //agregamos un nuevo artefacto
                l.agregarArtefacto(gestorArt.CrearArtefacto(artX, artY, numeroLaberitno));
            } else i--;
        }
    }
    
    public void CrearListaEnemigos(Laberinto l, int numeroLaberitno) {
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();
        
        //Hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        //La formula puede ir cambiando
        int nroEnemigos = Math.round((l.getPctEnemigo()* maxX * maxY)/20);
        int eneX, eneY;
        GestorEnemigo gestorEne = new GestorEnemigo();
        
        for(int i=0; i< nroEnemigos; i++){
            eneX = (rnd.nextInt(maxX/2)*2 +1);
            eneY = (rnd.nextInt(maxY/2)*2 +1);
            
            if(l.celdaVacia(eneX, eneY)){ //si la celda es del tipo pasadizo y esta vacia
                l.agregarEnemigo(gestorEne.CrearEnemigo(eneX, eneY, numeroLaberitno));
            } else i--;
        } 
    }
    
    public void MoverEnemigos() {
        
    }
}
