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
    
    private Sprite _tipo; //Pared o Pasadizo
    private Sprite _contenido; //Enemigo, Artefacto, Avatar, Anterior, Siguiente, NULL

    public Celda(Sprite tipo) {
        if (tipo instanceof Pared || tipo instanceof Pasadizo){
            this._tipo = tipo;
            this._contenido = null; //null significa que la celda no tiene contenido
        }else{
            this._tipo = null;
            this._contenido = null;
        }
    }

    public Sprite getTipo() {
        return _tipo;
    }

    public void setTipo(Sprite _tipo) {
        this._tipo = _tipo;
    }

    public Sprite getContenido() {
        return _contenido;
    }

    public void setContenido(Sprite _contenido) {
        this._contenido = _contenido;
    }
    
    public String getSprite(){
        if (_contenido != null)
            return _contenido.GetSpriteType();
        else 
            return _tipo.GetSpriteType();
    }
}