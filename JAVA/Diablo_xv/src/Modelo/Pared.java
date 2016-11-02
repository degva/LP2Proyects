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
public class Pared implements ObjetoGrafico{
    
    public char _elementoGrafico;
    
    public Pared() {
        _elementoGrafico = '#';
    }
    
    @Override
    public void Dibujar(){
        System.out.print(_elementoGrafico);
    }
}
