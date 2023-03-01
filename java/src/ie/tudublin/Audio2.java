package ie.tudublin;


import ddf.minim.*;
import ddf.minim.AudioBuffer;

import ddf.minim.AudioPlayer;
import processing.core.PApplet;

public class Audio2 extends PApplet
{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

   public void settings()
   {
    size(1024,1024);
   }


public void setup()
{
    m = new Minim(this);
    //audio input
    ai = m.getLineIn(Minim.MONO, width, 44100, 16);
    //audio buffer
    ab = ai.mix;
    
}

float[] lerpedBuffer;
public void draw()
{

background(0);
stroke(255);
float half = height /2;
for(int i = 0; i < ab.size(); i++)
{
    stroke(map(i,0,ab.size(), 0,255),255,255);
    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.01f);
    float f = abs(lerpedBuffer[i] * half * 2.0f);
    line(i,half + f, i, half -f);
}


//println(map(5,0,10,1000,2000));
//println(map1(5,0,10,1000,2000));

}



void map1(float a, float b, float c, float d, float e)
{
    float range1 = c-b;
    float range2 = e-d;
    float howFar = a-b;

    return d + (howFar / range1) * range2;
}


}


