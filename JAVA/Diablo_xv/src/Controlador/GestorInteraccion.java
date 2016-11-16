
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Facilidades.Aliado;
import Modelo.*;
import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class GestorInteraccion {
    
    private GestorAvatar _gestorAvatar;
    
    public GestorInteraccion(){


        _gestorAvatar = new GestorAvatar();


    }
    
    
    
    public void interactuarEnemigo(Avatar a, Enemigo e){
        int vidaA, vidaE;
        if (e.getVidaActual() > 0) {
            vidaA = a.getVidaActual() - e.getAtaque();
            vidaE = e.getVidaActual() - a.getArmaActual().getDano_max();
            a.setVidaActual(vidaA);
            e.setVidaActual(vidaE);
        }
        
       
    }
    
    public void interactuarArtefacto(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        Artefacto ar = l.obtenerArtefactoActual(coordenadaInteraccion.x, coordenadaInteraccion.y);
        _gestorAvatar.RecogerArtefacto(a, ar);
    }
    
    public String interactuarAliado(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        Aliado al = l.obtenerAliado();
        String consejo = al.darConsejo();
        return consejo;
    }    
}
