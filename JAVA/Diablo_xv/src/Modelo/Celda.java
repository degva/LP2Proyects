/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author degva
 */
public class Celda {
    
    // Esto debe tener tambien un tipo de Celda
    // private TipoCelda tipo;
    
    private ObjetoGrafico _tipo; //Pared o Pasadizo
    private ObjetoGrafico _contenido; //Enemigo, Artefacto, Avatar, Anterior, Siguiente

    public Celda(ObjetoGrafico tipo) {
        if (tipo instanceof Pared || tipo instanceof Pasadizo){
            this._tipo = tipo;
            this._contenido = null; //null significa que la celda no tiene contenido
        }else{
            this._tipo = null;
            this._contenido = null;
        }
    }

    public ObjetoGrafico getTipo() {
        return _tipo;
    }

    public void setTipo(ObjetoGrafico _tipo) {
        this._tipo = _tipo;
    }

    public ObjetoGrafico getContenido() {
        return _contenido;
    }

    public void setContenido(ObjetoGrafico _contenido) {
        this._contenido = _contenido;
    }        
}