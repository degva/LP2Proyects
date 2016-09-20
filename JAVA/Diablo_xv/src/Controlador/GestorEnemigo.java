/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Random;
import Modelo.*;

/**
 *
 * @author Gina
 */
public class GestorEnemigo {
    private static final int NRO_ENEMIGOS = 15; //por ahora
    private ArrayList<String> _enemigosDisponibles;
    
    public GestorEnemigo(){
        _enemigosDisponibles.add("Enemigo 1");
        _enemigosDisponibles.add("Enemigo 2");
        _enemigosDisponibles.add("Enemigo 3");
        _enemigosDisponibles.add("Enemigo 4");
        _enemigosDisponibles.add("Enemigo 5");
        _enemigosDisponibles.add("Enemigo 6");
        _enemigosDisponibles.add("Enemigo 7");
        _enemigosDisponibles.add("Enemigo 8");
        _enemigosDisponibles.add("Enemigo 9");
        _enemigosDisponibles.add("Enemigo 10");
        _enemigosDisponibles.add("Enemigo 11");
        _enemigosDisponibles.add("Enemigo 12");
        _enemigosDisponibles.add("Enemigo 13");
        _enemigosDisponibles.add("Enemigo 14");
        _enemigosDisponibles.add("Enemigo 15");
    }
    
    public Enemigo CrearEnemigo(int x, int y, int numeroLaberinto){
        Random rnd = new Random();
        int numeroEnemigo = rnd.nextInt(NRO_ENEMIGOS);//Devuelve el numero de nombre del enemigo
        
        
        
        
    }
    
/*    
    public Artefacto CrearArtefacto(int x, int y, int numeroLaberinto){
        Random rnd = new Random();
        
        int tipoArtefacto = rnd.nextInt(2);//0=ARMA | 1=ARMADURA
        int numeroArtefcato = rnd.nextInt(NRO_ARTEFACTOS);//Devuelve el numero dle nombre dle artefacto
        
        //declaramos los atributos comunes a ambos
        String nombre;     
        switch(tipoArtefacto){
            case 0: //creamos un arma
                int danoMin = rnd.nextInt(numeroLaberinto)+numeroLaberinto;
                int danoMax = rnd.nextInt(2*numeroLaberinto)+numeroLaberinto;
                nombre =  _armasDisponibles.get(numeroArtefcato);
                
                Arma nuevaArma = new Arma(nombre, x, y, danoMin, danoMax);
                return nuevaArma;
            case 1: //creamos un armadura
                int defensa = rnd.nextInt(2*numeroLaberinto)+numeroLaberinto;
                nombre = _armadurasDisponibles.get(numeroArtefcato);
                
                Armadura nuevaArmadura = new Armadura(nombre, x, y, defensa);
                return nuevaArmadura;
        }
        
        return null; 
    }
*/
    
}
