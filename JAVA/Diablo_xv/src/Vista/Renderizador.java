package Vista;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import Controlador.*;

/**
 *
 * @author fabricioandres
 */
public class Renderizador {
    
    // Algunas constantes
    private static final int ANCHO = 6;
    private static final int ALTO = 6;
    private int map_width = 0;
    
    public Renderizador() {
        map_width = ANCHO*2 + 2;
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
        ObjetoGrafico tipo, contenido;
        if (x<0 || y<0) {
            System.out.print('.');
        }else if ((x > lab.getSizeM()-1) || (y > lab.getSizeN()-1)){
            System.out.print('.');
        } else {
            aux = lab.getCelda(x, y);
            tipo = aux.getTipo();
            contenido = aux.getContenido();
            if (tipo instanceof Pasadizo){
                if(contenido instanceof Enemigo)
                    contenido.Dibujar();
                else if (contenido instanceof Artefacto)
                    contenido.Dibujar();
                else if (contenido instanceof Anterior)
                    contenido.Dibujar();
                else if (contenido instanceof Siguiente)
                    contenido.Dibujar();
            }else if(tipo instanceof Pared)
                tipo.Dibujar();
            
        }
    }

    public Boolean RevisarInteraccion(Avatar avatar, Laberinto lab, int x, int y) {
        Celda aux;
        aux = lab.getCelda(x, y);
        Boolean flag = false;
        if (aux.getContenido() instanceof Enemigo) {            
                if (x == avatar.getPosX() && y == avatar.getPosY())
                    flag = true;
                    //RenderInteraccionEnemigo(avatar, lab, x, y);
        }else if(aux.getContenido() instanceof Artefacto){
                if (x == avatar.getPosX() && y == avatar.getPosY())
                    flag = true;
                    //RenderInteraccionArtefacto(avatar, lab, x, y);
        }
        return flag;

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
        System.out.println("## NIVEL " + (nivel+1) + " " + lab.getSizeM() + "-" + lab.getSizeN());
        
        // Imprimir
        OUTER:
        for (int i = avatar.getPosY() - ALTO; i <= avatar.getPosY() + ALTO; i++) {
            for (int j = avatar.getPosX() - ANCHO; j <= avatar.getPosX() + ANCHO; j++) {
                if (i == avatar.getPosY() && j == avatar.getPosX()) { //si es la posicion en la que esta el avatar
                    if (lab.getCelda(j, i).getContenido() instanceof Anterior) state = 1;
                    else if (lab.getCelda(j, i).getContenido() instanceof Siguiente) state = -1;
                    avatar.Dibujar();
                    if (RevisarInteraccion(avatar, lab, j, i)) break OUTER;//||||||||||||||||||||||||||||||||||||| INTERACCION ||||||||||||||||||||||||||||||||||||||
                } else {
                    RenderCell(avatar, lab, j, i);
                }
            }
            if (listaDatos.size() > (i + ALTO - avatar.getPosY())) {
                System.out.print(' ');
                System.out.print(listaDatos.get(i + ALTO - avatar.getPosY()));
            }
            
            System.out.print('\n');
        }
        return state;
    }
    
}
