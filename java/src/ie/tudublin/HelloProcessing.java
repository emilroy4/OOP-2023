package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);

	}


	public void draw()
	{	
		stroke (100);
		line (10, 10, 100, 100);//x1,y1, x2, y2
		circle(300, 250, 70); // cx, cy, diameter
		fill(0,255,0);//colour
		rect(10, 300, 30, 100);// tlx, tly, width, height
		stroke(127);
		fill(0,0,255);
		noStroke();//turns off the colour outside of shape
		noFill();//turns off the fill for the shape
		triangle(40, 90, 300, 20, 80, 70);// x1,y1,x2,y2,x3,y3
		fill(0,0,255);
	}
}
