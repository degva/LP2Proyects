/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class EquipoParticipante implements Comparable<EquipoParticipante>{
    private String tema;
    private String fechaParticipacion;
    private int horaParticipacion;
    private String nombreArchivo;
    private double puntaje;
    
    public EquipoParticipante (String tema, String fechaParticipacion, int horaParticipacion, String nombreArchivo)
    {
        this.tema = tema;
        this.fechaParticipacion = fechaParticipacion;
        this.horaParticipacion = horaParticipacion;
        this.nombreArchivo = nombreArchivo;       
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the fechaParticipacion
     */
    public String getFechaParticipacion() {
        return fechaParticipacion;
    }

    /**
     * @param fechaParticipacion the fechaParticipacion to set
     */
    public void setFechaParticipacion(String fechaParticipacion) {
        this.fechaParticipacion = fechaParticipacion;
    }

    /**
     * @return the horaParticipacion
     */
    public int getHoraParticipacion() {
        return horaParticipacion;
    }

    /**
     * @param horaParticipacion the horaParticipacion to set
     */
    public void setHoraParticipacion(int horaParticipacion) {
        this.horaParticipacion = horaParticipacion;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
 
    public String getNombresParticipantes()
    {
        return null;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public int compareTo(EquipoParticipante equipo) {
        if (this.puntaje > equipo.getPuntaje())
            return 1;
        else if (this.puntaje == equipo.getPuntaje())
            return 0;
        else
            return -1;
    }
    
    public void Imprimir(){
        System.out.println("Equipo tema " + this.tema + "\n");
    }
}
