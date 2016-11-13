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
    private ArrayList<Laberinto> laberintos;
    private GameInfo gameInfo = GameInfo.Get();
    
    private GestorLaberinto _gesLab;
    
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
        _gesLab.MoverEnemigos(laberintos.get(gameInfo.LaberintoActual()), avatar.getPosX(), avatar.getPosY());
        if (PressedKeyIsMovement(keyCode)){
            IntPair desp = DesplazamientoByKeyCode(keyCode);
            if (DesplazamientoEsValido(desp)){
                avatar.Mover(desp.x, desp.y);
                CheckLevelChange();
            }
        }
        if (colisionConEnemigo()) {
            gameInfo.setOnColission(true);
        }
    }
    
    
//    private boolean PosicionDisparaInteraccion(Avatar avatar, Laberinto laberinto){
//        IntPair coordenadasAvatar = new IntPair(avatar.getPosX(), avatar.getPosY());
//        Celda celdaAvatar = laberinto.getCelda(coordenadasAvatar.x, coordenadasAvatar.y);
//        return (celdaAvatar.getContenido() instanceof Enemigo || celdaAvatar.getContenido() instanceof Artefacto);
//    }
    
    private boolean colisionConEnemigo() {
        Laberinto l = laberintos.get(gameInfo.LaberintoActual());
        IntPair av_pos = avatar.getPos();
        return  l.getCelda(av_pos.x + 1, av_pos.y).getContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x - 1, av_pos.y).getContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x, av_pos.y + 1).getContenido() instanceof Enemigo ||
                l.getCelda(av_pos.x, av_pos.y - 1).getContenido() instanceof Enemigo;
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
        int nuevoX = avatar.getPosX() + desplazamiento.x;
        int nuevoY = avatar.getPosY() + desplazamiento.y;
        Laberinto laberinto = laberintos.get(gameInfo.LaberintoActual());
        Celda celdaADesplazarse = laberinto.getCelda(nuevoX, nuevoY);
        Sprite aux = celdaADesplazarse.getTipo();
        return ((aux instanceof Pasadizo) && !(celdaADesplazarse.getContenido() instanceof Enemigo));
    }
    
    private void CheckLevelChange(){
        IntPair avatarPos = avatar.getPos();
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
    
    // Metodo para efectuar la interacción con el objeto en la dirección especificada
    // Si dirección = "", se hace la interacción con el objeto que está en la misma celda que el avatar. (DEPRECATED)
//    private void Interactuar(String direccion, Avatar avatar, Laberinto laberinto){        
//        IntPair desplazamiento = DesplazamientoByComando(direccion);
//        IntPair coordenadaInteraccion = new IntPair(avatar.getPosX()+desplazamiento.x, avatar.getPosY()+desplazamiento.y);
//        Sprite objetoInteraccion = laberinto.getContenidoCelda(coordenadaInteraccion.x, coordenadaInteraccion.y);        
//        // Revisamos el tipo de interaccion que corresponde
//        if(objetoInteraccion instanceof Enemigo){
//            //Se inicia una batalla
//            gestorInteraccion.interactuarEnemigo(avatar, laberinto, coordenadaInteraccion);
//        } else if (objetoInteraccion instanceof Artefacto){
//            gestorInteraccion.interactuarArtefacto(avatar, laberinto, coordenadaInteraccion);
//        }else if (objetoInteraccion instanceof Aliado){
//            gestorInteraccion.interactuarAliado(avatar, laberinto, coordenadaInteraccion);
//        }else{
//            //consola.SetLog("Aqui no hay nada para interactuar");
//        }
//    }
    
}
