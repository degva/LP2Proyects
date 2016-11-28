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
    
    public void RecogerArtefacto(Avatar avatar, Artefacto newArtefacto){
        avatar.Saco().AgregarArtefacto(newArtefacto);
    }
    
    public void AsignarArma(Avatar avatar, Arma newArma){
        avatar.SetArmaActual(newArma);
    }
    
    public void ModificarArmadura(Avatar avatar, Armadura newArmadura){
        avatar.setArmaduraActual(newArmadura);
    }        
    
}
