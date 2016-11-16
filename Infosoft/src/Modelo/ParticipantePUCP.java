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
public class ParticipantePUCP extends EquipoParticipante{
    private ArrayList<MiembroPUCP> miembros;
    private ArrayList<Trabajador> asesores;
    
    public ParticipantePUCP(String tema, String fechaParticipacion, int horaParticipacion, String nombreArchivo)
    {
        super(tema,fechaParticipacion,horaParticipacion,nombreArchivo);
        this.miembros = new ArrayList<MiembroPUCP>();
        this.asesores = new ArrayList<Trabajador>();
    }

    /**
     * @param miembros the miembros to set
     */
    public void setMiembro(MiembroPUCP miembro) {
        this.miembros.add(miembro);
    }

    /**
     * @return the asesores
     */
    public ArrayList<Trabajador> getAsesores() {
        return asesores;
    }

    /**
     * @param asesores the asesores to set
     */
    public void setAsesores(ArrayList<Trabajador> asesores) {
        this.asesores = asesores;
    }
        
    @Override        
    public String getNombresParticipantes() {               
        Iterator<MiembroPUCP> iterador = this.miembros.iterator();
        String cadena = new String();
        while(iterador.hasNext()){
            MiembroPUCP elemento = iterador.next();
            cadena.concat(elemento.getNombre()+" ");
        }
        return cadena;
    }
}
