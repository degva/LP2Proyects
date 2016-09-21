/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.util.Scanner;
import Modelo.IntPair;

/**
 *
 * @author wperezp
 */
public class Consola {
    
    public final Scanner consoleScanner;   
    
    public Consola(){
        consoleScanner = new Scanner(System.in);
    }
    
    public void MostrarMenu(){
        System.out.println("\n");
        System.out.println("Escriba una accion:");
        System.out.println("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):" );
        System.out.println("> [interactuar]");
        System.out.println("> [cambiar arma]");
        System.out.println("> [cambiar armadura]");
        System.out.print("> [salir]\n\n - > " );
    }
    
    public IntPair ObtenerDesplazamiento(String x){
        IntPair desplazamiento = null;
        switch(x){
            case "w":
            case "mover arriba":
                desplazamiento = new IntPair(0, -1);
                break;
            case "a":
            case "mover izquierda":
                desplazamiento = new IntPair(-1, 0);
                break;
            case "s":
            case "mover abajo":
                desplazamiento = new IntPair(0, 1);
                break;
            case "d":
            case "mover derecha":
                desplazamiento = new IntPair(1, 0);
                break;
        }

        return desplazamiento;
    }
    
    //public void Interactuar()
}

