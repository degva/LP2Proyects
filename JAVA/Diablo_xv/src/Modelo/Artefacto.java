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
public class Artefacto implements Sprite {
    private String _nombre;
    private int _posX;
    private int _posY;
    
    public Artefacto(String nombre, int posX, int posY) {
        _posX = posX;
        _posY = posY;
        _nombre = nombre;
    }
    
    @Override
    public String GetSpriteType() {
        return "artefacto";
    }

    /**
     * @return the nombre
     */
    public String Nombre() {
        return _nombre;
    }

    /**
     * @return the _posX
     */
    public int GetPosX() {
        return _posX;
    }

    public void SetPosX(int x) {
        _posX = x;
    }
    /**
     * @return the _posY
     */
    public int GetPosY() {
        return _posY;
    }
    public void SetPosY(int y) {
        _posY = y;
    }
    
    public void Mover(int dx, int dy) {
        SetPosX(GetPosX() + dx);
        SetPosY(GetPosY() + dy);
    } 
}
