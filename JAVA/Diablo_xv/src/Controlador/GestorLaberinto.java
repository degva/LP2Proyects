/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import Facilidades.Aliado;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gina
 */

public class GestorLaberinto {
    
    public static final int MAX_SIZE_LAB = 10;
    public static final int NRO_ARTEFACTOS = 10; // LUEGO SE VA A QUITAR, MIENTRAS TANTO... -----------------------------------------------------    
    
    public GestorLaberinto() {
    }
    
    public Laberinto CrearLaberinto(int numeroLaberinto){
        Random rnd = new Random();
        
        /*  Inicializamos el laberinto  */
        int aux_lololo = (int)(Math.random()*MAX_SIZE_LAB+5);
        int sizeM = 2*aux_lololo+1;
        int sizeN = sizeM;
        
        // creamos el arreglo de 2 dimensiones del laberinto
        Laberinto nuevoLaberinto = new Laberinto(sizeM, sizeN);
        //nuevoLaberinto.setPctEnemigo(rnd.nextFloat());
        
        /*Ahora generamos el laberinto*/
        
        //inicializamos todas las celdas como PARED
        for (int i = 0; i < nuevoLaberinto.getSizeM(); i++) {
            for (int j = 0; j < nuevoLaberinto.getSizeN(); j++) {
                nuevoLaberinto.SetTipoCelda(i, j, new Pared());
                nuevoLaberinto.setTipoContenido(i, j, null);
            }
        }
        
        
        for (int i = 1; i < nuevoLaberinto.getSizeM(); i+= 2) {
            for (int j = 1; j < nuevoLaberinto.getSizeN(); j+= 2) {
                nuevoLaberinto.SetTipoCelda(i, j, null);
            } 
        }
        
        
        // ****************
        //  Inicia el DFS 
        // ****************
        
        // creamos una pila
        Stack<IntPair> pilaCeldas = new Stack<>();
        // tomamos un valor random
        int x = rnd.nextInt(nuevoLaberinto.getSizeM()/4);
        // x y y son iguales siempre y "random"
        int rx = 2*x+1;
        int ry = rx;
        
        // marcamos celda como ADENTRO y la ponemos en la pila
        Pasadizo auxPasadizo = new Pasadizo();
        nuevoLaberinto.SetTipoCelda(rx, ry, auxPasadizo);
        pilaCeldas.push(new IntPair(rx,ry));
        
        IntPair aux, ady;
        
        while(!pilaCeldas.empty()) {
            // 3.1 tomamos la ultima apilada
            aux = pilaCeldas.peek();
            // 3.2 y 3.2.1 tomamos uno de los adjacentes aleatoriamente
            ady = devuelveRandomAdjacente(nuevoLaberinto, aux.x, aux.y, 2);
            
            // 3.3 si bota -1 entonces significa que no hay adyacentes. Entonces,
            // hacemos pop 
            if (ady.x == -1) {
                pilaCeldas.pop();
            } else {
                // 3.2.2 hacemos caminito
                int puente_x = ( aux.x + ady.x )/2;
                int puente_y = ( aux.y + ady.y )/2;
                nuevoLaberinto.SetTipoCelda(puente_x, puente_y, new Pasadizo());
                
                // 3.2.3 marcamos el adyacente como adentro tambien
                nuevoLaberinto.SetTipoCelda(ady.x, ady.y, new Pasadizo());
                
                // 3.2.4 apilamos v
                pilaCeldas.push(ady);                
            }
        }
        
        CrearListaEnemigos(nuevoLaberinto, numeroLaberinto);
        CrearListaArtefactos(nuevoLaberinto, numeroLaberinto);
        try {
            AgregarAliados(nuevoLaberinto, numeroLaberinto);
        } catch (IOException ex) {
            Logger.getLogger(GestorLaberinto.class.getName()).log(Level.SEVERE, null, ex);
        }
        AgregarAnteriorSiguiente(nuevoLaberinto);
        return nuevoLaberinto;
    }
    
