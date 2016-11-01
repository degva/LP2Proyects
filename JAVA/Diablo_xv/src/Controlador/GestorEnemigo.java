/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Random;
import com.thoughtworks.xstream.XStream;
import Modelo.*;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gina
 */
public class GestorEnemigo {
    private static final int NRO_ENEMIGOS = 15; //por ahora
    private ArrayList<Enemigo> _enemigosDisponibles;
    
    public GestorEnemigo(){
        _enemigosDisponibles = new ArrayList<>();
        leerEnemigoDeArchivo("enemigos.xml");
    }
    
    
    public Enemigo ObtenerEnemigo(int x, int y, int numeroLaberinto){
        Random rnd = new Random();
        Enemigo enem = null;
        int numEnemigo = rnd.nextInt(_enemigosDisponibles.size());
        enem = _enemigosDisponibles.get(numEnemigo); //obtenemos el enemigo
        //colocamos algunos atributos
        enem.setPosX(x);
        enem.setPosY(y);
        enem.setNivel(numeroLaberinto);
        /*la formula en estas funciones se puede cambiar*/
        /*
        vidaMaxima = nivel*10
        vidaactual = 0 y la vida maxima
        ataque = numero random entre uno y 10 * nivel
        */
        enem.setVidaMaxima(numeroLaberinto*10); 
        enem.setVidaActual(rnd.nextInt(numeroLaberinto*10));
        enem.setAtaque((rnd.nextInt(9)+1)*numeroLaberinto);
        return enem;
    }
           
    public final void leerEnemigoDeArchivo(String archivoNombre){
        try {
            XStream xs = new XStream();
            configureXStream(xs);
            
            FileReader fr = new FileReader(archivoNombre);
            _enemigosDisponibles = (ArrayList<Enemigo>)xs.fromXML(fr);
            fr.close();
        } catch (IOException e) {
             System.out.println(e.toString());
        }
        
    }
    
    private static void configureXStream(XStream xs) {
        xs.alias("Enemigo", Enemigo.class);
        xs.alias("ArregloEnemigosDisponibles", ArrayList.class);
    }
    
    

    
}
