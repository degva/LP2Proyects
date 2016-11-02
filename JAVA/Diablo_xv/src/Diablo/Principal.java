/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diablo;
import Controlador.*;
import java.awt.Canvas;
import Vista.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author degva
 */
public class Principal {
    
//    private String _name;
//    private static final int WIDTH = 640, HEIGHT = (WIDTH/16) * 9;
//    
//    public Principal(){
//        new MainWindow(WIDTH, HEIGHT, "Harambe's Maze", this);
//    }
//    
//    public synchronized void start(){
//        //Juego juego = new Juego();
//        //juego.Jugar();
//    }
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        WelcomeWindow welcomeWindow = new WelcomeWindow("");
        try {
            while(welcomeWindow.isVisible())
                Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Juego juego = new Juego(welcomeWindow.name);
        juego.Jugar();
    }
    
//    
//    @Override
//    public void run() {
//        //
//    }
}
