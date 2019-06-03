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
public class TetrisBoard extends Board{
    private Block[][] board;
    
    public TetrisBoard(int row, int col){
        super(row, col);
    }
    
    public TetrisBoard(int row, int col, Color c){
        super(row, col, c);
    }
    
    public boolean checkFullRow(int row){
        boolean color = true;
        for(Block b: getRow(row)){
            if(!b.isColored()){
                color = false;
            }
        }
        return color;
    }
    
    

}
