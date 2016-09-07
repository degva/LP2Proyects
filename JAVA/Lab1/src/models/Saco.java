/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alulab14
 */
public class Saco {
    private int size;
    List<Artefacto> artefactos;
    
    public Saco() {
        artefactos = new ArrayList<>();
    }
    public void agregarArtefacto (Artefacto item) {
        
    }
    public int getSize() {
        return artefactos.size();
    }
    public Artefacto getItem(int i) {
        return artefactos.get(i);
    }
    public void removeItem(int i){
        this.artefactos.remove(i);
    }
}
