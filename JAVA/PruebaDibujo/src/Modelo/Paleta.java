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

//Tiene una posicion en Y porque solo se mueve vertical y un alto que es el tamaño
//de la paleta.
public class Paleta {
    public int y;
    public int alto;
       
    public Paleta(int y, int alto) {
        this.y = y;
        this.alto = alto;        
    }
}
