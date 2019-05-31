package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Scoreboard {
	private int score;
	private int width;
	private int height;
	private Color color;
	private int highscore;
	
	public Scoreboard(Color c) {
		score = 0;
		width = 250;
		height = 150;
		color = c;
		highscore = 0;
	}
	
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(450, 200, width, height);
		window.setColor(Color.black);
		window.setFont(new Font("Helvetica", Font.PLAIN, 25));
		window.drawString("score: "+score, 500, 260);
		window.drawString("high score: "+highscore, 500, 300);
	}
	
	public void addScore(int s) {
		score += s;
	}
	
}
