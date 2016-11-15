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
public class Alumno extends MiembroPUCP
{
    private double craest;
    private int nivel;
    
    public Alumno (long codPUCP, long dni, String nombre, String correo, String fechaNac, int tipoOrganizador, String cargo, String responsabilidades, double craest, int nivel)			
    {
        super(codPUCP, dni, nombre, correo, fechaNac, tipoOrganizador, cargo, responsabilidades);
        this.craest = craest;
        this.nivel = nivel;
    }

    /**
     * @return the craest
     */
    public double getCraest() {
        return craest;
    }

    /**
     * @param craest the craest to set
     */
    public void setCraest(double craest) {
        this.craest = craest;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
