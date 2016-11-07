/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Laberinto;
import Vista.MapPanelData;

/**
 *
 * @author wpere
 */
public class ViewDataController {
    
    MapPanelData mapPanelData;
    
    public ViewDataController(MapPanelData md){
        mapPanelData = md;
    }
    
    public void LevelUp(Laberinto l){
        mapPanelData.setLaberinto(l);
        mapPanelData.avatarReposition(1);
    }
    
    public void LevelDown(Laberinto l){
        mapPanelData.setLaberinto(l);
        mapPanelData.avatarReposition(-1);
    }
}
