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
		background(255,0,0);

	}


	public void draw()
	{	


		fill(255,254,0);//colour
		circle(250, 250, 420); // cx, cy, diameter
		fill(0,255,255);//colour	
		triangle(250, 70, 70, 400, 450, 400);// x1,y1,x2,y2,x3,y3
		fill(255);
		ellipse(243, 250, 150, 90);
		stroke(0,0,0);
		fill(0,0,0);
		circle(243, 250, 60);

	}
}
