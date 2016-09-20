/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author degva
 */
public class Enemigo extends Entidad {
    
    private final char _elementoGrafico;
    int ataque;
    
    public Enemigo(int posicionX, int poscionY, String nombre, int nivel){
        super(posicionX,poscionY,nombre,nivel, nivel * 2);
        super.setVidaActual(nivel * 2);
        ataque = this.getNivel() * 2; 
        _elementoGrafico = 'E';
    }
    

    
    @Override
    public void Dibujar() {
        System.out.print(_elementoGrafico);
    }
    

}
