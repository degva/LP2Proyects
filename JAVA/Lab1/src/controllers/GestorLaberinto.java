/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Celda;
import enums.TipoCelda;

/**
 *
 * @author degva
 */
public class GestorLaberinto {
    public void generarLaberinto(Celda[][] lab, int m, int n) {
        int real_m = 2*m+1;
        int real_n = 2*n+1;
        
        lab = new Celda[real_m][real_n];
        
        // iniciamos todas las celdas como PARED
        for (int i = 0; i < real_m; i++) {
            for (int j = 0; j < real_n; j++) {
                lab[i][j] = new Celda(TipoCelda.PARED);
            }
        }
        
        // creamos los nodos
        // x -> 2 * x + 1
        // 0 -> 1
        // 1 -> 3
        // 2 -> 5
        // 3 -> 7
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lab[2*m+1][2*n+1].setTipo(TipoCelda.AFUERA);
            }
        }
        
        // inicia el DFS AQUI
    }
}
