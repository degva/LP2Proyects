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
import java.util.Scanner;

/**
 *
 * @author degva
 */
public class Dibujador {
    
    // Algunas constantes
    private static final int A = 6;
    private static final int B = 6;
    private int map_width = 0;
    
    public Dibujador() {
        map_width = A*2 + 2;
    }
    
    /*
    TODO: 
        - Avatar: getNombre, getSaco()
        - Artefacto: toString() (?)
    */
    
    public List<String> ObtenerListaDatos(Avatar avatar) {
        List<String> datos = new ArrayList<>();
        datos.add("Nombre: " + avatar.getNombre());
        String vida = Integer.toString(avatar.getVidaActual()) + "/" + Integer.toString(avatar.getVidaMaxima());
        datos.add("Vida: " + vida);
        //datos.add("Arma: " + avatar.getArmaActual().toString());
        //datos.add("Armadura: " + avatar.getArmaduraActual().toString());
        datos.add("Cosillas: ");
        Saco saco_aux = avatar.getSaco();
        String aux;
        Artefacto item;
        if (saco_aux.getSize() != 0) {
            for (int i = 0; i < saco_aux.getSize(); i++) {
                aux = Integer.toString(i + 1) + ". ";
                item = saco_aux.getItem(i);
                // aux.concat(item.getNombre());
                String aux2 = item.toString();
                String aux3 = aux.concat(aux2);
                datos.add(aux3);
            }
        } else {
            datos.add("No tienes cosillas\t");
        }
        return datos;
    }
    
    /**
     * Renderiza solo una celda
     * @param avatar
     * @param lab
     * @param x
     * @param y 
     */
    public void RenderCell(Avatar avatar, Laberinto lab, int x, int y) {
        Celda aux;

        if (x<0 || y<0) {
            System.out.print('.');
        }else if ((x > lab.getSize_m()-1) || (y > lab.getSize_n()-1)){
            System.out.print('.');
        } else {
            aux = lab.getCelda(x, y);
            switch (aux.getTipo()) {
                case ADENTRO:                    
                    switch (aux.getTipoContenido()) {
                        case 0:
                            System.out.print('+');
                            break;
                        case 1:
                            System.out.print('-');
                            break;
                        case 2:
                            System.out.print('E');
                            break;
                        case 3:
                            System.out.print('A');
                            break;
                        default:
                            System.out.print(' ');
                            break;
                    }
                    break;
                case PARED:
                case AFUERA:
                    System.out.print('#');
                    break;
                default:
                    System.out.print("Que? esto no deberia ejecutarse\n");
                    break;
            }
        }
    }

    public Boolean RevisarInteraccion(Avatar avatar, Laberinto lab, int x, int y) {
        Celda aux;
        aux = lab.getCelda(x, y);
        Boolean flag = false;
        switch (aux.getTipoContenido()) {
            case 2: //es un enemigo
                if (x == avatar.getPosicionX() && y == avatar.getPosicionY())
                    flag = true;
                    RenderInteraccionEnemigo(avatar, lab, x, y);
                break;
            case 3: //es un artefacto
                if (x == avatar.getPosicionX() && y == avatar.getPosicionY())
                    flag = true;
                    RenderInteraccionArtefacto(avatar, lab, x, y);
                break;
        }
        return flag;

    }
    
    // PREG_2:
    // Se imprime una lista de opciones cuando el avatar esta sobre un artefacto
    // o sobre un Enemigo. Luego se llaman a las funciones correspondientes.
    
    public void RenderInteraccionArtefacto (Avatar avatar, Laberinto lab, int x, int y) {
        clearScreen();
        Celda aux;
        aux = lab.getCelda(x, y);
        
        // buscamos al artefacto
        ArrayList<Artefacto> lista_artefactos = lab.getLista_artefactos();
        Artefacto a = lista_artefactos.get(0); 
        for (int i = 0; i < lista_artefactos.size(); i++) {
            a = lista_artefactos.get(i);
            if (a.getPosicionX() == x && a.getPosicionY() == y)
                break;
        }
        
        //Cuando sale del for, es porque a ya tiene como valor el artefacto en el que vamos a interactuar
        System.out.println("\nEstas sobre un artefacto");
        System.out.println("Puedes:");
        System.out.println("[recoger]");
        System.out.println("[obviar]");
        
        System.out.print("Dime que dice > ");
        
        Scanner input = new Scanner(System.in);
        String opcion = input.nextLine();
        switch (opcion) {
            case "recoger": 
                aux.setTipoContenido(-1);
                avatar.recogerArtefacto(a);
                break;
            default:
                aux.setTipoContenido(-1);
                break;
        }
    
    }
    
