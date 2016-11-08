/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GameWindow;
import Vista.InfoPanel;
import Vista.MapPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author wperezp
 */
public class ViewInputController implements KeyListener {
    
    private final GameWindow gameWindow;
    private final MapPanel mapPanel;
    private final InfoPanel infoPanel;
    private final GestorJuego gestorJuego;
    
    public ViewInputController(GameWindow gameWindow, MapPanel mapPanel, InfoPanel infoPanel, GestorJuego gestorJuego){
        this.gameWindow = gameWindow;
        this.mapPanel = mapPanel;
        this.infoPanel = infoPanel;
        this.gestorJuego = gestorJuego;
    }
    
    public void setListener(){
        gameWindow.addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    @Override
    public void keyPressed(KeyEvent e){
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        gestorJuego.Procesar(keyCode);
        mapPanel.repaint();
        infoPanel.repaint();
    }
    
   
}
