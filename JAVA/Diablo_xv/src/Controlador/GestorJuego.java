/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Vista.MapPanelData;
import java.util.ArrayList;

/**
 *
 * @author degva
 */
public class GestorJuego {
    
    // private final GestorLaberinto controladorLaberinto;
    private final GestorInteraccion gestorInteraccion;
    private final Avatar avatar;
    private final ArrayList<Laberinto> laberintos;
    private final GameStatus gameInfo = GameStatus.Get();
    
    private final GestorLaberinto _gesLab;
    
    private ViewDataController vdController;
    
    public GestorJuego(Avatar a, ArrayList<Laberinto> l, GestorLaberinto gesLab){
        _gesLab = gesLab;
        gestorInteraccion = new GestorInteraccion();
        avatar = a;
        laberintos = l;
    }
    
    public void setViewDataController(MapPanelData md){
        vdController = new ViewDataController(md);
    }
    
    public void Procesar(int keyCode){
        if (PressedKeyIsMovement(keyCode)){
            IntPair desp = DesplazamientoByKeyCode(keyCode);
            if (DesplazamientoEsValido(desp)){
                avatar.Mover(desp.x, desp.y);
                CheckLevelChange();
            }
        }
    }
    
    
    private boolean colisionConEnemigo() {
        Laberinto l = laberintos.get(gameInfo.LaberintoActual());
        IntPair av_pos = avatar.GetPosition();
        return  l.getCelda(av_pos.x + 1, av_pos.y).GetContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x - 1, av_pos.y).GetContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x, av_pos.y + 1).GetContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x, av_pos.y - 1).GetContenido() instanceof Enemigo;
    }
    
    private boolean PressedKeyIsMovement(int keyCode){
        int[] moveKeys = {37,38,39,40,87,104,68,102,65,100,83,98};
        for (int i=0; i< 12; i++){
            if (keyCode == moveKeys[i])
                return true;
        }
        return false;
    }
    
    // Funcion para obtener un par ordenado de desplazamiento en base a una dirección especificada
    private IntPair DesplazamientoByKeyCode(int keyCode){
        IntPair desplazamiento;
        switch(keyCode){
            case 38:
            case 87:
            case 104:
                desplazamiento = new IntPair(0, -1);
                break;
            case 39:
            case 68:
            case 102:
                desplazamiento = new IntPair(1, 0);
                break;
            case 37:
            case 65:
            case 100:
                desplazamiento = new IntPair(-1, 0);
                break;
            case 40:
            case 83:
            case 98:
                desplazamiento = new IntPair(0, 1);
                break;
            default:
                desplazamiento = new IntPair(0, 0);
        }
        return desplazamiento;
    }
    
    private boolean DesplazamientoEsValido(IntPair desplazamiento){
        int nuevoX = avatar.GetPosX() + desplazamiento.x;
        int nuevoY = avatar.GetPosY() + desplazamiento.y;
        Laberinto laberinto = laberintos.get(gameInfo.LaberintoActual());
        Celda celdaADesplazarse = laberinto.getCelda(nuevoX, nuevoY);
        Sprite aux = celdaADesplazarse.GetTipo();
        //return ((aux instanceof Pasadizo) && !(celdaADesplazarse.getContenido() instanceof Enemigo));
        return (aux instanceof Pasadizo);
    }
    
    private void CheckLevelChange(){
        IntPair avatarPos = avatar.GetPosition();
        Laberinto l = laberintos.get(gameInfo.LaberintoActual());
        IntPair antPos = l.DevolverAnterior();
        IntPair sigPos = l.DevolverSiguiente();
        if (IntPair.Equals(antPos, avatarPos)){
            if (gameInfo.LaberintoActual() != 0){
                gameInfo.LevelDown();
                vdController.Back(laberintos.get(gameInfo.LaberintoActual()));
            }
        } else if (IntPair.Equals(sigPos, avatarPos)){
            gameInfo.LevelUp();
            vdController.Next(laberintos.get(gameInfo.LaberintoActual()));
        }
    }
    
}
