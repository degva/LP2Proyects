package Vista;

import Modelo.*;
import com.thoughtworks.xstream.converters.Converter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import Controlador.*;

/**
 *
 * @author fabricioandres
 */
public class Render {
    
    // Algunas constantes
    private static final int ANCHO = 6;
    private static final int ALTO = 6;
    private int map_width = 0;
    private MapPanel mapPanel;
    private InfoPanel infoPanel;
    BufferedImage chipset;
    HashMap<String, BufferedImage> imgs;
    
    public Render(MapPanel mapPanel, InfoPanel infoPanel) {
        map_width = ANCHO*2 + 2;
        this.mapPanel = mapPanel;
        this.infoPanel = infoPanel;
        try {
            chipset = ImageIO.read(new File("rm2k3_mario_chipset_by_tiguidou.png"));
        } catch (IOException ex) {
            Logger.getLogger(Render.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgs = new HashMap<>();
        inicializarHashMap();
    }
    
    
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
    
    /**
     * Renderiza solo una celda
     * @param avatar
     * @param lab
     * @param x
     * @param y 
     */
    public void RenderCell(Avatar avatar, Laberinto lab, int x, int y) {
        Celda aux;
        ObjetoGrafico tipo, contenido;
        Graphics g = mapPanel.getGraphics();
        if (x<0 || y<0) {
            g.drawImage(imgs.get("nada"), x, y, mapPanel);
        }else if ((x > lab.getSizeM()-1) || (y > lab.getSizeN()-1)){
            System.out.print('.');
        } else {
            aux = lab.getCelda(x, y);
            tipo = aux.getTipo();            
            if (tipo instanceof Pasadizo){ 
                if (aux.getContenido()!= null)
                    g.drawImage(imgs.get("pasadizo"), x, y, mapPanel);
                else System.out.print(" ");
            }else if(tipo instanceof Pared) {
                g.drawImage(imgs.get("pared"), x, y, mapPanel);
            }
        }
    }
    
    
    //Clearscreen borrado 
    
    
    /**
     * 
     * Muestra: nombre, vida, arma, armadura y elementos que tiene el saco (con
     * indice diferenciado.
     * Ademas: muestra en que laberinto esta.
     * @param nivel
     * @param lab
     * @param avatar
     * @return -1 si avatar esta en ANTERIOR, 1 si avatar esta en SIGUIENTE, si no return = 0
     */
    public void Render(Avatar avatar,Laberinto lab, int nivel) {        
        List<String> listaDatos = ObtenerListaDatos(avatar);
        int state = 0;
        // imprimimos el nivel del mapa
        //System.out.println(">> NIVEL " + (nivel+1) + " " + lab.getSizeM() + "-" + lab.getSizeN());
        
        // Imprimir
        actualizarLaberinto(avatar, lab, nivel);
        actualizarInfo(listaDatos);
    }
    
    
    private void actualizarLaberinto(Avatar avatar,Laberinto lab, int nivel){
        Graphics g = mapPanel.getGraphics();
        for (int i = avatar.getPosY() - ALTO, x=0; i <= avatar.getPosY() + ALTO; i++, x+=16) {
            for (int j = avatar.getPosX() - ANCHO, y=0; j <= avatar.getPosX() + ANCHO; j++, y+=16) {
                if (i == avatar.getPosY() && j == avatar.getPosX()) { //si es la posicion en la que esta el avatar
                    //avatar.Dibujar();
                    g.drawImage(imgs.get("avatar"), x, y, mapPanel);
                } else {
                    RenderCell(avatar, lab, j, i);
                }
            }
        }
    }
    
    private void actualizarInfo(List<String> info){
        Graphics g = infoPanel.getGraphics();
        for (int i=0; i< info.size(); i++){
            g.drawString(info.get(i), 15, 20+i*20);
        }
    }
    
    private void inicializarHashMap(){
        Graphics g = mapPanel.getGraphics();
        int count = 1;
//        for(int i=0; i<30; i++){
//            for (int j=0; j<16; j++){                
//                BufferedImage img = chipset.getSubimage(i*16, j*16, 16, 16);
//                imgs.put(Integer.toString(count), img);
//                count++;
//                //probar si funciona
//                g.drawImage(img, i*16, j*16, mapPanel);
//            }
//        }
        BufferedImage psd = chipset.getSubimage(0, 0, 16, 16);
        imgs.put("pasadizo", psd);
        BufferedImage av = chipset.getSubimage(12*16, 10*16, 16, 16);
        imgs.put("avatar", av);
        BufferedImage prd = chipset.getSubimage(12*16, 12*16, 16, 16);
        imgs.put("pared", prd);
        BufferedImage sgt = chipset.getSubimage(23*16, 5*16, 16, 16);
        imgs.put("siguiente", sgt);
        BufferedImage enm = chipset.getSubimage(24*16, 3*16, 16, 16);
        imgs.put("enemigo", enm);
        BufferedImage ald = chipset.getSubimage(26*16, 8*16, 16, 16);
        imgs.put("aliado", ald);
        BufferedImage arm= chipset.getSubimage(18*16, 15*16, 16, 16);
        imgs.put("arma", arm);
        BufferedImage art = chipset.getSubimage(19*16, 11*16, 16, 16);
        imgs.put("artefacto", art);
        BufferedImage nada = chipset.getSubimage(16, 0, 16, 16);
        imgs.put("vacio", nada);
        
    }
}
