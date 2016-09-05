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
import java.util.Scanner;
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
