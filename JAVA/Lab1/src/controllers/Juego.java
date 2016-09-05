/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.*;
import enums.TipoCelda;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author degva
 */
public class Juego {
 
    // estoy seguro que necesitamos una lista de laberintos, pero por prueba
    // hare un unico laberinto :v
    private ArrayList<Laberinto> lista_laberintos;
    private Dibujador renderer;
    private Avatar avatar;
    private GestorLaberinto gestor;
    /* NOTAS BY GINA
    SEGUN YO, ACA NE JUEGO FALTA LA LISTA DE LABERINTOS, QUE SON ACA Y EN EL START
    SE DEBE LLAMR VARIAS VECES A EL CREADOR DE LABERINTOS O A GESTOR DE LABERINTOS
    NO SE, QUE ES EL ENCARGADO D EVER ESO
    */
    
    public Juego(int max_size) {
        lista_laberintos = new ArrayList<>();
        gestor = new GestorLaberinto();
        this.crearListaLaberintos(max_size);
        this.agregarAnteriorySiguiente();
        renderer = new Dibujador();
    }
    
    public void Start() {
        //aqui va el while
        System.out.print("Oyequedice\n");
        //renderer.Render(laberinto);
    }

    private void crearListaLaberintos(int max_size){                
        
        for (int i = 0; i < max_size; i++) {
            Laberinto objLab = new Laberinto();
            
            objLab.laberinto = gestor.generarLaberinto(objLab.laberinto, 
                    objLab.getSize_m(), objLab.getSize_n());
            
            lista_laberintos.add(objLab);                        
        }
    }
    
    private void agregarAnteriorySiguiente(){
        
        int anterior,siguiente, cont = 0;
        int x,y;
        Random rnd = new Random();
                
        /*
        Metodo de asignacion de la celda anterior y siguiente:
        Se recorrera el laberinto, guardando las coordenadas de todas las celdas que esten
        marcadas como ADENTRO, luego generando un numero aleatorio se elegira uno de esos pares
        para anterior y otro para siguiente
        */
        
        for (Laberinto lab : lista_laberintos) {
            IntPair[] coords = new IntPair[lab.getSize_m()*lab.getSize_n()/2];
            for (int i = 1; i < lab.getSize_m(); i++) 
                for (int j = 1; j < lab.getSize_n(); j++) {                    
                    if (lab.getCelda(i, j).getTipo() == TipoCelda.ADENTRO){
                        coords[cont++] = new IntPair(i,j);                      
                    }
                }

            anterior = rnd.nextInt(cont);
            siguiente = rnd.nextInt(cont);            
            
            x = coords[anterior].x;
            y = coords[anterior].y;            
            lab.getCelda(x, y).setTipoContenido(0);
            
            x = coords[siguiente].x;
            y = coords[anterior].y;
            lab.getCelda(x, y).setTipoContenido(1);
        }
    }      
}
