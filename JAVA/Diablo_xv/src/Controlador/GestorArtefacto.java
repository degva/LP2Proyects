/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Random;
import Modelo.*;

import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
// import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gina
 */
public class GestorArtefacto {    
    private ArrayList<Artefacto> _artefactosDisponibles;
    
    public GestorArtefacto(){
        _artefactosDisponibles = new ArrayList<>();
        leerArtefactoDeArchivo("artefactos.xml");
    }
    
    public Artefacto ObtenerArtefacto(int x, int y, int numeroLaberinto){
        Random rnd = new Random();
        Artefacto art = null;
        int numArtefacto = rnd.nextInt(_artefactosDisponibles.size());//Devuelve el numero dle nombre dle artefacto
        art = _artefactosDisponibles.get(numArtefacto);
        art.SetPosX(x);
        art.SetPosY(y);
        return art;
    }
    
    public final void leerArtefactoDeArchivo(String archivoNombre) {
        try {
            XStream xs = new XStream();
            configureXStream(xs);
            FileReader fr = new FileReader(archivoNombre);
            _artefactosDisponibles = (ArrayList<Artefacto>)xs.fromXML(fr);
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void configureXStream(XStream xs) {
        xs.alias("Arma", Arma.class);
        xs.alias("Armadura", Armadura.class);
        xs.alias("ArregloArmasDisponibles", ArrayList.class);
    }
}
