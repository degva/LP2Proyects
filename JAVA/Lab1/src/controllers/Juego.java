/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author degva
 */
public class Juego {

    private ArrayList<Laberinto> lista_laberintos;
    private Dibujador renderer;
    private GestorLaberinto gestor;
    private Avatar avatar;
    private int laberintoActual;
    /* NOTAS BY GINA
    SEGUN YO, ACA NE JUEGO FALTA LA LISTA DE LABERINTOS, QUE SON ACA Y EN EL START
    SE DEBE LLAMR VARIAS VECES A EL CREADOR DE LABERINTOS O A GESTOR DE LABERINTOS
    NO SE, QUE ES EL ENCARGADO D EVER ESO
    */
    
    public Juego() {
        lista_laberintos = new ArrayList<>();
        gestor = new GestorLaberinto();
        this.crearListaLaberintos();        
        renderer = new Dibujador();
        laberintoActual = 0;
    }
    
    public void Start() {
        String opcion;
        Scanner input = new Scanner(System.in);
        while (true){
            //Aqui en el render se debe pasar ademas de laberinto,
            //las coordenadas actuales de avatar
            renderer.Render(laberintoActual); //avatar.getPosicionX(),avatar.getPosicionY(),...
            System.out.print("Nombre: " ); // ,avatar.getNombre()
            System.out.print("\nVida: [ " + avatar.getVidaActual() + " ]" );
            
            // ,aqui debemos imprimir un indice dependiendo del tipo de arma
            System.out.print("\nArma: " ); 
            // ,same que el arma xd
            System.out.print("\nArmadura: " );
            
            /*aqui en la impresion del saco se tiene un numero de artefactos
              desconocido, que dependera de lo que tenga saco en ese momento
                falta codear esa parte :'
            */

            System.out.print("\n\n");
            System.out.print("Escriba una accion:\n" );
            System.out.print("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):\n" );
            System.out.print("> [interactuar]\n" );
            System.out.print("> [salir]\n\n - > " );

            opcion = input.nextLine();
            // faltan las restricciones de los limites del mapa(en el dibujador?)
            //por si se quiere salir o si hay una pared
            if ("mover arriba".equals(opcion)) {
                avatar.moveUp(); 
            }
            else if ("mover abajo".equals(opcion)) {
                avatar.moveDown();
            }
            else if ("mover izquierda".equals(opcion)) {
                avatar.moveLeft();
            }
            else if ("mover derecha".equals(opcion)) {
                avatar.moveRight();
            }
            else if ("interactuar".equals(opcion)) {
                //aqui se debe verificar si en las celdas adyacentes se
                //encuentra algun artefacto

                //if (alguna celda adyacente al avatar tiene un artefacto)
                    // agregar artefacto al saco
            }
            else if ("salir".equals(opcion)) {
                System.out.print("\nGudbai\n");
                break;
            }else {
                System.out.print("\nIngrese una accion correcta\n");
            }
        
            
        }
    }

    private void crearListaLaberintos(){                
        Random rnd = new Random(0);
        int MAX_LABERINTOS = 10; // un numero maximo de laberintos en el juego
        int numeroDeLaberintos = rnd.nextInt(MAX_LABERINTOS);
        for (int i = 0; i < numeroDeLaberintos; i++) {
            Laberinto objLab = new Laberinto();            
            objLab.laberinto = gestor.generarLaberinto(objLab.laberinto, 
                    objLab.getSize_m(), objLab.getSize_n());            
            lista_laberintos.add(objLab.laberinto);                        
        }
    }
    
    private void agregarAnteriorySiguiente(){        
        int counter = 1;        
        for (Celda[][] lista : lista_laberintos) {
            
        }
    }
    
    public int getLaberintoActual(){
        return this.laberintoActual;
    }
}
