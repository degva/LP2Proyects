/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infosoft;

import Controlador.GestorEventos;
import Modelo.*;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorEventos objGestorEventos = new GestorEventos();
        int opcion, codigo, cantidad, tipo;
        String nombre, fechaInauguracion, fechaInicio, fechaFin;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema INFOSOFT");
        System.out.println("1.- Agregar un Evento");
        System.out.println("2.- Visualizar Participantes de un Evento");
        System.out.print("Ingrese su opcion: ");
        opcion = sc.nextInt();
        switch (opcion)
        {
            case 1: {
                System.out.println("Ingrese datos del evento");
                System.out.print("Codigo: ");
                codigo = sc.nextInt();
                System.out.print("Nombre: ");
                nombre = sc.next();
                System.out.print("Fecha Inauguracion: ");
                fechaInauguracion = sc.next();
                System.out.print("Fecha Inicio: ");
                fechaInicio = sc.next();
                System.out.print("Fecha Fin: ");
                fechaFin = sc.next();
                Evento objEvento = new Evento(codigo,nombre,fechaInauguracion,fechaInicio,fechaFin);
                System.out.println("Ingrese datos de los Organizadores");
                System.out.print("Cantidad de Organizadores: ");
                cantidad = sc.nextInt();
                for (int i=0; i<cantidad; i++)
                {
                    System.out.print("Tipo MiembroPucp (1-Docente, 2-Alumno, 3-Administrativo): ");
                    tipo = sc.nextInt();
                    //Trabajador objDocente=new Trabajador(20010206,42225066,"David Allasi","09/08/1986","dallasi@pucp.edu.pe",1,"Coordinador Docente","Dirigir","Informatica","Titulado",0,0,1);
                    System.out.println("Ingrese datos del organizador:");
                    objEvento.AgregarOrganizador(tipo);
                }
                objGestorEventos.AgregarEvento(objEvento);
                break;
            }
        }
    }    
}
