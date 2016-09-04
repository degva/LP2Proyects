/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.*;
import controllers.*;
import java.util.ArrayList;
/**
 *
 * @author degva
 */
public class Juego {
 
    // estoy seguro que necesitamos una lista de laberintos, pero por prueba
    // hare un unico laberinto :v
    private ArrayList<Celda[][]> lista_laberintos;
    private Dibujador renderer;
    private GestorLaberinto gestor;
    /* NOTAS BY GINA
    SEGUN YO, ACA NE JUEGO FALTA LA LISTA DE LABERINTOS, QUE SON ACA Y EN EL START
    SE DEBE LLAMR VARIAS VECES A EL CREADOR DE LABERINTOS O A GESTOR DE LABERINTOS
    NO SE, QUE ES EL ENCARGADO D EVER ESO
    */
    
    public Juego(int max_size) {
        lista_laberintos = new ArrayList<>();
        gestor = new GestorLaberinto();
        this.crearListaLaberintos(max_size,10);
        renderer = new Dibujador();
    }
    
    public void Start() {
        //aqui va el while
        System.out.print("Oyequedice\n");
        //renderer.Render(laberinto);
    }

    private void crearListaLaberintos(int max_size, int size){
                
        
        for (int i = 0; i < max_size; i++) {
            Laberinto objLab = new Laberinto(size);
            
            objLab.laberinto = gestor.generarLaberinto(objLab.laberinto, 
                    objLab.getSize_m(), objLab.getSize_n());
            
            lista_laberintos.add(objLab.laberinto);
            
        }
    }
}
