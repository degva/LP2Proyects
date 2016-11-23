/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import Facilidades.*;
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
    
    public GestorAliado() {
        listaAliados = new ArrayList<>();
        CargarListaDeAliados();
    }
    
    private void CargarListaDeAliados() {
        String linea = "", nombreAliado, consejo;
        String[] s1,s2,s3,s4,s5, s6, consejoStr;
        RandomAccessFile readerAliados = null;
        try {
            readerAliados = new RandomAccessFile("aliados.txt", "r");
            linea = readerAliados.readLine();
        } catch (Exception ex) {
            Logger.getLogger(GestorAliado.class.getName()).log(Level.SEVERE, null, ex);
        }
        s1 = linea.split(":");
        int numeroDeAliados = Integer.parseInt(s1[1]);
        int numeroDeConsejos, nivelConsejo;
        for(int i=0; i < numeroDeAliados; i++){
            try {
                linea = readerAliados.readLine();
            } catch (IOException ex) {
                Logger.getLogger(GestorAliado.class.getName()).log(Level.SEVERE, null, ex);
            }
            s1 = linea.split("/");
            s2 = s1[0].split(":");
            nombreAliado = s2[1];
            s3 = s1[1].split(":");
            s4 = s3[1].split("@");
            numeroDeConsejos = Integer.parseInt(s4[0]);
            Aliado nuevoAliado = new Aliado(nombreAliado, 0, 0, 0);
            for (int j=1; j<=numeroDeConsejos; j++){
                consejoStr =  s4[j].split("\\.");
                consejo = consejoStr[0];
                nivelConsejo = Integer.parseInt(consejoStr[1]);                
                Consejo nuevoConsejo = new Consejo(consejo, nivelConsejo);
                nuevoAliado.AnadirConsejo(nuevoConsejo);
            }
            listaAliados.add(nuevoAliado);
        }
        
    }
}
