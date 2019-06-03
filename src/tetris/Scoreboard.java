package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Scoreboard {
	private int score;
	private int width;
	private int height;
	private Color color;
	private int lastScore;
	
	public Scoreboard(Color c) {
		score = 0;
		width = 250;
		height = 150;
		color = c;
	}
	
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(450, 200, width, height);
		window.setColor(Color.black);
		window.setFont(new Font("Helvetica", Font.PLAIN, 15));
		window.drawString(Game.playerName+"'s score: "+score, 500, 260);
		window.drawString("last game's score: "+lastScore, 500, 300);
	}
	
	public void addScore(int s) {
		score += s;
	}
        
        public int getScore(){
            return score;
        }
        
        public void changeLastScore(int ls){
            lastScore = ls;
        }
	
}
