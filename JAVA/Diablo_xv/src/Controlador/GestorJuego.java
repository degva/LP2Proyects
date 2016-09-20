/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author degva
 */
public class GestorJuego {
    
    // Constantes
    public static final int NRO_ARTEFACTOS = 10;
    public static final int MAX_LABERINTOS = 10;
    public static final int MIN_LABERINTOS = 5;
    
    private Avatar _avatar;
    private GestorLaberinto _gestorLab;
    private int _idxLaberinto;
    private int _idxLaberintoAnterior;
    private final ArrayList<Laberinto> _laberintos;
    
    public GestorJuego(String username) {
        Scanner input = new Scanner(System.in);
        
        _gestorLab = new GestorLaberinto();
        _laberintos = new ArrayList<>();
        _idxLaberinto = _idxLaberintoAnterior = 0;
        
        this.CrearListaLaberintos();
        
        String nombre;
        System.out.print("Ingresa tu nombre:\n");
        nombre = input.nextLine();
        
        // Deberia haber una funcion que ponga el avatar en la celda anterior
        // a un nivel X. Asi tambien cuando se pone en el siguiente laberinto
        // this.ColocaAvatarAnterior(1);
        // this.ColocaAvatarSiguiente(idx);
        // _avatar = new Avatar(username);
    }
    
    public void CrearListaLaberintos() {
        int _numLaberintos = (int)(Math.random()*10+5);
        for (int i = 0; i < _numLaberintos; i++) {
            _laberintos.add(_gestorLab.CrearLaberinto());
        }
    }
    
    public int GetLaberintoActual() {
        return _idxLaberinto;
    }
    
    public int GetLaberintoAnterior() {
        return _idxLaberintoAnterior;
    }
    
    public Laberinto ObtenerLaberinto(int idx) {
        return _laberintos.get(idx);
    }
    
    public void AgregarLaberinto(Laberinto lab) {
        _laberintos.add(lab);
    }
    
    public void Jugar() {
        Scanner input = new Scanner(System.in);
        
        Renderizador renderizador = new Renderizador();
        InterpreteComandos interprete = new InterpreteComandos();
        
        boolean finJuego = false;
        String opcion;
        
        while (!finJuego) {
            System.out.println("Aqui la historia: ");
            System.out.println("Habia una vez, trus. Fin.");
            System.out.println("Iniciar? Salir?");
            opcion = input.nextLine();
            switch (opcion) {
                case "Iniciar": case "iniciar":
                    boolean finPartida = false;
                    while (!finPartida) {
                        renderizador.Render(ObtenerLaberinto(_idxLaberinto));
                        finPartida = interprete.ProcesarComando(ObtenerLaberinto(_idxLaberinto));
                    }
                    break;
                case "Salir": case "salir":
                    finJuego = true;
                    break;
            }
            
        }
    }
}
