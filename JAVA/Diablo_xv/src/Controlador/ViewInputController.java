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
 * @author Fam. Pérez Portilla
 */
public class ViewInputController implements KeyListener {
    
    private GameWindow gameWindow;
    private MapPanel mapPanel;
    private InfoPanel infoPanel;
    
    public ViewInputController(GameWindow gameWindow, MapPanel mapPanel, InfoPanel infoPanel){
        this.gameWindow = gameWindow;
        this.mapPanel = mapPanel;
        this.infoPanel = infoPanel;
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
        mapPanel.repaint();
        infoPanel.repaint();
    }   
    
}
