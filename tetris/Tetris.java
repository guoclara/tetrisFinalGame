/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;

/**
 *
 * @author guoc6943
 */
public class Tetris extends Canvas implements KeyListener, Runnable{
    private BufferedImage back;
    private boolean rotateR;
    private boolean rotateL;
    private boolean[] keys;
    private Board board;
    private Block b;
    private Shape s;
    private Scoreboard score;
    private boolean gameOver;
    
    /**
     * @param args the command line arguments
     */
    public Tetris(){
        
        //INITIALIZE EVERYTHING
        keys = new boolean[4];
        board = new TetrisBoard(20,10);
//        b = new Block(0, 0, Color.red);
        s = new Shape();
        score = new Scoreboard(Color.white);
        gameOver = false;
//        board.addShape(4,5,"s", randomCol());;
//        board.addShape(2,2,"z", Color.orange);
        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
    }
    public void update(Graphics window)
    {
        paint(window);
    }
    public void paint( Graphics window )
    {
	//set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D)window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if(back==null)
           back = (BufferedImage)(createImage(getWidth(),getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        //board.setRowColor(20, Color.DARK_GRAY);

        
        board.draw(graphToBack);
        score.draw(graphToBack);

        

        
        s.draw(graphToBack);
        //MOVE EVERYTHING, CHECK EVERYTHING, CLEAR THINGS
        if(s.isLegalY(board.getBoard()))
        	s.move(board.getBoard(), 1, 0);
        if(keys[0]){
            s.move(board.getBoard(), 0, -1);
        }else if(keys[1]){
            s.move(board.getBoard(), 0, 1);
        }else if(keys[2]){
            s.rotatePiece();
        }else if(keys[3]){
            s.move(board.getBoard(), 1, 0);
            if(s.isLegalY(board.getBoard()))
            	s.move(board.getBoard(), 1, 0);
        }
//        //while(gameOver == false) {
	        if(!s.isLegalY(board.getBoard())){
	            board.placeShape(s);
	            //System.out.println("row: "+s.getFallingRow()+", col: "+s.getFallingCol());
	            if(s.getFallingRow() > 0)
	            	s = new Shape();
	            else
	            	graphToBack.drawString("GAME OVER", 325, 400);
	        }
        //}
	     
//        if(gameOver) {
//        	graphToBack.setColor(Color.black);
//        	graphToBack.drawRect(0, 0, 750, 840);
//        	graphToBack.setColor(Color.red);
//        	graphToBack.drawString("GAME OVER", 325, 400);
//        }
        
        
        for(int i = board.getBoard().length - 1; i>=0; i--) {
        	if(board.checkFullRow(i)) {
        		board.clearRow(i);
        		score.addScore(50);
        	}
        }
             

        twoDGraph.drawImage(back, null, 0, 0);
        
    }
    
    
    public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[2] = true;
		}
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[2] = false;
		}
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		
		repaint();
	}
    
    public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(450);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}            

