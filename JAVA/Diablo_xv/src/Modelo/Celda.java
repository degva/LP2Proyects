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
public class Celda {
    
    // Esto debe tener tambien un tipo de Celda
    // private TipoCelda tipo;
    
    private ObjetoGrafico objGrafico;

    public Celda(ObjetoGrafico objGrafico) {
        this.objGrafico = objGrafico;
    }
    
    /**
     * @return the objGrafico
     */
    public ObjetoGrafico getObjGrafico() {
        return objGrafico;
    }

    /**
     * @param objGrafico the objGrafico to set
     */
    public void setObjGrafico(ObjetoGrafico objGrafico) {
        this.objGrafico = objGrafico;
    }
    
    
}
