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
import Modelo.Artefacto;
import Modelo.Celda;
import Modelo.Enemigo;
import Modelo.Laberinto;

/**
 *
 * @author Gina
 */

class IntPair {
  final int x;
  final int y;
  IntPair(int x, int y) {this.x=x;this.y=y;}
}

public class GestorLaberinto {
    
    public static final int MAX_SIZE_LAB = 10;
    public static final int NRO_ARTEFACTOS = 10; // LUEGO SE VA A QUITAR, MIENTRAS TANTO... -----------------------------------------------------
    
    public GestorLaberinto() {
        
    }
    
    public Laberinto CrearLaberinto(){
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
    
        CrearListaEnemigos(nuevoLaberinto);
        CrearListaArtefactos(nuevoLaberinto);
        
        return nuevoLaberinto;
    }
    
    //NO SE QUE HACER CON EL DEVUELVE RANDOM ADYACENTE, LO HAGO DEPSUES C: --------------------------------------------------------------
    
    public void CrearListaArtefactos(Laberinto l) {
        Random rnd = new Random();
        int max_i = l.getSizeM();
        int max_j = l.getSizeN();

        int art_i, art_j, opcion;
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares
            //definimos las coordenadas donde van a estar los artefactos
            art_i = (rnd.nextInt(max_i/2)*2 +1);
            art_j = (rnd.nextInt(max_j/2)*2 +1);
            
            
            /*
            //Definimos si lo que vamos a crear es un arma o una armadura
            opcion = rnd.nextInt(1);
            
            if(opcion == 0){
                //codigo para crear un arma
            } else if (opcion == 1){
                //creamos una armadura
            }
            */
            
            
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
}
