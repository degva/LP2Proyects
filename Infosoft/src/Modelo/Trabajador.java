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
public class Trabajador extends MiembroPUCP{
    private String especialidad;
    private String grado;
    private int horaEntrada;
    private int horaSalida;
    private int tipoTrabajador;
    
    public Trabajador (long codPUCP, long dni, String nombre, String correo, String fechaNac, int tipoOrganizador, String cargo, String responsabilidades, String especialidad, String grado, int horaEntrada, int horaSalida, int tipoTrabajador)
    {
        super(codPUCP, dni, nombre, correo, fechaNac, tipoOrganizador, cargo, responsabilidades);
        this.especialidad = especialidad;
        this.grado = grado;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoTrabajador = tipoTrabajador;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the horaEntrada
     */
    public int getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the horaSalida
     */
    public int getHoraSalida() {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * @return the tipoTrabajador
     */
    public int getTipoTrabajador() {
        return tipoTrabajador;
    }

    /**
     * @param tipoTrabajador the tipoTrabajador to set
     */
    public void setTipoTrabajador(int tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }
    
    
}