    public void CrearListaArtefactos(Laberinto l, int numeroLaberitno) {
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();

        int artX, artY;
        GestorArtefacto gestorArt = new GestorArtefacto();
        
        for(int i=0; i< NRO_ARTEFACTOS; i++){
            //nodos impares
            //definimos las coordenadas donde van a estar los artefactos
            artX = (rnd.nextInt(maxX/2)*2 +1);
            artY = (rnd.nextInt(maxY/2)*2 +1);
            
            //verificamos que las cordenadas no esten ocupadas
            Celda auxCelda = new Celda(l.GetTipoCelda(artX, artY));
            auxCelda.SetContenido(l.getContenidoCelda(artX, artY));
            
            if(l.celdaVacia(artX, artY)){ //si la celda es del tipo pasadizo y esta vacia
                l.AgregarArtefacto(gestorArt.ObtenerArtefacto(artX, artY, numeroLaberitno));
            } else i--;
        }
    }
    
    public void CrearListaEnemigos(Laberinto l, int numeroLaberitno) {
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();
        
        //Hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        int nroEnemigos = Math.round((rnd.nextFloat()* maxX * maxY)/20);
        int eneX, eneY;
        GestorEnemigo gestorEne = new GestorEnemigo();
        
        for(int i=0; i< nroEnemigos; i++){
            eneX = (rnd.nextInt(maxX/2)*2 +1);
            eneY = (rnd.nextInt(maxY/2)*2 +1);
            
            if(l.celdaVacia(eneX, eneY)){ //si la celda es del tipo pasadizo y esta vacia
                l.AgregarEnemigo(gestorEne.CrearEnemigo(eneX, eneY, numeroLaberitno));
            } else 
                i--;
        } 
    }
    
    public void AgregarAliados(Laberinto l, int numeroLaberitno) throws IOException{
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();
        GestorAliado gestorAliados = new GestorAliado();
        int aliX, aliY;                
        
        for(int i=0; i< gestorAliados.listaAliados.size(); i++){
            //nodos impares
            aliX = (rnd.nextInt(maxX/2)*2 +1);
            aliY = (rnd.nextInt(maxY/2)*2 +1);
            
            //verificamos que las cordenadas no esten ocupadas
            Celda auxCelda = new Celda(l.GetTipoCelda(aliX, aliY));
            auxCelda.SetContenido(l.getContenidoCelda(aliX, aliY));
            
            if(l.celdaVacia(aliX, aliY)){ //si la celda es del tipo pasadizo y esta vacia
                //agregamos al aliado
                gestorAliados.listaAliados.get(i).SetPosX(aliX);
                gestorAliados.listaAliados.get(i).SetPosY(aliY);
                gestorAliados.listaAliados.get(i).SetNivel(numeroLaberitno);
                l.AgregarAliado(gestorAliados.listaAliados.get(i));
                l.getCelda(aliX,aliY).SetContenido(gestorAliados.listaAliados.get(i));
            } else i--;
        }
    }
    
    public synchronized void MoverEnemigos(Laberinto l, int avatarX, int avatarY) {
        Enemigo e; 
        IntPair nuevaPos;
        
        ArrayList<Enemigo> enemies = l.getListaEnemigos();
        int cantE = enemies.size();
        for (int z = 0; z < cantE; z++){
            e = enemies.get(z);
            int i = e.GetPosX();
            int j = e.GetPosY();
            if (EnemigoEsAdyacenteAlAvatar(i,j,avatarX,avatarY))
                continue;
            if (l.getContenidoCelda(i, j) instanceof Enemigo) {
                nuevaPos = devuelveRandomAdjacenteEnemigo(l, i, j, 1,avatarX, avatarY); // cambiar si molesta por adjpasadizo
                if (l.getCelda(nuevaPos.x, nuevaPos.y).GetTipo() instanceof Pasadizo
                        && (nuevaPos.x != avatarX || nuevaPos.y != avatarY)) {
                    //e = (Enemigo) l.getContenidoCelda(i, j);

                    e.Mover(nuevaPos.x - i, nuevaPos.y - j);
                    l.getCelda(nuevaPos.x, nuevaPos.y).SetContenido(e);
                    l.getCelda(i, j).SetContenido(null);
                }
            }
        }    
        
    }
    
