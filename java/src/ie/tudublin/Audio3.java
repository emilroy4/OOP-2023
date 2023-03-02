package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio3 extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;
    void keypressed()
    {
        if(key == ' ')
        {
            if (ap.isPlaying())
            {
                ap.pause();
            }
            else{
                ap.play();
            }
        }
    }

    public void settings()
    {
        size(1024, 1024, P3D);
    }

    public void setup()
    {
        m = new Minim(this);
        ap = m.loadFile("tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3", 1024);
        // i = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ap.mix;
        ap.play();
        lerpedBuffer = new float[width];

        fft = new FFT(width, 44100);
    }

    float[] lerpedBuffer;

    float rot = 0;
    public void draw()
    {

        float total = 0;
        for (int i = 0; i < ab.size(); i++)
        {
            total += abs(ab.get(i));
        }
        float average = total / (float) ab.size();
        
        lerpedAverage = lerp(lerpedAverage, );

        background(0);
        lights();
        //colorMode(HSB);
        stroke(255);
        strokeWeight(5);
        //fill(255);
        noFill();
        translate(width/2, height/2);
        
        rotateY(rot);
        rotateX(rot);

        float boxSize = max(100, map(lerpedAverage,0,1,100,500));
        box(boxSize);
      

    }

    float lerpedY = 0;
    
    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b;
        float range2 = e - d;
        float howFar = a - b;

        return d + (howFar / range1) * range2;
    }
}
