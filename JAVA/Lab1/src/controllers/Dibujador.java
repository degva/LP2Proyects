/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.*;
import enums.TipoCelda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author degva
 */
public class Dibujador {
    
    // Algunas constantes
    private static final int A = 5;
    private static final int B = 3;
    private int map_width = 0;
    
    public Dibujador() {
        map_width = A*2 + 2;
    }
    
    /*
    TODO: 
        - Avatar: getNombre, getArma(), getArmadura(), getSaco()
        - Arma, Armadura, Artefacto: toString()
    */
    
    public List<String> ObtenerListaDatos(Avatar avatar) {
        List<String> datos = new ArrayList<>();
        // falta hacer el getNombre() :v
        datos.add("Nombre: " + avatar.getNombre());
        String vida = Integer.toString(avatar.getVidaActual()) + "/" + Integer.toString(avatar.getVidaMaxima());
        datos.add("Vida: " + vida);
        datos.add("Arma: " + avatar.getArma().toString());
        datos.add("Armadura: " + avatar.getArmadura().toString());
        datos.add("Cosillas: ");
        Saco saco_aux = avatar.getSaco();
        String aux = new String();
        Artefacto item;
        for (int i = 0; i < saco_aux.getSize(); i++) {
            aux = Integer.toString(i) + ". ";
            item = saco_aux.getItem(i);
            aux.concat(item.toString());
        }
        return datos;
    }
    
    /**
     * 
     * Muestra: nombre, vida, arma, armadura y elementos que tiene el saco (con
     * indice diferenciado.
     * Ademas: muestra en que laberinto esta.
     * @param nivel
     * @param lab
     * @param avatar
     */
    public void Render(int nivel, Laberinto lab, Avatar avatar) {
        Celda aux;
        int sizex = 2*lab.getSize_m()+1;
        int sizey = 2*lab.getSize_n()+1;
        
        List<String> listaDatos = ObtenerListaDatos(avatar);
        List<Enemigo> listaEnemigos = lab.getEnemigos();
        
        // imprimimos el nivel del mapa
        System.out.println("## NIVEL " + nivel);
        
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
