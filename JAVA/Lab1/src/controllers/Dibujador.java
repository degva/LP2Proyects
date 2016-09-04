/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.*;
import enums.TipoCelda;

/**
 *
 * @author degva
 */
public class Dibujador {
    /**
     * 
     * Muestra: nombre, vida, arma, armadura y elementos que tiene el saco (con
     * indice diferenciado.
     * Ademas: muestra en que laberinto esta.
     * @param lab
     */
    public void Render(Laberinto lab) {
        Celda aux;
        int sizex = 2*lab.getSize_m()+1;
        int sizey = 2*lab.getSize_n()+1;
                
        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                aux = lab.getCelda(i, j);
                switch (aux.getTipo()) {
                    case ADENTRO:
                        System.out.print(' ');
                        break;
                    case PARED:
                        System.out.print('#');
                        break;
                    default:
                        System.out.print("Khe? esto no deberia ejecutarse\n");
                        break;
                }
            }
            System.out.print('\n');
        }
    }
}
