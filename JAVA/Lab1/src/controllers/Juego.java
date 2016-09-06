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
    private ArrayList<Enemigo> lista_enemigos; // para el laberinto actual
    private ArrayList<Artefacto> lista_artefactos; // para el laberinto actual
    
    
    private Dibujador renderer;
    private Avatar avatar;
    private GestorLaberinto gestor;
    private int laberintoActual;
    private int totalLaberintos=0;

 
    public Juego() {
        Scanner input = new Scanner(System.in);
        
        lista_laberintos = new ArrayList<>();
        lista_enemigos = new ArrayList<>();
        lista_artefactos = new ArrayList<>();
        //hey, aqui hay que tener cuidado, porque la lista de enemigos y artefactos creada es
        //para cada laberinto, asi que a la hora de pasar de un laberinto a otro
        //se deberian eliminar los elementos de la lista anterior y generar nuevas
        //lista
        
        
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
        avatar = new Avatar(1,1,nombre,1);
        // el avatar inicia en la celda anterior del nivel 1,
        // por lo cual creo que en la clase laberinto deberiamos tener como atributo
        // las posiciones del ANTERIOR y SIGUIENTE, sino no sé como hariamos
        // para pasar de un nivel a otro tambien :'
        // ^ this
        
        
        // aqui el avatar deberia estar en la casilla anterior xdxd
    }
    
    
    // papus aqui va el bucle xd pero falta definir la lista de los laberintos y otras cosas
    public void Start() {
        //renderer.Render(laberinto);
        Scanner input = new Scanner(System.in);
        int sigAnt;
        String opcion;
        OUTER:
        while (true) {
            clearScreen();            
            sigAnt = renderer.Render(laberintoActual, lista_laberintos.get(laberintoActual), avatar);
            
            if (sigAnt == 1){
                if (laberintoActual == totalLaberintos){
                    System.out.println("FELICIDADES HAS GANADO EL JUEGO!!!!");
                    break;
                }else{
                    laberintoActual++;
                    // cuando se va a otro laberinto usualmente se loquea y se pone sobre un muro :v
                    avatar.setPosicionX(1);
                    avatar.setPosicionY(1);
                    continue;
                }                
            }
            else if (sigAnt == -1 && laberintoActual != 0){
                laberintoActual--;
                // cuando se va a otro laberinto usualmente se loquea y se pone sobre un muro :v
                avatar.setPosicionX(1);
                avatar.setPosicionY(1);
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
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "s"://"mover abajo":
                    case "mover abajo":
                        if(validarMovimiento(actualLaberinto,posicionActualX,(posicionActualY+1)))
                            avatar.moveDown();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "a"://"mover izquierda":
                    case "mover izquierda":
                        if(validarMovimiento(actualLaberinto,(posicionActualX-1),posicionActualY))
                            avatar.moveLeft();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
                        break;
                    case "d"://"mover derecha":
                    case "mover derecha":
                        if(validarMovimiento(actualLaberinto,(posicionActualX+1),posicionActualY))
                            avatar.moveRight();
                        else System.out.println("\n NO TE PUEDES MOVER AHI, QUE TE PASA\n");
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
            objLab.laberinto = gestor.generarLaberinto(objLab.laberinto, objLab.getSize_m(), objLab.getSize_n());
            crearListaEnemigos(objLab);
            crearListaArtefactos(objLab);
            lista_laberintos.add(objLab);                        
        }
        
      
    }
    
    private void crearListaEnemigos(Laberinto l){
        Random rnd = new Random();
        int max_i = l.getSize_m();
        int max_j = l.getSize_n();
        // hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        // le puse entre 20 porque sino salen demasiados creo :'v 
        //la formula puede ir cambiando
        int nroEnemigos = Math.round((l.getPct_enemigo()* max_i * max_j)/20);
        int ene_i, ene_j;
        int niveles_Enemigo[] = l.getNiveles_enemigo();
        for(int i=0; i< nroEnemigos; i++){
            //voy a considerar que los enemigos aparezcan en los nodos (impares)xd
            //porque sino tendria que estar probando para cada celda que no 
            //sea una pared
            ene_i = (rnd.nextInt(max_i/2)*2 +1);
            ene_j = (rnd.nextInt(max_j/2)*2 +1);
            Enemigo e = new Enemigo (ene_i,ene_j, "Enemigo",niveles_Enemigo[rnd.nextInt(max_i)]);
            this.agregarEnemigo(e);
            l.getCelda(ene_i, ene_j).setTipoContenido(2);
        }
        
    }
    
    private void crearListaArtefactos(Laberinto l){
        //Random rnd = new Random();
        //int art_i, art_j;
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares pls :'
            //art_i = (rnd.nextInt(max_i/2)*2 +1);
            //art_j = (rnd.nextInt(max_j/2)*2 +1);
            Artefacto a = new Artefacto ("Artefacto");
            this.agregarArtefacto(a);
            //l.getCelda(ene_i, ene_j).setTipoContenido(3);
            // -> aqui faltaria asociar la clase artefacto con su posicion en el
            // -> mapa
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
    private void agregarEnemigo(Enemigo e){
        this.lista_enemigos.add(e);
    }
    
    private void agregarArtefacto(Artefacto a){
        this.lista_artefactos.add(a);
    }
    
    private boolean validarMovimiento (Laberinto l,int x, int y){
        return (l.laberinto[x][y].getTipo() != TipoCelda.PARED && l.laberinto[x][y].getTipoContenido() != 2);            
    }
    
}
