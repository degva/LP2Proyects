/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Evento;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author David
 */
public class GestorEventos {
    private ArrayList<Evento> eventos;

    public GestorEventos ()
    {
            this.eventos = new ArrayList<Evento>();
    }

    public void AgregarEvento(Evento evento)
    {
            this.eventos.add(evento);
    }

    public Evento ObtenerEvento(int codigo)
    {
        Evento objEvento = null;
        
        Iterator<Evento> iterador = this.eventos.iterator();
        while(iterador.hasNext()){
            Evento elemento = iterador.next();
            if (elemento.getCodigo() == codigo)
                objEvento = elemento;
        }
        return objEvento;
    }    
    
    public void VizualizarEquiposParticipantes(int codigo){
        //Obtenemos el evento
        Evento objEvento = null;
        objEvento = ObtenerEvento(codigo);
        objEvento.VerParticipantes();
    }
}
