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
        nuevoLaberinto.setPctEnemigo(rnd.nextFloat());
        
        /*Ahora generamos el laberinto*/
        
        //inicializamos todas las celdas como PARED
        
        for (int i = 0; i < nuevoLaberinto.getSizeM(); i++) {
            for (int j = 0; j < nuevoLaberinto.getSizeN(); j++) {
                nuevoLaberinto.setTipoCelda(i, j, new Pared());
                nuevoLaberinto.setTipoContenido(i, j, null);
            }
        }
        
        
        for (int i = 1; i < nuevoLaberinto.getSizeM(); i+= 2) {
            for (int j = 1; j < nuevoLaberinto.getSizeN(); j+= 2) {
                nuevoLaberinto.setTipoCelda(i, j, null);
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
        nuevoLaberinto.setTipoCelda(rx, ry, auxPasadizo);
        pilaCeldas.push(new IntPair(rx,ry));
        
        // algunos auxiliares para el while...
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
                nuevoLaberinto.setTipoCelda(puente_x, puente_y, new Pasadizo());
                
                // 3.2.3 marcamos el adyacente como adentro tambien
                nuevoLaberinto.setTipoCelda(ady.x, ady.y, new Pasadizo());
                
                // 3.2.4 apilamos v
                pilaCeldas.push(ady);                
            }
        }
        
        CrearListaEnemigos(nuevoLaberinto, numeroLaberinto);
        CrearListaArtefactos(nuevoLaberinto, numeroLaberinto);
        AgregarAliado(nuevoLaberinto, numeroLaberinto);
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
            Celda auxCelda = new Celda(l.getTipoCelda(artX, artY));
            auxCelda.setContenido(l.getContenidoCelda(artX, artY));
            
            if(l.celdaVacia(artX, artY)){ //si la celda es del tipo pasadizo y esta vacia
                //agregamos un nuevo artefacto
                l.agregarArtefacto(gestorArt.CrearArtefacto(artX, artY, numeroLaberitno));
            } else i--;
        }
    }
    
    public void CrearListaEnemigos(Laberinto l, int numeroLaberitno) {
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();
        
        //Hallar el nro de enemigos por mapa segun la probabilidad de que aparezca
        //La formula puede ir cambiando
        int nroEnemigos = Math.round((l.getPctEnemigo()* maxX * maxY)/20);
        int eneX, eneY;
        GestorEnemigo gestorEne = new GestorEnemigo();
        
        for(int i=0; i< nroEnemigos; i++){
            eneX = (rnd.nextInt(maxX/2)*2 +1);
            eneY = (rnd.nextInt(maxY/2)*2 +1);
            
            if(l.celdaVacia(eneX, eneY)){ //si la celda es del tipo pasadizo y esta vacia
                l.agregarEnemigo(gestorEne.CrearEnemigo(eneX, eneY, numeroLaberitno));
            } else i--;
        } 
    }
    
    public void AgregarAliado(Laberinto l, int numeroLaberitno){
        Random rnd = new Random();
        int maxX = l.getSizeM();
        int maxY = l.getSizeN();

        int aliX, aliY;                
        
        for(int i=0; i< 1; i++){
            //nodos impares
            aliX = (rnd.nextInt(maxX/2)*2 +1);
            aliY = (rnd.nextInt(maxY/2)*2 +1);
            
            //verificamos que las cordenadas no esten ocupadas
            Celda auxCelda = new Celda(l.getTipoCelda(aliX, aliY));
            auxCelda.setContenido(l.getContenidoCelda(aliX, aliY));
            
            if(l.celdaVacia(aliX, aliY)){ //si la celda es del tipo pasadizo y esta vacia
                //agregamos al aliado
                l.agregarAliado(new Aliado("Alditus",aliX,aliY,numeroLaberitno));
            } else i--;
        }
    }
    
    public void MoverEnemigos(Laberinto l) {
        Enemigo e; 
        IntPair nuevaPos;
        
        for (int i = 0; i < l.getSizeM(); i++) {
            for (int j = 0; j < l.getSizeN(); j++) {
                if (l.getContenidoCelda(i, j) instanceof Enemigo) {
                    nuevaPos = devuelveRandomAdjacenteEnemigo(l, i, j, 1);
                    if (l.getContenidoCelda(nuevaPos.x, nuevaPos.y) == null) {
                        e = (Enemigo) l.getContenidoCelda(i, j);
                        l.getCelda(i, j).setContenido(null);

                        e.Mover(nuevaPos.x - i, nuevaPos.y - j);
                        l.getCelda(nuevaPos.x, nuevaPos.y).setContenido(e);
                    }
                }
            }
        }
    }
    
    ///MODIFICACION
    public void MoverAliado(Laberinto l) {
        Aliado e; 
        IntPair nuevaPos;
        
        for (int i = 0; i < l.getSizeM(); i++) {
            for (int j = 0; j < l.getSizeN(); j++) {
                if (l.getContenidoCelda(i, j) instanceof Aliado) {
                    nuevaPos = devuelveRandomAdjacentePasadizo(l, i, j, 1);
                    if (l.getContenidoCelda(nuevaPos.x, nuevaPos.y) == null) {
                        e = (Aliado) l.getContenidoCelda(i, j);
                        l.getCelda(i, j).setContenido(null);

                        e.Mover(nuevaPos.x - i, nuevaPos.y - j);
                        l.getCelda(nuevaPos.x, nuevaPos.y).setContenido(e);
                    }
                }
            }
        }
    }
    
    private int ObtenerCuadrante(Laberinto lab){
        
        for (int i = 0; i < lab.getSizeM(); i++) 
            for (int j = 0; j < lab.getSizeN(); j++) {
                
            }
        return 0;
    }
    
    private IntPair devuelveRandomAdjacenteEnemigo(Laberinto lab, int x, int y, int i) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        int cuadrante = ObtenerCuadrante(lab);
        
        // checkeamos nodo a la derecha:
        if ((x > i) && (lab.getCelda(x - i, y).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x + i, y).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo abajo
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x, y + i);
            posibles.add(pair);
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
    
    
    public IntPair devuelveRandomAdjacentePasadizo(Laberinto lab, int x, int y, int i) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la derecha:
        if ((x > i) && (lab.getCelda(x - i, y).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x + i, y).getTipo() instanceof Pasadizo)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).getTipo() instanceof Pasadizo)) {
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
    
    public IntPair devuelveRandomAdjacente(Laberinto lab, int x, int y, int i) {

        Random rnd = new Random();
        
        IntPair pair;
        List<IntPair> posibles = new ArrayList<>();

        // checkeamos nodo a la derecha:
        if ((x > i) && (lab.getCelda(x - i, y).getTipo() == null)) {
            pair = new IntPair(x-i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo arriba
        if ((y > i) && (lab.getCelda(x, y - i).getTipo() == null)) {
            pair = new IntPair(x, y-i);
            posibles.add(pair);
        }
        
        // checkeamos nodo izquierda
        if ((x < lab.getSizeM() - i) && (lab.getCelda(x + i, y).getTipo() == null)) {
            pair = new IntPair(x+i, y);
            posibles.add(pair);
        }
        
        // checkeamos nodo derecha
        if ((y < lab.getSizeN() - i) && (lab.getCelda(x, y + i).getTipo() == null)) {
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
                    if (laberinto.getCelda(i, j).getTipo() instanceof Pasadizo) {
                        coords.add(new IntPair(i,j));
                    }
                }
            }

            do{
                anterior = rnd.nextInt(coords.size());
                siguiente = rnd.nextInt(coords.size()); 
            }while (anterior == siguiente); //evitando que se vaya al gg (con 0.0000001% de probabilidad)                 

            x = coords.get(anterior).x;
            y = coords.get(anterior).y;
            laberinto.getCelda(x, y).setContenido(new Anterior());

            x = coords.get(siguiente).x;
            y = coords.get(siguiente).y;
            laberinto.getCelda(x, y).setContenido(new Siguiente());            
    }
}
