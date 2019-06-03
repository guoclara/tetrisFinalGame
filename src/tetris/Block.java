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
public class Block implements Locatable{
    private int width;
    private int height;
    private Color color;
    private int xp;
    private int yp;
    private boolean isColored;
    private int r;
    private int col;
    
    public Block(int row, int column){
        xp = 40*column; //0th column = leftmost column, 10 columns total
        yp = 40*row; //0th row = bottom row, 20 rows total
        width = 40;
        height = 40;
        color = Color.black;
        isColored = false;
        r = row;
        col = column;
    }
    
    public Block(int row, int column, Color c){
        xp = 40*column;
        yp = 40*(row);
        width = 40;
        height = 40;
        color = c;
        isColored = true;
        r = row;
        col = column;
    }
    
//    public Block(int row, int column, Color c, boolean isColor){
//        xp = 40*column;
//        yp = 40*(1+row);
//        width = 40;
//        height = 40;
//        color = c;
//        isColored = isColor;
//        r = row;
//        col = column;
//    }
    
    public void setXY(int x, int y){
        xp = x;
        yp = y;
    }
    
    public void setX(int x){
        xp = x;
    }
    
    public void setY(int y){
        yp = y;
    }
    
    public void setColor(Color c){
        color = c;
        isColored = true;
    }
    
    public Color getColor(){
        return color;
    }
    
    public boolean isColored(){
        return isColored;
    }
    
    public int getX(){
        return xp;
    }
    
    public int getY(){
        return yp;
    }
    
    public void draw(Graphics window){
        window.setColor(color);
        window.fillRect(getX(), getY(), width, height);
        window.setColor(Color.gray);
        window.drawRect(getX(), getY(), width, height);
    }
    
    public void draw(Graphics window, Color c){
        window.setColor(c);
        window.fillRect(getX(), getY(), width, height);
    }
    
    public String toString(){
        return "x/row: "+getX()+"/"+r+", y/col: "+getY()+"/"+col+", color: "+getColor()+", isColored: "+isColored();
    }

    @Override
    public void setXY(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
