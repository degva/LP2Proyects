/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.Laberinto;
/**
 *
 * @author degva
 */
public class Juego {
 
    // estoy seguro que necesitamos una lista de laberintos, pero por prueba
    // hare un unico laberinto :v
    private Laberinto laberinto;
    private Dibujador renderer;
    
    public Juego(int max_size) {
        laberinto = new Laberinto(max_size);
        renderer = new Dibujador();
    }
    
    public void Start() {
        System.out.print("Oyequedice\n");
        renderer.Render(laberinto);
    }

    
}
