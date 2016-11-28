
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
        vidaA = a.GetVidaActual() - e.GetAtaque();
        vidaE = e.GetVidaActual() - a.ArmaActual().GetMaxDamage();
        a.SetVidaActual(vidaA);
        e.SetVidaActual(vidaE);
    }
    
    public void interactuarArtefacto(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        Artefacto ar = l.obtenerArtefactoActual(coordenadaInteraccion.x, coordenadaInteraccion.y);
        _gestorAvatar.RecogerArtefacto(a, ar);
    }
    
    public String interactuarAliado(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        Aliado al = l.GetAliado();
        String consejo = al.darConsejo();
        return consejo;
        
        //System.out.println("=====================================================\n\n");
        //System.out.println("Hola, soy tu aliado y este es mi consejo: " + consejo + "\n\n");
        //System.out.println("=====================================================\n\n");
    }    
}
