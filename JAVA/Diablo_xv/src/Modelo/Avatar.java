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
    private String direccion;
     
    public Avatar(IntPair coord, String nombre, int nivel){
        super(coord.x, coord.y,nombre,nivel, 100);
        super.SetVidaActual(100);
        this.saco = new Saco();
        this.armaduraActual = new Armadura("Armor", 0, 0, 50);
        this.armaActual = new Arma("Espada", 0, 0, 25, 75);
        this.direccion = "-der";
    }
    

     /**
     * @return the saco
     */
    public Saco Saco() {
        return this.saco;
    }

    /**
     * @return the armaduraActual
     */
    public Armadura ArmaduraActual() {
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
    public Arma ArmaActual() {
        return armaActual;
    } 
    
    public void SetArmaActual(Arma arma){
        this.armaActual = arma;
    }
    
    @Override
    public void Mover(int dx, int dy){
        SetPosX(GetPosX() + dx);
        SetPosY(GetPosY() + dy);
        if (dx == 1)
            direccion = "-der";
        else if (dx == -1)
            direccion = "-izq";
        else if (dy == 1)
            direccion = "-abj";
        else if (dy == -1)
            direccion = "-arr";
    }
    
    @Override
    public String GetSpriteType() {
        return "avatar"+direccion;
    }        
}
