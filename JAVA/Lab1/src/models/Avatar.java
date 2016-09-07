/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Gina
 */
public class Avatar extends Entidad{
    private int vidaMaxima;
    private Saco saco;
    private Armadura armaduraActual; 
    private Arma armaActual;
   
    public Avatar(int posicionX, int poscionY, String nombre, int nivel){
        super(posicionX,poscionY,nombre,nivel);
        super.setVidaActual(100);
        this.vidaMaxima = 100;
        this.saco = new Saco();
        this.armaduraActual = null;
        this.armaActual = null;
        
        this.saco.agregarArtefacto(new Arma("Excalibur", 10, 10));
    }
        
    /**
     * @return the vidaMaxima
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * @param vidaMaxima the vidaMaxima to set
     */
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
    
    /**
     * @return the saco
     */
    public Saco getSaco() {
        return saco;
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

    /**
     * @param armaActual the armaActual to set
     */
    public void setArmaActual(Arma armaActual) {
        this.armaActual = armaActual;
    }


    /*
    //Aumentar nivel
    public void levelUp(){
        this.nivel++;
    }
    */
        
    //Reocger Artefacto
    public void recogerArtefacto(Artefacto newArtefacto){
        getSaco().agregarArtefacto(newArtefacto);
    }
    
    /*
    Creo que avatar debe tener un metodo atacar enemigo, pero no tengo muy
    claro que debe hacer.
    */
    //Atacar enemigo
    public void atacarEnemigo(){
        
    }
    
    /*
    Metodo para cambiar armaduraActual
    recive como parametro el inidce de la nueva armadura que se quiere utilizar
    */
    public void cambiarArmaduraActual(int indiceArmadura){
        //Obtenemos la nueva armadura del saco
        /* NOTA: se debe hacer la operacion cast porque el metodo getItem 
           devuelve un artefacto(asi tambien se puede utilizar en cambair arma)*/
        Armadura nuevaArmadura = (Armadura)this.saco.getItem(indiceArmadura);
        //Removemos la nueva armadura del saco para que ya no este disponible
        this.saco.removeItem(indiceArmadura);
        //En caso el heroe este usando ya una armadura, colocamos la armadura actual en el saco
        if(this.armaActual!=null) this.saco.agregarArtefacto(this.getArmaduraActual());
        //Asignamos la nueva armadura actual
        this.setArmaduraActual(nuevaArmadura);                                                 
    }
    
    /*
    Metodo para cambiar el armaActual
    recive como parametro el inidce de la nueva arma que se quiere utilizar
    */
    public void cambiarArmaActual(int indiceArma){
        Arma nuevaArma = (Arma)this.saco.getItem(indiceArma);
        this.saco.removeItem(indiceArma);
        if(this.armaActual!=null)this.saco.agregarArtefacto(this.getArmaActual());
        this.setArmaActual(nuevaArma);
    }
  
}
