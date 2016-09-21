/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Anterior;
import Modelo.Avatar;
import Modelo.Laberinto;
import Modelo.IntPair;
import Modelo.Celda;
import Modelo.Enemigo;
import Modelo.Pasadizo;
import Modelo.Siguiente;

/**
 *
 * @author degva
 */
public class GestorJuego {
    
    private final Consola consola;
    private final GestorLaberinto controladorLaberinto;
    public boolean GameON;
    
    public GestorJuego(){
        consola = new Consola();
        GameON = true;
        controladorLaberinto = new GestorLaberinto();
    }
    
    public int Procesar(Avatar avatar, Laberinto laberinto){
        consola.MostrarMenu();
        if(PosicionDisparaInteraccion(avatar, laberinto)){
            //interaccion
            return 0;
        }
        IntPair desplazamiento = consola.ObtenerDesplazamiento();
        if(DesplazamientoEsValido(avatar, laberinto, desplazamiento)){
            avatar.Mover(desplazamiento.x, desplazamiento.y);
            int nuevoX = avatar.getPosX() + desplazamiento.x;
            int nuevoY = avatar.getPosY() + desplazamiento.y;
            Celda nuevaCeldaAvatar = laberinto.getCelda(nuevoX, nuevoY);
            if(nuevaCeldaAvatar.getTipo() instanceof Anterior)
                return -1;
            else if (nuevaCeldaAvatar.getTipo() instanceof Siguiente)
                return 1;
        }
        return 0;
    }
    
    private void GameOff(){
        GameON = false;
    }
    
    private boolean PosicionDisparaInteraccion(Avatar avatar, Laberinto laberinto){
        IntPair coordenadasAvatar = new IntPair(avatar.getPosX(), avatar.getPosY());
        Celda celdaAvatar = laberinto.getCelda(coordenadasAvatar.x, coordenadasAvatar.y);
        return celdaAvatar.getTipo() != null;
    }
    
    private boolean DesplazamientoEsValido(Avatar avatar, Laberinto laberinto, IntPair desplazamiento){
        int nuevoX = avatar.getPosX() + desplazamiento.x;
        int nuevoY = avatar.getPosY() + desplazamiento.y;
        Celda celdaADesplazarse = laberinto.getCelda(nuevoX, nuevoY);
        return celdaADesplazarse.getTipo() instanceof Pasadizo;
    }
}
