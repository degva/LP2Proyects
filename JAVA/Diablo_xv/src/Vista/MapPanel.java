/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author wperezp
 */
public class MapPanel extends javax.swing.JPanel {
    
    MapPanelData data;
    HashMap<String, BufferedImage> imgs;
    BufferedImage bgTiles;
    
    private final int ALTO = 6;
    private final int ANCHO = 6;

    /**
     * Creates new form MapPanel
     * @param data
     */
    public MapPanel(MapPanelData data) {
        imgs = new HashMap<>();
        this.data = data;
        initComponents();
        initHashMap();
        setPreferredSize(new Dimension(420,420));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initHashMap(){
        try {
            //Image harambeGIF = Toolkit.getDefaultToolkit().createImage("./res/harambe.gif");
            BufferedImage sprite = ImageIO.read(new File("./res/harambe_der.png"));
            imgs.put("avatar-der", sprite);
            sprite = ImageIO.read(new File("./res/harambe_izq.png"));
            imgs.put("avatar-izq", sprite);
            sprite = ImageIO.read(new File("./res/harambe_arr.png"));
            imgs.put("avatar-arr", sprite);
            sprite = ImageIO.read(new File("./res/harambe_abj.png"));
            imgs.put("avatar-abj", sprite);
            bgTiles = ImageIO.read(new File("./res/tiles1.png"));
            sprite = bgTiles.getSubimage(128, 96, 32, 32);
            imgs.put("pared", sprite);
            sprite = ImageIO.read(new File("./res/pasadizo.png"));
            imgs.put("pasadizo", sprite);
            sprite = ImageIO.read(new File("./res/afuera.png"));
            imgs.put("afuera", sprite);
            sprite = ImageIO.read(new File("./res/anterior.png"));
            imgs.put("anterior", sprite);
            sprite = ImageIO.read(new File("./res/siguiente.png"));
            imgs.put("siguiente", sprite);
            sprite = ImageIO.read(new File("./res/artefacto.png"));
            imgs.put("artefacto", sprite);
            sprite = ImageIO.read(new File("./res/enemigo.png"));
            imgs.put("enemigo", sprite);
            sprite = ImageIO.read(new File("./res/aliado.png"));
            imgs.put("aliado", sprite);
        } catch (IOException ex) {
            Logger.getLogger(MapPanel.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public void paintComponent(Graphics g){
        boolean cellIsOut, cellIsEmpty;
        super.paintComponent(g);
        int avX = data.avatar.GetPosX();
        int avY = data.avatar.GetPosY();
        for (int i = avX - ANCHO, x = 0; i <= avX + ANCHO; i++, x++) {
            for (int j = avY - ALTO, y = 0; j <= avY + ALTO; j++, y++) {
/*These are*/   cellIsOut = i<0 || j<0 || i > data.laberinto.getSizeM()-1 || j > data.laberinto.getSizeN()-1 ;
/*indentation*/ BufferedImage sp;
/*bunnies they*/String spType = null;
/*prevent*/     if (cellIsOut)
/*changes to*/      sp = imgs.get("afuera");
/*these blocks*/else if (i == avX && j == avY){
                    String gg = data.avatar.GetSpriteType();
/*()()*of*/         sp = imgs.get(data.avatar.GetSpriteType());
/*('.')**code*/ } else {
/*(() ()*/          spType = data.laberinto.getCelda(i, j).GetSprite();
/*(_() ()*/         sp = imgs.get(spType);
/*********()()*/}
/*commit*('.')*/if (sp == null) {
                    System.out.println(spType);
/*me!***() ())*/    System.out.println("No Sprite detected");
/******() ()_)*/}
/**************/g.drawImage(sp, x*32, y*32, this);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
