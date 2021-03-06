/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author degva
 */
public class Saco {
    private int size;
    List<Artefacto> artefactos;
    
    public Saco() {
        artefactos = new ArrayList();
    }
    
    public void agregarArtefacto (Artefacto item) {
        artefactos.add(item);
        this.size++;
    }
    
    public int getSize() {
        return artefactos.size();
    }
    
    public Artefacto getItem(int i) {              
        return artefactos.get(i);                  
    }
    
    public Artefacto getItemByName(String name){
        for (Artefacto artefacto : artefactos) {
            if (artefacto.getNombre().equals(name))
                return artefacto;
        }
        return null;
    }
    
    public void removeItem(int i){
        this.artefactos.remove(i);
    }

}
