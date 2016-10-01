/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DAVID
 */
public class GestorInteraccion {
    
    private GestorAvatar _gestorAvatar;
    
    public GestorInteraccion(){
        _gestorAvatar = new GestorAvatar();
    }
    
    public void interactuarEnemigo(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        //gg wp
        int vidaA, vidaE;
        Scanner consolaBatalla = new Scanner(System.in);
        Enemigo e = l.obtenerEnemigoActual(coordenadaInteraccion.x, coordenadaInteraccion.y);
        //Mini consola
        System.out.println("A pelear!");
        System.out.print("Enemigo: "); System.out.print(e.getNombre());        
        System.out.print(" Vida: "); System.out.print(e.getVidaActual());        
        System.out.print(" Ataque: "); System.out.print(e.getAtaque());        
        System.out.print("  Tu: "); System.out.print(a.getNombre());        
        System.out.print(" Vida: "); System.out.print(a.getVidaActual());        
        System.out.print(" Ataque: "); System.out.print(a.getArmaActual().getDano_max());        
        System.out.print("\n[atacar | huir | usar i]");
        System.out.print("\n - > ");
        //Batalla
        String comando = consolaBatalla.nextLine();
        OUTER:
        while(true){
            switch(comando){
                case "atacar":                    
                    vidaA = a.getVidaActual() - e.getAtaque();
                    vidaE = e.getVidaActual() - a.getArmaActual().getDano_max();
                    a.setVidaActual(vidaA);
                    e.setVidaActual(vidaE);
                    break;
                case "huir":
                    //Me muevo a la posicion de la interaccion para no chocar adyacentemente
                    a.setPosXY(coordenadaInteraccion);
                    break OUTER;
                case "usar i":
                    String[] usar = comando.split(" ");
                    int indexArtefactoElegido = Integer.parseInt(usar[1]);
                    if (indexArtefactoElegido > 0 && indexArtefactoElegido <= a.getSaco().getSize()){
                        Artefacto artefactoElegido = a.getSaco().getItem(indexArtefactoElegido-1);
                        if (artefactoElegido instanceof Arma)
                            a.setArmaActual((Arma)artefactoElegido);
                        else 
                            a.setArmaduraActual((Armadura) artefactoElegido);
                    }
                    
            }
            if (e.getVidaActual() <= 0) {
                System.out.println("Ganaste :v");
                break;
            }
            System.out.println("A pelear!");
            System.out.print("Enemigo: "); System.out.print(e.getNombre());        
            System.out.print(" Vida: "); System.out.print(e.getVidaActual());        
            System.out.print(" Ataque: "); System.out.print(e.getAtaque());        
            System.out.print("  Tu: "); System.out.print(a.getNombre());        
            System.out.print(" Vida: "); System.out.print(a.getVidaActual());        
            System.out.print(" Ataque: "); System.out.print(a.getArmaActual().getDano_max());

            System.out.print("\n[atacar | huir | usar i]");
            System.out.print("\n - > ");
            comando = consolaBatalla.nextLine();
        }
        l.retornarEnemigoActual(e);
    }
    
    public void interactuarArtefacto(Avatar a, Laberinto l, IntPair coordenadaInteraccion){
        Artefacto ar = l.obtenerArtefactoActual(coordenadaInteraccion.x, coordenadaInteraccion.y);
        _gestorAvatar.RecogerArtefacto(a, ar);
    }
    
}
