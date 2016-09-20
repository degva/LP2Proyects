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
    
    private Avatar _avatar;
    
    public GestorAvatar(Avatar avatar) {
        this._avatar = avatar;
    }
    
    public void RecogerArtefacto(Artefacto newArtefacto){
        _avatar.getSaco().agregarArtefacto(newArtefacto);
    }
    
    public void AsignarArma(Arma newArma){
        _avatar.setArmaActual(newArma);
    }   
}
