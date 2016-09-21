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
        _enemigosDisponibles = new ArrayList<>();
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
        
        //Datos
        String nombre = _enemigosDisponibles.get(numeroEnemigo);
        Enemigo nuevoEnemigo = new Enemigo(nombre, x, y, numeroLaberinto);
        return nuevoEnemigo;
    }
    

    
}
