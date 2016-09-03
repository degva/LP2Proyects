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
        while(true){
            System.out.println("Bienvenido al sistema INFOSOFT");
            System.out.println("1.- Agregar un Evento");
            if (objGestorEventos.TotalDeEventos()!=0){
                System.out.println("2.- Visualizar Participantes de un Evento");
                System.out.println("3.- Asignar Puntajes a los equipos de un evento");
                System.out.println("4.- Mostrar rankings de un evento");
                System.out.print("Ingrese su opcion: ");
            }            
            opcion = sc.nextInt();
            if (objGestorEventos.TotalDeEventos()==0){
                while(opcion != 1){
                    System.out.println("Opcion no valida");
                    opcion = sc.nextInt();
                }
            }
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
                    for (int i=0; i<cantidad; i++){
                        System.out.print("Tipo MiembroPucp (1-Docente, 2-Alumno, 3-Administrativo): ");
                        tipo = sc.nextInt();
                        //Trabajador objDocente=new Trabajador(20010206,42225066,"David Allasi","09/08/1986","dallasi@pucp.edu.pe",1,"Coordinador Docente","Dirigir","Informatica","Titulado",0,0,1);
                        System.out.println("Ingrese datos del organizador:");
                        objEvento.AgregarOrganizador(tipo);
                    }
                    System.out.println("Ingrese datos del equipo");
                    //System.out.print("Cantidad de participantes: ");
                    //cantidad = sc.nextInt();               
                    //for (int i = 0; i < cantidad; i++) {
                        System.out.println("Tipo Equipo (1-EquipoPucp, 2-Equipo Externo)");
                        tipo = sc.nextInt();
                        if (tipo == 1){
                            System.out.println("Equipo creado!");
                            ParticipantePUCP equipo = new ParticipantePUCP("Hora sad", "12/12/12", 1600,"Prros.txt");
                            System.out.println("Creando participantes...");
                            Trabajador doc1 = new Trabajador(20010206,42225066,"David Allasi","09/08/1986","dallasi@pucp.edu.pe",0,"Docente","Dirigir","Informatica","Titulado",0,0,1);                            
                            equipo.setMiembro(doc1);
                            Alumno alum1 = new Alumno(20131411,72365323,"Fabricio","fmonsalve@pucp.pe","21/11/1995",0,"Alumno","Exponer",56.26,1);         
                            equipo.setMiembro(alum1);
                            Trabajador doc2 = new Trabajador(20010200,42225066,"David Allasi","09/08/1986","dallasi@pucp.edu.pe",0,"Docente","Dirigir","Informatica","Titulado",0,0,1);
                            equipo.setMiembro(doc2);
                            Alumno alum2 = new Alumno(20131406,72365323,"Fabricio","fmonsalve@pucp.pe","21/11/1995",0,"Alumno","Exponer",56.26,1);
                            equipo.setMiembro(alum2);
                            System.out.println("Agregando participantes...");                            
                        }else if (tipo == 2){                        
                        }
                    //}

                    objGestorEventos.AgregarEvento(objEvento);
                    break;
                }
                case 2:{ //Visualizar particpantes del evento
                    System.out.print("Ingrese el codigo del evento: ");
                    codigo = sc.nextInt();
                    objGestorEventos.VizualizarEquiposParticipantes(codigo);
                }
                case 3:{
                    System.out.print("Ingrese el codigo del evento: ");
                    codigo = sc.nextInt();

                    Evento objEvento = objGestorEventos.ObtenerEvento(codigo);
                    ArrayList<EquipoParticipante> participantes = objEvento.getParticipantes();

                    for (EquipoParticipante participante : participantes) {
                        int puntaje;
                        participante.Imprimir();
                        System.out.println("\tIngrese puntaje: ");
                        puntaje = sc.nextInt();
                        participante.setPuntaje(puntaje);
                    }
                }
                objGestorEventos.AgregarEvento(objEvento);
                break;
            }
        }
    }    
}
