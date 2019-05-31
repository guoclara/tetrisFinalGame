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
public class BoardTester {
    public static void main(String[] args){
        Board b = new TetrisBoard(20, 10, Color.red);
        System.out.println(b.checkFullRow(19)); //bottom row
        
        Board board = new TetrisBoard(20,10);
        System.out.println(board.checkFullRow(19));
//        for(int i = 0; i<20; i++){
//            b2.clearRow(19);
//        }
        board.setRowColor(5, Color.cyan);
        board.setRowColor(4, Color.orange);
        board.setRowColor(3, Color.yellow);
        board.setRowColor(2, Color.green);
        board.setRowColor(1, Color.blue);
        board.setRowColor(0, Color.red);
        board.clearRow(5);
//        System.out.println(b2.checkFullRow(19));
//        
//        Board b3 = new TetrisBoard(20,10);
//        b3.setRowColor(19, Color.green);
//        System.out.println(b3.checkFullRow(19));
//        
//        int[] a = {1,2,3,4,5,6};
//        for(int i =3; i>0; i--){
//            a[i] = a[i-1];
//        }
//        a[0] = 0;
//        for(int i = 0; i<a.length; i++){
//            System.out.print(a[i]+" ");
//        }
           
    }
    
    
}
