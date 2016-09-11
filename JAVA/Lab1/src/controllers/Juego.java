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
    
    private final ArrayList<Laberinto> lista_laberintos;
    private final ArrayList<IntPair> lista_anteriores; 
    
    private final Dibujador renderer;
    private final Avatar avatar;
    private final GestorLaberinto gestor;
    private final int totalLaberintos;
    
    private int laberintoActual;
    private int laberintoAnterior;
    
    public Juego() {
        Scanner input = new Scanner(System.in);

        lista_laberintos = new ArrayList<>();
        lista_anteriores = new ArrayList<>();
        gestor = new GestorLaberinto();
        renderer = new Dibujador();
        laberintoAnterior = laberintoActual = 0;
        
        totalLaberintos = (int)(Math.random()*MAX_LABERINTOS + MIN_LABERINTOS);
        
        this.crearListaLaberintos();
        this.agregarAnteriorySiguiente();        
        this.mostrarHistoria();
        
        String nombre;
        System.out.print("Ingresa tu nombre:\n> ");
        nombre = input.nextLine();
        
        // se coloca el avatar en la celda anterior del nivel 1.
        avatar = new Avatar(lista_anteriores.get(laberintoActual).x, lista_anteriores.get(laberintoActual).y , nombre, 1);
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
            if (laberintoActual != laberintoAnterior){ //significa que acabamos de cambiar de nivel
                laberintoAnterior = laberintoActual;                
                avatar.setPosicionX(lista_anteriores.get(laberintoActual).x);
                avatar.setPosicionY(lista_anteriores.get(laberintoActual).y);                
            } else {
                lista_laberintos
                    .get(laberintoActual)
                    .getCelda(
                        lista_anteriores.get(laberintoActual).x, 
                        lista_anteriores.get(laberintoActual).y)
                    .setActivarAnterior(1);
            }

            sigAnt = renderer.Render(laberintoActual, lista_laberintos.get(laberintoActual), avatar);

            // Movemos a los enemigos de forma random
            gestor.moverEnemigos(lista_laberintos.get(laberintoActual));
            
            // en el caso que suba de nivel (al siguiente laberinto)
            if (sigAnt == 1){
                if ((laberintoActual + 1) == totalLaberintos){
                    System.out.println("FELICIDADES HAS GANADO EL JUEGO!!!!");
                    break;
                }else{
                    System.out.println("Pasando a siguiente nivel");

                    lista_laberintos
                        .get(laberintoActual)
                        .getCelda(
                            lista_anteriores.get(laberintoActual).x, 
                            lista_anteriores.get(laberintoActual).y)
                        .setActivarAnterior(0);

                    laberintoActual++;
                    continue;
                }                
            }
            
            // en el caso que baje de nivel (al laberinto anterior)
            if (sigAnt == -1 && laberintoActual != 0 &&
                    lista_laberintos
                        .get(laberintoActual)
                        .getCelda(
                                lista_anteriores.get(laberintoActual).x, 
                                lista_anteriores.get(laberintoActual).y)
                        .getActivarAnterior() == 1)
            {
                System.out.println("Pasando a nivel anterior");
                lista_laberintos
                    .get(laberintoActual)
                    .getCelda(
                            lista_anteriores.get(laberintoActual).x, 
                            lista_anteriores.get(laberintoActual).y)
                    .setActivarAnterior(0);
                laberintoActual--;
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
                Laberinto actualLaberinto = lista_laberintos.get(laberintoActual);
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
            lista_laberintos.add(objLab);                        
        }
    }
    
    /**
     * Creamos las posiciones de SIGUIENTE y ANTERIOR dentro de algunas casillas
     * random.
     */
    private void agregarAnterior(){
        
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
            ArrayList<IntPair> coords = new ArrayList<>();
            for (int i = 1; i < lab.getSize_m(); i++) {
                for (int j = 1; j < lab.getSize_n(); j++) {
                    if (lab.getCelda(i, j).getTipo() == TipoCelda.ADENTRO) {
                        coords.add(new IntPair(i,j));
                    }
                }
            }

            anterior = rnd.nextInt(coords.size());
            siguiente = rnd.nextInt(coords.size());            

            x = coords.get(anterior).x;
            y = coords.get(anterior).y;
            lab.getCelda(x, y).setTipoContenido(0);
            lista_anteriores.add(coords.get(siguiente));

            x = coords.get(siguiente).x;
            y = coords.get(siguiente).y;
            lab.getCelda(x, y).setTipoContenido(1);
        }
    }
    
    /**
     * @return laberintoActual
     */
    public int getLaberintoActual(){
        return this.laberintoActual;
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
    
}
