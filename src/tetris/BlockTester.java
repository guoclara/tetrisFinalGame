/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.Color;
/**
 *
 * @author guoc6943
 */
public class BlockTester {
    public static void main(String[] args){
        Block one = new Block(5,5);
        System.out.println(one);
        
        Block two = new Block(10, 5, Color.red);
        System.out.println(two);
    } 
}
