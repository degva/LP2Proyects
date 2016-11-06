/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Avatar;
import Modelo.Laberinto;

/**
 *
 * @author Fam. Pérez Portilla
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
}
