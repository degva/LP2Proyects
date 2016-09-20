/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author degva
 */
public class Juego {
    
    // Constantes
    public static final int NRO_ARTEFACTOS = 10;
    public static final int MAX_LABERINTOS = 10;
    public static final int MIN_LABERINTOS = 5;
    
    private Avatar _avatar;
    private GestorLaberinto _gestorLab;
    private GestorJuego _gestorJuego;
    private Render _render;
    private int _idxLaberinto;
    private int _idxLaberintoAnterior;
    private final ArrayList<Laberinto> _laberintos;
    
    
    public Juego(String username) {
        Scanner input = new Scanner(System.in);
        
        _gestorLab = new GestorLaberinto();
        _gestorJuego = new GestorJuego();
        _render = new Render();
        _laberintos = new ArrayList<>();
        _idxLaberinto = _idxLaberintoAnterior = 0;
        
        this.CrearListaLaberintos();
        
        String nombre;
        System.out.print("Ingresa tu nombre:\n");
        nombre = input.nextLine();
        
        
        _avatar = new Avatar(GetLaberintoActual().DevolverAnterior(), username, _idxLaberinto);
    }
    
    public void CrearListaLaberintos() {
        int _numLaberintos = (int)(Math.random()*10+5);
        for (int i = 0; i < _numLaberintos; i++) {
            _laberintos.add(_gestorLab.CrearLaberinto());
        }
    }
    
    public Laberinto GetLaberintoActual() {
        return _laberintos.get(GetIdxLaberintoActual());
    }
    
    public int GetIdxLaberintoActual() {
        return _idxLaberinto;
    }
    
    public int GetIdxLaberintoAnterior() {
        return _idxLaberintoAnterior;
    }
    
    public Laberinto ObtenerLaberinto(int idx) {
        return _laberintos.get(idx);
    }
    
    public void AgregarLaberinto(Laberinto lab) {
        _laberintos.add(lab);
    }
    
    public void Jugar() {
        
        // InterpreteComandos interprete = new InterpreteComandos();

        // Otra vista: Consola
        int di;
        while (_gestorJuego.GetGameOn()) {
            _render.Render(_avatar, ObtenerLaberinto(_idxLaberinto),_idxLaberinto);
            di = _gestorJuego.Procesar(_avatar, ObtenerLaberinto(_idxLaberinto));
            _idxLaberintoAnterior = _idxLaberinto;
            _idxLaberinto += di;
            if (di == -1) {
                _avatar.setPosXY(ObtenerLaberinto(_idxLaberinto).DevolverSiguiente());
            } else if (di == 1) {
                _avatar.setPosXY(ObtenerLaberinto(_idxLaberinto).DevolverAnterior());
            }
            _gestorLab.MoverEnemigos(ObtenerLaberinto(_idxLaberinto));
        }
    }
    
}
