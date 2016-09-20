/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Enemigo;
import java.util.ArrayList;
import Modelo.*;
import Modelo.Celda;
import Modelo.Enemigo;
import Modelo.Laberinto;

/**
 *
 * @author Gina
 */
public class GestorArtefacto {
    private ArrayList<String> _armasDisponibles; //arreglo con las armas que se pueden agregar al laberinto
    private ArrayList<String> _armadurasDisponibles; //arreglo con las armaduras que se pueden agregar al laberinto 
    
    public GestorArtefacto(){
        //Creamos varios tipos de armas y los agregamos
        _armasDisponibles.add("Arma tipo 1");
        _armasDisponibles.add("Arma tipo 2");
        _armasDisponibles.add("Arma tipo 3");
        _armasDisponibles.add("Arma tipo 4");
        _armasDisponibles.add("Arma tipo 5");
        _armasDisponibles.add("Arma tipo 6");
        _armasDisponibles.add("Arma tipo 7");
        _armasDisponibles.add("Arma tipo 8");
        _armasDisponibles.add("Arma tipo 9");
        _armasDisponibles.add("Arma tipo 10");
        _armasDisponibles.add("Arma tipo 11");
        _armasDisponibles.add("Arma tipo 12");
        _armasDisponibles.add("Arma tipo 13");
        _armasDisponibles.add("Arma tipo 14");
        _armasDisponibles.add("Arma tipo 15");
        
        //Creamos varios tipos de arma sy los agregamos
        _armadurasDisponibles.add("Armadura tipo 1");
        _armadurasDisponibles.add("Armadura tipo 2");
        _armadurasDisponibles.add("Armadura tipo 3");
        _armadurasDisponibles.add("Armadura tipo 4");
        _armadurasDisponibles.add("Armadura tipo 5");
        _armadurasDisponibles.add("Armadura tipo 6");
        _armadurasDisponibles.add("Armadura tipo 7");
        _armadurasDisponibles.add("Armadura tipo 8");
        _armadurasDisponibles.add("Armadura tipo 9");
        _armadurasDisponibles.add("Armadura tipo 10");
        _armadurasDisponibles.add("Armadura tipo 11");
        _armadurasDisponibles.add("Armadura tipo 12");
        _armadurasDisponibles.add("Armadura tipo 13");
        _armadurasDisponibles.add("Armadura tipo 14");
        _armadurasDisponibles.add("Armadura tipo 15"); 
    }
    
}
