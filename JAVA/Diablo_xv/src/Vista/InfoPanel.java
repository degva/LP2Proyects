/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author wperezp
 */
public class InfoPanel extends javax.swing.JPanel {
    
    BufferedImage frame;
    InfoPanelData data;
    GameInfo gameInfo = GameInfo.Get();

    /**
     * Creates new form InfoPanel
     * @param d
     */
    public InfoPanel(InfoPanelData d) {
        initComponents();
        data = d;
        frame = new BufferedImage(200, 420, BufferedImage.TYPE_INT_RGB);
        try {
            Image srcFrame = ImageIO.read(new File("./res/jungle_frame.jpg"));
            Image sclFrame = srcFrame.getScaledInstance(200, 420, Image.SCALE_SMOOTH);
            frame.getGraphics().drawImage(sclFrame, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(InfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setSize(200, 420);
        setLocation(420, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setLocation(420, 0);
        super.paintComponent(g);
        g.drawImage(frame, 0, 0, this);
        g.drawString(String.format("Nivel %d ", gameInfo.LaberintoActual()+1), 50, 30);
        g.drawString(data.avatar.getNombre(), 50, 50);
        g.drawString("Vida: " + data.avatar.getVidaActual(), 50, 70);
        g.drawString("Arma: " + data.avatar.getArmaActual().getNombre(), 50, 90);
        g.drawString("Armadura: " + data.avatar.getArmaduraActual().getNombre(), 50, 110);        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("^");

        jLabel1.setText("Interactuar");

        jButton2.setText(">");

        jButton3.setText("v");

        jButton4.setText("<");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jButton2)
                .addGap(0, 273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
