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
    // Creacion de constantes
    public static final int NRO_ARTEFACTOS = 10;
    public static final int MAX_LABERINTOS = 10;
    public static final int MIN_LABERINTOS = 5;
    
    private final ArrayList<Laberinto> laberintos;
    
    private final Dibujador renderer;
    private final Avatar avatar;
    private final GestorLaberinto gestor;
    private final int totalLaberintos;
    
    private Laberinto laberintoActual;
    private int indexLaberintoActual;
    private int indexLaberintoAnterior;
    
    public Juego() {                
        //Inicializar propiedades
        laberintos = new ArrayList<>();
        gestor = new GestorLaberinto();
        renderer = new Dibujador();
        indexLaberintoAnterior = indexLaberintoActual = 0;
        
        totalLaberintos = (int)(Math.random()*MAX_LABERINTOS + MIN_LABERINTOS);
        
        this.crearListaLaberintos();
        this.setLaberintoActual(indexLaberintoActual);        
        this.mostrarHistoria();
        
        String nombre;        
        System.out.print("Ingresa tu nombre:\n> ");
        Scanner input = new Scanner(System.in);
        nombre = input.nextLine();
        
        // se coloca el avatar en la celda anterior del nivel 1.
        int x_ant = laberintos.get(indexLaberintoActual).celdaAnterior.getX();
        int y_ant = laberintos.get(indexLaberintoActual).celdaAnterior.getY(); 
        avatar = new Avatar(x_ant, y_ant, nombre, 1);
    }
    
    /**
     * Bucle principal del juego
     */
    public void Start() {
        Scanner input = new Scanner(System.in);
        String opcion;
        
        int sigAnt;
        
        OUTER:
        while (true) {
            CLS.clearConsole();
            if (indexLaberintoActual != indexLaberintoAnterior){ //significa que acabamos de cambiar de nivel
                indexLaberintoAnterior = indexLaberintoActual;
                setLaberintoActual(indexLaberintoActual);                
                avatar.setPosicionX(laberintoActual.celdaAnterior.getX());
                avatar.setPosicionY(laberintoActual.celdaAnterior.getY());                
            } else {
                laberintoActual.celdaAnterior.setActivarAnterior(1);
            }

            sigAnt = renderer.Render(indexLaberintoActual, laberintoActual, avatar);

            // Movemos a los enemigos de forma random
            gestor.moverEnemigos(laberintos.get(indexLaberintoActual));
            
            // en el caso que suba de nivel (al siguiente laberinto)
            if (sigAnt == 1){
                if ((indexLaberintoActual + 1) == totalLaberintos){
                    System.out.println("FELICIDADES HAS GANADO EL JUEGO!!!!");
                    break;
                }else{
                    System.out.println("Pasando a siguiente nivel");
                    laberintoActual.celdaAnterior.setActivarAnterior(0);
                    indexLaberintoActual++;
                    continue;
                }                
            }
            
            // en el caso que baje de nivel (al laberinto anterior)
            if (sigAnt == -1 && indexLaberintoActual != 0 &&
                    laberintoActual.celdaAnterior.getActivarAnterior() == 1)
            {
                System.out.println("Pasando a nivel anterior");
                laberintoActual.celdaAnterior.setActivarAnterior(0);
                indexLaberintoActual--;
                continue;
            }
            
            System.out.println("\n");
            System.out.println("Escriba una accion:");
            System.out.println("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):" );
            System.out.println("> [interactuar]");

            /*para implementar estos 2, nececito que se cree la lista de artefactos*/
            System.out.println("> [cambiar arma]");
            System.out.println("> [cambiar armadura]");

            System.out.print("> [salir]\n\n - > " );
            
            opcion = input.nextLine();

            if (null != opcion) {
                // Los else son solo para probar que la funcionalidad trabaja bien
                int posicionActualX = avatar.getPosicionX();
                int posicionActualY = avatar.getPosicionY();
                Laberinto actualLaberinto = laberintos.get(indexLaberintoActual);
                switch (opcion) {
                    case "w":
                    case "mover arriba":
                        if(validarMovimiento(actualLaberinto,posicionActualX,(posicionActualY-1)))
                            avatar.moveUp();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "s":
                    case "mover abajo":
                        if(validarMovimiento(actualLaberinto,posicionActualX,(posicionActualY+1)))
                            avatar.moveDown();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "a":
                    case "mover izquierda":
                        if(validarMovimiento(actualLaberinto,(posicionActualX-1),posicionActualY))
                            avatar.moveLeft();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "d":
                    case "mover derecha":
                        if(validarMovimiento(actualLaberinto,(posicionActualX+1),posicionActualY))
                            avatar.moveRight();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "interactuar":
                        //aqui se debe verificar si en las celdas adyacentes se
                        //encuentra algun artefacto
                        //if (alguna celda adyacente al avatar tiene un artefacto)
                        // agregar artefacto al saco
                        break;
                    case "cambiar arma":
                        // Por implementar
                        break;
                    case "cambiar armadura":
                        // Por implementar
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

    /**
     * Crea la lista de laberintos para el Juego
     */
    private void crearListaLaberintos(){                
        for (int i = 0; i < totalLaberintos; i++) {
            Laberinto objLab = new Laberinto();            
            gestor.generarLaberinto(objLab, objLab.getSize_m(), objLab.getSize_n());
            laberintos.add(objLab);                        
        }
    }
    
    /**
     * @return indexLaberintoActual
     */
    public int getindexLaberintoActual(){
        return this.indexLaberintoActual;
    }
    
    /**
     * Valida si el avatar puede o no moverse entre paredes.
     * @param l
     * @param x
     * @param y
     * @return  boolean
     */
    private boolean validarMovimiento (Laberinto l,int x, int y){
        return (l.laberinto[x][y].getTipo() != TipoCelda.PARED);
    }
    
    private void mostrarHistoria(){
        
    }

    /**
     */
    public void setLaberintoActual(int index) {
        this.laberintoActual = laberintos.get(index);
    }
    
}
