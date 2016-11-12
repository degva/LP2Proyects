package Vista;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricioandres
 */
public class Render {
    
    // Algunas constantes
    private static final int ANCHO = 6;
    private static final int ALTO = 6;
    private int map_width = 0;
    
    public Render() {
        map_width = ANCHO*2 + 2;
    }
    
    /*
    TODO: 
        - Avatar: getNombre, getSaco()
        - Artefacto: toString() (?)
    */
    
    public List<String> ObtenerListaDatos(Avatar avatar) {
        List<String> datos = new ArrayList<>();
        datos.add("Nombre: " + avatar.getNombre());
        String vida = Integer.toString(avatar.getVidaActual()) + "/" + Integer.toString(avatar.getVidaMaxima());
        datos.add("Vida: " + vida);
        //datos.add("Arma: " + avatar.getArmaActual().toString());
        //datos.add("Armadura: " + avatar.getArmaduraActual().toString());
        datos.add("Cosillas: ");
        Saco saco_aux = avatar.getSaco();
        String aux;
        Artefacto item;
        if (saco_aux.getSize() != 0) {
            for (int i = 0; i < saco_aux.getSize(); i++) {
                aux = Integer.toString(i + 1) + ". ";
                item = saco_aux.getItem(i);
                // aux.concat(item.getNombre());
                String aux2 = item.toString();
                String aux3 = aux.concat(aux2);
                datos.add(aux3);
            }
        } else {
            datos.add("No tienes cosillas\t");
        }
        return datos;
    }
    
}
