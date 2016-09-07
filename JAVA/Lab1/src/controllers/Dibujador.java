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
        String aux = new String();
        Artefacto item;
        if (saco_aux.getSize() != 0) {
            for (int i = 0; i < saco_aux.getSize(); i++) {
                aux = Integer.toString(i) + ". ";
                item = saco_aux.getItem(i);
                aux.concat(item.toString());
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
                        default:
                            System.out.print(' ');
                            break;
                    }
                    break;
                case PARED:
                case AFUERA:
                    System.out.print('X');
                    break;
                default:
                    System.out.print("Khe? esto no deberia ejecutarse\n");
                    break;
            }
        }
    }

    public Boolean RevisarInteraccion(Avatar avatar, Laberinto lab, int x, int y) {
        Celda aux;
        aux = lab.getCelda(x, y);
        Boolean flag = false;
        switch (aux.getTipoContenido()) {
            case 2:
                if (x == avatar.getPosicionX() && y == avatar.getPosicionY())
                    flag = true;
                    RenderInteraccionEnemigo(avatar, lab, x, y);
                break;
        }
        return flag;

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
        
        System.out.print("\nEstas sobre un enemigo\n");
        System.out.print(e.toString() + "\n");
        
        System.out.print("Dime que dice > ");
        
        Scanner input = new Scanner(System.in);
        String opcion = input.nextLine();
        switch (opcion) {
            case "muere": 
                aux.setTipoContenido(-1);
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
                if (i == avatar.getPosicionY() && j == avatar.getPosicionX()) {
                    if (lab.getCelda(j, i).getTipoContenido() == 0) state = 1;
                    else if (lab.getCelda(j, i).getTipoContenido() == 1) state = -1;
                    System.out.print('A');
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
