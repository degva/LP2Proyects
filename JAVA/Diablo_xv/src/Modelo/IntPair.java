/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gina
 */
public class IntPair {
  public final int x;
  public final int y;

  public IntPair(int x, int y) {
      this.x=x;
      this.y=y;
  }
  
  public static boolean Equals(IntPair a, IntPair b){
      return a.x == b.x && a.y == b.y;
  }
}
