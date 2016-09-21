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
    public boolean GameON;
    
    public GestorJuego(){
        consola = new Consola();
        GameON = true;
        // controladorLaberinto = new GestorLaberinto();
    }
    
    public int Procesar(Avatar avatar, Laberinto laberinto){
        consola.MostrarMenu();
        String opcion = consola.consoleScanner.nextLine();
        
        String[] split = opcion.split(" ");
        switch (split[0]) {
            case "m":
            case "mover":
                IntPair desplazamiento = consola.ObtenerDesplazamiento(split[1]);
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
        }
        if(PosicionDisparaInteraccion(avatar, laberinto)){
            //interaccion
            return 0;
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
        ObjetoGrafico aux = celdaADesplazarse.getTipo();
        return aux instanceof Pasadizo;
    }
}
