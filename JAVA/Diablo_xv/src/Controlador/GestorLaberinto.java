/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

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
    
    public void MoverEnemigos(Laberinto l) {
        // REHACER
        // ArrayList<Enemigo> lista_enemigos = l.getLista_enemigos();
        // Celda aux;
        Enemigo e = null; 
        IntPair nuevaPos;
        
        for (int i = 0; i < l.getSizeM(); i++) {
            for (int j = 0; j < l.getSizeN(); j++) {
                if (l.getCelda(i, j).getContenido() instanceof Enemigo) {
                    e = (Enemigo) l.getCelda(i, j).getContenido();
                    l.getCelda(i, j).setContenido(null);
                    
                    nuevaPos = devuelveRandomAdjacente(l.getLaberinto(), i, j, l.getSizeM(), l.getSizeN(), 1);
                    
                    e.Mover(nuevaPos.x - i, nuevaPos.y - j);
                    
                    l.setCelda(i, j, e);
                }
                /*
                if (aux.getTipoContenido() == 2) {
                    
                    for (int k = 0; k < lista_enemigos.size(); k++) {
                        e = lista_enemigos.get(k);
                        if (e.getPosicionX() == i && e.getPosicionY() == j)
                            break;
                    }
                    
                    l.getCelda(i, j).setTipoContenido(-1);
                    
                    nuevaPos = devuelveRandomAdjacente(l.getLaberinto(), i, j, l.getSize_m(), l.getSize_n(), 1, TipoCelda.ADENTRO);
                    
                    e.setPosicionX(nuevaPos.x);
                    e.setPosicionY(nuevaPos.y);
                    
                    l.getCelda(nuevaPos.x, nuevaPos.y).setTipoContenido(2);
                }
                */
            }
        }
    }
    
    public IntPair devuelveRandomAdjacente(Celda[][] lab, int x, int y, int max_x, int max_y, int i) {
        // REHACER
        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la derecha:
        if ((x > i) && ((lab[x - i][y]).getTipo() == tipo)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && ((lab[x][y - i]).getTipo() == tipo)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < max_x - i) && ((lab[x + i][y]).getTipo() == tipo)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < max_y - i) && ((lab[x][y + i]).getTipo() == tipo)) {
            pair = new IntPair(x, y+i);
            posibles.add(pair);
        }
        
        // si no tiene, devolvemos (-1,-1)
        if (posibles.isEmpty()) {
            pair = new IntPair(-1,-1);
        } else {
            // Hey, aqui creo que podria haber error. 
            // mi cerebro no me da para saber si en el caso hipotetico que me de
            // el tamano de la lista, me bote error por overflow() :v
            // Ej:
            // Digamos que posibles.size() me de 1. Entonces, el random sera o 0
            // o 1. Entonces, si sale 1, posibles.get es por las. O en todo caso
            // si sale 0, puede que posibles.get tambien sea por las... 
            // TODO: revisar documentación java :v
            pair = posibles.get(rnd.nextInt(posibles.size()));
        }
        
        return pair;
    }
}
