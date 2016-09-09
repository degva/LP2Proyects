/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Juego.NRO_ARTEFACTOS;
import models.Celda;
import enums.TipoCelda;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import models.Artefacto;
import models.Enemigo;
import models.Laberinto;

/**
 *
 * @author degva
 */

class IntPair {
  final int x;
  final int y;
  IntPair(int x, int y) {this.x=x;this.y=y;}
}

public class GestorLaberinto {
    

    public GestorLaberinto() {
        
    }
     
    public IntPair devuelveRandomAdjacente(Celda[][] lab, int x, int y, int max_x, int max_y) {
        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la derecha:
        if ((x > 2) && ((lab[x - 2][y]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x-2, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > 2) && ((lab[x][y - 2]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x, y-2);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < max_x - 2) && ((lab[x + 2][y]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x+2, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < max_y - 2) && ((lab[x][y + 2]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x, y+2);
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
    
    //Sirve para verificar que el laberinto se esta creando correctamente
    public void printLaberinto(Celda[][] lab, int m, int n) {
        Celda aux;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                aux = lab[i][j];
                switch (aux.getTipo()) {
                    case PARED:
                        System.out.print('#');
                        break;
                    case ADENTRO:
                        System.out.print(' ');
                        break;
                    default:
                        System.out.print('?');
                        break;
                }
            }
            System.out.print('\n');
        }
    }
    
    public void generarLaberinto(Laberinto lab_origin, int m, int n) {
        Celda[][] lab = lab_origin.laberinto;
        
        Random rnd = new Random();
        
        // it doesn't work here
        // lab = new Celda[real_m+1][real_n+1];
        
        // iniciamos todas las celdas como PARED
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lab[i][j] = new Celda(TipoCelda.PARED);
            }
        }
        
        //System.out.print("Sin nodos\n");
        //printLaberinto(lab, m, n);

        for (int i = 1; i < m; i += 2) {
            for (int j = 1; j < n; j += 2) {
                lab[i][j].setTipo(TipoCelda.AFUERA);
            }
        }
        
        //System.out.print("Con nodos\n");
        //printLaberinto(lab, m, n);
        
        // ******************
        // inicia el DFS AQUI
        // ******************
        
        // creamos una pila
        Stack<IntPair> pilaCeldas = new Stack<>();
        // tomamos un valor random
        int x = rnd.nextInt(m/4);
        // x y y son iguales siempre y "random"
        int rx = 2*x+1;
        int ry = rx;

        // marcamos celda como ADENTRO y la ponemos en la pila
        lab[rx][ry].setTipo(TipoCelda.ADENTRO);
        pilaCeldas.push(new IntPair(rx,ry));
        
        // algunos auxiliares para el while...
        IntPair aux, ady;
        
        while(!pilaCeldas.empty()) {
            // 3.1 tomamos la ultima apilada
            aux = pilaCeldas.peek();
            // 3.2 y 3.2.1 tomamos uno de los adjacentes aleatoriamente
            ady = this.devuelveRandomAdjacente(lab, aux.x, aux.y, m, n);
            
            // 3.3 si bota -1 entonces significa que no hay adyacentes. Entonces,
            // hacemos pop :v
            if (ady.x == -1) {
                pilaCeldas.pop();
            } else {
                // 3.2.2 hacemos caminito
                int puente_x = ( aux.x + ady.x )/2;
                int puente_y = ( aux.y + ady.y )/2;
                lab[puente_x][puente_y].setTipo(TipoCelda.ADENTRO);
                
                // 3.2.3 marcamos el adyacente como adentro tambien
                lab[ady.x][ady.y].setTipo(TipoCelda.ADENTRO);
                
                // 3.2.4 apilamos v
                pilaCeldas.push(ady);                
            }
        }
        // printLaberinto(lab, m, n);
        
        crearListaEnemigos(lab_origin);
        crearListaArtefactos(lab_origin);
        
        // return lab_origin;
    }
    
    private void crearListaEnemigos(Laberinto l){
        Random rnd = new Random();
        int max_i = l.getSize_m();
        int max_j = l.getSize_n();
        // hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        // le puse entre 20 porque sino salen demasiados creo :'v 
        //la formula puede ir cambiando
        int nroEnemigos = Math.round((l.getPct_enemigo()* max_i * max_j)/20);
        int ene_i, ene_j;
        int niveles_Enemigo[] = l.getNiveles_enemigo();
        for(int i=0; i< nroEnemigos; i++){
            //voy a considerar que los enemigos aparezcan en los nodos (impares)xd
            //porque sino tendria que estar probando para cada celda que no 
            //sea una pared
            ene_i = (rnd.nextInt(max_i/2)*2 +1);
            ene_j = (rnd.nextInt(max_j/2)*2 +1);
            Enemigo e = new Enemigo (ene_i,ene_j, "Enemigo", niveles_Enemigo[rnd.nextInt(max_i)]);
            l.agregarEnemigo(e);
            l.getCelda(ene_i, ene_j).setTipoContenido(2);
        }
        
    }
    
    private void crearListaArtefactos(Laberinto l){
        Random rnd = new Random();
        int max_i = l.getSize_m();
        int max_j = l.getSize_n();

        int art_i, art_j;
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares pls :'
            art_i = (rnd.nextInt(max_i/2)*2 +1);
            art_j = (rnd.nextInt(max_j/2)*2 +1);
            Artefacto a = new Artefacto ("Artefacto " + i);
            l.agregarArtefacto(a);
            l.getCelda(art_i, art_j).setTipoContenido(3);
            // -> aqui faltaria asociar la clase artefacto con su posicion en el
            // -> mapa
        }
        
    }
    
    // PREG_1
    // Agregamos la funcion que mueve a todos los enemigos
    public void moverEnemigos(Laberinto l) {
        ArrayList<Enemigo> lista_enemigos = l.getLista_enemigos();
        ArrayList<IntPair> lista_posiciones_enemigos = new ArrayList<>(); 
        Celda aux;
        
        Enemigo e = null; 

        IntPair nuevaPos;
        
        for (int i = 0; i < l.getSize_m(); i++) {
            for (int j = 0; j < l.getSize_n(); j++) {
                aux = l.getCelda(i, j);
                if (aux.getTipoContenido() == 2) {
                    
                    nuevaPos = getNuevaPos(l, i, j);
                    
                    lista_posiciones_enemigos.add(new IntPair(i,j));
                    
                    for (int k = 0; k < lista_enemigos.size(); k++) {
                        e = lista_enemigos.get(k);
                        if (e.getPosicionX() == i && e.getPosicionY() == j)
                            break;
                    }
                    
                    l.getCelda(i, j).setTipoContenido(-1);
                    e.setPosicionX(i + 1);
                    e.setPosicionY(j + 1);
                    
                }
            }
        }
    }
    
    public IntPair getNuevaPos(Laberinto l, int i, int j) {
        // falto tiempooooo
        IntPair par = new IntPair(1,1);
        return par;
    }
}
