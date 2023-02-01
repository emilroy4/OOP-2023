package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX;
	float playerY;
	float playerWidth;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(100);
		playerX = width/2; // initialize playerX
		playerWidth = 40;  // initialize playerWidth
		playerY = height/2;  // initialize playerY
	}


	public void draw()
	{	
		if (keyPressed) {
			if (keyCode == LEFT) {
				playerX -= 5;  // decrement playerX
				if (playerX < playerWidth / 2) {
					playerX = playerWidth / 2;
				}
			}
			else if (keyCode == RIGHT) {
				playerX += 5;  // increment playerX
				if (playerX > width - playerWidth / 2) {
					playerX = width - playerWidth / 2;
				}
				if (key == ' ') {
					stroke(255, 0, 0);
					line(playerX, playerY, playerX, playerY - 20);
				}
			}
		}

		background(100);
		drawPlayer(playerX, playerY, playerWidth);
	}

	public void drawPlayer(float x, float y, float w) {
		float h = w * 0.5f;
		fill(255, 255, 0);
		rect(x - w / 2, y - h / 2, w, h);
		strokeWeight(2);
		stroke(255, 0, 0);
		line(x - w * 0.5f, y - h, x + w * 0.5f, y - h);
		line(x + w * 0.5f, y - h, x, y + h);
		line(x, y + h, x - w * 0.5f, y - h);
	}
	
	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}	
}