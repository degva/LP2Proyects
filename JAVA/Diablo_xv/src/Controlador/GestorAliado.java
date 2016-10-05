/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import Facilidades.*;
import Modelo.Laberinto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alulab14
 */
public class GestorAliado {
    
    ArrayList<Aliado> listaAliados;
    
    public GestorAliado() throws IOException {
        listaAliados = new ArrayList<>();
        CargarListaDeAliados();
    }
    
    private void CargarListaDeAliados() throws IOException{
        String linea, nombreAliado, consejo;
        String[] s1,s2,s3,s4,s5, s6, consejoStr;
        RandomAccessFile readerAliados = new RandomAccessFile("aliados.txt", "r");
        linea = readerAliados.readLine();
        s1 = linea.split(":");
        int numeroDeAliados = Integer.parseInt(s1[1]);
        int numeroDeConsejos, nivelConsejo;
        for(int i=0; i < numeroDeAliados; i++){
            linea = readerAliados.readLine();
            s1 = linea.split(" ");
            s2 = s1[1].split(":");
            s3 = s2[1].split("/");
            nombreAliado = s3[0];
            s4 = s3[1].split(":");
            s5 = s4[1].split("@");
            numeroDeConsejos = Integer.parseInt(s5[0]);
            Aliado nuevoAliado = new Aliado(nombreAliado, 0, 0, 0);
            for (int j=0; j< numeroDeConsejos-1; j++){
                s6 = s5[1].split("@");
                consejoStr =  s6[0].split(".");
                consejo = consejoStr[0];
                nivelConsejo = Integer.parseInt(consejoStr[1]);                
                Consejo nuevoConsejo = new Consejo(consejo, nivelConsejo);
                nuevoAliado.AnadirConsejo(nuevoConsejo);
                s5 = s4[1].split("@");
            }
            consejoStr = s5[1].split(".");
            consejo = consejoStr[0];
            nivelConsejo = Integer.parseInt(consejoStr[1]);                
            Consejo nuevoConsejo = new Consejo(consejo, nivelConsejo);
            nuevoAliado.AnadirConsejo(nuevoConsejo);
            listaAliados.add(nuevoAliado);         
        }
        
    }
}
