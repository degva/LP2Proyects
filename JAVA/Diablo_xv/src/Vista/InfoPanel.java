/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GestorInteraccion;
import Facilidades.Aliado;
import Modelo.*;
import Controlador.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author wperezp
 */
public class InfoPanel extends javax.swing.JPanel {
    
    BufferedImage frameBg;
    InfoPanelData data;
    ArrayList<Laberinto> laberintos;
    GestorInteraccion gestorInteraccion;
    GameStatus gameInfo = GameStatus.Get();
    private Juego _juegoActual;
    
    

    /**
     * Creates new form InfoPanel
     * @param d
     */
    public InfoPanel(InfoPanelData d, ArrayList<Laberinto> labs) {
        initComponents();
        data = d;
        laberintos = labs;
        gestorInteraccion = new GestorInteraccion();
        frameBg = new BufferedImage(200, 416, BufferedImage.TYPE_INT_RGB);
        try {
            Image srcFrame = ImageIO.read(new File("./res/jungle_frame.png"));
            Image sclFrame = srcFrame.getScaledInstance(200, 416, Image.SCALE_SMOOTH);
            frameBg.getGraphics().drawImage(sclFrame, 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(InfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setPreferredSize(new Dimension(200, 420));
        
        _juegoActual = Juego.Get();
        
        this.jButton1.setFocusable(false);
        this.jButton2.setFocusable(false);
        this.jButton3.setFocusable(false);
        this.jButton4.setFocusable(false);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x_ini = 60, y_ini = 60;
        g.drawImage(frameBg, 0, 0, this);
        g.drawString(String.format("Nivel %d ", gameInfo.LaberintoActual()+1), x_ini, y_ini);
        g.drawString(data.avatar.GetNombre(), x_ini, y_ini + 20);
        g.drawString("Vida: " + data.avatar.GetVidaActual(), x_ini, y_ini + 40);
        g.drawString("Arma: " + data.avatar.ArmaActual().Nombre(), x_ini, y_ini + 60);
        g.drawString("Armadura: " + data.avatar.ArmaduraActual().Nombre(), x_ini, y_ini + 80);
        //falta saco
        g.drawString("Cosillas:",x_ini,y_ini + 100);
        Saco saco = data.avatar.Saco();
        int sacoSize = saco.Size();
        if (sacoSize > 0){            
            DefaultListModel dlm = new DefaultListModel();
            Artefacto art;
            for (int i = 0; i < sacoSize; i++) {
                art = saco.Get(i);       
                
                if (art instanceof Arma)
                    dlm.addElement(String.format("%d) Arma: ",i+1) + art.Nombre());     
                else if (art instanceof Armadura)
                    dlm.addElement(String.format("%d) Armadura: ",i+1) + art.Nombre());
            }
            listaSaco.setModel(dlm);
        }
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSaco = new javax.swing.JList<>();

        jButton1.setText("^");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Interactuar");

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("v");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        listaSaco.setFocusTraversalKeysEnabled(false);
        listaSaco.setFocusable(false);
        jScrollPane1.setViewportView(listaSaco);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 279, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // izquierda
        //data.avatar.setNombre("crippling");
        IntPair pos = new IntPair(data.avatar.GetPosX() -1, data.avatar.GetPosY());
        Laberinto labAct = laberintos.get(gameInfo.LaberintoActual());
        verificarInteraccion(data.avatar, labAct, pos);
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // arriba
        IntPair pos = new IntPair(data.avatar.GetPosX(), data.avatar.GetPosY() -1);
        Laberinto labAct = laberintos.get(gameInfo.LaberintoActual());
        verificarInteraccion(data.avatar, labAct, pos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // abajo
        IntPair pos = new IntPair(data.avatar.GetPosX(), data.avatar.GetPosY() +1);
        Laberinto labAct = laberintos.get(gameInfo.LaberintoActual());
        verificarInteraccion(data.avatar, labAct, pos);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // derecha
        IntPair pos = new IntPair(data.avatar.GetPosX() +1, data.avatar.GetPosY());
        Laberinto labAct = laberintos.get(gameInfo.LaberintoActual());
        verificarInteraccion(data.avatar, labAct, pos);
    }//GEN-LAST:event_jButton2ActionPerformed

    public synchronized void verificarInteraccion(Avatar a, Laberinto l, IntPair coordInter){
        _juegoActual.movEnemigos.suspend();
        _juegoActual.movArtefactos.suspend();
        
        if (l.getContenidoCelda(coordInter.x, coordInter.y) instanceof Enemigo) {
            //gestorInteraccion.interactuarEnemigo(a, l, coordInter);
            
            Enemigo e = l.obtenerEnemigoActual(coordInter.x, coordInter.y);
            
            Window parentWindow = SwingUtilities.windowForComponent(this);
            Frame parentFrame = null;
            if (parentWindow instanceof Frame) {
                parentFrame = (Frame) parentWindow;
            }
            PeleaDialog ventanaPelea = new PeleaDialog(a, e, gestorInteraccion, parentFrame, true);
            ventanaPelea.setVisible(true);

            l.retornarEnemigoActual(e);
        }else if (l.getContenidoCelda(coordInter.x, coordInter.y) instanceof Artefacto){
            gestorInteraccion.interactuarArtefacto(a, l, coordInter);
        }else if (l.getContenidoCelda(coordInter.x, coordInter.y) instanceof Aliado){
            String consejo = gestorInteraccion.interactuarAliado(a, l, coordInter);
            JOptionPane.showMessageDialog(this, consejo, "Consejo del Aliado:", JOptionPane.INFORMATION_MESSAGE);
        }
        
        _juegoActual.movEnemigos.resume();
        _juegoActual.movArtefactos.resume();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaSaco;
    // End of variables declaration//GEN-END:variables
}
