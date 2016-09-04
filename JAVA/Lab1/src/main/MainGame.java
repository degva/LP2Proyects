/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.Juego;

import java.util.Scanner;
/**
 *
 * @author degva
 */
class MainGame {
    public static void main(String[] args) {
               
        System.out.print("Hello, this is the game\n");
        System.out.print("Insert the maximum size of the laberint:\n> ");
        
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();
        
        Juego game = new Juego(x);
        game.Start();
    }
}
