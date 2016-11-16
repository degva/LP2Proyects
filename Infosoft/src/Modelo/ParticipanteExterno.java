/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author David
 */
public class ParticipanteExterno extends EquipoParticipante {
    private String lugarProveniencia;
    private Persona expositor;
    private ArrayList<Persona> miembros;
    
    public ParticipanteExterno(String tema, String fechaParticipacion, int horaParticipacion, String nombreArchivo, String lugarProveniencia, Persona expositor)
    {
        super(tema,fechaParticipacion,horaParticipacion,nombreArchivo);
        this.lugarProveniencia = lugarProveniencia;
        this.expositor = expositor;
        this.miembros = new ArrayList<Persona>();
    }

    /**
     * @return the lugarProveniencia
     */
    public String getLugarProveniencia() {
        return lugarProveniencia;
    }

    /**
     * @param lugarProveniencia the lugarProveniencia to set
     */
    public void setLugarProveniencia(String lugarProveniencia) {
        this.lugarProveniencia = lugarProveniencia;
    }

    /**
     * @return the expositor
     */
    public Persona getExpositor() {
        return expositor;
    }

    /**
     * @param expositor the expositor to set
     */
    public void setExpositor(Persona expositor) {
        this.expositor = expositor;
    }

    /**
     * @return the miembros
     */
    public ArrayList<Persona> getMiembros() {
        return miembros;
    }

    /**
     * @param miembros the miembros to set
     */
    public void setMiembros(ArrayList<Persona> miembros) {
        this.miembros = miembros;
    }
    
    @Override        
    public String getNombresParticipantes() {               
        Iterator<Persona> iterador = this.miembros.iterator();
        String cadena = new String();
        while(iterador.hasNext()){
            Persona elemento = iterador.next();
            cadena.concat(elemento.getNombre()+" ");
        }
        return cadena;
    }
}
