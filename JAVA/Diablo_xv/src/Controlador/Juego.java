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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

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
    //private Render _render;
    private int _idxLaberinto;
    private int _idxLaberintoAnterior;
    private int _numLaberintos;
    //private GestorAvatar _gestorAvatar;
    private final ArrayList<Laberinto> _laberintos;
    
    private GameInfo gameInfo;
    
    private GameWindow gameWindow;
    private MapPanelData mapPanelData;
    
    private JDialog interaccionDialog;
    
    public Juego() {
        //_render = new Render();
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
        return _laberintos.get(_idxLaberinto);
    }
    
    
    public Laberinto ObtenerLaberinto(int idx) {
        return _laberintos.get(idx);
    }
    
    public void Start(){        
        PrepareData();
        Welcome();
        PrepareGameWindow();
        Play();
    }
    
    private void PrepareData(){
        _gestorLab = new GestorLaberinto();
        CrearListaLaberintos();
        _avatar = new Avatar(_laberintos.get(0).DevolverAnterior(), "", _idxLaberinto);
        mapPanelData = new MapPanelData(_laberintos.get(0), _avatar);
        gameInfo = GameInfo.Get();
        gameInfo.SetNumeroDeLaberintos(_numLaberintos);
        _gestorJuego = new GestorJuego(_avatar, _laberintos, _gestorLab);
        _gestorJuego.setViewDataController(mapPanelData);
    }
    
    private void Welcome(){
        gameWindow = new GameWindow();
        gameWindow.setSize(600, 400);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(new FlowLayout());
        WelcomeHarambe welcomeHarambeWindow = new WelcomeHarambe();
        gameWindow.getContentPane().add(welcomeHarambeWindow);
        gameWindow.setFocusable(true);
        gameWindow.pack();
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
    
    private void PrepareGameWindow(){
        gameWindow.setLocationRelativeTo(null);
        MapPanel mapPanel = new MapPanel(mapPanelData);
        InfoPanelData infoPanelData = new InfoPanelData(_avatar);
        InfoPanel infoPanel = new InfoPanel(infoPanelData);
        gameWindow.getContentPane().add(mapPanel);
        gameWindow.getContentPane().add(infoPanel);
        gameWindow.pack();
        mapPanel.setVisible(true);
        infoPanel.setVisible(true);
        ViewInputController inputController = new ViewInputController(gameWindow, mapPanel, infoPanel, _gestorJuego);
        inputController.setListener();
        
    }
    
    private void Play() {  
        // L5 : start thread
        while (gameInfo.GameIsNotOver()) {
            //try {
            //    Thread.sleep(100);
            //} catch (InterruptedException ex) {
            //    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            //}
            
            // L5 : verificar colision (avatar | enemigo | artefacto)
            // L5 : pausar threds
            // L5 : hacer todo lo del dialog
            // L5 : reanudar threads
            if (gameInfo.isOnColission()) {
                interaccionDialog.setVisible(true);
                
                gameInfo.setOnColission(false);
            }
        }
        if (gameInfo.PlayerHasWon()){
            //Display winning window
        } else {
            
        }
    }
}

