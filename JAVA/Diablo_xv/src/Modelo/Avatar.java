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
public class Avatar extends Entidad {
    private Saco saco;
    private Armadura armaduraActual; 
    private Arma armaActual;
    private final char _elementoGrafico;
     
     public Avatar(int posicionX, int poscionY, String nombre, int nivel){
        super(posicionX,poscionY,nombre,nivel, 100);
        super.setVidaActual(100);
        this.saco = new Saco();
        this.armaduraActual = null;
        this.armaActual = null;
        this._elementoGrafico = 'O';
    }
     
    public Avatar(IntPair coord, String nombre, int nivel){
        super(coord.x, coord.y,nombre,nivel, 100);
        super.setVidaActual(100);
        this.saco = new Saco();
        this.armaduraActual = null;
        this.armaActual = null;
        this._elementoGrafico = 'O';
    }
    

     /**
     * @return the saco
     */
    public Saco getSaco() {
        return this.saco;
    }
    
    /**
     * @param saco the saco to set
     */
    public void setSaco(Saco saco) {
        this.saco = saco;
    }

    /**
     * @return the armaduraActual
     */
    public Armadura getArmaduraActual() {
        return armaduraActual;
    }

    /**
     * @param armaduraActual the armaduraActual to set
     */
    public void setArmaduraActual(Armadura armaduraActual) {
        this.armaduraActual = armaduraActual;
    }

    /**
     * @return the armaActual
     */
    public Arma getArmaActual() {
        return armaActual;
    } 
    
    public void setArmaActual(Arma arma){
        this.armaActual = arma;
    }
    
    @Override
    public void Dibujar() {
        System.out.print(_elementoGrafico);
    }        
}
