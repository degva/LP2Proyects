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
public class MiembroPUCP {
    private long codigoPUCP;
    private long dni;
    private String correo;
    private String fechaNacimiento;
    private int tipoOrganizador;
    private String cargo;
    private String responsabilidades;
    private String nombre;
    
    public MiembroPUCP(long codPUCP, long dni, String nombre, String correo, String fechaNac, int tipoOrganizador, String cargo, String responsabilidades)
    {
            this.codigoPUCP = codPUCP;
            this.dni = dni;
            this.nombre = nombre;
            this.correo = correo;
            this.fechaNacimiento = fechaNac;
            this.tipoOrganizador = tipoOrganizador;
            this.cargo = cargo;
            this.responsabilidades = responsabilidades;
    }
    
    /**
     * @return the codigoPUCP
     */
    public long getCodigoPUCP() {
        return codigoPUCP;
    }

    /**
     * @param codigoPUCP the codigoPUCP to set
     */
    public void setCodigoPUCP(long codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    /**
     * @return the dni
     */
    public long getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(long dni) {
        this.dni = dni;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the tipoOrganizador
     */
    public int getTipoOrganizador() {
        return tipoOrganizador;
    }

    /**
     * @param tipoOrganizador the tipoOrganizador to set
     */
    public void setTipoOrganizador(int tipoOrganizador) {
        this.tipoOrganizador = tipoOrganizador;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the responsabilidades
     */
    public String getResponsabilidades() {
        return responsabilidades;
    }

    /**
     * @param responsabilidades the responsabilidades to set
     */
    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
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
    
    
}
