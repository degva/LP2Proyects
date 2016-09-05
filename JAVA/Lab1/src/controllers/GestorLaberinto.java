/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Celda;
import enums.TipoCelda;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
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
        if ((x > 0) && ((lab[x - 2][y]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x-1, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > 0) && ((lab[x][y - 2]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x, y-1);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < max_x) && ((lab[x + 2][y]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x+1, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < max_y) && ((lab[x][y + 2]).getTipo() == TipoCelda.AFUERA)) {
            pair = new IntPair(x, y+1);
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
    
    public Celda[][] generarLaberinto(Celda[][] lab, int m, int n) {
        Random rnd = new Random();
        
        // int real_m = 2*m+1;
        // int real_n = 2*n+1;
        
        // it doesn't work here
        // lab = new Celda[real_m+1][real_n+1];
        
        // iniciamos todas las celdas como PARED
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                lab[i][j] = new Celda(TipoCelda.PARED);
            }
        }
        
        // creamos los nodos
        // m o m+1 ?
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                lab[2*i+1][2*j+1].setTipo(TipoCelda.AFUERA);
            }
        }
        
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
        return lab;
    }
    
    
}
