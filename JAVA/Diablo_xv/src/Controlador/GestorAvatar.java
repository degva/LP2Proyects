/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;

/**
 *
 * @author fabricioandres
 */
public class GestorAvatar {
    
    public GestorAvatar() {
    }
    
    public Avatar RecogerArtefacto(Avatar avatar, Artefacto newArtefacto){
        avatar.getSaco().agregarArtefacto(newArtefacto);
        return avatar;
    }
    
    public Avatar AsignarArma(Avatar avatar, Arma newArma){
        avatar.setArmaActual(newArma);
        return avatar;
    }
    
    public Avatar ModificarArmadura(Avatar avatar, Armadura newArmadura){
        avatar.setArmaduraActual(newArmadura);
        return avatar;
    }        
}
