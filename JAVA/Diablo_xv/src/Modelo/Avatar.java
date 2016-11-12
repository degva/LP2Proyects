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
    private int dir = 6; 
     
     public Avatar(int posicionX, int poscionY, String nombre, int nivel){
        super(posicionX,poscionY,nombre,nivel, 100);
        super.setVidaActual(100);
        this.saco = new Saco();
        this.armaduraActual = new Armadura("Armor", 0, 0, 50);
        this.armaActual = new Arma("Espada", 0, 0, 25, 75);
    }
     
    public Avatar(IntPair coord, String nombre, int nivel){
        super(coord.x, coord.y,nombre,nivel, 100);
        super.setVidaActual(100);
        this.saco = new Saco();
        this.armaduraActual = new Armadura("Armor", 0, 0, 50);
        this.armaActual = new Arma("Espada", 0, 0, 25, 75);
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
    
    public void setDireccion(int d){
        
    }
    
    @Override
    public void Mover(int dx, int dy){
        setPosX(getPosX() + dx);
        setPosY(getPosY() + dy);
        if (dx == 1)
            dir = 6;
        else if (dx == -1)
            dir = 4;
        else if (dy == 1)
            dir = 2;
        else if (dy == -1)
            dir = 8;
    }
    
    @Override
    public String GetSpriteType() {
        String direccion = (dir == 6) ? "" : (dir == 8) ? "-arr": (dir == 4) ? "-izq": "-abj";
        return "avatar"+direccion;
    }        
}
