/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Scanner;
/**
 *
 * @author degva
 */
public class Juego {
    private int c;

    public void Start() {
        System.out.print("Hello, this is the game\n");
        System.out.print("Insert a new integer:\n> ");
        
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();
        this.setC(x);
        System.out.print("The new value: " + this.getC() + "\n\n");    
        
    }
    
    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }
    
}
