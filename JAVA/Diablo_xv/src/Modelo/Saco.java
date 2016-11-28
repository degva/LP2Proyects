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
    
    List<Artefacto> artefactos;
    
    public Saco() {
        artefactos = new ArrayList();
    }
    
    public void AgregarArtefacto(Artefacto item) {
        artefactos.add(item);
    }
    
    public int Size(){
        return artefactos.size();
    }
    
    public Artefacto Get(int i) {              
        return artefactos.get(i);                  
    }
    
    public Artefacto Get(String name){
        for (Artefacto artefacto : artefactos) {
            if (artefacto.Nombre().equals(name))
                return artefacto;
        }
        return null;
    }
    
    public void Remove(int i){
        this.artefactos.remove(i);
    }

}
