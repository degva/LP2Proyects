/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilidades;

/**
 *
 * @author alulab14
 */
public class Consejo {
    private String _consejo;
    public int _nivel;
    
    public Consejo(String consejo, int nivel){
        _consejo = consejo;
        _nivel = nivel;
    }

    /**
     * @return the _consejo
     */
    public String getConsejo() {
        return _consejo;
    }

    /**
     * @return the _nivel
     */
    public int getNivel() {
        return _nivel;
    }
    
    
}