    public synchronized void MoverArtefactos(Laberinto l, int avatarX, int avatarY) {
        Artefacto a; 
        IntPair nuevaPos;
        
        ArrayList<Artefacto> artefactos = l.getListaArtefactos();
        int cantA = artefactos.size();
        for (int z = 0; z < cantA; z++){
            a = artefactos.get(z);
            int i = a.GetPosX();
            int j = a.GetPosY();
            if (l.getContenidoCelda(i, j) instanceof Artefacto) {
                nuevaPos = devuelveRandomAdjacentePasadizo(l, i, j, 1);
                if (l.getCelda(nuevaPos.x, nuevaPos.y).GetTipo() instanceof Pasadizo
                        && (nuevaPos.x != avatarX || nuevaPos.y != avatarY)) {
                    
                    a.Mover(nuevaPos.x - i, nuevaPos.y - j);
                    l.getCelda(nuevaPos.x, nuevaPos.y).SetContenido(a);
                    l.getCelda(i, j).SetContenido(null);
                }
            }
        }   
    }
    
    ///MODIFICACION
    public synchronized void MoverAliado(Laberinto l) {
        Aliado e; 
        IntPair nuevaPos;
        
        for (int i = 0; i < l.getSizeM(); i++) {
            for (int j = 0; j < l.getSizeN(); j++) {
                if (l.getContenidoCelda(i, j) instanceof Aliado) {
                    nuevaPos = devuelveRandomAdjacentePasadizo(l, i, j, 1);
                    if (l.getCelda(nuevaPos.x, nuevaPos.y).GetTipo() instanceof Pasadizo) {
                        e = (Aliado) l.getContenidoCelda(i, j);
                        e.Mover(nuevaPos.x - i, nuevaPos.y - j);
                        l.getCelda(nuevaPos.x, nuevaPos.y).SetContenido(e);
                        l.getCelda(i, j).SetContenido(null);
                    }
                }
            }
        }
    }
    
    private IntPair ObtenerCuadrante(int eneX, int eneY, int avX, int avY){
        // posicion del avatar respecto al enemigo (posE-posA):
        //  si xCuadrante < 0, el avatar está a la derecha, si > 0, a la izquierda
        //  si yCuadrante < 0, el avatar está abajo, si > 0, arriba
        //  así, tendriamos:
        //      -> cuadrante 1 : (<0,>0)
        //      -> cuadrante 2 : (>0, >0)
        //      -> cuadrante 3 : (>0, <0)
        //      -> cuadrante 4 : (<0 , <0)
        int xCuadrante = eneX - avX;
        int yCuadrante = eneY - avY;
        IntPair cuadrante = new IntPair(xCuadrante, yCuadrante);
        return cuadrante;
    }
    
    private IntPair devuelveRandomAdjacenteEnemigo(Laberinto lab, int x, int y, int i, int avX, int avY) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        IntPair cuadrante = ObtenerCuadrante(x,y,avX,avY);
        //añadiremos nuevas condiciones para verificar el cuadrante correcto
        
