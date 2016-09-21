/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAVID
 */
public class GestorInteraccion {
    
    private GestorAvatar _gestorAvatar;
    public GestorInteraccion(){
        this._gestorAvatar = new GestorAvatar();
    }
    
    public void interactuarEnemigo(Avatar a, Laberinto l){
        //gg wp
        int vidaA, vidaE;
        Enemigo e = l.obtenerEnemigoActual(a.getPosX(), a.getPosY());
        vidaA = a.getVidaActual() - e.getAtaque();
        vidaE = e.getVidaActual() -  5; //a.getArmaActual().getDano_max();
        a.setVidaActual(vidaA);
        e.setVidaActual(vidaE);
        l.retornarEnemigoActual(e);
        
    }
    
    public void interactuarArtefacto(Avatar a, Laberinto l){
        Artefacto ar = l.obtenerArtefactoActual(a.getPosX(), a.getPosY());
        _gestorAvatar.RecogerArtefacto(a, ar);
    }
    
}
