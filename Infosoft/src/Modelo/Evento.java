/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Evento {
    private int codigo;
    private String nombre;
    private String fechaInauguracion;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<EquipoParticipante> participantes;
    private ArrayList<MiembroPUCP> organizadores;
    Scanner sce = new Scanner(System.in);

    public Evento (int codigo, String nombre, String fechaInauguracion, String fechaInicio,
		   String fechaFin)
    {
            this.codigo = codigo;
            this.nombre = nombre;
            this.fechaInauguracion = fechaInauguracion;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.participantes = new ArrayList<EquipoParticipante>();            
            this.organizadores = new ArrayList<MiembroPUCP>();
    }    
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaInauguracion
     */
    public String getFechaInauguracion() {
        return fechaInauguracion;
    }

    /**
     * @param fechaInauguracion the fechaInauguracion to set
     */
    public void setFechaInauguracion(String fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the participantes
     */
    public ArrayList<EquipoParticipante> getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(EquipoParticipante participante) {
        this.participantes.add(participante);
    }

    /**
     * @return the organizadores
     */
    public ArrayList<MiembroPUCP> getOrganizadores() {
        return organizadores;
    }

    /**
     * @param organizadores the organizadores to set
     */
    public void setOrganizadores(ArrayList<MiembroPUCP> organizadores) {
        this.organizadores = organizadores;
    }
    
    public void AgregarOrganizador(MiembroPUCP objOrganizador)
    {
        this.organizadores.add(objOrganizador);
    }                       
    
    public void ObtenerRanking(){
        
        Collections.sort(participantes);        
        int counter = 1;
        for (EquipoParticipante participante : participantes) {
            if (counter > 5) break;
            System.out.println(counter + ".- " + participante.getTema()
                    + " " + participante.getPuntaje());
            counter++;
        }
    }
    
    public void VerParticipantes(){
        for (EquipoParticipante participante : participantes) {
            participante.Imprimir();
        }
    }
    
    public void PuntuarParticipantes(){
        int puntaje;
        System.out.println("ingreso correcto a equipoparticipante \n");///-----------------------------------------

        for (EquipoParticipante participante : participantes) {
            System.out.println("ingreso correcto al participante");
            participante.Imprimir();
            System.out.println("\tIngrese puntaje: ");
            puntaje = sce.nextInt();
            participante.setPuntaje(puntaje);
        }
    }
}
