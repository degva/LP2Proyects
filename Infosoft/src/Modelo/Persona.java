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
public class Persona {
    private long dni;
    private String nombre;

    public Persona (long dni, String nombre)
    {
            this.dni = dni;
            this.nombre = nombre;
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