        // checkeamos nodo a la derecha:
        if ((x > i) && (lab.getCelda(x + i, y).GetTipo() instanceof Pasadizo)
                && (cuadrante.x < 0) && (lab.getCelda(x + i, y).GetContenido() == null)) {
            IntPair pairR = new IntPair(x+i, y);
            posibles.add(pairR);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).GetTipo() instanceof Pasadizo)
                && (cuadrante.y > 0) && (lab.getCelda(x, y - i).GetContenido() == null)) {
            IntPair pairU = new IntPair(x, y-i);
            posibles.add(pairU);
        }
        
        // checkeamos nodo izquierda
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x - i, y).GetTipo() instanceof Pasadizo)
                && (cuadrante.x > 0) && (lab.getCelda(x - i, y).GetContenido() == null)) {
            IntPair pairL = new IntPair(x-i, y);
            posibles.add(pairL);
        }
        
        // checkeamos nodo abajo
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).GetTipo() instanceof Pasadizo)
                && (cuadrante.y < 0) && (lab.getCelda(x, y + i).GetContenido() == null)) {
            IntPair pairD = new IntPair(x, y+i);
            posibles.add(pairD);
        }
        
        // si no tiene, devolvemos (-1,-1)
        if (posibles.isEmpty()) {
            pair = devuelveRandomAdjacentePasadizo(lab, x, y, i);
        } else {
            // Hey, aqui creo que podria haber error. 
            // mi cerebro no me da para saber si en el caso hipotetico que me de
            // el tamano de la lista, me bote error por overflow() :v
            // Ej:
            // Digamos que posibles.size() me de 1. Entonces, el random sera o 0
            // o 1. Entonces, si sale 1, posibles.get es por las. O en todo caso
            // si sale 0, puede que posibles.get tambien sea por las... 
            // TODO: revisar documentación java :v
            pair = posibles.get(rnd.nextInt(posibles.size()));
        }
        
        return pair;
    }
    
    private boolean EnemigoEsAdyacenteAlAvatar(int eX, int eY, int aX, int aY){
        if (eX-1 == aX && eY == aY)
            return true;
        if (eX+1 == aX && eY == aY)
            return true;
        if (eY-1 == aY && eX == aX)
            return true;
        if (eY+1 == aY && eX == aX)
            return true;
        return false;
    }
    
    public synchronized IntPair devuelveRandomAdjacentePasadizo(Laberinto lab, int x, int y, int i) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la izq:
        if ((x > i) && (lab.getCelda(x - i, y).GetTipo() instanceof Pasadizo)
                && (lab.getCelda(x - i, y).GetContenido() == null)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).GetTipo() instanceof Pasadizo)
                && (lab.getCelda(x, y - i).GetContenido() == null)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo der
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x + i, y).GetTipo() instanceof Pasadizo)
                && (lab.getCelda(x + i, y).GetContenido() == null)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo abajo
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).GetTipo() instanceof Pasadizo)
                && (lab.getCelda(x, y + i).GetContenido() == null)) {
            pair = new IntPair(x, y + i);
            posibles.add(pair);
        }
        
        // si no tiene, devolvemos (0,0)
        if (posibles.isEmpty()) {
            pair = new IntPair(0,0);
        } else {
            pair = posibles.get(rnd.nextInt(posibles.size()));
        }
        
        return pair;
    }
    
    public IntPair devuelveRandomAdjacente(Laberinto lab, int x, int y, int i) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la derecha:
        if ((x > i) && (lab.getCelda(x - i, y).GetTipo() == null)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).GetTipo() == null)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x + i, y).GetTipo() == null)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).GetTipo() == null)) {
            pair = new IntPair(x, y + i);
            posibles.add(pair);
        }
        
        // si no tiene, devolvemos (-1,-1)
        if (posibles.isEmpty()) {
            pair = new IntPair(-1,-1);
        } else {
            // Hey, aqui creo que podria haber error. 
            // mi cerebro no me da para saber si en el caso hipotetico que me de
            // el tamano de la lista, me bote error por overflow() :v
            // Ej:
            // Digamos que posibles.size() me de 1. Entonces, el random sera o 0
            // o 1. Entonces, si sale 1, posibles.get es por las. O en todo caso
            // si sale 0, puede que posibles.get tambien sea por las... 
            // TODO: revisar documentación java :v
            pair = posibles.get(rnd.nextInt(posibles.size()));
        }
        
        return pair;
    }
    
    
    public void AgregarAnteriorSiguiente(Laberinto laberinto){
        int anterior,siguiente;
        int x,y;
        Random rnd = new Random();
                
        /*
        Metodo de asignacion de la celda anterior y siguiente:
        Se recorrera el laberinto, guardando las coordenadas de todas las celdas que esten
        marcadas como ADENTRO, luego generando un numero aleatorio se elegira uno de esos pares
        para anterior y otro para siguiente
        */
                
        ArrayList<IntPair> coords = new ArrayList<>();
        for (int i = 1; i < laberinto.getSizeM(); i++) {
            for (int j = 1; j < laberinto.getSizeN(); j++) {
                if (laberinto.getCelda(i, j).GetTipo() instanceof Pasadizo) {
                    coords.add(new IntPair(i,j));
                }
            }
        }

        do{
            anterior = rnd.nextInt(coords.size());
            siguiente = rnd.nextInt(coords.size()); 
        }while (anterior == siguiente); //evitando que se vaya al gg (con 0.0000001% de probabilidad)                 

        
        IntPair celdaAnterior = coords.get(anterior);
        laberinto.SetAnterior(celdaAnterior);
        laberinto.getCelda(celdaAnterior.x, celdaAnterior.y).SetContenido(new Anterior());

        IntPair celdaSiguiente = coords.get(siguiente);
        laberinto.SetSiguiente(celdaSiguiente);
        laberinto.getCelda(celdaSiguiente.x, celdaSiguiente.y).SetContenido(new Siguiente());            
    }
}
