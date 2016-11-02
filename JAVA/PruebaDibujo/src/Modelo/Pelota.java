/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */

//Tiene una posicion X e Y y una velocidad en ambos ejes.
public class Pelota {
    public int x;
    public int y;
    public int veloX;
    public int veloY;
   
    public Pelota(int x, int y, int veloX, int veloY) {
        this.x = x;
        this.y = y;
        this.veloX = veloX;
        this.veloY = veloY;
    } 
}
