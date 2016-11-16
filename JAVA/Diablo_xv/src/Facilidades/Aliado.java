/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facilidades;
import Modelo.*;
import Controlador.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Comparator;

/**
 *
 * @author Fabricio Monsalve Escudero
 */

////MODIFICACION 1
public class Aliado extends Entidad{

    private final char _elementoGrafico;
    private ArrayList<Consejo> _consejos;
    private Saco _saco;
    
    public Aliado(String nombre, int posicionX, int poscionY, int nivel){
        super(posicionX,poscionY,nombre,nivel, nivel * 2);
        super.setVidaActual(nivel * 2);
        _elementoGrafico = 'L';
        _consejos = new ArrayList<>();
        _saco = new Saco();
        LlenarSaco();
        //GenerarListaConsejos();
    }
    
    private void LlenarSaco(){
        GestorArtefacto gestorArt = new GestorArtefacto();
        for (int i = 0; i < 10; i++) {
            _saco.agregarArtefacto(gestorArt.ObtenerArtefacto(this.getPosX(), this.getPosY(), this.getNivel()));
        }
    }
    
//    private void GenerarListaConsejos(){        
//        _consejos[0] = "No debes morir";
//        _consejos[1] = "Busca el +";
//        _consejos[2] = "Cuidado con los enemigos";
//        _consejos[3] = "Agarra todos los artefactos que puedas";
//        _consejos[4] = "OYR ";
//        _consejos[5] = "Hey puedes volver al laberinto anterior avanzando a la casilla -";
//        _consejos[6] = "Me gusta pokemon GO";
//        _consejos[7] = "No debes morir 5";
//        _consejos[8] = "No debes morir 6";
//        _consejos[9] = "No debes morir 7";
//    }
    
    public void AnadirConsejo(Consejo c){
        _consejos.add(c);
        Collections.sort(_consejos, new Comparator<Consejo>() {
        @Override public int compare(Consejo p1, Consejo p2) {
            return p1._nivel - p2._nivel; // Ascending
        }
        });
    }
    
    public String darConsejo(){
        Random rnd = new Random();
        int indice = rnd.nextInt(_consejos.size());        
        return _consejos.get(indice).getConsejo();
    }
    
    
    @Override
    public String GetSpriteType() {
        return "aliado";
    }


    
}