    public void RenderInteraccionEnemigo (Avatar avatar, Laberinto lab, int x, int y) {
        clearScreen();
        Celda aux;
        aux = lab.getCelda(x, y);
        
        // buscamos al enemigo
        ArrayList<Enemigo> lista_enemigos = lab.getLista_enemigos();
        // esto deberia ser modificado mas abajo...
        Enemigo e = lista_enemigos.get(0); 
        for (int i = 0; i < lista_enemigos.size(); i++) {
            e = lista_enemigos.get(i);
            if (e.getPosicionX() == x && e.getPosicionY() == y)
                break;
        }
        System.out.print("\n\n\n\n\n\n");
        System.out.println("---------------------------");
        System.out.println("\nEstas sobre un enemigo:");
        System.out.println("Se llama: " + e.getNombre());
        System.out.println("Ataque: " + e.getNivel() * 2);
        System.out.println("Vida: " + e.getVidaActual() + "/" + e.getVidaMaxima());
        System.out.println("Puedes:");
        System.out.println("[atacar]");
        System.out.println("[pirar]");
        // System.out.print(e.toString() + "\n");
        
        System.out.print("Dime que dice > ");
        
        Scanner input = new Scanner(System.in);
        String opcion = input.nextLine();
        switch (opcion) {
            case "atacar": 
                
                avatar.atacarEnemigo(e);
                System.out.println("Te quedaste con " + avatar.getVidaActual() + " de vida");
                System.out.println("El enemigo quedo con " + e.getVidaActual() + " de vida");
                // PREG_2
                // Al atacar vemos si la vida es menor/igual que 0. Entonces se
                // procede a eliminar a el Enemigo.
                if (e.getVidaActual() <= 0) {
                    aux.setTipoContenido(-1);
                } else {
                    // movemos al avatar a la derecha (esperemos que no toque pared)
                    avatar.moveRight();
                    avatar.moveRight();
                }
                break;
            case "pirar": 
                // aux.setTipoContenido(-1);
                // avatar.atacarEnemigo(e);
                avatar.moveRight();
                avatar.moveRight();
                break;
            default:
                aux.setTipoContenido(-1);
                break;
        }
        // que haya interaccion :v
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    /**
     * 
     * Muestra: nombre, vida, arma, armadura y elementos que tiene el saco (con
     * indice diferenciado.
     * Ademas: muestra en que laberinto esta.
     * @param nivel
     * @param lab
     * @param avatar
     * @return -1 si avatar esta en ANTERIOR, 1 si avatar esta en SIGUIENTE, si no return = 0
     */
    public int Render(int nivel, Laberinto lab, Avatar avatar) {        
        List<String> listaDatos = ObtenerListaDatos(avatar);
        // List<Enemigo> listaEnemigos = lab.getEnemigos();
        int state = 0;
        // imprimimos el nivel del mapa
        System.out.println("## NIVEL " + (nivel+1) + " " + lab.getSize_m() + "-" + lab.getSize_n());
        
        // Imprimir
        OUTER:
        for (int i = avatar.getPosicionY() - B; i <= avatar.getPosicionY() + B; i++) {
            for (int j = avatar.getPosicionX() - A; j <= avatar.getPosicionX() + A; j++) {
                if (i == avatar.getPosicionY() && j == avatar.getPosicionX()) { //si es la posicion en la que esta el avatar
                    if (lab.getCelda(j, i).getTipoContenido() == 0) state = 1;
                    else if (lab.getCelda(j, i).getTipoContenido() == 1) state = -1;
                    System.out.print('O');
                    if (RevisarInteraccion(avatar, lab, j, i)) break OUTER;//||||||||||||||||||||||||||||||||||||| INTERACCION ||||||||||||||||||||||||||||||||||||||
                } else {
                    RenderCell(avatar, lab, j, i);
                }
            }
            if (listaDatos.size() > (i + B - avatar.getPosicionY())) {
                System.out.print(' ');
                System.out.print(listaDatos.get(i + B - avatar.getPosicionY()));
            }
            
            System.out.print('\n');
        }
        return state;
    }
}
