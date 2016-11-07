/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.MapPanelData;
import Modelo.*;
import Vista.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private GameWindow gameWindow;
    private MapPanelData mapPanelData;
    
    
    public Juego() {
        _render = new Render();
        _laberintos = new ArrayList<>();
        _idxLaberinto = _idxLaberintoAnterior = 0;
        _numLaberintos = (int)(Math.random()*10+5);
        //_gestorAvatar = new GestorAvatar();        
        
    }
    
    private void CrearListaLaberintos() {
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
    
    public void Start(){        
        PrepareData();
        Welcome();
        PrepareGameWindow();
    }
    
    private void Welcome(){
        gameWindow = new GameWindow();
        gameWindow.setSize(600, 400);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(new BorderLayout());
        WelcomeHarambe welcomeHarambeWindow = new WelcomeHarambe();
        gameWindow.add(welcomeHarambeWindow);
        gameWindow.setFocusable(true);
        gameWindow.setVisible(true);
        while(welcomeHarambeWindow.isShowing()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String nombre = welcomeHarambeWindow.NombreJugador;
        _avatar.setNombre(nombre);
        gameWindow.remove(welcomeHarambeWindow);
    }    
    
    private void PrepareData(){
        _gestorLab = new GestorLaberinto();
        CrearListaLaberintos();
        _avatar = new Avatar(_laberintos.get(0).DevolverAnterior(), "", _idxLaberinto);
        mapPanelData = new MapPanelData(_laberintos.get(0), _avatar);
        _gestorJuego = new GestorJuego(_avatar);
    }
    
    private void PrepareGameWindow(){
        gameWindow.setSize(620, 420);
        gameWindow.setLocationRelativeTo(null);
        MapPanel mapPanel = new MapPanel(mapPanelData);
        mapPanel.setSize(420, 420);
        mapPanel.setBackground(Color.GREEN);
        gameWindow.add(mapPanel);
        InfoPanel infoPanel = new InfoPanel();
        infoPanel.setSize(200, 420);
        gameWindow.add(infoPanel);
        infoPanel.setLocation(420, 0);
        infoPanel.setBackground(Color.CYAN);
        mapPanel.setVisible(true);
        infoPanel.setVisible(true);
        ViewInputController inputController = new ViewInputController(gameWindow, mapPanel, infoPanel, _gestorJuego);
        inputController.setListener();
        while (_gestorJuego.GameON) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void Play() {
        
        int di= 0;
        while (_gestorJuego.GameON) {
            _render.Render(_avatar, ObtenerLaberinto(_idxLaberinto),_idxLaberinto);
            //di = _gestorJuego.Procesar(_avatar, ObtenerLaberinto(_idxLaberinto));
            _idxLaberinto += di;
            // Si querías evitar que el indice de laberintoActual sea negativo, bastaba:
            if (_idxLaberinto < 0)
                _idxLaberinto = 0;
            // Evaluamos si hemos ganado
            if (_idxLaberinto == _numLaberintos){
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

