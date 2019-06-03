/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author guoc6943
 */
public class Shape{
    private boolean[][] S = 
            {{false, true, true}, 
            {true, true, false}};
    private boolean[][] Z = 
            {{true, true, false},
             {false, true, true}};
    private boolean[][] O = 
            {{true, true},
             {true, true}}; 
    private boolean[][] L= 
            {{false, false, true},
             {true, true, true}};
    private boolean[][] J= 
            {{true, false, false},
             {true, true, true}};
    private boolean[][] T= 
            {{false, true, false},
             {true, true, true}};
    private boolean[][] I= 
            {{true, true, true, true}};
    private boolean[][][] tetrisPieces = {S, Z, O, L, J, T, I};
    private Color[] tetrisCol = {Color.red, Color.orange, Color.blue, Color.green, Color.magenta, Color.pink, Color.LIGHT_GRAY};
    private boolean[][] fallingPiece;
    private Color fallingColor;
    private int fallingRow;
    private int fallingCol;
    
    public Shape(){
          int randInd = (int)  (Math.random()*7);
          fallingPiece = tetrisPieces[randInd];
          fallingColor = tetrisCol[randInd];
          fallingRow = 0;
          fallingCol = 5 - fallingPiece[0].length/2;

        
    }
    public void draw(Graphics window){
        for(int r = 0; r<fallingPiece.length; r++){
            for(int c = 0; c<fallingPiece[0].length; c++){
                if(fallingPiece[r][c]){
                    Block b = new Block(fallingRow + r, fallingCol + c, fallingColor);
                    b.draw(window);
                }
            }
        }
    }
    
    public boolean move(Block[][] board, int dr, int dc){
        
        
        if(isLegalY(board) && !isLegalX(board)){
            fallingRow += dr;
            if(fallingCol == 0 && dc>0){
                fallingCol +=dc;
                //System.out.println("move x right");
            }
            if(fallingCol >= 8 - fallingPiece[0].length/2 && dc<0){
                fallingCol += dc;
                //System.out.println("move x left");
            }
            return true;
        }
        if(isLegal(board)){
            fallingRow += dr;
            fallingCol += dc;
            
            return true;
        }else{
        	fallingRow -= dr;
            return false;
        }
    }
    
    public boolean isLegal(Block[][] board){
        for(int r = 0; r<fallingPiece.length; r++){
            for(int c = 0; c<fallingPiece[0].length; c++){
                if(fallingPiece[r][c]){
                    if((fallingRow+r<0) || (fallingRow+r>board.length-2) || (fallingCol+c<1)|| (fallingCol+c>board[0].length-1) || board[fallingRow+r+1][fallingCol+c].isColored()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isLegalY(Block[][] board){
        for(int r = 0; r<fallingPiece.length; r++){
            for(int c = 0; c<fallingPiece[0].length; c++){
                if(fallingPiece[r][c]){
                    if((fallingRow+r<0) || (fallingRow+r>board.length-2) || board[fallingRow+r+1][fallingCol+c].isColored()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isLegalX(Block[][] board){
        for(int r = 0; r<fallingPiece.length; r++){
            for(int c = 0; c<fallingPiece[0].length; c++){
                if(fallingPiece[r][c]){
                    if( (fallingCol+c<1)|| (fallingCol+c>board[0].length-2)||board[fallingRow+r+1][fallingCol+c].isColored()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void rotatePiece() {
    	boolean[][] temp = fallingPiece;
    	int tempX = fallingPiece.length;
    	int tempY = fallingPiece[0].length;
    	int tempRow = fallingRow;
    	int tempCol = fallingCol;
    	
    	fallingRow = tempRow + tempX/2 - tempY/2;
    	fallingCol = tempCol + tempY/2 - tempX/2;
    	
    	boolean[][] rotatedPiece = new boolean[tempY][tempX];
    	
    	for(int i = 0; i<temp.length; i++) {
    		for(int n = 0; n<temp[0].length; n++) {
    			rotatedPiece[rotatedPiece.length-1-n][i] = temp[i][n];
    		}
    	}
    	
    	fallingPiece = rotatedPiece;
    	
    	
    }
    
    
    public int getFallingRow(){
        return fallingRow;
    }
    
    public int getFallingCol(){
        return fallingCol;
    }
    
    public Color getFallingColor(){
        return fallingColor;
    }
    
    public int getFallingLength(){
        return fallingPiece[0].length;
    }
    
    public int getFallingHeight(){
        return fallingPiece.length;
    }
    
    public boolean[][] getFallingPiece(){
        return fallingPiece;
    }
    
    
        


}
