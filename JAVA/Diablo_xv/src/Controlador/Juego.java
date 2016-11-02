/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author degva
 */
public class Juego {
    
    // Constantes
    public static final int NRO_ARTEFACTOS = 10;
    public static final int MAX_LABERINTOS = 10;
    public static final int MIN_LABERINTOS = 5;
    
    private Avatar _avatar;
    private GestorLaberinto _gestorLab;
    private GestorJuego _gestorJuego;
    private Render _render;
    private int _idxLaberinto;
    private int _idxLaberintoAnterior;
    private int _numLaberintos;
    //private GestorAvatar _gestorAvatar;
    private final ArrayList<Laberinto> _laberintos;
    
    private final GameWindow ventanaJuego;
    
    
    public Juego(String name) {
        //Scanner input = new Scanner(System.in);
        _gestorLab = new GestorLaberinto();
        _gestorJuego = new GestorJuego();        
        _laberintos = new ArrayList<>();
        _idxLaberinto = _idxLaberintoAnterior = 0;
        _numLaberintos = (int)(Math.random()*10+5);
        //_gestorAvatar = new GestorAvatar();
        
        this.CrearListaLaberintos();
        _avatar = new Avatar(GetLaberintoActual().DevolverAnterior(), name, _idxLaberinto);
        
        ventanaJuego = new GameWindow();        
        ventanaJuego.setVisible(true);
        _render = new Render(ventanaJuego.mapPanel, ventanaJuego.infoPanel);
    }
    
    public void CrearListaLaberintos() {
        for (int i = 0; i < _numLaberintos; i++) {
            _laberintos.add(_gestorLab.CrearLaberinto(i+1));
        }
    }
    
    public Laberinto GetLaberintoActual() {
        return _laberintos.get(GetIdxLaberintoActual());
    }
    
    public int GetIdxLaberintoActual() {
        return _idxLaberinto;
    }
    
    public int GetIdxLaberintoAnterior() {
        return _idxLaberintoAnterior;
    }
    
    public Laberinto ObtenerLaberinto(int idx) {
        return _laberintos.get(idx);
    }
    
    public void AgregarLaberinto(Laberinto lab) {
        _laberintos.add(lab);
    }
    
    public void Jugar() {               
        // Otra vista: Consola
        int di;
        while (_gestorJuego.GameON) {
            _render.Render(_avatar, ObtenerLaberinto(_idxLaberinto),_idxLaberinto);
            di = _gestorJuego.Procesar(_avatar, ObtenerLaberinto(_idxLaberinto));
            _idxLaberinto += di;
            // Si querías evitar que el indice de laberintoActual sea negativo, bastaba:
            if (_idxLaberinto < 0)
                _idxLaberinto = 0;
            // Evaluamos si hemos ganado
            if (_idxLaberinto == _numLaberintos){
                System.out.println("¡¡¡GANASTE!!!");
                break;
            }
            //Evaluamos el avance
            if ((di == -1) && (_idxLaberinto != 0)) {
                _avatar.setPosXY(ObtenerLaberinto(_idxLaberinto).DevolverSiguiente());
            } else if (di == 1) {
                _avatar.setPosXY(ObtenerLaberinto(_idxLaberinto).DevolverAnterior());
            }
            _gestorLab.MoverEnemigos(ObtenerLaberinto(_idxLaberinto), _avatar.getPosX(), _avatar.getPosY());
            _gestorLab.MoverAliado(ObtenerLaberinto(_idxLaberinto));            
        }
    }
    
}

