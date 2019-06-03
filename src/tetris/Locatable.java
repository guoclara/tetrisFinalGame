/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author guoc6943
 */
public interface Locatable {
    public void setXY( int x );
    public void setX( int x );
    public void setY( int y );

    public int getX();
    public int getY();
}
