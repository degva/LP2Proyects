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
    
    
    public Enemigo CrearEnemigo(int x, int y, int numeroLaberinto){
        Random rnd = new Random();
        Enemigo nuevoEne = new Enemigo(null, 1, 1, 1);
        int numEnemigo = rnd.nextInt(_enemigosDisponibles.size());
        nuevoEne.SetNombre(_enemigosDisponibles.get(numEnemigo).GetNombre()); //obtenemos el enemigo
        //colocamos algunos atributos
        nuevoEne.SetPosX(x);
        nuevoEne.SetPosY(y);
        nuevoEne.SetNivel(numeroLaberinto);
        /*la formula en estas funciones se puede cambiar*/
        /*
        vidaMaxima = nivel*10
        vidaactual = 0 y la vida maxima
        ataque = numero random entre uno y 10 * nivel
        */
        nuevoEne.SetVidaMaxima(numeroLaberinto*10); 
        nuevoEne.SetVidaActual(rnd.nextInt(numeroLaberinto*10));
        nuevoEne.SetAtaque((rnd.nextInt(9)+1)*numeroLaberinto);
        return nuevoEne;
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
