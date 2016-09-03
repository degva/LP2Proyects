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
                        System.out.print((char) 128);
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
