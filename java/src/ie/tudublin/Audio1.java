package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings() {
        size(1024, 1000);
        // Use the default JAVA2D renderer
    }

    public void setup() {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix;

        // And comment the next two lines out
        ap = minim.loadFile("drugs.mp3", 1024);
        if (ap == null) {
            println("Failed to load audio file!");
            exit();
        }
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;
    }

    public void draw() {
        // Calculate sum and average of the samples
        float sum = 0;
        for (int i = 0; i < ab.size(); i++) {
            float sample = ab.get(i);
            sum += sample * sample; // square each sample to get the amplitude
        }
        float average = sqrt(sum / (float) ab.size()); // take the square root to get the RMS amplitude

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        switch (mode) {
            case 0:
                background(0);
                for (int i = 0; i < ab.size(); i++) {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * height / 2;
                    line(i, height / 2 + f, i, height / 2 - f);
                }
                break;
            case 1:
                background(0);
                float lerpedA = smoothedAmplitude * 100;
                stroke(255);
                fill(100, 255, 255);
                circle(width / 2, height / 2, lerpedA);
                circle(100, y, 50);
                y += random(-10, 10);
                smoothedY = lerp(smoothedY, y, 0.1f);
                circle(200, smoothedY, 50);
                break;
            case 2:
                //
                break;
            default:
                println("Invalid mode: " + mode);
                break;
        }
    }
}
