/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
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
    public void setParticipantes(ArrayList<EquipoParticipante> participantes) {
        this.participantes = participantes;
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
    
    public void AgregarOrganizador(int tipo)
    {
        Scanner sc = new Scanner(System.in);
        
        long codigoPUCP,dni;
        String correo,fechaN;
        //int tipoOrganizador = 1;
        String cargo, resp, nom;
        System.out.print(" - Nombre: ");
        nom = sc.next();
        System.out.print(" - DNI: ");
        dni = sc.nextLong();
        System.out.print(" - Codigo PUCP: ");
        codigoPUCP = sc.nextLong();
        System.out.print(" - Correo: ");
        correo = sc.next();
        System.out.print(" - Fecha de Nacimiento: ");
        fechaN = sc.next();
        System.out.print(" - Cargo: ");
        cargo = sc.next();
        System.out.print(" - Responsabilidad: ");
        resp = sc.next();
        
        switch (tipo){
            case 1:
            case 3:
                String espec, grado;
                int horaEnt, horaSal;
                // tipo trabajador es 1 (docente), 2 (administrativo)
                System.out.print(" - Especialidad: ");
                espec = sc.next();
                System.out.print(" - Grado: ");
                grado = sc.next();
                System.out.print(" - Hora de entrada: ");
                horaEnt = sc.nextInt();
                System.out.print(" - Hora de salida: ");
                horaSal = sc.nextInt();
                if (tipo == 1){
                    Trabajador docente = new Trabajador (codigoPUCP,dni,nom,fechaN,correo,1,cargo,resp,espec,grado,horaEnt,horaSal,1);
                    this.organizadores.add(docente);
                }else{
                    Trabajador administrador = new Trabajador (codigoPUCP,dni,nom,fechaN,correo,1,cargo,resp,espec,grado,horaEnt,horaSal,2);
                    this.organizadores.add(administrador);
                }
                break;
                
            case 2:{
                int nivel;
                double craest;
                System.out.print(" - Nivel: ");
                nivel = sc.nextInt();
                System.out.print(" - Craest: ");
                craest = sc.nextDouble();
                Alumno alumno = new Alumno (codigoPUCP,dni,nom,fechaN,correo,1,cargo,resp,craest,nivel);
                this.organizadores.add(alumno);
                break;}
                
        }
        
        


        //Trabajador objDocente=new Trabajador(20010206,42225066,"David Allasi","09/08/1986","dallasi@pucp.edu.pe",1,"Coordinador Docente","Dirigir","Informatica","Titulado",0,0,1);
                    
        //this.organizadores.add(objOrganizador);
    }    
}
