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
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author degva
 */
public class Juego {
    private ArrayList<Laberinto> lista_laberintos;
    private Dibujador renderer;
    private Avatar avatar;
    private GestorLaberinto gestor;
    private int laberintoActual;

 
    public Juego() {
        Scanner input = new Scanner(System.in);
        
        lista_laberintos = new ArrayList<>();
        gestor = new GestorLaberinto();
        renderer = new Dibujador();
        laberintoActual = 0;
        
        this.crearListaLaberintos();
        this.agregarAnteriorySiguiente();

        /* aqui se crea un nuevo objeto Avatar, pero debe modificarse el constructor
        y agregarle el atributo de nombre :' */        
        String nombre;
        System.out.print("Insert your name:\n> ");
        nombre = input.nextLine();
        
        // el avatar inicia en la celda anterior del nivel 1,
        // por lo cual creo que en la clase laberinto deberiamos tener como atributo
        // las posiciones del ANTERIOR y SIGUIENTE, sino no sé como hariamos
        // para pasar de un nivel a otro tambien :'
        // ^ this
        
        avatar = new Avatar(1, 1, nombre, 1);
        // estoy poniendo al avatar en la esquinita superior izquierda por mientras xd
    }
    
    
    // papus aqui va el bucle xd pero falta definir la lista de los laberintos y otras cosas
    public void Start() {
        //renderer.Render(laberinto);
        Scanner input = new Scanner(System.in);
        int sigAnt;
        OUTER:
        while (true) {
            
            String opcion;
            sigAnt = renderer.Render(laberintoActual, lista_laberintos.get(laberintoActual), avatar);
            
            if (sigAnt == 1){
                laberintoActual++;
                continue;
            }
            else if (sigAnt == -1){
                laberintoActual--;
                continue;
            }
            
            System.out.print("\n\n");
            System.out.print("Escriba una accion:\n" );
            System.out.print("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):\n" );
            System.out.print("> [interactuar]\n" );
            System.out.print("> [salir]\n\n - > " );
            opcion = input.nextLine();

            if (null != opcion) {
                /*Los else son solo para porbar que la funcionalidad trabaja bien*/
                int posicionActualX = avatar.getPosicionX();
                int posicionActualY = avatar.getPosicionY();
                Laberinto actualLaberinto = lista_laberintos.get(laberintoActual);
                switch (opcion) {
                    case "w"://"mover arriba":
                        if(actualLaberinto.laberinto[posicionActualX][posicionActualY-1].getTipo() != TipoCelda.PARED)
                            avatar.moveUp();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "s"://"mover abajo":
                        if(actualLaberinto.laberinto[posicionActualX][posicionActualY+1].getTipo() != TipoCelda.PARED)
                            avatar.moveDown();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "a"://"mover izquierda":
                        if(actualLaberinto.laberinto[posicionActualX-1][posicionActualY].getTipo() != TipoCelda.PARED)
                            avatar.moveLeft();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "d"://"mover derecha":
                        if(actualLaberinto.laberinto[posicionActualX+1][posicionActualY].getTipo() != TipoCelda.PARED)
                            avatar.moveRight();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "interactuar":
                        //aqui se debe verificar si en las celdas adyacentes se
                        //encuentra algun artefacto
                        //if (alguna celda adyacente al avatar tiene un artefacto)
                        // agregar artefacto al saco
                        break;
                    case "salir":
                        System.out.print("\nGudbai\n");
                        break OUTER;
                    default:
                        System.out.print("\nIngrese una accion correcta\n");
                        break;
                }
            }
        }
    }

    private void crearListaLaberintos(){                
        Random rnd = new Random(0);
        int MAX_LABERINTOS = 10; // un numero maximo de laberintos en el juego
        int MIN_LABERINTOS = 5; // un numero minimo de laberintos en el juego
        int numeroDeLaberintos = rnd.nextInt(MAX_LABERINTOS) + MIN_LABERINTOS;
        for (int i = 0; i < numeroDeLaberintos; i++) {
            Laberinto objLab = new Laberinto();            
            objLab.laberinto = gestor.generarLaberinto(objLab.laberinto, objLab.getSize_m(), objLab.getSize_n());
            lista_laberintos.add(objLab);                        
        }
    }
    
    private void agregarAnteriorySiguiente(){
        
        int anterior,siguiente;//, cont = 0;
        int x,y;
        Random rnd = new Random();
                
        /*
        Metodo de asignacion de la celda anterior y siguiente:
        Se recorrera el laberinto, guardando las coordenadas de todas las celdas que esten
        marcadas como ADENTRO, luego generando un numero aleatorio se elegira uno de esos pares
        para anterior y otro para siguiente
        */
        
        for (Laberinto lab : lista_laberintos) {
            List<IntPair> coords = new ArrayList<>();
            // IntPair[] coords = new IntPair[ lab.getSize_m() * lab.getSize_n() / 2];
            for (int i = 1; i < lab.getSize_m(); i++) {
                for (int j = 1; j < lab.getSize_n(); j++) {
                    if (lab.getCelda(i, j).getTipo() == TipoCelda.ADENTRO) {
                        // coords[cont++] = new IntPair(i,j);
                        coords.add(new IntPair(i,j));
                        //cont++;
                    }
                }
            }

            anterior = rnd.nextInt(coords.size());
            siguiente = rnd.nextInt(coords.size());            
            
            //x = coords[anterior].x;
            //y = coords[anterior].y;            
            x = coords.get(anterior).x;
            y = coords.get(anterior).y;
            lab.getCelda(x, y).setTipoContenido(0);
            
            //x = coords[siguiente].x;
            //y = coords[siguiente].y;
            x = coords.get(siguiente).x;
            y = coords.get(siguiente).y;
            lab.getCelda(x, y).setTipoContenido(1);
        }
    }
    
    public int getLaberintoActual(){
        return this.laberintoActual;
    }
}
