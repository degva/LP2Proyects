/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Facilidades.Aliado;
import Modelo.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author degva
 */
public class GestorJuego {
    
    // private final GestorLaberinto controladorLaberinto;
    private final GestorInteraccion gestorInteraccion;
    public boolean GameON;
    private final Avatar avatar;
    
    public GestorJuego(Avatar a){
        GameON = true;
        gestorInteraccion = new GestorInteraccion();
        avatar = a;
    }
    
    public void Procesar(int keyCode){
//        switch (opcion[0]) {
//            case "w":
//            case "a":
//            case "s":
//            case "d":
//                IntPair desplazamiento = DesplazamientoByComando(opcion[0]);
//                if(DesplazamientoEsValido(avatar, laberinto, desplazamiento)){
//                    int nuevoX = avatar.getPosX() + desplazamiento.x;
//                    int nuevoY = avatar.getPosY() + desplazamiento.y;
//                    Celda nuevaCeldaAvatar = laberinto.getCelda(nuevoX, nuevoY);
//                    avatar.Mover(desplazamiento.x, desplazamiento.y);
//                    consola.ClearLog();
//                    if(nuevaCeldaAvatar.getContenido() instanceof Anterior)
//                        return -1;
//                    else if (nuevaCeldaAvatar.getContenido() instanceof Siguiente)
//                        return 1;
//                } else{
//                    consola.SetLog("¡Movimiento invalido!");
//                    return 0;
//                }
//                break;
//            case "interactuar":
//                Interactuar(opcion[1], avatar, laberinto);
//                break;
//            case "salir":
//                this.GameOff();
//                break;
//            default:
//                return 0;
//        }
//        return 0;
        switch (keyCode){
            case 87:
            case 104:
                avatar.Mover(0, -1);
                break;
            case 68:
            case 102:
                avatar.Mover(1, 0);
                break;
            case 65:
            case 100:
                avatar.Mover(-1, 0);
                break;
            case 83:
            case 98:
                avatar.Mover(0, 1);
                break;
        }
    }
    
    private void GameOff(){
        GameON = false;
    }
    
//    private boolean PosicionDisparaInteraccion(Avatar avatar, Laberinto laberinto){
//        IntPair coordenadasAvatar = new IntPair(avatar.getPosX(), avatar.getPosY());
//        Celda celdaAvatar = laberinto.getCelda(coordenadasAvatar.x, coordenadasAvatar.y);
//        return (celdaAvatar.getContenido() instanceof Enemigo || celdaAvatar.getContenido() instanceof Artefacto);
//    }
    
    // Funcion para obtener un par ordenado de desplazamiento en base a una dirección especificada
    private IntPair DesplazamientoByComando(String direccion){
        IntPair desplazamiento;
        switch(direccion){
            case "w":
            case "arriba":
                desplazamiento = new IntPair(0, -1);
                break;
            case "a":
            case "izquierda":
                desplazamiento = new IntPair(-1, 0);
                break;
            case "s":
            case "abajo":
                desplazamiento = new IntPair(0, 1);
                break;
            case "d":
            case "derecha":
                desplazamiento = new IntPair(1, 0);
                break;
            default:
                desplazamiento = new IntPair(0, 0);
        }
        return desplazamiento;
    }
    
    private boolean DesplazamientoEsValido(Avatar avatar, Laberinto laberinto, IntPair desplazamiento){
        int nuevoX = avatar.getPosX() + desplazamiento.x;
        int nuevoY = avatar.getPosY() + desplazamiento.y;
        Celda celdaADesplazarse = laberinto.getCelda(nuevoX, nuevoY);
        Sprite aux = celdaADesplazarse.getTipo();
        return ((aux instanceof Pasadizo) && !(celdaADesplazarse.getContenido() instanceof Enemigo));
    }
    
    // Metodo para efectuar la interacción con el objeto en la dirección especificada
    // Si dirección = "", se hace la interacción con el objeto que está en la misma celda que el avatar. (DEPRECATED)
    private void Interactuar(String direccion, Avatar avatar, Laberinto laberinto){        
        IntPair desplazamiento = DesplazamientoByComando(direccion);
        IntPair coordenadaInteraccion = new IntPair(avatar.getPosX()+desplazamiento.x, avatar.getPosY()+desplazamiento.y);
        Sprite objetoInteraccion = laberinto.getContenidoCelda(coordenadaInteraccion.x, coordenadaInteraccion.y);        
        // Revisamos el tipo de interaccion que corresponde
        if(objetoInteraccion instanceof Enemigo){
            //Se inicia una batalla
            gestorInteraccion.interactuarEnemigo(avatar, laberinto, coordenadaInteraccion);
        } else if (objetoInteraccion instanceof Artefacto){
            gestorInteraccion.interactuarArtefacto(avatar, laberinto, coordenadaInteraccion);
        }else if (objetoInteraccion instanceof Aliado){
            gestorInteraccion.interactuarAliado(avatar, laberinto, coordenadaInteraccion);
        }else{
            //consola.SetLog("Aqui no hay nada para interactuar");
        }
    }
    
}
