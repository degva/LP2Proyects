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
    public static final int NRO_ARTEFACTOS= 10;
    
    private ArrayList<Laberinto> lista_laberintos;
    private ArrayList<IntPair> lista_anteriores; 
    
    private Dibujador renderer;
    private Avatar avatar;
    private GestorLaberinto gestor;
    private int laberintoActual;
    private int totalLaberintos=0;

    public Juego() {
        Scanner input = new Scanner(System.in);
        lista_laberintos = new ArrayList<>();
        lista_anteriores = new ArrayList<>();
        gestor = new GestorLaberinto();
        renderer = new Dibujador();
        laberintoActual = 0;
        
        this.crearListaLaberintos(); // dentro de esto esta el crear listas
        this.agregarAnteriorySiguiente();
        //para poder colocar el avatar en el mapa en la casilla anterior :p
        //this.agregarAnteriorySiguienteyColocarAvatar();
        
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
        
        avatar = new Avatar(lista_anteriores.get(laberintoActual).x, lista_anteriores.get(laberintoActual).y , nombre, 1);
        // estoy poniendo al avatar en la esquinita superior izquierda por mientras xd
    }
    
    
    // papus aqui va el bucle xd pero falta definir la lista de los laberintos y otras cosas
    public void Start() {
        //renderer.Render(laberinto);
        Scanner input = new Scanner(System.in);
        int sigAnt;
        String opcion;
        int laberintoAnterior = 0;
        OUTER:
        while (true) {
            clearScreen();    
            if (laberintoActual != laberintoAnterior){ //significa que acabamos de cambiar de nivel
                laberintoAnterior = laberintoActual;                
                avatar.setPosicionX(lista_anteriores.get(laberintoActual).x);
                avatar.setPosicionY(lista_anteriores.get(laberintoActual).y);                
            }else{
                lista_laberintos.get(laberintoActual).getCelda(lista_anteriores.get(laberintoActual).x, 
                        lista_anteriores.get(laberintoActual).y).setActivarAnterior(1);
            }
            
            System.out.println("LaberintoActual = " + laberintoActual);
            /*AQUI SE IMPRIME EL LABERINTO*/
            sigAnt = renderer.Render(laberintoActual, lista_laberintos.get(laberintoActual), avatar);
            
            if (sigAnt == 1){
                if ((laberintoActual + 1) == totalLaberintos){
                    System.out.println("FELICIDADES HAS GANADO EL JUEGO!!!!");
                    break;
                }else{
                    System.out.println("Pasando a siguiente nivel");
                    lista_laberintos.get(laberintoActual).getCelda(lista_anteriores.get(laberintoActual).x, 
                            lista_anteriores.get(laberintoActual).y).setActivarAnterior(0);
                    laberintoActual++;
                    // cuando se va a otro laberinto usualmente se loquea y se pone sobre un muro :v
                    avatar.setPosicionX(1);
                    avatar.setPosicionY(1);
                    continue;
                }                
            }
            if (sigAnt == -1 && laberintoActual != 0 &&
                    lista_laberintos.get(laberintoActual).getCelda(lista_anteriores.get(laberintoActual).x, lista_anteriores.get(laberintoActual).y).getActivarAnterior() == 1){
                System.out.println("Pasando a nivel anterior");
                lista_laberintos.get(laberintoActual).getCelda(lista_anteriores.get(laberintoActual).x, lista_anteriores.get(laberintoActual).y).setActivarAnterior(0);
                laberintoActual--;
                // cuando se va a otro laberinto usualmente se loquea y se pone sobre un muro :v
                continue;
            }
            
            System.out.print("\n\n");
            System.out.print("Escriba una accion:\n" );
            System.out.print("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):\n" );
            System.out.print("> [interactuar]\n" );
            /*para implementar estos 2, nececito que se cree la lista de artefactos*/
            System.out.println("> [cambiar arma]");
            System.out.println("> [cambiar armadura]");
            System.out.print("> [salir]\n\n - > " );
            opcion = input.nextLine();

            if (null != opcion) {
                /*Los else son solo para porbar que la funcionalidad trabaja bien*/
                int posicionActualX = avatar.getPosicionX();
                int posicionActualY = avatar.getPosicionY();
                Laberinto actualLaberinto = lista_laberintos.get(laberintoActual);
                switch (opcion) {
                    case "w"://"mover arriba":
                    case "mover arriba":
                        if(validarMovimiento(actualLaberinto,posicionActualX,(posicionActualY-1)))
                            avatar.moveUp();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "s"://"mover abajo":
                    case "mover abajo":
                        if(validarMovimiento(actualLaberinto,posicionActualX,(posicionActualY+1)))
                            avatar.moveDown();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "a"://"mover izquierda":
                    case "mover izquierda":
                        if(validarMovimiento(actualLaberinto,(posicionActualX-1),posicionActualY))
                            avatar.moveLeft();
                        else System.out.println("\n NO TE PUEDES MOVER AHI \n");
                        break;
                    case "d"://"mover derecha":
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
                        
                        break;
                    case "cambiar armadura":
                        
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
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    private void crearListaLaberintos(){                
        Random rnd = new Random(0);
        int MAX_LABERINTOS = 10; // un numero maximo de laberintos en el juego
        int MIN_LABERINTOS = 5; // un numero minimo de laberintos en el juego
        totalLaberintos = (int)(Math.random()*MAX_LABERINTOS + MIN_LABERINTOS);
        for (int i = 0; i < totalLaberintos; i++) {
            Laberinto objLab = new Laberinto();            
            //objLab = gestor.generarLaberinto(objLab, objLab.getSize_m(), objLab.getSize_n());
            gestor.generarLaberinto(objLab, objLab.getSize_m(), objLab.getSize_n());
            // crearListaEnemigos(objLab);
            // crearListaArtefactos(objLab);
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
            ArrayList<IntPair> coords = new ArrayList<>();
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
            lista_anteriores.add(coords.get(siguiente));
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
    
    private boolean validarMovimiento (Laberinto l,int x, int y){
        // return (l.laberinto[x][y].getTipo() != TipoCelda.PARED && l.laberinto[x][y].getTipoContenido() != 2);
        return (l.laberinto[x][y].getTipo() != TipoCelda.PARED);
    }
    
}
