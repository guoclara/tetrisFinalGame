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
public abstract class Board { //kind of like alien horde MAKE INTO ABSTRACT CLASS LATER
    
    private Block[][] board;
//    private Block[] S;
//    private Block[] Z;
//    private Block[] O; //square shape
//    private Block[] L;
//    private Block[] J;
//    private Block[] T;
//    private Block[] I;
//    private String type;
//    private Color color;

    
    public Board(int row, int col){ //20 rows, 10 cols
        board = new Block[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                board[r][c] = new Block(r, c);
            }
        }

    }
    
    public Board(int row, int col, Color color){ //20 rows, 10 cols
        board = new Block[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                board[r][c] = new Block(r, c, color);
            }
        }
    }
    
    public void draw(Graphics window){
        for(Block[] row: board){
            for(Block b: row){
                b.draw(window);
            }
        }
    }
    
//    public void addShape(int row, int col, String shape, Color shapeCol){
//        shape = shape.toLowerCase();
//        type = shape;
//        
//        if(shape.equals("s")){
//            S = new Block[4];
//            S[0] = new Block(row, col, shapeCol);
//            board[row][col] = S[0];
//            S[1] = new Block(row, col+1, shapeCol);
//            board[row][col+1] = S[1];
//            S[2] = new Block(row-1, col+1, shapeCol);
//            board[row-1][col+1] = S[2];
//            S[3] = new Block(row-1, col+2, shapeCol);
//            board[row-1][col+2] = S[3];
//        }else if(shape.equals("z")){
//            Z = new Block[4];
//            Z[0] = new Block(row-1, col, shapeCol);
//            board[row][col] = Z[0];
//            Z[1] = new Block(row-1, col+1, shapeCol); 
//            board[row-1][col+1] = Z[1];
//            Z[2] = new Block(row, col+1, shapeCol);
//            board[row][col+1] = Z[2];
//            Z[3] = new Block(row, col+2, shapeCol);
//            board[row][col+2] = Z[3];
//        }else if(shape.equals("o")){
//            O = new Block[4];
//        }else if(shape.equals("l")){
//            L = new Block[4];
//        }else if(shape.equals("j")){
//            J = new Block[4];
//        }else if(shape.equals("t")){
//            T = new Block[4];
//        }else{ //shape = I
//            I = new Block[4];
//        }
//    }
    

    
    public Block[] getRow(int r){
        return board[r];
    }
    public Block[][] getBoard(){
        return board;
    }
    public int getLength(){
        return board.length;
    }

    public void setRowColor(int row, Color c){
        for(int i = 0; i<board[0].length; i++){
            board[row][i] = new Block(row, i, c);
        }
    }
    
    public void setPartRowColor(int x, int f, int row, Color c) {
    	for(int i = x; i<f; x++){
            board[row][i] = new Block(row, i, c);
        }
    }
    
    public abstract boolean checkFullRow(int row);
    
    public void placeShape(Shape s){
        for(int r = 0; r<s.getFallingHeight(); r++){
            for(int c = 0; c<s.getFallingLength(); c++){
                if(s.getFallingPiece()[r][c]){
                    //System.out.println("row: "+(s.getFallingRow()+r)+", col: "+(s.getFallingCol()+c));
                    board[s.getFallingRow()+r][s.getFallingCol()+c].setColor(s.getFallingColor());
                }
            }
        }
    }

//    public boolean checkFullRow(int row){
//        boolean color = true;
//        for(Block b: board[row]){
//            if(!b.isColored()){
//                color = false;
//            }
//        }
//        return color;
//    }
    public void clearRow(int row){ //doesn't work when clearing black rows under color
        Block[] temp = new Block[board[0].length];
        for(int i = 0; i<board[0].length; i++){
            temp[i] = board[0][i];
        }
        for(int i = row; i>0; i--){
            board[i] = board[i-1];
            for(int c = 0; c<board[0].length; c++){
                board[i][c].setY(board[i][c].getY()+40);
            }
        }
//        
        for(int c = 0; c<board[0].length; c++){
            board[0][c] = new Block(0, c);
        }
        board[1] = temp;
        for(int i = 0; i<board[0].length; i++){
            board[1][i].setY(40);
        }
//        int count = 0;
//        for(int n = 0; n<board.length; n++){
//            count++;
//            for(int i = 0; i<board[0].length; i++){
//                System.out.println(board[n][i]);
//            }
//            System.out.println("count: "+count);
//        }
    }
    
    public String toString(){
        String str = "";
        for(Block[] row: board){
            for(Block b: row){
                str += "x: "+ b.getX() + ", y: "+ b.getY()+", color: "+ b.getColor();
            }
        }
        return str;
    }
    
    
        
}
