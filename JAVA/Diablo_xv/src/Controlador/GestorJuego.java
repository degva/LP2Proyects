/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Avatar;
import Modelo.Laberinto;
import Modelo.IntPair;

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
        if(DesplazamientoEsValido(desplazamiento)){
            //desplazar
            
        }
        return 0;
    }
    
    private void GameOff(){
        GameON = false;
    }
    
    private boolean PosicionDisparaInteraccion(Avatar avatar, Laberinto laberinto){
        IntPair coordenadasAvatar = new IntPair(avatar.getPosX(), avatar.getPosY());
        
    }
    
    private boolean DesplazamientoEsValido(IntPair desplazamiento){
        
    }
}
