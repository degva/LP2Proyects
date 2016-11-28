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

    public Sprite GetTipo() {
        return _tipo;
    }

    public void SetTipo(Sprite _tipo) {
        this._tipo = _tipo;
    }

    public Sprite GetContenido() {
        return _contenido;
    }

    public void SetContenido(Sprite _contenido) {
        this._contenido = _contenido;
    }
    
    public String GetSprite(){
        if (_contenido != null)
            return _contenido.GetSpriteType();
        else 
            return _tipo.GetSpriteType();
    }
}