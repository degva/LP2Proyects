/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Avatar;
import Modelo.IntPair;
import Modelo.Laberinto;

/**
 *
 * @author wperezp
 */
public class MapPanelData {
    
    Laberinto laberinto;
    Avatar avatar;
    
    public MapPanelData(Laberinto laberinto, Avatar avatar){
        this.laberinto = laberinto;
        this.avatar = avatar;        
    }
    
    public void setLaberinto(Laberinto l){
        laberinto = l;
    }
    
    public void avatarReposition(int step){
        IntPair reposition = new IntPair(0, 0);
        if (step == 1){
            reposition = laberinto.DevolverAnterior();
        } else if (step == -1){
            reposition = laberinto.DevolverSiguiente();
        }
        avatar.SetPosXY(reposition);
    }
}
