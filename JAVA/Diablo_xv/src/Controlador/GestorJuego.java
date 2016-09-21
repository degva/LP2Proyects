/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;

/**
 *
 * @author degva
 */
public class GestorJuego {
    
    private final Consola consola;
    // private final GestorLaberinto controladorLaberinto;
    private final GestorInteraccion gestorInteraccion;
    public boolean GameON;
    
    public GestorJuego(){
        consola = new Consola();
        GameON = true;
        gestorInteraccion = new GestorInteraccion();
        // controladorLaberinto = new GestorLaberinto();
    }
    
    public int Procesar(Avatar avatar, Laberinto laberinto){
        consola.MostrarMenu();
        
        if(PosicionDisparaInteraccion(avatar, laberinto)){
            Celda celda = laberinto.getCelda(avatar.getPosX(), avatar.getPosY());
            if(celda.getContenido() instanceof Enemigo){
                consola.MostrarEnemigo(laberinto.obtenerEnemigoActual(avatar.getPosX(), avatar.getPosY()));
                gestorInteraccion.interactuarEnemigo(avatar, laberinto);
            } else if (celda.getContenido() instanceof Artefacto) {
                consola.MostrarArtefacto(laberinto.obtenerArtefactoActual(avatar.getPosX(), avatar.getPosY()));
                gestorInteraccion.interactuarArtefacto(avatar, laberinto);
            }
            return 0;
        }
        
        String opcion = consola.consoleScanner.nextLine();        
        String[] split = opcion.split(" ");
        switch (split[0]) {
            case "w":
            case "a":
            case "s":
            case "d":
                IntPair desplazamiento = consola.ObtenerDesplazamiento(split[0]);
                if(DesplazamientoEsValido(avatar, laberinto, desplazamiento)){
                    int nuevoX = avatar.getPosX() + desplazamiento.x;
                    int nuevoY = avatar.getPosY() + desplazamiento.y;
                    Celda nuevaCeldaAvatar = laberinto.getCelda(nuevoX, nuevoY);
                    avatar.Mover(desplazamiento.x, desplazamiento.y);
                    if(nuevaCeldaAvatar.getContenido() instanceof Anterior)
                        return -1;
                    else if (nuevaCeldaAvatar.getContenido() instanceof Siguiente)
                        return 1;
                }
                break;
            case "cambiar":
                break;
            case "salir":
                this.GameOff();
                break;
            default:
                return 2;
        }
        return 0;
    }
    
    private void GameOff(){
        GameON = false;
    }
    
    private boolean PosicionDisparaInteraccion(Avatar avatar, Laberinto laberinto){
        IntPair coordenadasAvatar = new IntPair(avatar.getPosX(), avatar.getPosY());
        Celda celdaAvatar = laberinto.getCelda(coordenadasAvatar.x, coordenadasAvatar.y);
        return (celdaAvatar.getContenido() instanceof Enemigo || celdaAvatar.getContenido() instanceof Artefacto);
    }
    
    private boolean DesplazamientoEsValido(Avatar avatar, Laberinto laberinto, IntPair desplazamiento){
        int nuevoX = avatar.getPosX() + desplazamiento.x;
        int nuevoY = avatar.getPosY() + desplazamiento.y;
        Celda celdaADesplazarse = laberinto.getCelda(nuevoX, nuevoY);
        ObjetoGrafico aux = celdaADesplazarse.getTipo();
        return aux instanceof Pasadizo;
    }
}
