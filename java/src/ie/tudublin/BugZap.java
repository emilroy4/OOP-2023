package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
	float playerX;
	float playerY;
	float halfPlayer;

	float playerWidth;

	// bug
	float bugX;
	float bugY;
	float bugSpeed;
	boolean bugAlive;

	// score
	int score = 0;

	// settings
	public void settings() {
		size(500, 500);
	}

	// setup
	public void setup() {
		colorMode(HSB);
		background(100);
		smooth();

		playerX = width * 0.5f; // initialize playerX
		playerWidth = 50; // initialize playerWidth
		playerY = height - 100; // initialize playerY
		halfPlayer = playerWidth * 0.5f; // initialize halfPlayerWidth

	}

	void resetBug() {
		bugX = random(halfBug, width - halfBug);
		bugY = 50;
		bugSpeed = 10;
		bugAlive = true;
	}

	public void drawPlayer(float x, float y, float w) {
		noFill();
		stroke(255);
		rectMode(CENTER);
		rect(w, x, y, w);
		line(x, y - halfPlayer, x, y - halfPlayer * 2);

		/*
		 * float h = w * 0.5f;
		 * fill(255, 255, 0);
		 * rect(x - w / 2, y - h / 2, w, h);
		 * strokeWeight(2);
		 * stroke(255, 0, 0);
		 * line(x - w * 0.5f, y - h, x + w * 0.5f, y - h);
		 * line(x + w * 0.5f, y - h, x, y + h);
		 * line(x, y + h, x - w * 0.5f, y - h);
		 */
	}

	public void keyPressed() {
		if (keyCode == LEFT) {
			playerX--;
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT) {
			playerX++;
			System.out.println("Right arrow pressed");
		}
		if (key == ' ') {
			line(playerX, playerY, bugX, bugY);

			System.out.println("SPACE key pressed");
		}
	}

	public void draw() { /*
							 * if (keyPressed) {
							 * if (keyCode == LEFT) {
							 * playerX -= 5; // decrement playerX
							 * if (playerX < playerWidth / 2) {
							 * playerX = playerWidth / 2;
							 * }
							 * }
							 * else if (keyCode == RIGHT) {
							 * playerX += 5; // increment playerX
							 * if (playerX > width - playerWidth / 2) {
							 * playerX = width - playerWidth / 2;
							 * }
							 * if (key == ' ') {
							 * stroke(255, 0, 0);
							 * line(playerX, playerY, playerX, playerY - 20);
							 * }
							 * }
							 * }
							 * 
							 * background(100);
							 * drawPlayer(playerX, playerY, playerWidth);
							 */
		drawPlayer(playerX, playerY, playerWidth);

	}

}