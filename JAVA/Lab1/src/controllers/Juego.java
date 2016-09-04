/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.util.Scanner;
import models.*;
/**
 *
 * @author degva
 */
public class Juego {
 
    // estoy seguro que necesitamos una lista de laberintos, pero por prueba
    // hare un unico laberinto :v
    private Laberinto laberinto;
    private Dibujador renderer;
    private Avatar avatar;
    /* NOTAS BY GINA
    SEGUN YO, ACA NE JUEGO FALTA LA LISTA DE LABERINTOS, QUE SON ACA Y EN EL START
    SE DEBE LLAMR VARIAS VECES A EL CREADOR DE LABERINTOS O A GESTOR DE LABERINTOS
    NO SE, QUE ES EL ENCARGADO D EVER ESO
    */
    
    public Juego(int max_size) {
        Scanner input = new Scanner(System.in);
        String nombre;
        laberinto = new Laberinto(max_size);
        renderer = new Dibujador();
        System.out.print("Insert your name:\n> ");
        nombre = input.nextLine();
        /* aqui se crea un nuevo objeto Avatar, pero debe modificarse el constructor
        y agregarle el atributo de nombre :' */
        
        // el avatar inicia en la celda anterior del nivel 1,
        // por lo cual creo que en la clase laberinto deberiamos tener como atributo
        // las posiciones del ANTERIOR y SIGUIENTE, sino no sé como hariamos
        // para pasar de un nivel a otro tambien :'
        
        avatar = new Avatar(1,1); //, nombre);
        // estoy poniendo al avatar en la esquinita superior izquierda por mientras xd
        
    }
    
    
    // papus aqui va el bucle xd pero falta definir la lista de los laberintos y otras cosas
    public void Start() {
        Scanner input = new Scanner(System.in);
        while (true){
            //Aqui en el render se debe pasar ademas de laberinto,
            //las coordenadas actuales de avatar y tambien las coordenadas
            //de los enemigos y los artefactos creo e.e
            String opcion;
            renderer.Render(laberinto); //avatar.getPosicionX(),avatar.getPosicionY(),...
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
        System.out.print("Oyequedice\n"); // lol
    }

    
}
