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
    
    public Thread movEnemigos;
    public Thread movArtefactos;
    public Thread movAliado;
    
    private static Juego INSTANCE = null;
    
    protected Juego() {
        //_render = new Render();
        _laberintos = new ArrayList<>();
        _idxLaberinto = _idxLaberintoAnterior = 0;
        _numLaberintos = (int)(Math.random()*10+5);
        //_gestorAvatar = new GestorAvatar();        
        
    }
    
    public static Juego Get(){
        if (INSTANCE == null)
            INSTANCE = new Juego();
        return INSTANCE;
    }
    
    private void CrearListaLaberintos() {
        for (int i = 0; i < _numLaberintos; i++) {
            _laberintos.add(getGestorLab().CrearLaberinto(i+1));
        }
    }
    
    public synchronized Laberinto GetLaberintoActual() {
        return _laberintos.get(gameInfo.getIdxLaberinto());
    }
    
    
    public Laberinto ObtenerLaberinto(int idx) {
        return _laberintos.get(idx);
    }
    
    public void Start(){        
        PrepareData();
        Welcome();
        PrepareGameWindow();
        PrepareThreads();
        Play();
    }
    
    private void PrepareData(){
        setGestorLab(new GestorLaberinto());
        CrearListaLaberintos();
        _avatar = new Avatar(_laberintos.get(0).DevolverAnterior(), "", _idxLaberinto);
        mapPanelData = new MapPanelData(_laberintos.get(0), getAvatar());
        gameInfo = GameInfo.Get();
        gameInfo.SetNumeroDeLaberintos(_numLaberintos);
        _gestorJuego = new GestorJuego(getAvatar(), _laberintos, getGestorLab());
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
        getAvatar().setNombre(nombre);
        gameWindow.remove(welcomeHarambeWindow);
    }    
    
    private void PrepareGameWindow(){
        gameWindow.setLocationRelativeTo(null);
        MapPanel mapPanel = new MapPanel(mapPanelData);
        gameWindow.add(mapPanel);
        InfoPanelData infoPanelData = new InfoPanelData(getAvatar());
        InfoPanel infoPanel = new InfoPanel(infoPanelData, _laberintos); //deep gg
        gameWindow.getContentPane().add(mapPanel);
        gameWindow.getContentPane().add(infoPanel);
        gameWindow.pack();
        mapPanel.setVisible(true);
        infoPanel.setVisible(true);
        ViewInputController inputController = new ViewInputController(gameWindow, mapPanel, infoPanel, _gestorJuego);
        inputController.setListener();
        
        interaccionDialog = new JDialog(gameWindow, "Interaccion", true);
        InteractuarPanel intPanel = new InteractuarPanel();
        interaccionDialog.getContentPane().add(intPanel);
        interaccionDialog.pack();
    }
    
    private void PrepareThreads(){
        this.movEnemigos = new Thread(new Runnable() {
            @Override
            public void run() {
                while(gameInfo.GameIsNotOver()){
                    getGestorLab().MoverEnemigos(GetLaberintoActual(), getAvatar().getPosX(), getAvatar().getPosY());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        this.movArtefactos = new Thread(new Runnable() {
            @Override
            public void run() {
                while(gameInfo.GameIsNotOver()){
                    getGestorLab().MoverArtefactos(GetLaberintoActual(), getAvatar().getPosX(), getAvatar().getPosY());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                }
            }
        });
        
        this.movAliado = new Thread(new Runnable() {
            @Override
            public void run() {
                while(gameInfo.GameIsNotOver()){
                    getGestorLab().MoverAliado(GetLaberintoActual());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    private void Play() {
        this.movEnemigos.start();
        this.movArtefactos.start();
        this.movAliado.start();
        while (gameInfo.GameIsNotOver()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            gameWindow.repaint();
        }
        if (gameInfo.PlayerHasWon()){
            //Display winning window
        } else {
            
        }
    }

    /**
     * @return the _gestorLab
     */
    public synchronized GestorLaberinto getGestorLab() {
        return _gestorLab;
    }

    /**
     * @param _gestorLab the _gestorLab to set
     */
    public void setGestorLab(GestorLaberinto _gestorLab) {
        this._gestorLab = _gestorLab;
    }

    /**
     * @return the _avatar
     */
    public synchronized Avatar getAvatar() {
        return _avatar;
    }

}

