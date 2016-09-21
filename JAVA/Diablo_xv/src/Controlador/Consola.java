/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Artefacto;
import java.util.Scanner;
import Modelo.IntPair;
import Modelo.Enemigo;

/**
 *
 * @author wperezp
 */
public class Consola {
    
    private final Scanner consoleScanner;
    private String log; //Dará mensajes del juego y de error
    
    public Consola(){
        consoleScanner = new Scanner(System.in);
        log = "";
    }
    
    public void MostrarMenu(){
        if(!log.isEmpty())
            System.out.println(log);
        System.out.println("\n");
        System.out.println("Escriba una accion:");
        System.out.println("> [mover 'x'] (siendo x: arriba, abajo, derecha, izquierda):" );
        System.out.println("> [interactuar 'x'] (siendo x: arriba, abajo, derecha, izquierda): ");
        System.out.print("> [salir]\n\n - > " );
    }
    
    public String[] ObtenerComando(){
        String input = consoleScanner.nextLine();
        String[] inputSplit = input.split(" ");
        while(true){
            switch(inputSplit[0]){
                case "w":
                case "a":
                case "s":
                case "d":
                    return inputSplit;
                case "interactuar":
                    switch(inputSplit[1]){
                        case "arriba":
                        case "abajo":
                        case "izquierda":
                        case "derecha":
                            return inputSplit;
                        default:
                            break;
                    }
                case "salir":
                    return inputSplit;
                        
            }
            System.out.println("Comando invalido");
            System.out.print("- > ");
            input = consoleScanner.nextLine();
            inputSplit = input.split(" ");
        }
    }
    
    public void MostrarEnemigo(Enemigo enemigo){
        System.out.println("Estas sobre un enemigo");
        System.out.print("Enemigo: ");
        System.out.print(enemigo.getNombre());
        System.out.print(" Vida: ");
        System.out.print(enemigo.getVidaActual());
        System.out.print(" Ataque: ");
        System.out.println(enemigo.getAtaque());
    }
    
    public void MostrarArtefacto(Artefacto artefacto){
        System.out.println("Estas sobre un artefacto");
        System.out.print("Artefacto: ");
        System.out.print(artefacto.getNombre());
    }
    
    public void SetLog(String message){
        log = message;
    }
    
    public void ClearLog(){
        log = "";
    }
}

