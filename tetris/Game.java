/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author guoc6943
 */
public class Game extends JFrame{
    private static final int WIDTH = 750;
    private static final int HEIGHT = 840;
        
    public Game(){
        // TODO code application logic here
            super("TETRIS");
            setSize(WIDTH,HEIGHT);

            Tetris game = new Tetris();

            ((Component)game).setFocusable(true);
            getContentPane().add(game);

            setVisible(true);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Game run = new Game();
	}
}